package com.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.data.User;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;


/**
 * Clase con el Dao de implementacion de los Usuarios
 * @author NestoR
 * 24-07-2016
 */

public class UserDAOImpl implements UserDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Guarda o actualiza los usuarios.
	 */
	public void saveOrUpdateUser(User user) {
		try {
			session.saveOrUpdate(user);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Elimina los usuarios.
	 */
	public void deleteUser(Long userId) {
		try {
			User user = (User) session.get(User.class, userId);
			session.delete(user);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Trae una lista de usuarios.
	 */
	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		List<User> courses = null;
		try {
			courses = session.createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Trae los usuarios por Id.
	 */
	public User listUserById(Long userId) {
		User user = null;
		try {
			user = (User) session.get(User.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
