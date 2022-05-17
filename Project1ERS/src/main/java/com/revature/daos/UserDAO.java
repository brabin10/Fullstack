package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements UserDAOInterface {

	@Override
	public ArrayList<User> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ERS_USERS;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<User> users = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
				users.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return new User(
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User findByUser(String usr) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  usr);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return new User(
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User save(User obj) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)"
					+ " VALUES(?, ?, ?, ?, ?, ?)";
			
			String[] keyNames = {"USER_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getEmail());
			ps.setInt(6,  obj.getRole_id());
			
			
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				
				ResultSet rs = ps.getGeneratedKeys();
				
				while(rs.next()) {
					
					obj.setId(rs.getInt(1));
					
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User update(User obj) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE ERS_USERS SET ERS_USERNAME = ?, SET ERS_PASSWORD = ?, SET USER_FIRST_NAME = ?, SET USER_LAST_NAME = ?, SET USER_EMAIL = ?, SET USER_ROLE_ID = ? WHERE ERS_USERS_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3,  obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setInt(5, obj.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub
		
	}

}
