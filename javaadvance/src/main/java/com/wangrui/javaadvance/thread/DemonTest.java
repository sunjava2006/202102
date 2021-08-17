package com.wangrui.javaadvance.thread;

public class DemonTest {

	public static void main(String[] args) {
		
		Thread t = new Thread() {
			public void run() {
				for(int i=0;i<100;i++) {
					System.out.println("----------------");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		
		
		Thread demon = new Thread(){
			public void run() {
				while(true) {
					System.out.println("**************");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		demon.setDaemon(true);// 将该线程设置为守护线程
		t.start();
		demon.start();
		
	}

}
