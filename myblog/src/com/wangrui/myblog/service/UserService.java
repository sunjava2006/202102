package com.wangrui.myblog.service;

import java.sql.SQLException;

import com.wangrui.myblog.bean.User;
import com.wangrui.myblog.dao.UserDao;

public class UserService {

	public User regist(String loginName, String pwd, String email, String question, String answer) throws SQLException {
		
		UserDao dao = new UserDao();
		return dao.add(loginName, pwd, email, question, answer);
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		UserService us = new UserService();
		User u = us.regist("wang", "123456", "w@qq.com", "1+1", "3");
		System.out.println(u);
	}
}
