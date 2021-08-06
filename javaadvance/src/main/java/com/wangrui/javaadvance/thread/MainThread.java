package com.wangrui.javaadvance.thread;

public class MainThread {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread(); // 静态方法，获取当前线程
		
		String threadName = t.getName();
		
		System.out.println(threadName);
		
	}
}
