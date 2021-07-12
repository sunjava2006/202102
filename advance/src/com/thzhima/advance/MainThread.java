package com.thzhima.advance;

public class MainThread {

	public static void main(String[] args) {
		
		// 获取当前线程
		Thread currThread = Thread.currentThread(); 
		
		String name = currThread.getName();
		
		System.out.println(name);
		
		Runnable task = new Runnable() {
			public void run() {
				System.out.println("线程名："+Thread.currentThread().getName());
			}
		};
		
		Thread st1 = new Thread(task, "子线程1"); // 创建一个线程
		
		
		Thread st2 = new Thread("子线程2") {
			public void run() {
				System.out.println("线程名:："+Thread.currentThread().getName());
			}
		};
		
		
		
		st1.start(); // 启动线程
		st2.start();
		
		st2.run(); // 
		
		
	}
}
