package com.wangrui.ioc.anno;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class PrintService {

	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	
	public void print() {
		System.out.println("print------------------");
	}
	
	@PreDestroy
	public void shutdown() {
		System.out.println("------shutdown------------------");
	}
}
