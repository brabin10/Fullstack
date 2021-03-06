package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //again, we want to make this Class a bean
@Scope("prototype") //Classes are singletons by default...
public class User {

	private int id;
	private String name;
	private Account account;

	
	//boilerplate code
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	//we created this Account only constructor to accomplish Autowiring in our Config Class
	@Autowired //autowiring our Account Bean with CONSTUCTOR INJECTION (thanks to the easy way of configuring/wiring beans) 
	public User(Account account) {
		super();
		this.account = account;
	}

	public User(int id, String name, Account account) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	
	
	
}