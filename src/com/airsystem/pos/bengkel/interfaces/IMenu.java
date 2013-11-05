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
}