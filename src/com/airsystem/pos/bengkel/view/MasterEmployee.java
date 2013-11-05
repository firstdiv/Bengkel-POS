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

import javax.swing.ImageIcon;

import com.airsystem.pos.bengkel.controller.MasterEmployeeController;
import com.airsystem.pos.bengkel.controller.MenuController;
import com.airsystem.pos.bengkel.util.TextUtil;

/**
 * @author Budi Oktaviyan
 */
public class MasterEmployee extends MasterEmployeeController {

	public MasterEmployee(MenuController menuController) {
		super();

		this.menuController = menuController;
		initComponents();
		setup();
	}

	private void initComponents() {
		setTitle("Data Karyawan");
		setFrameIcon(new ImageIcon(getClass().getResource("../res/user.png")));
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

		gajiLabel.setFont(new Font("Verdana", 0, 12));
		gajiLabel.setText("Gaji/bln");

		uangmakanLabel.setFont(new Font("Verdana", 0, 12));
		uangmakanLabel.setText("Uang Makan/bln");

		namaField.setFont(new Font("Verdana", 0, 12));
		namaField.setColumns(15);
		namaField.setDocument(new TextUtil(30, TextUtil.LETTER));

		gajiField.setFont(new Font("Verdana", 0, 12));
		gajiField.setColumns(15);
		gajiField.setDocument(new TextUtil(17, TextUtil.NUMBER));

		uangmakanField.setFont(new Font("Verdana", 0, 12));
		uangmakanField.setColumns(15);
		uangmakanField.setDocument(new TextUtil(17, TextUtil.NUMBER));

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
				// TODO Implement later
			}
		});

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO Implement later
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO Implement later
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		basePanel.add(namaLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(gajiLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(uangmakanLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(namaField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(gajiField, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(uangmakanField, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(searchButton, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(idField, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(buttonPanel, new GridBagConstraints(0, 4, 8, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(15, 0, 0, 0), 0, 0));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 530) / 2, (screenSize.height - 530) / 2, 530, 300);
	}

	private void searchButtonActionPerformed(ActionEvent evt) {
		search();
	}

	private void cancelButtonActionPerformed(ActionEvent evt) {
		// TODO Implement later
	}
}