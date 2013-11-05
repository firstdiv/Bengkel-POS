package com.airsystem.pos.bengkel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.controller.SplashScreenController;

/**
 * @author Budi Oktaviyan
 */
public class SplashScreen extends SplashScreenController {
	private static final Logger LOG = Logger.getLogger(SplashScreen.class.getSimpleName());

	private JDesktopPane desktopPane;

	public SplashScreen() {
		super();

		initComponents();
		load();
	}

	private void initComponents() {
		getContentPane().add(panel, BorderLayout.CENTER);

		baseLayout.columnWidths = new int[] { 0, 0 };
		baseLayout.rowHeights = new int[] { 0, 0 };
		baseLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		baseLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(baseLayout);

		desktopLayout.columnWidths = new int[] { 0, 0 };
		desktopLayout.rowHeights = new int[] { 0, 0 };
		desktopLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		desktopLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

		logoLabel.setText("Jasa Service Bengkel v.1");
		logoLabel.setFont(new Font("Verdana", 1, 15));

		desktopPane = new JDesktopPane() {
			public void paintComponent(Graphics graphics) {
				try {
					super.paintComponent(graphics);

					Image backgroundImage = new ImageIcon(getClass().getResource("../res/splash.png")).getImage();
					graphics.drawImage(backgroundImage, 0, 0, this);
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
				}
			}
		};

		desktopPane.setLayout(desktopLayout);
		desktopPane.setBackground(Color.LIGHT_GRAY);

		desktopPane.add(logoLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 0), 0, 0));
		panel.add(desktopPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		setSize(500, 300);
		setLocationRelativeTo(this);
	}
}