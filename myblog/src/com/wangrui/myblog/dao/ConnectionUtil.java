package com.wangrui.myblog.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {

	private static String url, user, pwd;

	
	static {
		try {
			// 读配置文件
			Properties p = new Properties();
			p.load(ConnectionUtil.class.getResourceAsStream("/db.properties"));
			String driver = p.getProperty("driver");
			
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			
			Class.forName(driver);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} 
	}
	

	public static Connection getConnection() throws SQLException {
		return  DriverManager.getConnection(url, user, pwd);
	}
	
}
