package com.wangrui.tsd.dao;

import org.apache.ibatis.jdbc.SQL;

import com.wangrui.tsd.bean.User;

public class Provider {

	public String updateUser(User user) {
		String s = null;
		
		SQL sql = new SQL();
		sql.UPDATE("t_user");
		if(null != user.getUserName()) {
			sql.SET("user_name=#{userName, jdbcType=VARCHAR}");
		}
		if(null != user.getPhoneNumber()) {
			sql.SET("phone_number=#{phoneNumber, jdbcType=VARCHAR}");
		}
		if(null != user.getAvatarUrl()) {
			sql.SET("avatarurl=#{avatarUrl, jdbcType=VARCHAR}");
		}
		sql.WHERE("user_id=#{userID}");
		
		
		s = sql.toString();// 从sql对象中获取动态生成的语句
		System.out.println("动态生成的语句"+s);
		return s;
	}
}
