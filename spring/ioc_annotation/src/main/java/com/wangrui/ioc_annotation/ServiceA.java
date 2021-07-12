package com.wangrui.ioc_annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {

	@PostConstruct
	public void init() {
		System.out.println("初始化工作");
	}
	
	public void service() {
		System.out.println("为用户进行服务");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("进行资源回收");
	}
}
