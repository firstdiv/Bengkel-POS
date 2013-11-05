package com.airsystem.pos.bengkel.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.airsystem.pos.bengkel.component.DesktopFrame;
import com.airsystem.pos.bengkel.util.TextUtil;

/**
 * @author Fanny Irawan S (fannyirawans@gmail.com) 
 */
public class VehicleDataModel extends DesktopFrame {
	
	private static final long serialVersionUID = 6358009999492337044L;
	
	private static final	String 			TITLE = "Data Kendaraan";
	
	private final 			ImageIcon		windowIcon;
	private final			BasePanel 		basePanel;
	
	public VehicleDataModel() {
		windowIcon = new ImageIcon(getClass().getResource("../res/admin.png") );
		basePanel = new BasePanel();
	}
	
	protected void buildWindow() {
		setBaseAttribute();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 550) / 2, (screenSize.height - 550) / 2, 550, 400);
	}
	
	private void setBaseAttribute() {
		setTitle(TITLE);
		setFrameIcon(windowIcon);
		setIconifiable(true);
		setClosable(true);
		getContentPane().add(basePanel, BorderLayout.CENTER);
	}
	
	
	// ==========================================
	// INNER CLASS
	// ==========================================
	
	/**
	 * 
	 */
	private final class BasePanel extends JPanel {
		
		private static final long serialVersionUID = 8659528249075109262L;
		
		private final GridBagLayout baseLayout;
		private final ButtonPanel	buttonPanel;
		
		private final Label			lbBrand;
		private final Label			lbType;
		
		private final TextBox		txtBrand;
		private final TextBox		txtType;
		
		public BasePanel() {
			baseLayout = new GridBagLayout();
			baseLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
			baseLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			baseLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			baseLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			
			super.setLayout(baseLayout);
			
			lbBrand = new Label("Merk");
			lbType = new Label("Sub Merk");
			txtBrand = new TextBox(50);
			txtType = new TextBox(100);
			
			buttonPanel = new ButtonPanel();
			
			super.add(lbBrand, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(15, 0, 20, 30), 0, 0));
			super.add(lbType, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 10, 30), 0, 0));
			super.add(txtBrand, new GridBagConstraints(2, 1, 9, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(15, 0, 20, 10), 0, 0));
			super.add(txtType, new GridBagConstraints(2, 2, 9, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 10, 10), 0, 0));
			super.add(buttonPanel, new GridBagConstraints(0, 4, 12, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
	}
	
	/**
	 * 
	 */
	private final class ButtonPanel extends JPanel {
		
		private static final long serialVersionUID = -1305294574704696218L;
		
		private final JButton btnSave;
		private final JButton btnUpdate;
		private final JButton btnCancel;
		
		public ButtonPanel() {
			setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			btnSave = Button.get()
			  		  .setIcon(new ImageIcon(getClass().getResource( "../res/logon.png") ) )
			  		  .setText("SIMPAN")
			  		  .build();
			
			btnUpdate = Button.get()
	  		  		  	.setIcon(new ImageIcon(getClass().getResource( "../res/logon.png") ) )
	  		  		    .setText("UBAH")
	  		  		    .build();
			
			btnCancel = Button.get()
	  		  		 	.setIcon(new ImageIcon(getClass().getResource( "../res/logon.png") ) )
	  		  		 	.setText("BATAL")
	  		  		 	.build();
			
			super.add(btnSave);
			super.add(btnUpdate);
			super.add(btnCancel);
		}
		
	}
	
	/**
	 * 
	 */
	private final class Label extends JLabel {
		
		private static final long serialVersionUID = 804111601962843740L;
		
		final Font VERDANA = new Font("Verdana", 0, 12);
		
		public Label(String text) {
			setText(text);
			setFont(VERDANA);
		}
	}
	
	/**
	 * 
	 */
	private static final class Button {
		
		private static 	Button 	INSTANCE;
		
		private 		JButton	buttonBuilder;
		
		private Button() { }
		
		public static Button get() {
			if(INSTANCE == null) {
				INSTANCE = new Button();
			}
			return INSTANCE;
		}
		
		public Button setIcon(Icon icon) {
			createNew();
			buttonBuilder.setIcon(icon);
			return this;
		}
		
		public Button setText(String text) {
			createNew();
			buttonBuilder.setText(text);
			
			return this;
		}
		
		public JButton build() {
			createNew();
			JButton temp = buttonBuilder;
			buttonBuilder = null;
			return temp;
		}
		
		private void createNew() {
			if(buttonBuilder == null) {
				buttonBuilder = new JButton();
			} 
		}
	}
	
	/**
	 * 
	 */
	private final class TextBox extends JTextField {
		
		private static final long serialVersionUID = -8909711944300410526L;
		
		final Font VERDANA = new Font("Verdana", 0, 12);
		
		public TextBox(int length) {
			setFont(VERDANA);
			setColumns(length);
			setDocument(new TextUtil(length, TextUtil.ALPHANUMERIC));
		}
	}
	
	
	// ==========================================
	// SETTER GETTER
	// ==========================================
	public BasePanel getBasePanel() {
		return basePanel;
	}
}
