package com.wangrui.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Synchronous {

	public static void main(String[] args) throws InterruptedException {
		SynchronousQueue<String> q = new SynchronousQueue<>();
		
		Thread t = new Thread(()->{
			try {
				String s = q.poll(100, TimeUnit.MICROSECONDS);
				System.out.println("poll:" + s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t.start();
		
		boolean offerOk = q.offer("hi", 100, TimeUnit.MICROSECONDS);
		System.out.println(offerOk);
	}
}
