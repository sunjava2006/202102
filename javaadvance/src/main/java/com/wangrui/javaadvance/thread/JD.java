package com.wangrui.javaadvance.thread;

import java.util.ArrayList;
import java.util.List;

public class JD {

	
	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> schema = new ArrayList();
		
		Thread t = new Thread() {
			public void run() {
				synchronized (schema) { // 必须先持有schema对象的锁。
					try {
						schema.wait(5); // 在schema对象上等待通知，并释放schema上的锁，并进入等待池。等待线程被唤醒。进入锁池，竞争为schema加锁。
						if(schema.size()>0) {
							Integer o = schema.remove(schema.size()-1);
							System.out.println(Thread.currentThread().getName()+":"+o);
						}
						System.out.println(Thread.currentThread().getName()+"end");
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		

		
		Thread t2 = new Thread() {
			public void run() {
				synchronized (schema) { // 必须先持有schema对象的锁。
					try {
						schema.wait(4); // 在schema对象上等待通知，并释放schema上的锁，并进入等待池。等待线程被唤醒。进入锁池，竞争为schema加锁。
						if(schema.size()>0) {
							Integer o = schema.remove(schema.size()-1);
							System.out.println(Thread.currentThread().getName()+":"+o);
						}
						System.out.println(Thread.currentThread().getName()+"end");
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t2.start();
		t.start();
		
		t.join(10);
		t2.join(10);
		
		synchronized (schema) {
			 Integer i = new Integer(123567);
        
             schema.add(i);
             schema.notifyAll(); // 发出通知，通知那些等待schema对象，并获取锁的线程。
		}
       
//		synchronized (schema) {
//			 Integer i = new Integer(123567);
//       
//            schema.add(i);
//            schema.notifyAll(); // 发出通知，通知那些等待schema对象，并获取锁的线程。
//		}
        
		
		
	}
}
