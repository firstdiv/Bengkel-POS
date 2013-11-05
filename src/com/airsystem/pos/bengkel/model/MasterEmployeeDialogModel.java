package com.airsystem.pos.bengkel.model;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.airsystem.pos.bengkel.component.DialogFrame;

/**
 * @author Budi Oktaviyan
 */
public class MasterEmployeeDialogModel extends DialogFrame {
	protected int row = 0;

	protected GridBagLayout baseLayout = new GridBagLayout();
	protected GridBagLayout tableLayout = new GridBagLayout();

	protected JPanel basePanel = new JPanel();
	protected JPanel tablePanel = new JPanel();

	protected JScrollPane tableScroll = new JScrollPane();

	protected JTable tableData = new JTable();

	protected JLabel searchLabel = new JLabel();

	protected JComboBox searchCombo = new JComboBox();

	protected JTextField searchField = new JTextField();

	protected JButton searchButton = new JButton();

	protected DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
																   new String[] { "Nama", "Gaji/bln", "Uang Makan/bln", "ID" }) {

		boolean[] canEdit = new boolean[] { false, false, false, false };

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return canEdit[columnIndex];
		}
	};

	public MasterEmployeeDialogModel() {
		super();
	}
}