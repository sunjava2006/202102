package com.wangrui.myblog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtrector <T>{

	
	T extract(ResultSet rst) throws SQLException;
}
