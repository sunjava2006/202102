package com.thzhima.advance.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {

	public static void read(String file) throws IOException {
		FileInputStream in  = null;
		try {
			in = new FileInputStream(file);
			int data = -1;
			do {
				data = in.read();
				if(-1 != data) {
					System.out.println(data + ":"+(char)data);
				}
				
			}while(-1 != data);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
			
		}
	}
	
	public static byte[] read(File f) throws IOException {
		byte[] buffer = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream(f);
			buffer = new byte[in.available()];
			in.read(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
		}
		return buffer;
	}
	
	
	public static void write(String f, byte[] data) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(f);
			out.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close(); // close会刷新缓冲区
			}
		}
	}
	
	public static void find(String f, char c) throws IOException {
		byte[] buffer = new byte[4];
		FileInputStream in = null;
		try {
			in = new FileInputStream(f);
			int count = -1;
			do {
				count = in.read(buffer);
				if(-1 != count) {
					String str = new String(buffer, 0, count, "utf-8");
					System.out.println(str);
					boolean contain = str.contains(c+"");
					if(contain) {
						System.out.println("存在");
						break;
					}
					
				}
			}while(-1 != count);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
		}
	}
	
	public static void copy(String source, String target) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(target);
			byte[] buffer = new byte[1024];
			int count = -1;
			while(-1 != (count=in.read(buffer))) {
				out.write(buffer, 0, count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
			if(null != out) {
				out.close();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		File f = new File("d:/a.txt");
//		byte[] data = FileOperation.read(new File("d:/a.txt"));
//		System.out.println(Arrays.toString(data));
//		String str = new String(data, "utf-8");
//		System.out.println(str);
		
//		FileOperation.find("d:/a.txt", '欢');
		
//		byte[] data = "hello大家好".getBytes("utf-8");
//		FileOperation.write("d:/c.txt", data);
		
		copy("D:\\录频\\2021_1小班\\01_File文件操作.mp4", "d:\\a.mp4");
		
	}
}
