package com.thzhima.advance.util;

public class ThreadStauteTest {

	public static void main(String[] args) throws InterruptedException {
		Thread main = Thread.currentThread();
		
		Thread sub  = new Thread("sub") {
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println("---------");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		
		Thread t = new Thread() {
			public void run() {
				while(true) {
					State s = sub.getState();
					System.out.println(sub.getName()+ ":"+ s);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		t.setDaemon(true); // 设置一个线程为守护线程
		
		t.start();
		
		Thread.sleep(1);
		
		sub.start();
		
		System.out.println("---------------end----------------");
		
	}
}
