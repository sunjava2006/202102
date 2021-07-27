package com.wangrui.tsd.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.wangrui.tsd.bean.Admin;

@Mapper
@Repository
public interface AdminDao {

	@Select("select * from t_admin where login_name=#{loginName} and pwd=#{pwd}")
	@Results(id="AdminMapper", value = {@Result(column = "id", property = "ID", id = true ),
			                            @Result(column = "login_name", property = "loginName"),
			                            @Result(column = "pwd", property = "pwd")
	                                    })
	public Admin find(Admin admin);
}
