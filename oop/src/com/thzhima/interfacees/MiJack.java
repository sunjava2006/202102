package com.thzhima.interfacees;

public  class MiJack extends JackBoard implements Jack, USB{

	public MiJack(int width, int length, int height) {
		super(width, length, height);
	}
	
	@Override
	public void connect() {
		System.out.println("��Դ��������");
	}

	@Override
	public void connectUSB() {
		System.out.println("usb����");
		
	}

}
