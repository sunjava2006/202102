package com.wangrui.base.accessable.abc;

import com.wangrui.base.accessable.Father;

public class Other {

	public void aboutFather() {
		Father f = new Father();
		
		System.out.println( f.gender );
	}
}
