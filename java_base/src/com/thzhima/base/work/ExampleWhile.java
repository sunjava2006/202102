package com.thzhima.base.work;

public class ExampleWhile {

	public static void main(String[] args) {
		/*
		 * 打印输出：
		 *    **********
		 *    **********
		 *    **********
		 *    **********
		 *    **********
		 */
		int row = 1;
		while(row <= 5) {
			
			int count = 1;
			while(count<=10) {
				System.out.print("*");
				count++;
			}
			System.out.println();
			row++;
		}
		
		/*
		 * 打印输出：
		 *    **********
		 *     **********
		 *      **********
		 *       **********
		 *        **********
		 */
		row = 1;
		while(row <= 5) {
			// 输出空格
			int b= 1;
			while(b<row) {
				System.out.print(" ");
				b++;
			}
			
			// 输出10个*
			int count = 1;
			while(count<=10) {
				System.out.print("*");
				count++;
			}
			System.out.println();
			row++;
		}
		/*
		 * 输出 99 乘法表
		 */
		
		int i = 1;
		while(i <= 9) {
			
			int j = 1;
			while(j<=i) {
				System.out.print(j + "*" + i + "=" + j*i + "\t");
				j++;
			}
			System.out.println();
			i++;
		}
		
		/*
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		
		int j = 1;
		while(j<=5) {
			
			int k = 1;
			while(k<=j){
				System.out.print("*");
				k++;
			}
			
			System.out.println();
			j++;
		}
	}
}
