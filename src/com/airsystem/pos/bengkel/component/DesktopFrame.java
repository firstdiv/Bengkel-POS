package com.airsystem.pos.bengkel.component;

import java.beans.PropertyVetoException;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;

import com.airsystem.pos.bengkel.controller.MenuController;

/**
 * @author Budi Oktaviyan
 */
public class DesktopFrame extends JInternalFrame {
	private static final Logger LOG = Logger.getLogger(DesktopFrame.class.getSimpleName());

	protected boolean isMaximum = false;

	protected MenuController menuController;

	protected JDialog dialogUserManagement, dialogMasterEmployee, dialogMasterVehicle;

	public void setMaximum(boolean b) {
		isMaximum = b;

		if (isVisible() == false) {
			return;
		}

		try {
			super.setMaximum(b);
		} catch (PropertyVetoException vetoEx) {
			LOG.error(vetoEx.getMessage(), vetoEx);
		}
	}

	protected boolean getMaximum() {
		return isMaximum;
	}

	public void setVisible(boolean b) {
		super.setVisible(b);

		if (isMaximum == true) {
			setMaximum(true);
		}
	}
}