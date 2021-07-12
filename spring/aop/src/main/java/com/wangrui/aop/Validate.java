package com.wangrui.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Validate {

//	@Before("execution(* com.wangrui.aop.ReportService.service(..))")
	public boolean isOk() {
		int ran = (int)(Math.random()*10);
		boolean ok = ran%2==0 ? true : false;
		System.out.println("校验：" + ok);
		return ok;
	}
	
	@Around("execution(* com.wangrui.aop.ReportService.service(..))")
	public Object validate(ProceedingJoinPoint pjp) throws Throwable {
		Object o = null;
		if(isOk()) {
			o = pjp.proceed();
		}
		return o;
	}
}
