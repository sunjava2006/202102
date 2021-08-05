package com.wangrui.base.usualy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		
		System.out.println(d);
		
		//==============================================
		
		DateFormat fmt = DateFormat.getDateInstance(DateFormat.SHORT);
		
		String s = fmt.format(d);
		System.out.println(s);
		
		
		//=================================================
		SimpleDateFormat sfmt = new SimpleDateFormat("yyyy��M��d�� E");
		s = sfmt.format(d);
		System.out.println(s);
		
		
		String date = "2021��8��5�� ������";
		
		Date d2 = sfmt.parse(date);
		System.out.println(d2);
		
	}
}
