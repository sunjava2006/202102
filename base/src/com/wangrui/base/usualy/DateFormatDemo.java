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
		SimpleDateFormat sfmt = new SimpleDateFormat("yyyy年M月d日 E");
		s = sfmt.format(d);
		System.out.println(s);
		
		
		String date = "2021年8月5日 星期四";
		
		Date d2 = sfmt.parse(date);
		System.out.println(d2);
		
	}
}
