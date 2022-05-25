package com.revature.models;

public class LoginDTO {

	private String username;
	private String password;
	
	//I just want a no args and all args constructor, so we can instantiate LoginDTOs

		public LoginDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public LoginDTO(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		//we need getters/setters to access our fields(encapsulation)
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		//so that we can actually print out this print this class out
		@Override
		public String toString() {
			return "LoginDTO [username=" + username + ", password=" + password + "]";
		}
		
		
}
