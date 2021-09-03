package com.wangrui.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		BlockingQueue q = new ArrayBlockingQueue<>(2, true);
		BlockingQueue q = new SynchronousQueue<>();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 10, TimeUnit.MICROSECONDS, q);
		
		int activeCount = pool.getActiveCount();
		System.out.println("没有执行任务时，活动线程数：" + activeCount);
		
		Runnable task1 = ()->{
			System.out.println(Thread.currentThread().getName());
			System.out.println("活动线程数："+ pool.getActiveCount());
		};
		
		Callable task2 = ()->{System.out.println("------------");Thread.sleep(100);return Thread.currentThread().getName();};
		
		for(int i=0; i<=13;i++) {
//			Future f = pool.submit(task2);
//			System.out.println(f.get());
			
			pool.submit(task1);
		}
		
		pool.shutdown();
	}
}
