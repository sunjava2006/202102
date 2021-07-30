package com.wangrui.tsd.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.tsd.bean.User;
@SpringBootTest
class UserDaoTest {

	@Autowired
	private UserDao dao;
	
	@Test
	void testFindByID() {
		User u = dao.findByID(1);
		u = dao.findByID(1);
	}

}
