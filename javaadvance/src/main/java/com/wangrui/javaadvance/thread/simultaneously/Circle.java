package com.wangrui.javaadvance.thread.simultaneously;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Circle {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(5);
		
		for(int i=1; i<=5; i++) {
			Thread t = new Thread(()->{
				System.out.println("start");
				try {
					barrier.await(); // 等待计数减1，至到0。
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("---------->执行任务");
			});
			t.start();
		}
		for(int i=1; i<=5; i++) {
			Thread t = new Thread(()->{
				System.out.println("start");
				try {
					barrier.await(); // 等待计数减1，至到0。
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("---------->执行任务");
			});
			t.start();
		}
	}
}
