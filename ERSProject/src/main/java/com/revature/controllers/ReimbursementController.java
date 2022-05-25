package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {

ReimbursementService rs = new ReimbursementService();
	
	//this Handler will get the HTTP GET request for all employees, and send back the employees from the database
	public Handler getAllReimbHandler = (ctx) -> {
		
		if(ctx.req.getSession(true) != null) { //if the sessions exists 
		
		//we need an ArrayList of Reimbursement objects (which we'll get from the service layer)
		List<Reimbursement> reimbursements = rs.getAllReimb();
	
		
		//create a GSON object to convert our Java object into JSON (since we can only transfer JSON, not Java)
		Gson gson = new Gson();
		
		//use the JSON .toJson() method to turn our Java into JSON
		String JSONReimbursements = gson.toJson(reimbursements);
		
				
		
		//Give a HTTP response containing our JSON string back to the webpage (or wherever the HTTP request came from)
		ctx.result(JSONReimbursements); //.result() sends a response of data back
		ctx.status(200); //.status() sets the HTTP status code. 200 stands for "OK"
		
		} else { //if a session DOESN'T exist (user isn't logged in)
			ctx.status(400);
		}
		
	};
}
