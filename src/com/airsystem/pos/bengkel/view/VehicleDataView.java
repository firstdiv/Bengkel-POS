package com.airsystem.pos.bengkel.view;

import com.airsystem.pos.bengkel.controller.MenuController;
import com.airsystem.pos.bengkel.controller.VehicleDataController;

/**
 * @author Fanny Irawan S (fannyirawans@gmail.com)
 */
public class VehicleDataView extends VehicleDataController {
	
	private static final long serialVersionUID = 5097756794482442708L;

	public VehicleDataView(MenuController menuController) {
		super();
		
		super.menuController = menuController;
		super.buildWindow();
	}
}
