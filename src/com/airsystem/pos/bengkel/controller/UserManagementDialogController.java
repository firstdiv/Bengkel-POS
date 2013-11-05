package com.airsystem.pos.bengkel.controller;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.component.TableFrame;
import com.airsystem.pos.bengkel.entity.User;
import com.airsystem.pos.bengkel.interfaces.IMasterLookup;
import com.airsystem.pos.bengkel.model.UserManagementDialogModel;
import com.airsystem.pos.bengkel.service.UserServices;

/**
 * @author Budi Oktaviyan
 */
public class UserManagementDialogController extends UserManagementDialogModel implements IMasterLookup {
	private static final Logger LOG = Logger.getLogger(UserManagementDialogController.class.getSimpleName());

	private String search;

	private UserServices userServices = new UserServices();

	public UserManagementDialogController() {
		super();
	}

	public void setup() {
		TableFrame.deleteTable(tableData, tableModel);
	}

	public void get() {
		setNama(tableData.getValueAt(row, 0).toString());
		setUsername(tableData.getValueAt(row, 1).toString());
		setRole(tableData.getValueAt(row, 2).toString());
		setId(tableData.getValueAt(row, 3).toString());
	}

	public void reset() {
		searchField.setText("");
		searchCombo.requestFocus();
	}

	public void load() {
		try {
			List<User> users = userServices.select();
			for (User user : users) {
				Vector<String> vector = new Vector<String>();
				vector.add(user.getNama());
				vector.add(user.getUsername());
				vector.add(user.getRole().getRole());
				vector.add(String.valueOf(user.getId()));
				tableModel.addRow(vector);
			}
			tableData.setModel(tableModel);

			this.setResizable(false);
			this.setVisible(true);
		} catch (Exception e) {
			this.setVisible(false);
			LOG.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(UserManagementDialogController.this, "Load data gagal!", "Pesan", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void category() {
		switch (searchCombo.getSelectedIndex()) {
		case 1:
			search = "nama";
			break;
		case 2:
			search = "username";
			break;
		}
	}

	public void search() {
		if (searchCombo.getSelectedIndex() == 0 || searchField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(UserManagementDialogController.this, "Silahkan pilih data!", "Pesan", JOptionPane.WARNING_MESSAGE);
			reset();
		} else {
			try {
				category();
				setup();

				List<User> users = userServices.select(search, searchField.getText());
				for (User user : users) {
					Vector<String> vector = new Vector<String>();
					vector.add(user.getNama());
					vector.add(user.getUsername());
					vector.add(user.getRole().getRole());
					vector.add(String.valueOf(user.getId()));
					tableModel.addRow(vector);
				}

				tableData.setModel(tableModel);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(UserManagementDialogController.this, "Load data gagal!", "Pesan", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}