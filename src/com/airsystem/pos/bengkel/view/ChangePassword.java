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

import com.airsystem.pos.bengkel.controller.ChangePasswordController;
import com.airsystem.pos.bengkel.controller.MenuController;
import com.airsystem.pos.bengkel.util.TextUtil;

/**
 * @author Budi Oktaviyan
 */
public class ChangePassword extends ChangePasswordController {

	public ChangePassword(MenuController menuController) {
		super();

		this.menuController = menuController;
		initComponents();
		load();
	}

	private void initComponents() {
		setTitle("Ganti Password");
		setFrameIcon(new ImageIcon(getClass().getResource("../res/password.png")));
		setIconifiable(true);
		setClosable(true);
		getContentPane().add(basePanel, BorderLayout.CENTER);

		baseLayout.columnWidths = new int[] {0, 0, 30, 30, 30, 30, 30, 30, 30, 0, 30, 30, 0};
		baseLayout.rowHeights = new int[] {30, 0, 0, 30, 30, 0, 30, 30, 0};
		baseLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		baseLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		basePanel.setLayout(baseLayout);

		oldpasswordLabel.setFont(new Font("Verdana", 0, 12));
		oldpasswordLabel.setText("Password Lama");

		newpasswordLabel.setFont(new Font("Verdana", 0, 12));
		newpasswordLabel.setText("Password Baru");

		oldpasswordField.setFont(new Font("Verdana", 0, 12));
		oldpasswordField.setColumns(15);
		oldpasswordField.setDocument(new TextUtil(30, TextUtil.PASSWORD));

		newpasswordField.setFont(new Font("Verdana", 0, 12));
		newpasswordField.setColumns(15);
		newpasswordField.setDocument(new TextUtil(30, TextUtil.PASSWORD));

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		editButton.setIcon(new ImageIcon(getClass().getResource("../res/update.png")));
		editButton.setFont(new Font("Verdana", 1, 12));
		editButton.setText("UBAH");
		buttonPanel.add(editButton);

		cancelButton.setIcon(new ImageIcon(getClass().getResource("../res/cancel.png")));
		cancelButton.setFont(new Font("Verdana", 1, 12));
		cancelButton.setText("BATAL");
		buttonPanel.add(cancelButton);

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				change(evt);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		basePanel.add(oldpasswordLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 20, 20, 10), 0, 0));
		basePanel.add(newpasswordLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 20, 10, 10), 0, 0));
		basePanel.add(oldpasswordField, new GridBagConstraints(2, 1, 10, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(30, 0, 20, 20), 0, 0));
		basePanel.add(newpasswordField, new GridBagConstraints(2, 2, 10, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 10, 20), 0, 0));
		basePanel.add(buttonPanel, new GridBagConstraints(0, 4, 12, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 400) / 2, (screenSize.height - 400) / 2, 400, 250);
	}

	private void cancelButtonActionPerformed(ActionEvent evt) {
		reset();
	}
}