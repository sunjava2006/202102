package com.wangrui.myblog.service;

import java.sql.SQLException;

import com.wangrui.myblog.bean.User;
import com.wangrui.myblog.dao.UserDao;

public class UserService {

	public User regist(String loginName, String pwd, String email, String question, String answer) throws SQLException {
		
		UserDao dao = new UserDao();
		return dao.add(loginName, pwd, email, question, answer);
		
	}
	
	public boolean loginNameUnique(String loginName) throws SQLException {
		UserDao dao = new UserDao();
		int c = dao.selectLoginName(loginName);
		if(0==c) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws SQLException {
		UserService us = new UserService();
		User u = us.regist("Tang", "123456", "w@qq.com", "1+1", "3");
		System.out.println(u);
	}
}
