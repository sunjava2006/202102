package com.thzhima.advance.threads;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedArrayList<E> {

	ReentrantLock lock = new ReentrantLock();
	
	private ArrayList<E> list;
	
	public SynchronizedArrayList(ArrayList list){
		this.list = list;
	}
	
	public int size() {
		lock.lock();
		int size =  this.list.size();
		lock.unlock();
        return size;
	}
	
	public  boolean add(E e) {
		lock.lock();
		lock.lock();
		boolean b =  this.list.add(e);
		lock.unlock();
		lock.unlock();
        return b;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		SynchronizedArrayList<Integer> list = new SynchronizedArrayList<>(new ArrayList<>());
		
		Runnable task = ()->{
			for(int i=0;i<10000;i++) {
				list.add(i);
			}
		};
		
		Thread t = new Thread(task);
		Thread t2 = new Thread(task);
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(list.size());
		
	}
	
	
}
