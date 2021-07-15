package com.wangrui.tsd.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.wangrui.tsd.bean.User;

@Repository
@Mapper
public interface UserDao {

	@Select("select * from t_user where phone_number=#{phoneNumber}")
	@Results(id = "UserMap", value = {@Result(column = "user_id", property = "userID", id = true),
			                          @Result(column = "phone_number", property = "phoneNumber"),
			                          @Result(column = "user_name", property = "userName")})
	public User findByPhoneNumber(String phoneNumber);
	
	
	@Insert("insert into t_user(user_id, phone_number, user_name) values (#{userID}, #{phoneNumber}, #{userName})")
	@SelectKey(before = true, keyColumn = "user_id", resultType = Integer.class, keyProperty = "userID",
	           statement = { "select seq_user.nextval from dual" })
	public void add(User user);
	
	@Update("update t_user set user_name=#{userName} where user_id=#{userID}")
	public void update(User user);
}
