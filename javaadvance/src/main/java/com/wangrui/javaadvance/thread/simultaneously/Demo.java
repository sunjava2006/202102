package com.wangrui.javaadvance.thread.simultaneously;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(5); // 创建5个计数的门闩
		
		// lambda 表达式， 就是匿名类的一个不同的表现形式。
		Runnable target = ()->{
			System.out.println("start");
			latch.countDown(); // 使门闩计数减1。
		    try {
				latch.await();   // 等待计数为0
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("---------------->执行任务");
		}; 
		
		
		for(int i=0; i<5; i++) {
			Thread t = new Thread(target);
			
			t.start();
		}
		for(int i=0; i<5; i++) {
			Thread t = new Thread(target);
			
			t.start();
		}
		
	}
}
