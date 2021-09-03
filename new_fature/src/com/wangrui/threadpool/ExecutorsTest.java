package com.wangrui.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		pool = Executors.newFixedThreadPool(2);
		
		pool = Executors.newSingleThreadExecutor();
		
		Runnable task1 = ()->{
			System.out.println(Thread.currentThread().getName());
		};
		
		Callable task2 = ()->{System.out.println("------------");Thread.sleep(100);return Thread.currentThread().getName();};
		
		for(int i=0;i<30;i++) {
			pool.submit(task1);
		}
		
		pool.shutdown();
		
		ScheduledExecutorService spool =  Executors.newScheduledThreadPool(2);
		spool.schedule(task2, 10, TimeUnit.SECONDS);
		
		
	}
}
