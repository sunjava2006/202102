package com.wangrui.javaadvance.thread;

import java.util.ArrayList;
import java.util.List;

public class SynchroList {

	
	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=10000;i++) {
					synchronized (list) {// 同步代码块。synchronized（对象名）， 在指定的对象上加同步锁（排它锁）。
						list.add(i);
					}
				}
			}
		};
		
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=10000;i++) {
					synchronized (list2) {// 同步代码块。synchronized（对象名）， 在指定的对象上加同步锁（排它锁）。
						list.add(i);
					}
				}
			}
		};
		
		
		Thread t = new Thread(runnable);
		
		Thread t2 = new Thread(runnable2);
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(list.size());
		System.out.println(list2.size());
		
		
	}
}
