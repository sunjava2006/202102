package com.wangrui.base.interfaces;

import java.io.Serializable;
import java.util.Arrays;

public class TypeC extends Object implements USBC, Serializable {

	@Override
	public void connect(USB usb) {
		System.out.println("CONNECT");
	}

	@Override
	public byte[] transfor(USB usb) {
		return "HFDFD".getBytes();
	}
	
	public static void main(String[] args) {
		USBC usbc = new TypeC();
		
		System.out.println(usbc.maxVoltage);
		System.out.println(usbc.maxSpeed);
		System.out.println(usbc.pinCount);
		
		usbc.connect(usbc);
		byte[] data = usbc.transfor(usbc);
		System.out.println(Arrays.toString(data));
	}

}
