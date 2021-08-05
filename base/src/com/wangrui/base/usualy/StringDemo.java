package com.wangrui.base.usualy;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "hEllO World";
		
		System.out.println(s.length());
		
		System.out.println(s.toUpperCase());
		System.out.println(s);
		
		System.out.println(s.toLowerCase());
		System.out.println(s);
		
		System.out.println(s = s.replace("l", "*"));
		System.out.println("------------------------------------------");
		System.out.println(s);
		
		System.out.println(s.indexOf("o"));
		char c = s.charAt(7);
		System.out.println(c);
		
		int idx = s.lastIndexOf("h");
		System.out.println(idx);
		
		byte[] data = s.getBytes("utf-8");
		
		String tr = String.valueOf(true);
		System.out.println(tr);
		
		System.out.println(String.join(",", Arrays.asList(new String[]{"h","i","o"})));
	}
}
