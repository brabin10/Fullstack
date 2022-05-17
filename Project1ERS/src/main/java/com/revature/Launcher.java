package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.ReimburseController;
import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) { //if creating this connection fails... catch the exception and print the stack trace
			System.out.println("connection failed... :(");
			e.printStackTrace();
		}
		
		ReimburseController rc = new ReimburseController();
		UserController uc = new UserController();
		
		//Typical Javalin syntax to create a Javalin object
				Javalin app = Javalin.create(
							//the config lambda lets us specify certain configurations.
							config -> {
								config.enableCorsForAllOrigins(); //this allows us to process JS requests from anywhere
							}
						).start(3000);
				
				app.get("/users", uc.findAllHandler);
				app.post("/login", rc.loginHandler);
				
	}

}
