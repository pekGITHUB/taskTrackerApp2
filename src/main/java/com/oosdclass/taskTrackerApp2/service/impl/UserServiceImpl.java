package com.oosdclass.taskTrackerApp2.service.impl;

import com.oosdclass.taskTrackerApp2.model.User;
import com.oosdclass.taskTrackerApp2.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean isUserValid(User user) {
		
		User mockUser = mockUserDAO();
		
		if(user.getUsername().equals(mockUser.getUsername()) &&
				user.getPassword().equals(mockUser.getPassword())) {
			return true;
		}
		else {
			return false;	
		}
		
	}
	
	public User mockUserDAO() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("pass");
		return user;
	}

}
