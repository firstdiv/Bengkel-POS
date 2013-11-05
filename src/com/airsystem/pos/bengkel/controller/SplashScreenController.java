package com.airsystem.pos.bengkel.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.interfaces.ISystem;
import com.airsystem.pos.bengkel.model.SplashScreenModel;
import com.airsystem.pos.bengkel.view.Login;

/**
 * @author Budi Oktaviyan
 */
public class SplashScreenController extends SplashScreenModel implements ISystem {
	private static final Logger LOG = Logger.getLogger(SplashScreenController.class.getSimpleName());

	private Timer splashTimer;

	public SplashScreenController() {
		super();
	}

	public void load() {
		ActionListener progressAction = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				count++;

				if (count == 60) {
					splashTimer.stop();
					dispose();

					try {
						Login userLogin = new Login();
						userLogin.setResizable(false);
						userLogin.setVisible(true);
					} catch (Exception e) {
						LOG.error(e.getMessage(), e);
					}
				}
			}
		};

		splashTimer = new Timer(60, progressAction);
		splashTimer.start();
	}
}