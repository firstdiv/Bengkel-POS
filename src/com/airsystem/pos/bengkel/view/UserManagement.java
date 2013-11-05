package com.airsystem.pos.bengkel.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.airsystem.pos.bengkel.controller.MenuController;
import com.airsystem.pos.bengkel.controller.UserManagementController;
import com.airsystem.pos.bengkel.util.TextUtil;

/**
 * @author Budi Oktaviyan
 */
public class UserManagement extends UserManagementController {

	public UserManagement(MenuController menuController) {
		super();

		this.menuController = menuController;
		initComponents();
		setup();
	}

	private void initComponents() {
		setTitle("Data User");
		setFrameIcon(new ImageIcon(getClass().getResource("../res/admin.png")));
		setIconifiable(true);
		setClosable(true);
		getContentPane().add(basePanel, BorderLayout.CENTER);

		baseLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		baseLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		baseLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		baseLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		basePanel.setLayout(baseLayout);

		namaLabel.setFont(new Font("Verdana", 0, 12));
		namaLabel.setText("Nama");

		roleLabel.setFont(new Font("Verdana", 0, 12));
		roleLabel.setText("Hak Akses");

		usernameLabel.setFont(new Font("Verdana", 0, 12));
		usernameLabel.setText("Username");

		passwordLabel.setFont(new Font("Verdana", 0, 12));
		passwordLabel.setText("Password");

		confirmpasswordLabel.setFont(new Font("Verdana", 0, 12));
		confirmpasswordLabel.setText("Konfirmasi Password");

		namaField.setFont(new Font("Verdana", 0, 12));
		namaField.setColumns(15);
		namaField.setDocument(new TextUtil(30, TextUtil.LETTER));

		roleCombo.setFont(new Font("Verdana", 0, 12));
		roleCombo.setModel(new DefaultComboBoxModel(new String[] { "-- PILIH --", "ADMIN", "USER" }));

		usernameField.setFont(new Font("Verdana", 0, 12));
		usernameField.setColumns(15);
		usernameField.setDocument(new TextUtil(15, TextUtil.ALPHANUMERIC));

		passwordField.setFont(new Font("Verdana", 0, 12));
		passwordField.setColumns(15);
		passwordField.setDocument(new TextUtil(30, TextUtil.PASSWORD));

		confirmpasswordField.setFont(new Font("Verdana", 0, 12));
		confirmpasswordField.setColumns(15);
		confirmpasswordField.setDocument(new TextUtil(30, TextUtil.PASSWORD));

		idField.setFont(new Font("Verdana", 0, 12));
		idField.setColumns(5);

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		searchButton.setIcon(new ImageIcon(getClass().getResource("../res/search.png")));
		searchButton.setFont(new Font("Verdana", 1, 12));
		searchButton.setText("CARI");

		saveButton.setIcon(new ImageIcon(getClass().getResource("../res/save.png")));
		saveButton.setFont(new Font("Verdana", 1, 12));
		saveButton.setText("SIMPAN");
		buttonPanel.add(saveButton);

		editButton.setIcon(new ImageIcon(getClass().getResource("../res/update.png")));
		editButton.setFont(new Font("Verdana", 1, 12));
		editButton.setText("UBAH");
		buttonPanel.add(editButton);

		deleteButton.setIcon(new ImageIcon(getClass().getResource("../res/delete.png")));
		deleteButton.setFont(new Font("Verdana", 1, 12));
		deleteButton.setText("HAPUS");
		buttonPanel.add(deleteButton);

		cancelButton.setIcon(new ImageIcon(getClass().getResource("../res/cancel.png")));
		cancelButton.setFont(new Font("Verdana", 1, 12));
		cancelButton.setText("BATAL");
		buttonPanel.add(cancelButton);

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchButtonActionPerformed(evt);
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				save(evt);
			}
		});

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				update(evt);
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				delete(evt);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		basePanel.add(namaLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(roleLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(usernameLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(passwordLabel, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(confirmpasswordLabel, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(namaField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(roleCombo, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(usernameField, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(passwordField, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(confirmpasswordField, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(searchButton, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(idField, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(buttonPanel, new GridBagConstraints(0, 7, 8, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 20, 0), 0, 0));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 550) / 2, (screenSize.height - 550) / 2, 550, 400);
	}

	private void searchButtonActionPerformed(ActionEvent evt) {
		search();
	}

	private void cancelButtonActionPerformed(ActionEvent evt) {
		cancel();
	}
}