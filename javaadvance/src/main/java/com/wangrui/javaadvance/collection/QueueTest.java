package com.wangrui.javaadvance.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new ArrayBlockingQueue(2);
		
		q.offer("hello");
		q.offer("ok");
		q.offer("!");
		
		String s = q.peek();
		System.out.println(s);
		s = q.peek();
		System.out.println(s);
		
		System.out.println("=========================");
		while(! q.isEmpty()) {
			s = q.remove();
			System.out.println(s);
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		BlockingQueue<String> bq = new LinkedBlockingQueue<>(3);
		bq.offer("i");
		bq.offer("o");
		bq.offer("u");
		try {
			bq.offer("!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(bq);
		
	}
}
