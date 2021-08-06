package com.wangrui.javaadvance.thread;

public class CreateThread {

	public static void main(String[] args) {
		
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		

		Thread t = new Thread(runnable);

		t.start();
		
		
		Thread t3= new Thread(runnable);
		t3.start();
		
//		t.run(); //error
		
		
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		t2.start();
		
		
		Thread t4 = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		t4.start();
	}
}
