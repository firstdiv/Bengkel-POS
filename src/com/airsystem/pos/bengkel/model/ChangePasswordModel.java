package com.airsystem.pos.bengkel.model;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.airsystem.pos.bengkel.component.DesktopFrame;

/**
 * @author Budi Oktaviyan
 */
public class ChangePasswordModel extends DesktopFrame {
	protected GridBagLayout baseLayout = new GridBagLayout();

	protected JPanel basePanel = new JPanel();
	protected JPanel buttonPanel = new JPanel();

	protected JLabel oldpasswordLabel = new JLabel();
	protected JLabel newpasswordLabel = new JLabel();

	protected JPasswordField oldpasswordField = new JPasswordField();
	protected JPasswordField newpasswordField = new JPasswordField();

	protected JButton editButton = new JButton();
	protected JButton cancelButton = new JButton();

	public ChangePasswordModel() {
		super();
	}
}