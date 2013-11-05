package com.airsystem.pos.bengkel.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

import com.airsystem.pos.bengkel.controller.LoginController;
import com.airsystem.pos.bengkel.util.TextUtil;

/**
 * @author Budi Oktaviyan
 */
public class Login extends LoginController {

	public Login() {
		super();

		this.setIconImage(new ImageIcon(getClass().getResource("../res/login.png")).getImage());
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Login Aplikasi");
		getContentPane().add(basePanel, BorderLayout.CENTER);

		baseLayout.columnWidths = new int[] {0, 0, 30, 30, 30, 30, 30, 30, 30, 0, 30, 30, 0};
		baseLayout.rowHeights = new int[] {30, 0, 0, 30, 30, 0, 30, 30, 0};
		baseLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		baseLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		basePanel.setLayout(baseLayout);

		userLabel.setFont(new Font("Verdana", 0, 12));
		userLabel.setText("Username");

		passLabel.setFont(new Font("Verdana", 0, 12));
		passLabel.setText("Password");

		userField.setFont(new Font("Verdana", 0, 12));
		userField.setColumns(15);
		userField.setDocument(new TextUtil(15, TextUtil.ALPHANUMERIC));

		passField.setFont(new Font("Verdana", 0, 12));
		passField.setColumns(15);
		passField.setDocument(new TextUtil(30, TextUtil.PASSWORD));

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		loginButton.setIcon(new ImageIcon(getClass().getResource( "../res/logon.png")));
		loginButton.setFont(new Font("Verdana", 1, 12));
		loginButton.setText("LOGIN");
		buttonPanel.add(loginButton);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				login(evt);
			}
		});

		basePanel.add(userLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(15, 0, 20, 30), 0, 0));
		basePanel.add(passLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 10, 30), 0, 0));
		basePanel.add(userField, new GridBagConstraints(2, 1, 9, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(15, 0, 20, 10), 0, 0));
		basePanel.add(passField, new GridBagConstraints(2, 2, 9, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 10, 10), 0, 0));
		basePanel.add(buttonPanel, new GridBagConstraints(0, 4, 12, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		setSize(400, 250);
		setLocationRelativeTo(this);
	}
}