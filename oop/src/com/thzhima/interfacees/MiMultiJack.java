package com.thzhima.interfacees;

public class MiMultiJack extends JackBoard implements MulitJack{

	public MiMultiJack(int width, int length, int height) {
		super(width, length, height);
	}

	@Override
	public void connect() {
		System.out.println("�������ӹ��ꡢӢ�����ֲ�ͷ");
	}

	@Override
	public void connectUSB() {
		System.out.println("USB�ӿ�");
	}

	@Override
	public void switcher() {
		System.out.println("�򿪿���");
	}
	
	public static void main(String[] args) {
		USB usb = new MiMultiJack(40, 250, 50);
		A a;
	}

}
