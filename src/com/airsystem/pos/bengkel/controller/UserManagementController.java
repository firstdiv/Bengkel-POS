package com.airsystem.pos.bengkel.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.entity.Role;
import com.airsystem.pos.bengkel.entity.User;
import com.airsystem.pos.bengkel.interfaces.IMaster;
import com.airsystem.pos.bengkel.model.UserManagementModel;
import com.airsystem.pos.bengkel.service.UserServices;
import com.airsystem.pos.bengkel.view.UserManagementDialog;

/**
 * @author Budi Oktaviyan
 */
public class UserManagementController extends UserManagementModel implements IMaster {
	private static final Logger LOG = Logger.getLogger(UserManagementController.class.getSimpleName());

	private char[] password, confirm;

	private String nama, role, username, userPassword, confirmuserPassword, id;

	private UserServices userServices = new UserServices();

	public UserManagementController() {
		super();
	}

	public void setup() {
		editButton.setVisible(false);
		deleteButton.setVisible(false);
		idField.setVisible(false);
	}

	public void search() {
		dialogUserManagement = new UserManagementDialog();

		try {
			if (((UserManagementDialog) dialogUserManagement).getNama() == null
			|| ((UserManagementDialog) dialogUserManagement).getUsername() == null) {
				cancel();
			} else {
				namaField.setText(((UserManagementDialog) dialogUserManagement).getNama());
				usernameField.setText(((UserManagementDialog) dialogUserManagement).getUsername());
				roleCombo.setSelectedItem(((UserManagementDialog) dialogUserManagement).getRole());
				idField.setText(((UserManagementDialog) dialogUserManagement).getId());

				passwordField.setText("");
				confirmpasswordField.setText("");

				saveButton.setVisible(false);
				editButton.setVisible(true);
				deleteButton.setVisible(true);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public void get() {
		nama = namaField.getText();
		role = roleCombo.getSelectedItem().toString();
		username = usernameField.getText();
		password = passwordField.getPassword();
		confirm = confirmpasswordField.getPassword();
		userPassword = new String(password);
		confirmuserPassword = new String(confirm);
		id = idField.getText();
	}

	public void reset() {
		namaField.setText("");
		roleCombo.setSelectedIndex(0);
		usernameField.setText("");
		passwordField.setText("");
		confirmpasswordField.setText("");
		idField.setText("");
	}

	public void save(ActionEvent evt) {
		try {
			get();

			if (nama.isEmpty() || role.equalsIgnoreCase("-- PILIH --") || username.isEmpty()
			||  userPassword.isEmpty() || confirmuserPassword.isEmpty()) {
				JOptionPane.showMessageDialog(UserManagementController.this, "Data kosong!", "Pesan Sistem", JOptionPane.WARNING_MESSAGE);
			} else if (!userPassword.equalsIgnoreCase(confirmuserPassword)) {
				JOptionPane.showMessageDialog(UserManagementController.this, "Konfirmasi password tidak sama!", "Pesan Sistem", JOptionPane.WARNING_MESSAGE);
			} else {
				User user = new User();
				user.setNama(nama);
				user.setUsername(username);
				user.setPassword(confirmuserPassword);

				Role roles = new Role();
				roles.setRole(role);
				roles.setUser(user);

				userServices.saveOrUpdate(user, roles);

				JOptionPane.showMessageDialog(UserManagementController.this, "Data berhasil disimpan", "Pesan Sistem", JOptionPane.INFORMATION_MESSAGE);
				reset();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(UserManagementController.this, "Simpan data gagal!", "Pesan Sistem", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void update(ActionEvent evt) {
		try {
			get();

			if (nama.isEmpty() || role.equalsIgnoreCase("-- PILIH --") || username.isEmpty()
			||  userPassword.isEmpty() || confirmuserPassword.isEmpty() || id.isEmpty()) {
				JOptionPane.showMessageDialog(UserManagementController.this, "Data kosong!", "Pesan Sistem", JOptionPane.WARNING_MESSAGE);
			} else if (!userPassword.equalsIgnoreCase(confirmuserPassword)) {
				JOptionPane.showMessageDialog(UserManagementController.this, "Konfirmasi password tidak sama!", "Pesan Sistem", JOptionPane.WARNING_MESSAGE);
			} else {
				User user = new User();
				user.setId(Integer.parseInt(id));
				user.setNama(nama);
				user.setUsername(username);
				user.setPassword(confirmuserPassword);

				Role roles = new Role();
				roles.setId(Integer.parseInt(id));
				roles.setRole(role);
				roles.setUser(user);

				userServices.saveOrUpdate(user, roles);

				JOptionPane.showMessageDialog(UserManagementController.this, "Data telah dirubah", "Pesan Sistem", JOptionPane.INFORMATION_MESSAGE);
				cancel();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(UserManagementController.this, "Ubah data gagal!", "Pesan Sistem", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void delete(ActionEvent evt) {
		try {
			get();

			if (nama.isEmpty() || role.equalsIgnoreCase("-- PILIH --") || username.isEmpty() || id.isEmpty()) {
				JOptionPane.showMessageDialog(UserManagementController.this, "Data kosong!", "Pesan Sistem", JOptionPane.WARNING_MESSAGE);
			} else {
				User user = new User();
				user.setId(Integer.parseInt(id));
				user.setNama(nama);
				user.setUsername(username);

				Role roles = new Role();
				roles.setId(Integer.parseInt(id));
				roles.setRole(role);
				roles.setUser(user);

				userServices.delete(roles, user);

				JOptionPane.showMessageDialog(UserManagementController.this, "Data berhasil dihapus", "Pesan Sistem", JOptionPane.INFORMATION_MESSAGE);
				cancel();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(UserManagementController.this, "Hapus data gagal!", "Pesan Sistem", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cancel() {
		reset();

		try {
			saveButton.setVisible(true);
			editButton.setVisible(false);
			deleteButton.setVisible(false);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
}