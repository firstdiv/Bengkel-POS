package com.airsystem.pos.bengkel.component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Budi Oktaviyan
 */
public class TableFrame {

	public static void deleteTable(JTable table, DefaultTableModel model) {
		for (int i = table.getRowCount(); i > 0; i--) {
			model.removeRow(i - 1);
		}
	}
}