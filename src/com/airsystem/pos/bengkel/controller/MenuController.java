package com.airsystem.pos.bengkel.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.interfaces.IMenu;
import com.airsystem.pos.bengkel.model.MenuModel;
import com.airsystem.pos.bengkel.view.ChangePassword;
import com.airsystem.pos.bengkel.view.Login;
import com.airsystem.pos.bengkel.view.UserManagement;

/**
 * @author Budi Oktaviyan
 */
public class MenuController extends MenuModel implements IMenu {
	private static final Logger LOG = Logger.getLogger(MenuController.class.getSimpleName());

	private boolean isFormOpen, isSystemExit;

	private String setToday, setDate, setMonth, setYear, getDay, getDate, getHour, hours, minutes, seconds;

	private String[] month, days;

	private Calendar calendar;

	private Date date;

	private SimpleDateFormat dateFormat, formatDate, formatMonth, formatYear;

	private Timer workingTimer;

	private JInternalFrame[] internalFrame;

	public MenuController() {
		super();
	}

	public void setup(boolean authority) {
		itemUserManagement.setVisible(authority);
		itemChangePassword.setVisible(!authority);
		masterMenu.setVisible(authority);
	}

	public void timer() {
		date = new Date();
		dateFormat = new SimpleDateFormat("EEEE");
		setToday = dateFormat.format(date);

		month = new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni",
							   "Juli", "Agustus", "September", "Oktober", "November", "Desember" };
		days = new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu" };

		formatDate = new SimpleDateFormat("dd");
		formatMonth = new SimpleDateFormat("MM");
		formatYear = new SimpleDateFormat("yyyy");

		setDate = formatDate.format(date);
		setMonth = formatMonth.format(date);
		setYear = formatYear.format(date);

		int i = 0;
		if (setToday.equals("Monday")) {
			i = 0;
		} else if (setToday.equals("Tuesday")) {
			i = 1;
		} else if (setToday.equals("Wednesday")) {
			i = 2;
		} else if (setToday.equals("Thursday")) {
			i = 3;
		} else if (setToday.equals("Friday")) {
			i = 4;
		} else if (setToday.equals("Saturday")) {
			i = 5;
		} else if (setToday.equals("Sunday")) {
			i = 6;
		}

		getDay = days[i];
		getDate = setDate + " " + month[Integer.parseInt(setMonth) - 1] + " " + setYear;

		workingTimer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calendar = Calendar.getInstance();

				int h = calendar.get(Calendar.HOUR_OF_DAY);
				int m = calendar.get(Calendar.MINUTE);
				int s = calendar.get(Calendar.SECOND);

				if (h <= 9) {
					hours = "0" + h;
				} else {
					hours = "" + h;
				}
				if (m <= 9) {
					minutes = "0" + m;
				} else {
					minutes = "" + m;
				}
				if (s <= 9) {
					seconds = "0" + s;
				} else {
					seconds = "" + s;
				}

				getHour = hours + ":" + minutes + ":" + seconds;
				timeLabel.setText(getDay + ", " + getDate + " | " + getHour);
			}
		});

		workingTimer.start();
	}

	public void logout(ActionEvent evt) {
		isSystemExit = false;
		checkFormOpen();

		if (!isFormOpen && !isSystemExit) {
			Login userLogin = new Login();
			userLogin.setResizable(false);
			userLogin.setVisible(true);
		}
	}

	public void exit(WindowEvent evt) {
		if (askExit()) {
			checkFormOpen();
		} else {
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
	}

	public void openUserManagement(ActionEvent evt) {
		if (!desktopPane.isAncestorOf(formUserManagement)) {
			formUserManagement = new UserManagement(this);
			desktopPane.add(formUserManagement);

			try {
				formUserManagement.setVisible(true);
				formUserManagement.setSelected(true);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(MenuController.this, "Gagal buka form!", "Pesan", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			try {
				formUserManagement.setSelected(true);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(MenuController.this, "Gagal buka form!", "Pesan", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void openChangePassword(ActionEvent evt) {
		if (!desktopPane.isAncestorOf(formChangePassword)) {
			formChangePassword = new ChangePassword(this);
			desktopPane.add(formChangePassword);

			try {
				formChangePassword.setVisible(true);
				formChangePassword.setSelected(true);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(MenuController.this, "Gagal buka form!", "Pesan", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			try {
				formChangePassword.setSelected(true);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(MenuController.this, "Gagal buka form!", "Pesan", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void openMasterEmployee(ActionEvent evt) {
		// TODO Implement later
	}

	public void openMasterBilling(ActionEvent evt) {
		// TODO Implement later
	}

	public void openMasterVehicle(ActionEvent evt) {
		// TODO Implement later
	}

	public void openMasterCustomer(ActionEvent evt) {
		// TODO Implement later
	}

	public void openMasterSparepart(ActionEvent evt) {
		// TODO Implement later
	}

	public void openMasterJasa(ActionEvent evt) {
		// TODO Implement later
	}

	public void openSparepartOrder(ActionEvent evt) {
		// TODO Implement later
	}

	public void openJasaOrder(ActionEvent evt) {
		// TODO Implement later
	}

	private boolean askExit() {
		try {
			Object[] objects = { "Ya", "Tidak" };
			int ask = JOptionPane.showOptionDialog(MenuController.this, "Keluar dari aplikasi?", "Konfirmasi",
					  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, objects, objects[0]);

			if (ask == 0) {
				return isSystemExit = true;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return false;
	}

	private void checkFormOpen() {
		internalFrame = desktopPane.getAllFrames();

		if (internalFrame.length > 0) {
			isFormOpen = true;

			JOptionPane.showMessageDialog(MenuController.this, "Form masih terbuka!", "Pesan", JOptionPane.ERROR_MESSAGE);
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else if (internalFrame.length == 0) {
			isFormOpen = false;

			if (isSystemExit) {
				System.exit(0);
			} else {
				dispose();
			}
		}
	}
}