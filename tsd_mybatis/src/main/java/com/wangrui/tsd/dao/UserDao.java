package com.wangrui.tsd.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.wangrui.tsd.bean.User;

@Repository
@Mapper
@CacheNamespace
public interface UserDao {

	@Select("select * from t_user  where phone_number=#{phoneNumber}")
	@Results(id = "UserMapper", value = {@Result(column = "user_id", property = "userID", id = true),
			                          @Result(column = "phone_number", property = "phoneNumber"),
			                          @Result(column = "user_name", property = "userName"),
			                          @Result(column = "avatarUrl", property = "avatarUrl"),
			                          @Result(column = "user_id", property = "dynamicList", 
			                          many = @Many(select = "com.wangrui.tsd.dao.DynamicDao.listByUserID") )
			                           })
	public User findByPhoneNumber(String phoneNumber);
	
	
	@Insert("insert into t_user(user_id, phone_number, user_name) values (#{userID}, #{phoneNumber}, #{userName})")
	@SelectKey(before = true, keyColumn = "user_id", resultType = Integer.class, keyProperty = "userID",
	           statement = { "select seq_user.nextval from dual" })
	public void add(User user);
	
	@Update("update t_user set user_name=#{userName, jdbcType=VARCHAR},"
			+ " avatarUrl=#{avatarUrl ,jdbcType=VARCHAR} where user_id=#{userID}")
	public void update(User user);
	
	@Select("select * from t_user where user_id=#{userID}")
	@ResultMap("UserMapper")
	public User findByID(int userID);
	
	@UpdateProvider(type = Provider.class, method = "updateUser")
	public void updateUser(User user);
	
}
