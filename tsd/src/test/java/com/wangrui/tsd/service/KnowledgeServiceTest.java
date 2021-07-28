package com.wangrui.tsd.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KnowledgeServiceTest {
	
	@Autowired
	private KnowledgeService ks;

	@Test
	void testPublish() {
		
	}

//	@Test
	void testListByPage() {
		ks.listByPage(1, 2);
		ks.listByPage(1, 2);
	}

//	@Test
	void testTotalCount() {
		ks.totalCount();
		ks.totalCount();
	}

//	@Test
	void testTotalPage() {
		ks.totalPage(2);
		ks.totalPage(2);
	}

	@Test
	void testFindById() {
		System.out.println(ks.findById(5));
		ks.deleteByID(5);
		System.out.println(ks.findById(5));
	}

	@Test
	void testDeleteByID() {
		
	}

}
