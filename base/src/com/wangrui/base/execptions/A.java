package com.wangrui.base.execptions;

import java.net.MalformedURLException;
import java.net.URL;

public class A {

	public static void main(String[] args)   {
		try {
			int a = 1/0;
			
			System.out.println(a);
	        
			URL url = new URL("fdf");
			
			int[] array = new int[-1];
			
		}
//		catch(ArithmeticException  | MalformedURLException ex) {
//			System.out.println("≤∂ªÒ¡À“Ï≥£");
//		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			System.out.println("over");
		}
		
		
		
		
	}
}
