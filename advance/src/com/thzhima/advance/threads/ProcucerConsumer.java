package com.thzhima.advance.threads;

import java.util.ArrayList;
import java.util.List;

public class ProcucerConsumer {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		Thread procucer = new Thread(()->{
			int count = 1;
			while(true) {
				try {
					synchronized (list) {
						
						for(int i=1;i<=10;i++) {
							System.out.println("生产了商品：" + count);
							list.add(count++);
							Thread.sleep(500);
						}
						list.notifyAll();
						list.wait();
					}
				} catch (Exception e) {
					
				}
			}
			
		});
		
		Thread consumer = new Thread(()->{
			while(true)
			try {
				synchronized (list) {
					while(! list.isEmpty()) {
						Integer o = list.remove(0);
						System.out.println("消费了商品：" + o);
						Thread.sleep(500);
					}
					list.notifyAll();
					list.wait();
				}	
			}catch(Exception e) {
				
			}
		});
		
		procucer.start();
		consumer.start();
	}
}
