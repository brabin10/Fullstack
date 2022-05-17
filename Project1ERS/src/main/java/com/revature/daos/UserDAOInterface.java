package com.revature.daos;

import java.util.ArrayList;
import com.revature.models.User;

public interface UserDAOInterface {

ArrayList<User> findAll();
	
	User findById(int id);
	
	User findByUser(String usr);
	
	User save(User obj);
	
	User update(User obj);
	
	void delete(User obj);
}
