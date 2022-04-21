package com.revature.models;

// transaction model for table transactions
public class Transaction {
	private int id;
	private String username;
	private String currency;
	private int amount;
	private String firstname;
	private String lastname;

	public Transaction() {}
	public Transaction(String username, String currency, int amount) {
		super();
		this.id = 0;
		this.username = username;
		this.currency = currency;
		this.amount = amount;
		this.firstname = new String("");
		this.lastname = new String("");
	}

	public Transaction(int id, String username, String currency, int amount, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.currency = currency;
		this.amount = amount;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		if (firstname == "" || lastname == "") {
			return "Transaction [id=" + id + ", username=" + username + ", currency=" + currency + ", amount=" + amount + ", firstname=" + firstname + ", lastname=" + lastname + "]";
		}
		else {
			return "Transaction [id=" + id + ", username=" + username + ", currency=" + currency + ", amount=" + amount + "]";
		}
	}
}