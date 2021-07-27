package com.wangrui.tsd.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.wangrui.tsd.bean.Dynamic;

@Repository
@Mapper
public interface DynamicDao {

	@Insert("insert into t_dynamic(dynamic_id, title, content, picture, user_id)"
			+ " values (#{dynamicID}, #{title}, #{content}, #{picture}, #{user.userID})")
	@SelectKey(before = true, keyColumn = "dynamic_id", keyProperty = "dynamicID", resultType = Integer.class, 
	           statement = "select seq_dynamic.nextval from dual")
	public void add(Dynamic d);
}
