package com.thzhima.ususly;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd ahh:mm:ss");
		
		Date now = new Date();
		
		String str = fmt.format(now); // 格式化
		
		System.out.println(str);
		
		Date d = fmt.parse("2021/05/26 上午04:03:0"); // 解析
		System.out.println(d);
		
		
		DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(f.format(now));
	}
}
