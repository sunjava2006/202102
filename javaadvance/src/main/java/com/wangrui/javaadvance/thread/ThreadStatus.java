package com.wangrui.javaadvance.thread;

public class ThreadStatus {

	public static void main(String[] args) throws InterruptedException {
		
		Object o = new Object();
		
		
		Thread t = new Thread() {
			public void run() {
				System.out.println("------------------");
				try {
//					Thread.sleep(30);
					synchronized (o) {
//						o.wait(100);
						
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread daemon = new Thread() {
			public void run() {
			   while(true) {
				   System.out.println(t.getState());
			   }
			}
		};
		
		daemon.setDaemon(true);
		daemon.start();
		
		
		daemon.join(10);
		
		t.start();
		
		synchronized (o) {
			Thread.sleep(10);
		}
		
		
	}
	
}
