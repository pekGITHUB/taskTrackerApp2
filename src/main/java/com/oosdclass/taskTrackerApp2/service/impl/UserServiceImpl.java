package com.oosdclass.taskTrackerApp2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oosdclass.taskTrackerApp2.dao.UserDAO;
import com.oosdclass.taskTrackerApp2.model.User;
import com.oosdclass.taskTrackerApp2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	
	@Override
	public boolean isUserValid(User user) {
		
		User mockUser = userDAO.retrieveByUserName(user.getUsername());
		
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
