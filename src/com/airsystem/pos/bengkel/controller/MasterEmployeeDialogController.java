package com.airsystem.pos.bengkel.controller;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.component.TableFrame;
import com.airsystem.pos.bengkel.interfaces.IMasterLookup;
import com.airsystem.pos.bengkel.interfaces.ISystem;
import com.airsystem.pos.bengkel.model.MasterEmployeeDialogModel;

/**
 * @author Budi Oktaviyan
 */
public class MasterEmployeeDialogController extends MasterEmployeeDialogModel implements IMasterLookup, ISystem {
	private static final Logger LOG = Logger.getLogger(MasterEmployeeDialogController.class.getSimpleName());

	// TODO Implement later
	// private String search;

	// private KaryawanServices karyawanServices = new KaryawanServices();

	public MasterEmployeeDialogController() {
		super();
	}

	public void setup() {
		TableFrame.deleteTable(tableData, tableModel);
	}

	public void get() {
	}

	public void reset() {
		searchField.setText("");
		searchCombo.requestFocus();
	}

	public void category() {
	}

	public void search() {
	}

	public void load() {
		try {
			this.setResizable(false);
			this.setVisible(true);
		} catch (Exception e) {
			this.setVisible(false);
			LOG.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(MasterEmployeeDialogController.this, "Load data gagal!", "Pesan", JOptionPane.ERROR_MESSAGE);
		}
	}
}