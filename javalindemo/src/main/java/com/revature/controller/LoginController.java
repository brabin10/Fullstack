package com.revature.controller;

import com.google.gson.Gson;
import com.revature.models.LoginResponse;
import com.revature.models.UserLogin;
import com.revature.service.LoginService;

import io.javalin.http.Handler;

public class LoginController {
	
	//we generate the login service objest to handle business logic
	LoginService ls = new LoginService();

	public Handler loginHandler = (ctx) -> {
		
		//In our HTTP request, we have a body that contains
		//The data for the request
		String body = ctx.body();
		
		//this is GSON, our json parser
		Gson gson = new Gson();
		
		//GSON turns the body string into an object  of the class you provide
		UserLogin lDTO = gson.fromJson(body, UserLogin.class);
		
		//We now use the Login Response object to represent a potential response to the front end
		LoginResponse lr = ls.loginValidation(lDTO.getUsername(), lDTO.getPassword());
		
		//This a null check to see if it was a successful response
		if(lr != null) {
			ctx.req.getSession(); //this activates the session for the current logged in user
			ctx.status(200); //status code of success, this tell the browser that it was a successful login
			ctx.result(gson.toJson(lr)); //convert the java object of login response to a JSON string
		
		
		
		}else {
			ctx.status(401);  //unauthorized status code
			ctx.result(gson.toJson(null));
		}
	};
}
	


