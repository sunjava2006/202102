package com.thzhima.interfacees.test;

//import com.thzhima.interfacees.*;


public class Test {

	public static void main(String[] args) {
		
		com.thzhima.interfacees.Jack jack = new com.thzhima.interfacees.MiJack(60, 120, 50);
		
		jack.connect();
		
		
		com.thzhima.interfacees.JackBoard j = new com.thzhima.interfacees.MiJack(60, 120, 50);
		System.out.println(j.width);
		
		
		com.thzhima.interfacees.USB usb = new com.thzhima.interfacees.MiJack(60, 120, 50);
		usb.connectUSB();
		
		

	}
}
