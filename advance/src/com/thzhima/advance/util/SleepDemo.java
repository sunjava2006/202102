package com.thzhima.advance.util;

public class SleepDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable target = ()->{ // Lambda ±Ì¥Ô Ω
			System.out.println("start");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end");
		};
		
		Thread t = new Thread(target);
		
		t.start();
		
		Thread.sleep(2000);
		t.interrupt();
		System.out.println("------interrupt t---------");
		
	}

}
