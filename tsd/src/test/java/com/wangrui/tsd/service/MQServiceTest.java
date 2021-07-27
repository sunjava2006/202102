package com.wangrui.tsd.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MQServiceTest {

	@Autowired
	private MQService mqService;
	
	@Test
	void testSend() {
		this.mqService.send("今天大家在宿舍上课吗？?");
	}

}
