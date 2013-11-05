package com.airsystem.pos.bengkel.model;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;

/**
 * @author Budi Oktaviyan
 */
public class MenuModel extends JFrame {
	protected JDesktopPane desktopPane = new JDesktopPane();

	protected JPanel statusPane = new JPanel();

	protected Separator systemSeparator = new Separator();

	protected JMenuBar menuBar = new JMenuBar();

	protected JMenu systemMenu = new JMenu();
	protected JMenu masterMenu = new JMenu();
	protected JMenu transactionMenu = new JMenu();

	protected JMenuItem itemUserManagement = new JMenuItem();
	protected JMenuItem itemChangePassword = new JMenuItem();
	protected JMenuItem itemLogout = new JMenuItem();
	protected JMenuItem itemEmployee = new JMenuItem();
	protected JMenuItem itemBilling = new JMenuItem();
	protected JMenuItem itemCustomer = new JMenuItem();
	protected JMenuItem itemSparepart = new JMenuItem();
	protected JMenuItem itemJasa = new JMenuItem();
	protected JMenuItem itemSparepartOrder = new JMenuItem();
	protected JMenuItem itemJasaOrder = new JMenuItem();
	protected final JMenuItem itemVehicleData = new JMenuItem();

	protected JInternalFrame formUserManagement = new JInternalFrame();
	protected JInternalFrame formChangePassword = new JInternalFrame();
	protected JInternalFrame formMasterEmployee = new JInternalFrame();
	protected JInternalFrame formMasterBilling = new JInternalFrame();
	protected JInternalFrame formMasterCustomer = new JInternalFrame();
	protected JInternalFrame formMasterSparepart = new JInternalFrame();
	protected JInternalFrame formMasterJasa = new JInternalFrame();
	protected JInternalFrame formSparepartOrder = new JInternalFrame();
	protected JInternalFrame formJasaOrder = new JInternalFrame();
	protected JInternalFrame formVehicleData = new JInternalFrame();

	protected JLabel timeLabel = new JLabel();

	public MenuModel() {
		super();
	}
}