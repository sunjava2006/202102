package com.thzhima.base.work;

public class ExampleFor {

	public static void main(String[] args) {
		/*
		 * ��ӡ�����
		 *    **********
		 *    **********
		 *    **********
		 *    **********
		 *    **********
		 */
		
		for(int row = 1; row <= 5; row++) {
			for(int count = 1;count<=10; count++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * ��ӡ�����
		 *    **********
		 *     **********
		 *      **********
		 *       **********
		 *        **********
		 */
		
		for(int i=0; i<5; i++) {
			for(int b=0; b<i; b++) {
				System.out.print(" ");
			}
			for(int s=1; s<=10; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * ��� ��99 �˷���
		 */
		for(int i=9; i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print(j + "*" + i + "=" + j*i + "\t");
			}
			System.out.println();
		}
		
		
		/*
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		
		
	}
}
