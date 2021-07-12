package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static String driver;
	private static String url;
	private static String user, password;
	
	static {
		try {
			Properties p = new Properties();
			p.load(ConnectionUtil.class.getResourceAsStream("/db.properties"));
			
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			
			// 1¡¢ÏòJDBC×¢²áÇý¶¯
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection  conn = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/XE";
		String user = "relation";
		String password = "relation";
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
