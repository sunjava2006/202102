package com.wangrui.javaadvance.thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		Thread producer = new Thread() {
			public void run() {
				int count = 1;
				for (;;) {
					synchronized (list) {
						while (list.size() < 10) {
							System.out.println("+:" + count);
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							list.add(count++);
						}
						System.out.println(list);
						list.notifyAll();
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		};
		
		Thread producer2 = new Thread() {
			public void run() {
				int count = 100;
				for (;;) {
					synchronized (list) {
						while (list.size() < 10) {
							System.out.println("+:" + count);
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							list.add(count+=10);
						}
						System.out.println(list);
						list.notifyAll();
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		};

		Thread consumer = new Thread() {
			public void run() {

				synchronized (list) {
					while (true) {
						int size = list.size();
						System.out.println("size:" + size);
						for (int k = 0; k < size; k++) {
							Integer sn = list.remove(0);
							System.out.println("sn:" + sn);
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						list.notifyAll();
						try {
							list.wait();

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		};

		producer.start();
		consumer.start();
		producer2.start();

	}
}
