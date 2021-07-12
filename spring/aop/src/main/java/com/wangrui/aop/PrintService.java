package com.wangrui.aop;

import org.springframework.stereotype.Service;

@Service
public class PrintService {

	public void init() {
		System.out.println("-------------- print init ------------------");
	}
	
	public void service() {
		System.out.println("=======================print==============");
	}
	
	
}
