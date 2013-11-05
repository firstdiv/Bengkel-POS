package com.airsystem.pos.bengkel.view;

import com.airsystem.pos.bengkel.controller.MenuController;
import com.airsystem.pos.bengkel.controller.VehicleDataController;

/**
 * @author Fanny Irawan S (fannyirawans@gmail.com)
 */
public class VehicleDataView extends VehicleDataController {

	public VehicleDataView(MenuController menuController) {
		super();

		super.menuController = menuController;
		super.buildWindow();
	}
}