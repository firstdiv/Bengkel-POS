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

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import com.airsystem.pos.bengkel.controller.MenuController;

/**
 * @author Budi Oktaviyan
 */
public class Menu extends MenuController {

	public Menu() {
		super();

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

		masterMenu.setFont(new Font("Verdana", 1, 14));
		masterMenu.setText("Data");

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

		itemEmployee.setIcon(new ImageIcon(getClass().getResource("../res/user.png")));
		itemEmployee.setFont(new Font("Verdana", 0, 14));
		itemEmployee.setText("Data Karyawan");

		itemEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openMasterEmployee(evt);
			}
		});

		itemBilling.setIcon(new ImageIcon(getClass().getResource("../res/wallet.png")));
		itemBilling.setFont(new Font("Verdana", 0, 14));
		itemBilling.setText("Data Tagihan");

		itemBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openMasterBilling(evt);
			}
		});

		itemVehicle.setIcon(new ImageIcon(getClass().getResource("../res/vehicle.png")));
		itemVehicle.setFont(new Font("Verdana", 0, 14));
		itemVehicle.setText("Data Kendaraan");

		itemVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openMasterVehicle(evt);
			}
		});

		itemCustomer.setIcon(new ImageIcon(getClass().getResource("../res/customer.png")));
		itemCustomer.setFont(new Font("Verdana", 0, 14));
		itemCustomer.setText("Data Pelanggan");

		itemCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openMasterCustomer(evt);
			}
		});

		itemSparepart.setIcon(new ImageIcon(getClass().getResource("../res/sparepart.png")));
		itemSparepart.setFont(new Font("Verdana", 0, 14));
		itemSparepart.setText("Data Sparepart");

		itemSparepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openMasterSparepart(evt);
			}
		});

		itemJasa.setIcon(new ImageIcon(getClass().getResource("../res/jasa.png")));
		itemJasa.setFont(new Font("Verdana", 0, 14));
		itemJasa.setText("Data Jenis Service");

		itemJasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openMasterJasa(evt);
			}
		});

		itemSparepartOrder.setIcon(new ImageIcon(getClass().getResource("../res/sparepart.png")));
		itemSparepartOrder.setFont(new Font("Verdana", 0, 14));
		itemSparepartOrder.setText("Pesan Sparepart");

		itemSparepartOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openSparepartOrder(evt);
			}
		});

		itemJasaOrder.setIcon(new ImageIcon(getClass().getResource("../res/jasa.png")));
		itemJasaOrder.setFont(new Font("Verdana", 0, 14));
		itemJasaOrder.setText("Jasa Service");

		itemJasaOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openJasaOrder(evt);
			}
		});

		timeLabel.setFont(new Font("Verdana", 1, 12));

		systemMenu.add(itemUserManagement);
		systemMenu.add(itemChangePassword);
		systemMenu.add(systemSeparator);
		systemMenu.add(itemLogout);

		masterMenu.add(itemEmployee);
		masterMenu.add(itemBilling);
		masterMenu.add(itemVehicle);
		masterMenu.add(itemCustomer);
		masterMenu.add(itemSparepart);
		masterMenu.add(itemJasa);

		transactionMenu.add(itemSparepartOrder);
		transactionMenu.add(itemJasaOrder);

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
}