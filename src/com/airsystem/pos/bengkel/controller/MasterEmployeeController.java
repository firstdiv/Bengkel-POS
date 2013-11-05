package com.airsystem.pos.bengkel.controller;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.interfaces.IMaster;
import com.airsystem.pos.bengkel.model.MasterEmployeeModel;
import com.airsystem.pos.bengkel.service.KaryawanServices;
import com.airsystem.pos.bengkel.view.MasterEmployeeDialog;

/**
 * @author Budi Oktaviyan
 */
public class MasterEmployeeController extends MasterEmployeeModel implements IMaster {
	private static final Logger LOG = Logger.getLogger(MasterEmployeeController.class.getSimpleName());

	private String nama, gaji, uangMakan, id;

	private KaryawanServices karyawanServices = new KaryawanServices();

	public MasterEmployeeController() {
		super();
	}

	public void setup() {
		editButton.setVisible(false);
		deleteButton.setVisible(false);
		idField.setVisible(false);
	}

	public void search() {
		dialogMasterEmployee = new MasterEmployeeDialog();
	}

	public void get() {
		nama = namaField.getText();
		gaji = gajiField.getText();
		uangMakan = uangmakanField.getText();
		id = idField.getText();
	}

	public void reset() {
		namaField.setText("");
		gajiField.setText("");
		uangmakanField.setText("");
		idField.setText("");
	}

	public void save(ActionEvent evt) {
	}

	public void update(ActionEvent evt) {
	}

	public void delete(ActionEvent evt) {
	}

	public void cancel() {
		reset();

		try {
			saveButton.setVisible(true);
			editButton.setVisible(false);
			deleteButton.setVisible(false);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
}