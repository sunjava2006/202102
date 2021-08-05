package com.wangrui.base.abs;

public class A {

	static int a = 10;
	B bobj = new B();
	int b = bobj.a1;
	
	class B{
		int a1 = a;
	}
	
	static class C{
		int i = a; 
	}
	
	 static class D{
		static  int i ;
	}
	 
	public void todo() {
		{
			class AA{
		       int j = a;	
		    }
		
		    AA aa = new AA();
		}
//		AA aa = new AA();
	}
	
	
}
