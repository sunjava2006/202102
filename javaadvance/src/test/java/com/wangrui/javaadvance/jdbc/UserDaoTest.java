package com.wangrui.javaadvance.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wangrui.javaadvance.jdbc.bean.User;

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
	
	//@Test
	public void testUpdate() throws SQLException {
		int c = dao.update(1220, "123abc");
		assertEquals(c, 1);
	}
	
//	@Test
	public void testDelete() throws SQLException {
		int c = dao.delete(1220);
		assertEquals(c, 1);
	}
	
//	@Test
	public void testSelect() throws SQLException {
		Map m = dao.select("wang", "123abc");
		System.out.println(m);
		assertNotNull(m);
	}
	
//	@Test
	public void testLogin() throws SQLException {
		User u = dao.login("Wang", "111222" );
		System.out.println(u);
//		assertEquals(u, null);
	}
	
//	@Test
	public void testUpdate2() throws SQLException {
		int c = dao.update(20, "Wang", "111222", "男");
		assertEquals(c, 1);
	}
	
	@Test
	public void testDeleteCascade() throws SQLException {
		int[] c = dao.deleteCascade(44);
		System.out.println(Arrays.toString(c));
	}

}
