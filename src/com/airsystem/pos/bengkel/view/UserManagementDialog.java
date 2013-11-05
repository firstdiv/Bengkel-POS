package com.airsystem.pos.bengkel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.airsystem.pos.bengkel.controller.UserManagementDialogController;

/**
 * @author Budi Oktaviyan
 */
public class UserManagementDialog extends UserManagementDialogController {

	public UserManagementDialog() {
		super();

		this.setIconImage(new ImageIcon(getClass().getResource("../res/detail.png")).getImage());
		initComponents();
		load();
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Data User");

		getContentPane().add(basePanel, BorderLayout.NORTH);
		getContentPane().add(tablePanel, BorderLayout.CENTER);

		baseLayout.columnWidths = new int[] { 10, 0, 0, 0, 0, 0 };
		baseLayout.rowHeights = new int[] { 0, 0 };
		baseLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		baseLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		basePanel.setLayout(baseLayout);

		tableLayout.columnWidths = new int[] { 0, 0 };
		tableLayout.rowHeights = new int[] { 0, 0 };
		tableLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		tableLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		tablePanel.setLayout(tableLayout);

		searchLabel.setFont(new Font("Verdana", 0, 12));
		searchLabel.setText("Cari Berdasarkan");

		searchCombo.setFont(new Font("Verdana", 0, 12));
		searchCombo.setModel(new DefaultComboBoxModel(new String[] { "-- PILIH --", "Nama", "Username" }));

		searchField.setFont(new Font("Verdana", 0, 12));
		searchField.setColumns(15);

		searchButton.setIcon(new ImageIcon(getClass().getResource("../res/search.png")));
		searchButton.setFont(new Font("Verdana", 1, 12));
		searchButton.setText("CARI");

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchButtonActionPerformed(evt);
			}
		});

		tableScroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 0, 0), new Color(0, 0, 0)),
															   "Klik 2x untuk pilih data user",
															   TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12)));

		tableData.setFont(new Font("Verdana", 0, 12));
		tableData.setModel(tableModel);

		tableData.getTableHeader().setReorderingAllowed(false);
		tableData.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableData.getColumnModel().getColumn(1).setPreferredWidth(100);

		/* Hide Column */
		tableData.getColumnModel().getColumn(3).setMaxWidth(0);
		tableData.getColumnModel().getColumn(3).setMinWidth(0);
		tableData.getColumnModel().getColumn(3).setPreferredWidth(0);

		tableData.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tableDataMouseClicked(evt);
			}
		});
		tableScroll.setViewportView(tableData);

		basePanel.add(searchLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 10, 10), 0, 0));
		basePanel.add(searchCombo, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 10, 10), 0, 0));
		basePanel.add(searchField, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 10, 10), 0, 0));
		basePanel.add(searchButton, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 0, 10, 10), 0, 0));
		tablePanel.add(tableScroll, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		setSize(600, 300);
		setLocationRelativeTo(this);
	}

	private void searchButtonActionPerformed(ActionEvent evt) {
		search();
	}

	private void tableDataMouseClicked(MouseEvent evt) {
		row = tableData.getSelectedRow();

		if (evt.getClickCount() == 2) {
			get();
			dispose();
		}
	}
}