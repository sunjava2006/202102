package com.thzhima.base.work;

public class ������ {

	public static void main(String[] args) {
		/**
		 * ���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬����񫣬�ֶ����һ����
		 * �ڶ��������ֽ�ʣ�µ����ӳԵ�һ�룬�ֶ����һ�����Ժ�ÿ������
		 * ������ǰһ��ʣ�µ�һ����һ��������10���������ٳ�ʱ����ֻʣ��
		 * һ�������ˡ����һ�칲ժ�˶��١���֪ʶ�㣺ѭ����� while��
		 * 
		 * 10  9  8   7
		 * 1   4  10  22
		 * 
		 *    (10-5)-1=4
		 *    (4-2)-1=1
		 *    
		 *    (n+1)*2
		 * 
		 * 
		 */
		
		int n = 1;
		for(int i=1;i<=9;i++) {
			n = (n+1)*2;
		}
		System.out.println(n);
		System.out.println("============================");
		for(int i=1; i<=9; i++) {
			System.out.println(n);
			n = n/2-1;
		}
		System.out.println(n);
	}
}
