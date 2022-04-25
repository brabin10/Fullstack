package com.revature;

import com.revature.controller.LoginController;

import io.javalin.Javalin;

public class App {

	
	public static void main(String[] args) {
		
		//Inside APP we provide controllers that handle our endpoint functionalities
		LoginController lc = new LoginController();
		
		//This will be where we start our server
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
	
				).start(9898); // we start on  port 9898
		
		//Setting an end point that will return a Hello World
		//Plain text for the domain name
		//In this example the domain name is http://localhost:9898
		app.get("/", ctx -> ctx.result("Hello world"));
		
		app.get("/greet", ctx -> {
			ctx.res.getWriter().write("Hello there from javalin");
		});
		
		//Based around logging into our
		app.post("/login",lc.loginHandler);
	}
}
