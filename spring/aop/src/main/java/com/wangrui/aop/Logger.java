package com.wangrui.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class Logger {

//	@Before("execution(* com.wangrui.aop.PrintService.init(..))")
	@After("execution(* com.wangrui.aop.PrintService.service(..))")
	public void log() {
		System.out.println("--------------log-------------");
	}
	
	
}
