package com.wangrui.aop.dynamicproxy;

import java.time.LocalDate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class Log {

//	@Before("execution(* com.wangrui.aop.dynamicproxy.PrintService.service(*))")
	//@After("execution(* com.wangrui.aop.dynamicproxy.PrintService.service(..))")
	public void log() {
		System.out.println(LocalDate.now());
	}
	
	
	//@Around("@annotation(com.wangrui.aop.dynamicproxy.Monitor)")
	public Object time(ProceedingJoinPoint pjp) throws Throwable {
		Object o = null;
		System.out.println(System.currentTimeMillis());
		
		o = pjp.proceed();
		 
		System.out.println(System.currentTimeMillis());
		
		return o;
	}
}
