package com.wangrui.myblog.dao;

import java.sql.SQLException;

import com.wangrui.myblog.bean.Blog;

public class BlogDao {

	public Blog findByUserID(int userID) throws SQLException {
		Blog b = null;
		
		String sql = "select * from t_blog where user_id=?";
		ResultSetExtrector<Blog> ext = (rst)->{
			Blog bb = null;
			if(rst.next()) {
				int blogID = rst.getInt("blog_id");
				String blogName = rst.getString("blog_name");
				String nickName = rst.getString("nick_name");
				String photo = rst.getString("photo");
				
				bb = new Blog(blogID, blogName, nickName, userID, photo);
			}
			return bb;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		b = tmp.select(sql, ext, userID);
		
		return b;
	}
	
	
	public Blog add(String blogName, String nickName, String photo, int userID) throws SQLException {
		
		Blog b = null;
		
		// ªÒ»° blogID
		String idsql = "select seq_blog.nextval from dual";
		ResultSetExtrector<Integer> ext = (rst)->{
			Integer i = null;
			if(rst.next()) {
				i = rst.getInt(1);
			}
			return i;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		Integer blogID = tmp.select(idsql, ext);
		if(blogID != null) {
			
			String sql = "insert into t_blog(blog_id, blog_name, nick_name, photo, user_id) values(?,?,?,?,?)";
			int count = tmp.cud(sql, blogID, blogName, nickName, photo, userID);
			if(1==count) {
				b = new Blog(blogID, blogName, nickName, userID, photo);
			}
			
		}

		return b;
		
	}
}
