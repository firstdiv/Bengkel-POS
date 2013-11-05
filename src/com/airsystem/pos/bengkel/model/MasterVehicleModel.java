package com.airsystem.pos.bengkel.model;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.airsystem.pos.bengkel.component.DesktopFrame;

/**
 * @author Budi Oktaviyan
 */
public class MasterVehicleModel extends DesktopFrame {
	protected GridBagLayout baseLayout = new GridBagLayout();

	protected JPanel basePanel = new JPanel();
	protected JPanel buttonPanel = new JPanel();

	protected JLabel merkLabel = new JLabel();
	protected JLabel submerkLabel = new JLabel();

	protected JTextField merkField = new JTextField();
	protected JTextField submerkField = new JTextField();
	protected JTextField idField = new JTextField();

	protected JButton searchButton = new JButton();
	protected JButton saveButton = new JButton();
	protected JButton editButton = new JButton();
	protected JButton deleteButton = new JButton();
	protected JButton cancelButton = new JButton();

	public MasterVehicleModel() {
		super();
	}
}