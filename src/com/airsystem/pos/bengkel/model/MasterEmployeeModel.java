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
public class MasterEmployeeModel extends DesktopFrame {
	protected GridBagLayout baseLayout = new GridBagLayout();

	protected JPanel basePanel = new JPanel();
	protected JPanel buttonPanel = new JPanel();

	protected JLabel namaLabel = new JLabel();
	protected JLabel gajiLabel = new JLabel();
	protected JLabel uangmakanLabel = new JLabel();

	protected JTextField namaField = new JTextField();
	protected JTextField gajiField = new JTextField();
	protected JTextField uangmakanField = new JTextField();
	protected JTextField idField = new JTextField();

	protected JButton searchButton = new JButton();
	protected JButton saveButton = new JButton();
	protected JButton editButton = new JButton();
	protected JButton deleteButton = new JButton();
	protected JButton cancelButton = new JButton();

	public MasterEmployeeModel() {
		super();
	}
}