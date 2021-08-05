package com.wangrui.base.interfaces;

public abstract interface USB {

	public static final int pinCount = 4; //public static final 
	int maxVoltage = 5;
	
	
	public abstract void connect(USB usb); // public abstract
	
    byte[] transfor(USB usb);

}
