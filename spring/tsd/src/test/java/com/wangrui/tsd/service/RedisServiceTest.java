package com.wangrui.tsd.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisServiceTest {
	
	@Autowired
	private RedisService redisService;

	@Test
	void testAdd() {
		this.redisService.add();
	}

}
