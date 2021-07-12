package com.thzhima.advance;

public class MainThread {

	public static void main(String[] args) {
		
		// ��ȡ��ǰ�߳�
		Thread currThread = Thread.currentThread(); 
		
		String name = currThread.getName();
		
		System.out.println(name);
		
		Runnable task = new Runnable() {
			public void run() {
				System.out.println("�߳�����"+Thread.currentThread().getName());
			}
		};
		
		Thread st1 = new Thread(task, "���߳�1"); // ����һ���߳�
		
		
		Thread st2 = new Thread("���߳�2") {
			public void run() {
				System.out.println("�߳���:��"+Thread.currentThread().getName());
			}
		};
		
		
		
		st1.start(); // �����߳�
		st2.start();
		
		st2.run(); // 
		
		
	}
}
