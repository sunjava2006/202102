package com.thzhima.interfacees;


public interface Jack {
	
 	int volt = 220;  //public static final
 	public static final int hole = 3;
	
    void connect(); // �����ǳ��󷽷�  public abstract 
    
    static void a() {
    	
    }
    
    public default void b() {
    	System.out.println("-------------");
    }
	
}
