package com.thzhima.advance.threads;

public class Procuder {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		
	    Object[] list = {1};
		
		Thread t = new Thread(()->{
			try {
				synchronized (o) {
					System.out.println(Thread.currentThread().getName()+"wait");
					o.wait();    // �����Ȼ������waitʱ�����ͷŵġ�
//					Thread.sleep(10000); // �����ͷŵġ����߳�֮ǰ�Ƿ��ȡ��û�й�ϵ������Ҳ���ı�������״̬��
				    if(list[0]!=null) {
				    	list[0]= null;
				    	System.out.println("����");
				    }else {
				    	System.out.println("û��");
				    }
						
					System.out.println("end");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	
		t.start();
		
		Thread t2 = new Thread(()->{
			try {
				synchronized (o) {
					System.out.println(Thread.currentThread().getName()+"wait");
					o.wait();    // �����Ȼ������waitʱ�����ͷŵġ�

				    if(list[0]!=null) {
				    	list[0]= null;
				    	System.out.println("����");
				    }else {
				    	System.out.println("û��");
				    }
						
					System.out.println("end");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t2.start();
		
		
		Thread.sleep(3000);
		synchronized (o) {
			System.out.println("will notify");
			o.notify();
		}
		
	}
}
