package com.revature.repository;

import com.revature.repository.entities.LoginEntity;
import com.revature.repository.entities.LoginEntity;

public class LoginRepository {

	//This is the DAO layer
	//We would have CRUD methods
	// I will fake the Read method, this should made with JDBC
	public LoginEntity getLogin(String username) {
		
		//As I'm not implementing JDBC, I'll fake a successful return
		
		if(username.equals("user1")) {
			return new LoginEntity(1, "user1", "pass1", "Bobby");
		}else {
			return null;
		}
		
	}
}
