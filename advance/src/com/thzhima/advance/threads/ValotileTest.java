package com.thzhima.advance.threads;

public class ValotileTest {
    volatile  boolean ok = true; // 缓存一致性协议
	
	public static void main(String[] args) throws InterruptedException {
		
		ValotileTest vt = new ValotileTest();
		
		Thread t = new Thread() {
			public void run() {
				while(vt.ok){
					System.out.println(vt); // 缓存一致性协议
				}
				System.out.println("----------end------------");
			}
		};
		
		t.start();
		
		Thread.sleep(2000);
		vt.ok = false;
		System.out.println("ok 设置为 false。");
		
		
	}
}
