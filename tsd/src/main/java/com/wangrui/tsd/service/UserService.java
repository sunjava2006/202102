package com.wangrui.tsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.tsd.bean.User;
import com.wangrui.tsd.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User login(User user) {
		
		User u =  this.userDao.findByPhoneNumber(user.getPhoneNumber());
		if(null == u) {
			 userDao.add(user);
		}
		else {
			user.setUserID(u.getUserID());
			userDao.update(user);
			
		}
		 
		return user;
	}
	

}
