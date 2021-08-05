package com.wangrui.base.interfaces;

import java.io.Serializable;

public  class MinUSB implements USB, Serializable {

	@Override
	public void connect(USB usb) {
		System.out.println("connect");

	}

	@Override
	public byte[] transfor(USB usb) {	
		return "data".getBytes();
	}

}
