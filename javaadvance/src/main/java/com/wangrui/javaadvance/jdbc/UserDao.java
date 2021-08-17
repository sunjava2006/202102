package com.wangrui.javaadvance.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	public int update(int userID, String pwd) throws SQLException {
		Connection conn = null;
		Statement stm = null;
		int count = -1;
		try {
			
			// 连接连接
			conn = ConnectionUtil.getConnection();

			// 创建语句对象，发送语句
			stm = conn.createStatement();
			String sql = "update t_user set pwd='" + pwd + "' where user_id="+userID;
			count = stm.executeUpdate(sql); // CUD操作都调用executeUpdate，返回语句影响的行数。
			// 处理返回结果
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 资源释放
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return count;
	}
	
	public int add(String loginName, String pwd, String gender) throws SQLException {
		Connection conn = null;
		Statement stm = null;
		int count = -1;
		try {
			
			// 连接连接
			conn = ConnectionUtil.getConnection();
		
			// 创建语句对象，发送语句
			stm = conn.createStatement();
			String sql = "insert into t_user(user_id, login_name,pwd,gender) "
					    + "values(seq_user.nextval, '"+loginName+"', '"+pwd+"', '"+gender+"')";
			count = stm.executeUpdate(sql); // CUD操作都调用executeUpdate，返回语句影响的行数。
			// 处理返回结果

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 资源释放
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return count;
	}
}
