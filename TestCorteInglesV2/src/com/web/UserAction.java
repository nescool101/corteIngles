package com.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.data.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * Clase con el que trae las acciones
 * @author NestoR
 * 24-07-2016
 */

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -6659925652584240539L;

	private User user = new User();
	private List<User> userList = new ArrayList<User>();
	private UserDAO userDAO = new UserDAOImpl();
	
	public User getModel() {
		return user;
	}
	
	/**
	 * Metodo para actualizar los usuarios o guardarlos
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		userDAO.saveOrUpdateUser(user);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		userList = userDAO.listUser();
		return SUCCESS;
	}
	
	/**
	 * Elimina lo usuarios
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		userDAO.deleteUser(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * Edita los usuarios
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = userDAO.listUserById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
