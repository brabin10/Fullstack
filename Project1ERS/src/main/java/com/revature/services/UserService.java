package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {

	UserDAO uDAO = new UserDAO();

	
	
	public ArrayList<User> findAll() {
		
		ArrayList<User> users = uDAO.findAll();
		
		return users;
	}
	
	
}
