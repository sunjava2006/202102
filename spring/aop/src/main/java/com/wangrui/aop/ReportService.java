package com.wangrui.aop;


@org.springframework.stereotype.Service
public class ReportService implements Service{

	@Override
	public void service() {
		System.out.println("报表服务执行..........................");
	}

}
