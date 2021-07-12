package com.thzhima.interfacees;

public class MiMultiJack extends JackBoard implements MulitJack{

	public MiMultiJack(int width, int length, int height) {
		super(width, length, height);
	}

	@Override
	public void connect() {
		System.out.println("可以连接国标、英制两种插头");
	}

	@Override
	public void connectUSB() {
		System.out.println("USB接口");
	}

	@Override
	public void switcher() {
		System.out.println("打开开关");
	}
	
	public static void main(String[] args) {
		USB usb = new MiMultiJack(40, 250, 50);
		A a;
	}

}
