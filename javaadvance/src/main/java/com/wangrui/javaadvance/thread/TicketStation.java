package com.wangrui.javaadvance.thread;

import java.util.Arrays;

public class TicketStation {

	Ticket[] njtickets;
	int njcount;

	public TicketStation(int n) {
		this.njtickets = new Ticket[n];
		this.njcount = n;
		for (int i = 0; i < njtickets.length; i++) {
			Ticket t = new Ticket(i + 1);
			this.njtickets[i] = t;
		}

	}

	public Ticket[] buy(int n) {
		synchronized (njtickets) {
			Ticket[] m = null;

			if (njcount >= n) {
				m = new Ticket[n];
				for (int i = 0; i < n; i++) {
					Ticket s = this.njtickets[--njcount];
					
					
					
					
					this.njtickets[njcount] = null;
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					m[i] = s;
				}
			}

			return m;
		}

	}

	public static void main(String[] args) {
		TicketStation ts = new TicketStation(10);
		
		class BuyTicketTask implements Runnable{
			int count;
			
			BuyTicketTask(int count){
				this.count = count;
			}
			
			public void run() {
				Ticket[] myTicket = ts.buy(this.count);
				String name = Thread.currentThread().getName();
				System.out.println(name + ": " + Arrays.toString(myTicket));
			}
		}
		
		BuyTicketTask task1 = new BuyTicketTask(3);
		BuyTicketTask task2 = new BuyTicketTask(2);
		BuyTicketTask task3 = new BuyTicketTask(4);
		BuyTicketTask task4 = new BuyTicketTask(5);

		Thread t1 = new Thread(task1, "t1");
		Thread t2 = new Thread(task2, "t2");
		Thread t3 = new Thread(task3, "t3");
		Thread t4 = new Thread(task4, "t4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println(Arrays.toString(ts.njtickets));

	}

}

class Ticket {
	int sn;

	Ticket(int sn) {
		this.sn = sn;
	}

	@Override
	public String toString() {
		return "Ticket [sn=" + sn + "]";
	}

}