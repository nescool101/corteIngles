package com.dao;

import java.util.List;

import com.data.User;

/**
 * Clase con el Dao de los Usuarios
 * @author NestoR
 * 24-07-2016
 */

public interface UserDAO {

	public void saveOrUpdateUser(User user);
	public List<User> listUser();
	public User listUserById(Long userId);
	public void deleteUser(Long userId);
}
