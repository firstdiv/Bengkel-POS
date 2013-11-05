package com.airsystem.pos.bengkel.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.airsystem.pos.bengkel.entity.Karyawan;
import com.airsystem.pos.bengkel.util.HibernateUtil;

/**
 * @author Budi Oktaviyan
 */
public class KaryawanServices {

	/* GENERIC DAO */
	public void saveOrUpdate(Karyawan karyawan) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.saveOrUpdate(karyawan);
		session.flush();
		session.close();
	}

	public void delete(Karyawan karyawan) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.delete(karyawan);
		session.flush();
		session.close();
	}

	public List<Karyawan> select() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> criteria = (List<?>) session.createCriteria(Karyawan.class).list();
		session.close();

		List<Karyawan> karyawans = new ArrayList<Karyawan>();
		for (Object result : criteria) {
			Karyawan karyawan = (Karyawan) result;
			karyawans.add(karyawan);
		}

		return karyawans;
	}

	/* CUSTOM DAO */
	public List<Karyawan> select(String searchCombo, String searchText) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> query = (List<?>) session.createQuery("FROM Karyawan WHERE " + searchCombo + " LIKE:LIKE")
										 .setString("LIKE", searchText).list();
		session.close();

		List<Karyawan> karyawans = new ArrayList<Karyawan>();
		for (Object result : query) {
			Karyawan karyawan = (Karyawan) result;
			karyawans.add(karyawan);
		}

		return karyawans;
	}
}