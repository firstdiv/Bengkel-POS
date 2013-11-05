package com.airsystem.pos.bengkel.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * @author Budi Oktaviyan
 */
public interface IMenu {

	public void setup(boolean authority);

	public void timer();

	public void logout(ActionEvent evt);

	public void exit(WindowEvent evt);

	public void openUserManagement(ActionEvent evt);

	public void openChangePassword(ActionEvent evt);

	public void openMasterEmployee(ActionEvent evt);

	public void openMasterBilling(ActionEvent evt);

	public void openMasterVehicle(ActionEvent evt);

	public void openMasterCustomer(ActionEvent evt);

	public void openMasterSparepart(ActionEvent evt);

	public void openMasterJasa(ActionEvent evt);

	public void openSparepartOrder(ActionEvent evt);

	public void openJasaOrder(ActionEvent evt);
}