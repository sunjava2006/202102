package com.wangrui.tsd.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.tsd.bean.Dynamic;
@SpringBootTest
class DynamicDaoTest {

	@Autowired
	private DynamicDao dd;
	
	@Test
	void testListByUserID() {
		List<Dynamic> list = dd.listByUserID(1);
		System.out.println(list);
	}

}
