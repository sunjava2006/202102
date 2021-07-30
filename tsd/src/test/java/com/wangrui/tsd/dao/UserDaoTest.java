package com.wangrui.tsd.dao;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.tsd.bean.User;
@SpringBootTest
class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
//	@Test
	void testFindByPhoneNumber() {
		User u = userDao.findByPhoneNumber("18013007327");
		System.out.println(u);
	}

//	@Test
	void testFindByID() {
		fail("Not yet implemented");
	}
	
	@Test
	void testUpdateUser() {
		User u = new User(2, "110", "小红");
//		u.setAvatarUrl("http://xxx");
		this.userDao.updateUser(u);
	}

}
