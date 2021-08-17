package com.wangrui.javaadvance.annotations;

import com.wangrui.javaadvance.jdbc.bean.User;

@Mapper
public interface UserDao {

	@Select("select * from t_user")
	public User find(int id);
	
	@Update("update t_ser set pwd=#{pwd} where user_id=#{userID}")
	public int update(int userID, String pwd);
}
