package com.wangrui.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

	public <T> T selectOne(String sql, ResultSetExtrector<T> ext,  Object...args) throws SQLException {
		Connection conn = null;
		PreparedStatement stm = null;
		T t = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql); // 创建语句对象
			if(args!=null) {
				for(int i=0; i<args.length; i++) {
					stm.setObject(i+1, args[i]); // 为参数赋值
				}
			}
			
			rst = stm.executeQuery();
			t = ext.extract(rst);

		} catch (SQLException e) {
			throw e;
		} finally {
			if(rst!= null) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return t;
	}
	
	public int cud(String sql, Object...args) throws SQLException {
		int count = -1;
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql); // 创建语句对象
			if(args!=null) {
				for(int i=0; i<args.length; i++) {
					stm.setObject(i+1, args[i]); // 为参数赋值
				}
			}
			
			count = stm.executeUpdate();

		} catch (SQLException e) {
			throw e;
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
}
