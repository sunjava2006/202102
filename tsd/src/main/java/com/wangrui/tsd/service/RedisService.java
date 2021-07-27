package com.wangrui.tsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.wangrui.tsd.bean.Book;

@Service
public class RedisService {



	@Autowired
//	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	RedisAutoConfiguration c;
	
	@Autowired
	Book book;
	
	public void add() {
		ValueOperations vo = redisTemplate.opsForValue();
		vo.set("book", book);
		Object o = vo.get("book");
		System.out.println(o);
	}
}
