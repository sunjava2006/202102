package com.wangrui.mybatislearning.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.cache.decorators.LruCache;

import com.wangrui.mybatislearning.bean.User;





@Mapper
@CacheNamespace(eviction = LruCache.class, flushInterval = 2000, size = 20)
public interface UserDao {

	@Select("select * from t_user  where phone_number=#{phoneNumber}")
	@Results(id = "UserMapper", value = {@Result(column = "user_id", property = "userID", id = true),
			                          @Result(column = "phone_number", property = "phoneNumber"),
			                          @Result(column = "user_name", property = "userName"),
			                          @Result(column = "avatarUrl", property = "avatarUrl"),
			                          @Result(column = "user_id", property = "dynamicList", 
			                          many = @Many(select = "com.wangrui.mybatislearning.dao.DynamicDao.listByUserID") )
			                           })
	public User findByPhoneNumber(String phoneNumber);
	
	
	@Insert("insert into t_user(user_id, phone_number, user_name) values (#{userID}, #{phoneNumber}, #{userName})")
	@SelectKey(before = true, keyColumn = "user_id", resultType = Integer.class, keyProperty = "userID",
	           statement = { "select seq_user.nextval from dual" })
	public void add(User user);
	
	@Options(flushCache =FlushCachePolicy.FALSE) // FALSE不清除缓存
	@Update("update t_user set user_name=#{userName, jdbcType=VARCHAR},"
			+ " avatarUrl=#{avatarUrl ,jdbcType=VARCHAR} where user_id=#{userID}")
	public void update(User user);
	
	@Select("select * from t_user where user_id=#{userID}")
	@ResultMap("UserMapper")
	public User findByID(int userID);
	
	@UpdateProvider(type = Provider.class, method = "updateUser")
	public void updateUser(User user);
	
}
