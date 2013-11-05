package com.airsystem.pos.bengkel.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.airsystem.pos.bengkel.entity.Kendaraan;
import com.airsystem.pos.bengkel.util.HibernateUtil;

/**
 * @author Budi Oktaviyan
 */
public class KendaraanServices {

	/* GENERIC DAO */
	public void saveOrUpdate(Kendaraan kendaraan) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.saveOrUpdate(kendaraan);
		session.flush();
		session.close();
	}

	public void delete(Kendaraan kendaraan) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.delete(kendaraan);
		session.flush();
		session.close();
	}

	public List<Kendaraan> select() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> criteria = (List<?>) session.createCriteria(Kendaraan.class).list();
		session.close();

		List<Kendaraan> kendaraans = new ArrayList<Kendaraan>();
		for (Object result : criteria) {
			Kendaraan kendaraan = (Kendaraan) result;
			kendaraans.add(kendaraan);
		}

		return kendaraans;
	}

	/* CUSTOM DAO */
	public List<Kendaraan> select(String searchCombo, String searchText) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> query = (List<?>) session.createQuery("FROM Kendaraan WHERE " + searchCombo + " LIKE:LIKE")
										 .setString("LIKE", searchText).list();
		session.close();

		List<Kendaraan> kendaraans = new ArrayList<Kendaraan>();
		for (Object result : query) {
			Kendaraan kendaraan = (Kendaraan) result;
			kendaraans.add(kendaraan);
		}

		return kendaraans;
	}
}