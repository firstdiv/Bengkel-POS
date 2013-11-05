package com.airsystem.pos.bengkel.model;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Budi Oktaviyan
 */
public class LoginModel extends JFrame {
	public static String idLogin, passwordLogin;

	protected GridBagLayout baseLayout = new GridBagLayout();

	protected JPanel basePanel = new JPanel();
	protected JPanel buttonPanel = new JPanel();

	protected JLabel userLabel = new JLabel();
	protected JLabel passLabel = new JLabel();

	protected JTextField userField = new JTextField();

	protected JPasswordField passField = new JPasswordField();

	protected JButton loginButton = new JButton();

	public LoginModel() {
		super();
	}

	public static String getIdLogin() {
		return idLogin;
	}

	public static void setIdLogin(String idLogin) {
		LoginModel.idLogin = idLogin;
	}

	public static String getPasswordLogin() {
		return passwordLogin;
	}

	public static void setPasswordLogin(String passwordLogin) {
		LoginModel.passwordLogin = passwordLogin;
	}
}