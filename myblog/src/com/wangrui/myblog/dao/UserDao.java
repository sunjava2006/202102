package com.wangrui.myblog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangrui.myblog.bean.User;

public class UserDao {

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
			int id = tmp.selectOne("select seq_user.nextval from dual", extrector);

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
