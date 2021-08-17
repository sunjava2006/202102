package com.wangrui.javaadvance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.wangrui.javaadvance.jdbc.bean.User;

public class UserDao {
	
	public User login(String loginName, String pwd) throws SQLException {
		User u = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			String sql = "select * from t_user where login_name=? and pwd=?"; // 语句中用“？”做为参数的占位符。
			stm = conn.prepareStatement(sql); // 预先对语句进行了编译，SQL做为参数。
			
			//  为语句中的参数赋值
			stm.setString(1, loginName);
			stm.setString(2, pwd);
			
			// PreparedStatement子类中新增的executeQuery方法。
			boolean b = stm.execute();
			
			if(b) {
				rst = stm.getResultSet();
				
				while(rst.next()) {
					int userID = rst.getInt("user_id");
					String name = rst.getString("login_name");
					String p = rst.getString("pwd");
					String g = rst.getString("gender");
					
					u = new User(userID, name, p, g);
				}
			}
			else {
				int c = stm.getUpdateCount();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}

		return u;
	}
	
	public Map<String , Object> select(String loginName, String pwd) throws SQLException {
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null; // 结果集
		Map<String, Object> map = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			String sql = "select user_id, login_name, pwd, gender from t_user where login_name='"+loginName+"' and pwd='"+pwd+"'";
			rst = stm.executeQuery(sql);// R select 
			
//			rst.close();
			
			
			while(rst.next()) { // 判断是否有下一个记录
				int id = rst.getInt(1);  // 指定列是1开始，不是0。
				String loginname = rst.getString(2);
				String password = rst.getString("pwd"); // 取指定列名
				String gender = rst.getString("gender");
				
				map = new HashMap<>();
				map.put("userID", id);
				map.put("loginName", loginname);
				map.put("pwd", password);
				map.put("gender", gender);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return map;
		
	}
	
	public int[] deleteCascade(int userID) throws SQLException {
		int[] c = null;
		
		Connection conn = null;
//		Statement stm = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false); // 不自动提交
			
//			stm = conn.createStatement();
			
//			stm.addBatch("delete from t_techroledge where user_id="+userID);
//			stm.addBatch("delete from t_user where user_id="+userID);
//		
//			c = stm.executeBatch(); // {3, 1}
			
			stm = conn.prepareStatement("delete from t_techroledge where user_id=?");
			stm.setInt(1, userID);
			stm.execute();
			
			stm = conn.prepareStatement("delete from t_user where user_id=?");
			stm.setInt(1, userID);
			stm.execute();
			
			
			conn.commit(); // 手动提交
			
		} catch (SQLException e) {
			
			conn.rollback(); // 回滚
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true); // 改回默认值
				conn.close();
			}
		}
		
		return c;
	}
	
	public int delete(int userID) throws SQLException {
		int count = -1;
		Connection conn = null;
		Statement stm = null;
				
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			String sql = "delete from t_user where user_id="+userID;
			count = stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != stm) {
				stm.close();
			}
		}
		
		return count;
	}

	public int update(int userID, String loginName, String pwd, String gender) throws SQLException {
		int count = -1;
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement("update t_user set login_name=? , pwd=?, gender=? where user_id=?");
			
			stm.setString(1, loginName);
			stm.setString(2, pwd);
			stm.setString(3, gender);
			stm.setInt(4, userID);
			
			count = stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		
		return count;
	}
	
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
