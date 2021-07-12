package com.thzhima.except;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class A {

	public static void main(String[] args) throws IOException  {
		
		int a = 3;
		int b = 10;
		
		int c = a / b;
		
		int length = 3;
		int[] array = new int[length];
		
		array[0] = 50;
		
		Object o = new Object();
		
//		String s = (String) o;
		
		System.out.println("end");
		InputStream in = null;
		try {
			URI uri = new URI("http://www.qq.com");
			in = uri.toURL().openStream();
			byte[] buffer = new byte[1024*1024];
			int count = in.read(buffer);
			String str = new String(buffer,0, count, "utf-8");
			System.out.println(str);
		} 
//		catch (URISyntaxException ex) {
//			System.out.println(ex);
//		} catch(IOException ex) {
//			ex.printStackTrace();
//		}
		catch(Exception ex) {
			ex.printStackTrace();
		} 
		
	
		finally {
			in.close();
		}
		
	}
}
