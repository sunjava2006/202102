package com.wangrui.javaadvance.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {

	private static UserDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new UserDao();
	}

//	@Test
	public void testAdd() throws SQLException {
		int c = dao.add("FangFang", "123456", "女");
		assertEquals(c, 1);
	}
	
	@Test
	public void testUpdate() throws SQLException {
		int c = dao.update(1220, "123abc");
		assertEquals(c, 1);
	}

}
