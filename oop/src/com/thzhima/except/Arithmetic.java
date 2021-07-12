package com.thzhima.except;

public class Arithmetic {

	public static double division(double a, double b) throws ParameterException, ArithmeticException {
		if(b == 0) {
			throw new ParameterException("����Ϊ0����������ȷ��");	
		}
		double result = a / b;
		return result;
	}
	
	
	public static void main(String[] args)  {
		while(true) {
			int b = (int)(Math.random()*10);
			try {
				double d = Arithmetic.division(10, b);
				System.out.println(d);
				break;
			} catch (ParameterException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
