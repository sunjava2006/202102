package com.wangrui.tsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

//@Service
public class RedisService {

//	RedisAutoConfiguration
//	@Autowired
	private RedisTemplate tmp;
	
	public void add() {
		ValueOperations valOps= tmp.opsForValue();
		valOps.append("userID", "1000");
		
		String id = (String) valOps.get("userID");
		System.out.println(id);
	}
}
