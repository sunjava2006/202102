package com.thzhima.wraper;

public class IntegerDemo {
	
	public static void main(String[] args) {
		
		int a = 200;
		Integer aa = 200;   // Integer.valueOf(200) ; ×°Ïä
		
		a = aa;            //  aa.intValue();        ²ðÏä  
		
		long l = 20L;
		Long ll = new Long(300L);
		
		short s = 9;
		Short ss = 9;
		
		byte b = 0;
		Byte bb = 0;
		
		char c ='c';
		Character cc = 'c';
		
		boolean bf = false;
		Boolean bbf = false;
		
		float f = 3.3F;
		Float ff = 4.4F;
		
		double d = 3.3;
		Double dd = 4.4;
	}

}
