package com.airsystem.pos.bengkel.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.airsystem.pos.bengkel.view.SplashScreen;

/**
 * @author Budi Oktaviyan
 */
public class HibernateUtil {
	private static final Logger LOG = Logger.getLogger(HibernateUtil.class.getSimpleName());

	private static final SessionFactory SESSION_FACTORY;

	private static final ServiceRegistry SERVICE_REGISTRY;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("/hibernate.cfg.xml");

			SERVICE_REGISTRY = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			SESSION_FACTORY = configuration.buildSessionFactory(SERVICE_REGISTRY);

			SplashScreen splashScreen = new SplashScreen();
			splashScreen.setVisible(true);
		} catch (Exception e) {
			LOG.error("Initial SessionFactory creation failed: " + e.getMessage(), e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}