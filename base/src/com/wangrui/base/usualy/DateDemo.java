package com.wangrui.base.usualy;

import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date birthDate = new Date(1995-1900, 8-1, 1); // 当前时间日期对象
		
		System.out.println(birthDate);
		
		//----------------------------------------
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2009);
		c.set(Calendar.MONTH, 11);
//		c.set(1995, 8-1, 1, 2, 23,45);
		
		Date d = c.getTime();
		
		long millis = c.getTimeInMillis();
		System.out.println(millis);
		
		
		System.out.println(d);
	}
}
