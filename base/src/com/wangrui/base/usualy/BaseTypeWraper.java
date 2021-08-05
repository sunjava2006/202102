package com.wangrui.base.usualy;

public class BaseTypeWraper {

	public static void main(String[] args) {
		
		byte b = 127;
		Byte bb = 127; //new Byte(b);
		
		b = bb;
		
		
		short s = 500;
		Short ss = 500;
		
		int i = 900;
		Integer ii = 900;
		
		long l = 90L;
		Long ll = 90L;
		
		float f = 3.14F;
		Float ff = 3.14F;
		
		double d = 2.3;
		Double dd = 2.3;
		
		char c = 'a';
		Character cc = 'a';
		
		boolean o = false;
		Boolean oo = false;
		
		boolean b2 = oo.booleanValue();
		
		String.valueOf(20);
		
		Integer ii2 = Integer.valueOf("30");
		
	}
}
