package com.wangrui.myblog.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.myblog.bean.Type;

public class TypeDao {

	public static List<Type> listType() throws SQLException{
		List<Type> list = null;
		
		String sql = "select * from t_type";
		
		ResultSetExtrector<List<Type>> ext = (rst)->{
			List<Type> li = new ArrayList<>();
			while(rst.next()) {
				int typeID = rst.getInt(1);
				String typeName = rst.getString(2);
				li.add(new Type(typeID, typeName));
			}
			
			return li;
		};
		
		
		JdbcTemplate tmp = new JdbcTemplate();
		list = tmp.select(sql, ext);
		
		return list;
	}
	
}
