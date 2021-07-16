package com.wangrui.tsd.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.tsd.bean.Knowledge;

@SpringBootTest
class KnowledgeDaoTest {

	@Autowired
	private KnowledgeDao dao;
	
	//@Test
	void testList() {
		List<Knowledge> list = dao.list(1, 2);
		System.out.println(list);
	}
	
	@Test
	void testTotalCount() {
		int count = this.dao.totalCount();
		assertEquals(count, 8);
	}

}
