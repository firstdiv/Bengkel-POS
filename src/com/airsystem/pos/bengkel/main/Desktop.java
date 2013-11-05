package com.airsystem.pos.bengkel.main;

import java.awt.EventQueue;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.airsystem.pos.bengkel.util.HibernateUtil;

/**
 * @author Budi Oktaviyan
 */
public class Desktop {
	private static final Logger LOG = Logger.getLogger(Desktop.class.getSimpleName());

	public static void main(String[] desktop) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					PropertyConfigurator.configure(Desktop.class.getResource("/log4j.properties"));
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					Socket socket = new Socket("127.0.0.1", 3306);
					if (socket.isConnected()) {
						HibernateUtil.getSessionFactory().openSession();
					}
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
					JOptionPane.showMessageDialog(null, "Database belum terkoneksi!", "Pesan", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}