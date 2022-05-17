package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.services.ReimburseService;

import io.javalin.http.Handler;

public class ReimburseController {
	
	ReimburseService rs = new ReimburseService();
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		if(rs.login(LDTO.getUsername(), LDTO.getPassword()) != null) {
			ctx.req.getSession();
			ctx.status(202);
			
			String userJSON = gson.toJson(rs.login(LDTO.getUsername(), LDTO.getPassword()));
			ctx.result(userJSON);
			
		} else {
			ctx.status(401);
			System.out.println("login failed");
		}
		
	};
}
