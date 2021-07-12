package com.wangrui.iocaop.ioc;

import com.wangrui.iocaop.ioc.factory.TV;
import com.wangrui.iocaop.ioc.factory.TVFactory;

public class Test {

	public static void main(String[] args) {
		TVFactory f = new TVFactory();
		TV tv = f.createTV();
	}
}
