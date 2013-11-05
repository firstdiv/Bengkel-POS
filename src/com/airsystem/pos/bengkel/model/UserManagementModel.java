package com.airsystem.pos.bengkel.model;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.airsystem.pos.bengkel.component.DesktopFrame;

/**
 * @author Budi Oktaviyan
 */
public class UserManagementModel extends DesktopFrame {
	protected GridBagLayout baseLayout = new GridBagLayout();

	protected JPanel basePanel = new JPanel();
	protected JPanel buttonPanel = new JPanel();

	protected JLabel namaLabel = new JLabel();
	protected JLabel roleLabel = new JLabel();
	protected JLabel usernameLabel = new JLabel();
	protected JLabel passwordLabel = new JLabel();
	protected JLabel confirmpasswordLabel = new JLabel();

	protected JTextField namaField = new JTextField();
	protected JTextField usernameField = new JTextField();
	protected JTextField idField = new JTextField();

	protected JPasswordField passwordField = new JPasswordField();
	protected JPasswordField confirmpasswordField = new JPasswordField();

	protected JComboBox roleCombo = new JComboBox();

	protected JButton searchButton = new JButton();
	protected JButton saveButton = new JButton();
	protected JButton editButton = new JButton();
	protected JButton deleteButton = new JButton();
	protected JButton cancelButton = new JButton();

	public UserManagementModel() {
		super();
	}
}