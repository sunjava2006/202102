package com.wangrui.aop.dynamicproxy;

import java.time.LocalDate;

public class Log {

	public void log() {
		System.out.println(LocalDate.now());
	}
}
