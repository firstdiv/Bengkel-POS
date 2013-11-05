package com.airsystem.pos.bengkel.model;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * @author Budi Oktaviyan
 */
public class SplashScreenModel extends JWindow {
	protected int count = 0;

	protected GridBagLayout baseLayout = new GridBagLayout();
	protected GridBagLayout desktopLayout = new GridBagLayout();

	protected JPanel panel = new JPanel();

	protected JLabel logoLabel = new JLabel();

	public SplashScreenModel() {
		super();
	}
}