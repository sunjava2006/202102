package com.wangrui.javaadvance.thread;

public class SleepTest {

	public static void main(String[] args) {

		Thread t = new Thread() {
			public void run() {

				try {
					for (int i = 1; i <= 10; i++) {
						System.out.println("-----");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		
        
		t.start();
		t.interrupt();
		

	}

}
