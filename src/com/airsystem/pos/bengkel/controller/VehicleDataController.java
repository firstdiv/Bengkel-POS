package com.airsystem.pos.bengkel.controller;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.interfaces.IMaster;
import com.airsystem.pos.bengkel.model.VehicleDataModel;

/**
 * @author Fanny Irawan S (fannyirawans@gmail.com)
 */
public class VehicleDataController extends VehicleDataModel implements IMaster {
	
	private static final long 	serialVersionUID = 2457857808747237070L;
	private static final Logger LOG = Logger.getLogger(VehicleDataController.class.getSimpleName());
	
	public VehicleDataController() {
		super();
	}
	
	@Override
	public void setup() {
		
	}

	@Override
	public void search() {
		
	}

	@Override
	public void get() {
		
	}

	@Override
	public void reset() {
		
	}

	@Override
	public void save(ActionEvent evt) {
		
	}

	@Override
	public void update(ActionEvent evt) {
		
	}

	@Override
	public void delete(ActionEvent evt) {
		
	}

	@Override
	public void cancel() {
		
	}

}
