package com.wangrui.javaadvance.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {

	public static void writeFile(String fileName, byte[] data) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);// ====>file
			out.write(data);  // data ====>out ====>file
			out.flush();      // 刷新缓冲区。
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close();  // 释放流资源
			}
			
		}
	}
	
	public static byte[] readFile(String file) throws IOException {
		byte[] buffer = null;
		
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);  // file--->
			int size = in.available(); // 获取流中有还有多少数据可以读取
			System.out.println(Integer.MAX_VALUE);
			buffer = new byte[size];    // 创建缓冲区
			
			in.read(buffer);            // 读出数据  file--->in---->buffer
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
		}
		
		return buffer;
	}
	
	public static void copy(String source, String target) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(target);
			
			byte[] buffer = new byte[1024];
			int count = -1;
			
			while(-1 != (count=in.read(buffer))) { // read
				out.write(buffer, 0, count);       // write
			}
		  
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close();
			}
			if(null != in) {
				in.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
//        byte[] buffer = new byte[3];
		StringBuffer sb = new StringBuffer();
		FileInputStream in = null;
		try {
			in = new FileInputStream("d:/a.txt");  // file--->
			
			System.out.println(Integer.MAX_VALUE);
			
			int data = 0;
			do{
				data = in.read();
				System.out.println(data);
				sb.append((char)data);
			}while(data != -1);
			
//			in.read(buffer);            // 读出数据  file--->in---->buffer
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
		}
		System.out.println(sb.toString());
		
	}
}
