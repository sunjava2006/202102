package com.wangrui.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheculedThreadPool {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(1);
		
		Runnable task1 = ()->{
			System.out.println(Thread.currentThread().getName());
			System.out.println("活动线程数："+ scheduledPool.getActiveCount());
		};
		
		Callable task2 = ()->{System.out.println("------------");Thread.sleep(100);return Thread.currentThread().getName();};
		
//		scheduledPool.schedule(task2, 10, TimeUnit.SECONDS);
		
//		scheduledPool.schedule(task1, 10, TimeUnit.SECONDS);
		
//		scheduledPool.scheduleAtFixedRate(task1, 10, 1, TimeUnit.SECONDS);
		
		scheduledPool.scheduleWithFixedDelay(task1, 10, 1, TimeUnit.SECONDS);
		
//		scheduledPool.shutdown();
		
	}
}
