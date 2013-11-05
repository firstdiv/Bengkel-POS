package com.airsystem.pos.bengkel.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.entity.User;
import com.airsystem.pos.bengkel.interfaces.IPassword;
import com.airsystem.pos.bengkel.interfaces.ISystem;
import com.airsystem.pos.bengkel.model.ChangePasswordModel;
import com.airsystem.pos.bengkel.service.UserServices;
import com.airsystem.pos.bengkel.view.Login;

/**
 * @author Budi Oktaviyan
 */
public class ChangePasswordController extends ChangePasswordModel implements IPassword, ISystem {
	private static final Logger LOG = Logger.getLogger(ChangePasswordController.class.getSimpleName());

	private char[] oldPassword, newPassword;

	private String olduserPass, newuserPass, idLogin;

	private UserServices userServices = new UserServices();

	public ChangePasswordController() {
		super();
	}

	public void get() {
		oldPassword = oldpasswordField.getPassword();
		newPassword = newpasswordField.getPassword();
		olduserPass = new String(oldPassword);
		newuserPass = new String(newPassword);
	}

	public void reset() {
		oldpasswordField.setText("");
		newpasswordField.setText("");
	}

	public void change(ActionEvent evt) {
		try {
			get();

			if (olduserPass.isEmpty() || newuserPass.isEmpty() || idLogin.isEmpty()) {
				JOptionPane.showMessageDialog(ChangePasswordController.this, "Data kosong!", "Pesan", JOptionPane.WARNING_MESSAGE);
			} else if (olduserPass.equalsIgnoreCase(newuserPass)) {
				JOptionPane.showMessageDialog(ChangePasswordController.this, "Password lama dan baru\ntidak boleh sama!", "Pesan", JOptionPane.WARNING_MESSAGE);
				reset();
			} else if (!olduserPass.equalsIgnoreCase(Login.getPasswordLogin())) {
				JOptionPane.showMessageDialog(ChangePasswordController.this, "Password lama tidak cocok!", "Pesan", JOptionPane.WARNING_MESSAGE);
				reset();
			} else {
				User user = new User();
				userServices.change(user, Integer.parseInt(idLogin), newuserPass);

				dispose();
				JOptionPane.showMessageDialog(ChangePasswordController.this, "Ganti password sukses.\nSilahkan logout dan login kembali!", "Pesan", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(ChangePasswordController.this, "Ganti password gagal!", "Pesan", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void load() {
		idLogin = Login.getIdLogin();
	}
}