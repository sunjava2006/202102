package com.wangrui.myblog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangrui.myblog.bean.User;

public class UserDao {
	
	public User selectByLoginNamePwd(String loginName, String pwd) throws SQLException {
		User u = null;
		String sql = "select * from t_user where login_name=? and pwd=?";
		ResultSetExtrector<User> ext = (rst)->{
			User us = null;
			if(rst.next()) {
				int userID = rst.getInt("user_id");
				String email = rst.getString("email");
				String question = rst.getString("question");
				String answer = rst.getString("answer");
				
				us = new User(userID, loginName, pwd, email, question, answer);
			}
			return us;
		};
		JdbcTemplate tmp = new JdbcTemplate();
		u = tmp.select(sql, ext, loginName, pwd);
		
		return u;
	}
	
	public int selectLoginName(String loginName) throws SQLException {
		int count = 0;
		String sql = "select count(*) from t_user where login_name=?";
		
		JdbcTemplate tmp = new JdbcTemplate();
		ResultSetExtrector<Integer> ext = (rst)->{
			rst.next();
			return rst.getInt(1);
		};
		count = tmp.select(sql,ext, loginName);
		return count;
	}

	public User add(String loginName, String pwd, String email, String question, String answer) throws SQLException {
		User u = null;

		JdbcTemplate tmp = new JdbcTemplate();
		try {
			ResultSetExtrector<Integer> extrector = new ResultSetExtrector<Integer>() {
				@Override
				public Integer extract(ResultSet rst) throws SQLException {
					rst.next();
					return rst.getInt(1);
				}
			};
			
			int id = tmp.select("select seq_user.nextval from dual", extrector);

			int c = tmp.cud("insert into t_user(user_id, login_name, pwd, email, question, answer)values(?,?,?,?,?,?)", id, loginName, pwd, email, question, answer);

			if(c==1) {
				u = new User(id, loginName, pwd, email, question, answer);
			}
			
		} catch (SQLException ex) {
			throw ex;
		}

		return u;
	}
}
