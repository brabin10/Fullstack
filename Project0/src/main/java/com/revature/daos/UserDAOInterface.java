package com.revature.daos;

import com.revature.models.User;

import java.util.ArrayList;


// Recall that interfaces contain abstract methods. They are meant to be implemented by concrete classes
// We want to UserDAO to implement this interface, for the sake of organizing what we want our UserDAO to do
public interface UserDAOInterface {

	// This method will take in an user object, and insert it into the database
	boolean createUser(User user);
	// This method will find user by user's username and update user's password
	boolean updateUser(String username, String password);
	// This method will delete user by username from the database
	boolean deleteUser(String username);

	// login with username and password
	boolean login(String username, String password);

	// get user info by username
	User getUser(String username);

	// get all users in database
	ArrayList<User> getAllUsers();
}