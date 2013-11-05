package com.airsystem.pos.bengkel.interfaces;

import java.awt.event.ActionEvent;

/**
 * @author Budi Oktaviyan
 */
public interface IPassword extends IBase {

	public void change(ActionEvent evt);

	public void logout();
}