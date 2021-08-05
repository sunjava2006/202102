package com.wangrui.base.interfaces;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.println(USB.pinCount);
		
		USB usb = new MinUSB() ;
		
		usb.connect(usb);
		byte[] data = usb.transfor(usb);
		System.out.println(Arrays.toString(data));
	}
}
