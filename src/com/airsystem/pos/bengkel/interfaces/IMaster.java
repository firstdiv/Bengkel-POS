package com.airsystem.pos.bengkel.interfaces;

import java.awt.event.ActionEvent;

/**
 * @author Budi Oktaviyan
 */
public interface IMaster extends IMasterBase {

	public void save(ActionEvent evt);

	public void update(ActionEvent evt);

	public void delete(ActionEvent evt);

	public void cancel();
}