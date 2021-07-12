package com.thzhima.interfacees;

public  class MiJack extends JackBoard implements Jack, USB{

	public MiJack(int width, int length, int height) {
		super(width, length, height);
	}
	
	@Override
	public void connect() {
		System.out.println("电源插座连接");
	}

	@Override
	public void connectUSB() {
		System.out.println("usb连接");
		
	}

}
