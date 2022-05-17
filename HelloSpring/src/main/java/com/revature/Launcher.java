package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;

public class Launcher {
	
	public static void main(String[] args) {
		
		//Create an ApplicationContext Spring Container object
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//we are instantiating a new ApplicationContext to hold our Spring beans
		//But in order to configure it we need to give it the class path context to our config file(our xml file)
		
		//Now that we have a Spring Container which is storing User and Account beans, we can make some!
		
		//we're calling our ApplicationContext  and attempting to get a Bean with the name = "user"
		// a cast is needed because the ApplicationCOntext can't guess what kind of object this will be
		User u = (User)ac.getBean("user");
		
		//lets take a look at our User bean looks like
		System.out.println(u);
		//we got a User object that the ApplicationContext created for us with .getBean()
		//But .. nowhere did I create  an Account class to attach to it.
		//This is the power of autowiring - spring did it for us, "automatically"
		
		//now we can give our Bean some values
		u.setId(1);
		u.setName("Bon");
		u.getAccount().setBalance(5000.56); //we need to use the getter of the User class to access Account variables
		u.getAccount().setType("Saving");
		
		//User should have full data now
		System.out.println(u);
		
		System.out.println("======Messing with Bean Scopes======");
		
		//recall bean scope - Beans are singletons by defaults, which means there can only ever be one instance
		User u2 = (User)ac.getBean("user");
		
		//Give the user new values
		u2.setName("Bono");
		u2.setId(2);
		
		//THus
		System.out.println(u2);
		
		//Thus, this new User is the same User as the first one we made
		System.out.println(u2);
		System.out.println(u); //the values will be the same across all User objects
	}

}
