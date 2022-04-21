package com.revature.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;
import com.revature.daos.UserDAOInterface;

public class UserDAO implements UserDAOInterface {
	// This method will take in an user object, and insert it into the database
	public boolean createUser(User user) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getConnection();
			// a string that will represent our SQL statement
			String sql = "INSERT INTO users" +
					" (username, password, firstname, lastname) VALUES " +
					" (?, ?, ?, ?);";

			// a statement object to execute our query
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstname());
			pstmt.setString(4, user.getLastname());

			// execute our insert query, a result reutrns 1 if success, otherwise returns 0
			int result = pstmt.executeUpdate();

			if(result == 1){
				return true;
			}

		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally {
			ConnectionUtil.close(con, pstmt);
		}

		return false;
	}
	// This method will find user by user's username and update user's password
	public boolean updateUser(String username, String password) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			con = ConnectionUtil.getConnection();

			// a statement object to execute our query
			String sql = "UPDATE users SET password=? WHERE username=?";

			// a statement object to execute our query
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);

			int result = pstmt.executeUpdate();

			if(result == 1){
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt);
		}
		return false;
	}
	// This method will delete user by username from the database
	public boolean deleteUser(String username) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM users where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);

			int result = pstmt.executeUpdate();

			if(result == 1){
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt);
		}
		return false;
	}

	// login with username and password
	public boolean login(String username, String password) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User user = null;

		try{
			con = ConnectionUtil.getConnection();

			String sql = "SELECT username, password from users where username=? AND password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();

			if(rset.next()){
				return true;
			} else {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt, rset);
		}

		return false;
	}
	// get user info by username
	public User getUser(String username) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User user = null;

		try{
			con = ConnectionUtil.getConnection();

			String sql = "SELECT username, password, firstname, lastname FROM users WHERE username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rset = pstmt.executeQuery();

			if(rset.next()){
				user = new User(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt, rset);
		}
		return user;
	}

	// get all users in database
	public ArrayList<User> getAllUsers() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> list = null;

		try{
			con = ConnectionUtil.getConnection();

			String sql = "SELECT username, password, firstname, lastname FROM users";
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<User>();

			while(rset.next()){
				list.add(new User(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error");
		} finally{
			ConnectionUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
