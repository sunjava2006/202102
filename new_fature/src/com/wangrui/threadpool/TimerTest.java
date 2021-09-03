package com.wangrui.threadpool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer("定时任务", false);
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
		};
		
		timer.schedule(task, 5000, 1000);
		
//		timer.scheduleAtFixedRate(task, 5000, 1000);
		

		
		
		Thread.sleep(10000);
		timer.cancel(); // 取消定时任务
	    
	}
}
