package com.thzhima.advance.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CountDownDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Account a = new Account(243434543434554L, 3000);
		
		CountDownLatch countDown = new CountDownLatch(3);
//		CyclicBarrier cb = new CyclicBarrier(3);
		
		Runnable task = ()->{
			
			try {
				System.out.println(Thread.currentThread().getName());
				countDown.countDown();
				countDown.await();
//				cb.await(10, TimeUnit.MILLISECONDS);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bank.save(a, 100);
			}
			
			
		};
		
		for(int i=0;i<3;i++) {
			Thread t = new Thread(task);
			t.start();
		}
		System.out.println("-----------------------------------------");
		for(int i=0;i<3;i++) {
			Thread t = new Thread(task);
			t.start();
		}
	}
}
