package com.wangrui.tsd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.wangrui.tsd.bean.Dynamic;
import com.wangrui.tsd.bean.User;

@Repository
@Mapper
public interface DynamicDao {

	@Insert("insert into t_dynamic(dynamic_id, title, content, picture, user_id)"
			+ " values (#{dynamicID}, #{title}, #{content}, #{picture}, #{user.userID})")
	@SelectKey(before = true, keyColumn = "dynamic_id", keyProperty = "dynamicID", resultType = Integer.class, 
	           statement = "select seq_dynamic.nextval from dual")
	public void add(Dynamic d);
	
	@Select("select * from t_dynamic where user_id=#{userID}")
	@Results(id = "DynamicMapper", 
	         value = {@Result(column = "dynamic_id", property = "dynamicID", id = true),
	        		  @Result(column = "title", property = "title"),
	        		  @Result(column = "content", property = "content"),
	        		  @Result(column = "picture", property = "picture"),
	        		  @Result(column = "user_id", property = "user.userID")})
	public List<Dynamic> listByUserID(int userID);
}
