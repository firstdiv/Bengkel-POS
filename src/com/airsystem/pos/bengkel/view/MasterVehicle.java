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

import com.airsystem.pos.bengkel.controller.MasterVehicleController;
import com.airsystem.pos.bengkel.controller.MenuController;
import com.airsystem.pos.bengkel.util.TextUtil;

/**
 * @author Budi Oktaviyan
 */
public class MasterVehicle extends MasterVehicleController {

	public MasterVehicle(MenuController menuController) {
		super();

		this.menuController = menuController;
		initComponents();
	}

	private void initComponents() {
		setTitle("Data Kendaraan");
		setFrameIcon(new ImageIcon(getClass().getResource("../res/vehicle.png")));
		setIconifiable(true);
		setClosable(true);
		getContentPane().add(basePanel, BorderLayout.CENTER);

		baseLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		baseLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		baseLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		baseLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		basePanel.setLayout(baseLayout);

		merkLabel.setFont(new Font("Verdana", 0, 12));
		merkLabel.setText("Merk");

		submerkLabel.setFont(new Font("Verdana", 0, 12));
		submerkLabel.setText("Sub Merk");

		merkField.setFont(new Font("Verdana", 0, 12));
		merkField.setColumns(15);
		merkField.setDocument(new TextUtil(30, TextUtil.LETTER));

		submerkField.setFont(new Font("Verdana", 0, 12));
		submerkField.setColumns(15);
		submerkField.setDocument(new TextUtil(30, TextUtil.ALPHASPACE));

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

		basePanel.add(merkLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(submerkLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(merkField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(submerkField, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(searchButton, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 30, 15, 0), 0, 0));
		basePanel.add(idField, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 30, 15, 0), 0, 0));
		basePanel.add(buttonPanel, new GridBagConstraints(0, 3, 8, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(15, 0, 0, 0), 0, 0));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 530) / 2, (screenSize.height - 530) / 2, 530, 250);
	}

	private void searchButtonActionPerformed(ActionEvent evt) {
		// TODO Implement later
	}

	private void cancelButtonActionPerformed(ActionEvent evt) {
		// TODO Implement later
	}
}