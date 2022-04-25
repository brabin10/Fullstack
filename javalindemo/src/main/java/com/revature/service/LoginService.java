package com.revature.service;

import com.revature.models.LoginResponse;
import com.revature.repository.LoginRepository;
import com.revature.repository.entities.LoginEntity;


public class LoginService {
	
	//This is the login repo that will get the 
	private LoginRepository loginRepository;
	
	public LoginService() {
		this.loginRepository = new LoginRepository();
	}
	
	public LoginResponse loginValidation(String username, String password) {
		LoginEntity loginEntity = loginRepository.getLogin(username);
		
		if(loginEntity.getPass().equals(password)) {
			return new LoginResponse(loginEntity.getUsername(), loginEntity.getName());
		}else {
			return null;
		}
		
	}
	
}
