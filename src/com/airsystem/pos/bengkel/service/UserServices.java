package com.airsystem.pos.bengkel.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.airsystem.pos.bengkel.entity.Role;
import com.airsystem.pos.bengkel.entity.User;
import com.airsystem.pos.bengkel.util.HibernateUtil;

/**
 * @author Budi Oktaviyan
 */
public class UserServices {

	/* GENERIC DAO */
	public void saveOrUpdate(User user, Role role) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.saveOrUpdate(user);
		session.saveOrUpdate(role);
		session.flush();
		session.close();
	}

	public void delete(Role role, User user) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.delete(role);
		session.delete(user);
		session.flush();
		session.close();
	}

	public List<User> select() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> criteria = (List<?>) session.createCriteria(User.class).list();
		session.close();

		List<User> users = new ArrayList<User>();
		for (Object result : criteria) {
			User user = (User) result;
			users.add(user);
		}

		return users;
	}

	/* CUSTOM DAO */
	public List<User> select(String searchCombo, String searchText) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> query = (List<?>) session.createQuery("FROM User WHERE " + searchCombo + " LIKE:LIKE")
										 .setString("LIKE", searchText).list();
		session.close();

		List<User> users = new ArrayList<User>();
		for (Object result : query) {
			User user = (User) result;
			users.add(user);
		}

		return users;
	}

	public List<User> login(String username, String password) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<?> query = (List<?>) session.createQuery("FROM User user WHERE username=:username AND password=:password")
										 .setString("username", username)
										 .setString("password", password).list();
		session.close();

		List<User> users = new ArrayList<User>();
		for (Object result : query) {
			User user = (User) result;
			users.add(user);
		}

		return users;
	}

	public void change(User user, Integer id, String password) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("UPDATE User SET password=:password WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("password", password);
		query.executeUpdate();
		session.flush();
		session.close();
	}
}