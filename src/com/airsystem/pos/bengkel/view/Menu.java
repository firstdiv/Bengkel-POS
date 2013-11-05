package com.airsystem.pos.bengkel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import com.airsystem.pos.bengkel.controller.MenuController;

/**
 * @author Budi Oktaviyan
 */
public class Menu extends MenuController {
	
	private final Font VERDANA_MENU;
	private final Font VERDANA_ITEM;
	
	public Menu() {
		super();
		
		VERDANA_MENU = new Font("Verdana", 1, 14);
		VERDANA_ITEM = new Font("Verdana", 0, 14);
		
		this.setIconImage(new ImageIcon(getClass().getResource("../res/logo.png")).getImage());
		initComponents();
		timer();
	}

	private void initComponents() {
		setTitle("Jasa Service Bengkel v.1");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exit(evt);
			}
		});

		desktopPane.setBackground(Color.gray);
		statusPane.setBorder(BorderFactory.createEtchedBorder(new Color(153, 153, 153), null));

		getContentPane().add(desktopPane, BorderLayout.CENTER);
		getContentPane().add(statusPane, BorderLayout.PAGE_END);

		systemMenu.setFont(new Font("Verdana", 1, 14));
		systemMenu.setText("Sistem");

		initMasterMenu();

		transactionMenu.setFont(new Font("Verdana", 1, 14));
		transactionMenu.setText("Transaksi");

		itemUserManagement.setIcon(new ImageIcon(getClass().getResource("../res/admin.png")));
		itemUserManagement.setFont(new Font("Verdana", 0, 14));
		itemUserManagement.setText("Data User");

		itemUserManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openUserManagement(evt);
			}
		});

		itemChangePassword.setIcon(new ImageIcon(getClass().getResource("../res/password.png")));
		itemChangePassword.setFont(new Font("Verdana", 0, 14));
		itemChangePassword.setText("Ganti Password");

		itemChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openChangePassword(evt);
			}
		});

		itemLogout.setIcon(new ImageIcon(getClass().getResource("../res/logout.png")));
		itemLogout.setFont(new Font("Verdana", 0, 14));
		itemLogout.setText("Logout");

		itemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				logout(evt);
			}
		});

		timeLabel.setFont(new Font("Verdana", 1, 12));

		systemMenu.add(itemUserManagement);
		systemMenu.add(itemChangePassword);
		systemMenu.add(systemSeparator);
		systemMenu.add(itemLogout);

		menuBar.add(systemMenu);
		menuBar.add(masterMenu);
		menuBar.add(transactionMenu);
		setJMenuBar(menuBar);

		GroupLayout statusLayout = new GroupLayout(statusPane);
		statusPane.setLayout(statusLayout);
		statusLayout.setHorizontalGroup(statusLayout.createParallelGroup(GroupLayout.LEADING).add(statusLayout.createSequentialGroup()
																							 .addPreferredGap(LayoutStyle.RELATED, 550, Short.MAX_VALUE).add(timeLabel)
																							 .add(10, 10, 10)));

		statusLayout.setVerticalGroup(statusLayout.createParallelGroup(GroupLayout.LEADING).add(statusLayout.createParallelGroup(GroupLayout.BASELINE)
																						   .add(timeLabel)));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setLocationRelativeTo(this);
	}
	
	/**
	 * Initialize Master menu button.
	 */
	private void initMasterMenu() {
		masterMenu.setFont(VERDANA_MENU);
		masterMenu.setText("Data");
		
		itemVehicleData.setIcon(new ImageIcon(getClass().getResource("../res/vehicle.png")));
		itemVehicleData.setFont(VERDANA_ITEM);
		itemVehicleData.setText("Data Karyawan");
		
		itemVehicleData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openVehicleData(evt);
			}
		});
		
		masterMenu.add(itemVehicleData);
	}
	
}
