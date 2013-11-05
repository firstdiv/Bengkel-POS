package com.airsystem.pos.bengkel.controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.entity.User;
import com.airsystem.pos.bengkel.interfaces.ILogin;
import com.airsystem.pos.bengkel.interfaces.ISystem;
import com.airsystem.pos.bengkel.model.LoginModel;
import com.airsystem.pos.bengkel.service.UserServices;
import com.airsystem.pos.bengkel.view.Menu;

/**
 * @author Budi Oktaviyan
 */
public class LoginController extends LoginModel implements ILogin, ISystem {
	private static final Logger LOG = Logger.getLogger(LoginController.class.getSimpleName());

	private char[] password;

	private String userName, userPassword, userRole, idLogin;

	private UserServices userServices = new UserServices();

	public LoginController() {
		super();
	}

	public void get() {
		userName = userField.getText();
		password = passField.getPassword();
		userPassword = new String(password);
	}

	public void reset() {
		userField.setText("");
		passField.setText("");
	}

	public void login(ActionEvent evt) {
		try {
			get();

			if (userName.isEmpty() || userPassword.isEmpty()) {
				JOptionPane.showMessageDialog(LoginController.this, "Username/Password kosong!", "Pesan Sistem", JOptionPane.WARNING_MESSAGE);
			} else {
				List<User> users = userServices.login(userName, userPassword);

				if (users.size() > 0) {
					for (User user : users) {
						userRole = user.getRole().getRole();
						idLogin = user.getId().toString();
					}

					load();
				} else {
					JOptionPane.showMessageDialog(LoginController.this, "Username/Password salah!", "Pesan Sistem", JOptionPane.ERROR_MESSAGE);
					reset();
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(LoginController.this, "Database belum terkoneksi!", "Database Status: Disconnect", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void load() {
		dispose();

		Menu menu = new Menu();
		menu.setExtendedState(Frame.MAXIMIZED_BOTH);
		menu.setVisible(true);

		if (userRole.equalsIgnoreCase("USER")) {
			menu.setup(false);

			setIdLogin(idLogin);
			setPasswordLogin(userPassword);
		} else if (userRole.equalsIgnoreCase("ADMIN")) {
			menu.setup(true);
		}
	}
}