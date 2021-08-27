package com.wangrui.myblog.service;

import java.sql.SQLException;
import java.util.List;

import com.wangrui.myblog.bean.Type;
import com.wangrui.myblog.dao.TypeDao;

public class TypeService {

	
	public static  List<Type> ListType() throws SQLException {
		return TypeDao.listType();
	}
}
