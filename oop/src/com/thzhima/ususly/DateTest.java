package com.thzhima.ususly;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Date d = new Date(System.currentTimeMillis());
		System.out.println(d);
		
		Date birthDate = new Date(2009-1900, 5, 4);
		System.out.println(birthDate);
		
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DATE, 25);
//		ca.set(2009, 5, 4, 8, 12, 30);
		Date birthday = ca.getTime();
		System.out.println(birthday);
		
		long millis = ca.getTimeInMillis();
		
		
	}
}
