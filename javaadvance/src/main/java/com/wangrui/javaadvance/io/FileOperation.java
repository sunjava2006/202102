package com.wangrui.javaadvance.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileOperation {
	
	public static void writeFile(String fileName, String data, String charset, boolean append) throws IOException {
		OutputStreamWriter outWriter = null;
		FileOutputStream out = null;
		BufferedWriter bufWriter = null;
		try {
			
			// 缓冲流  --->  桥接流  ----> 字节流
			out = new FileOutputStream(fileName, append);
			outWriter = new OutputStreamWriter(out, charset); // 为桥接流指定字符编码
			bufWriter = new BufferedWriter(outWriter);
//			outWriter.write(data);
			bufWriter.write(data);
			bufWriter.flush();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			if(null != bufWriter) {
				bufWriter.close();
			}
			if(null != outWriter) {
				outWriter.close();
			}
			if(null != out) {
				out.close();
			}
		}
		
	}
	
	public static String read(String fileName, String charset) throws IOException {
		StringBuffer sb = new StringBuffer();
		InputStreamReader inReader = null;
		FileInputStream in = null;
		BufferedReader bufReader = null;
		
		try {
			
			//  字节流---> 桥接流(指定字符集) ----> 缓冲流
			in = new FileInputStream(fileName); 
			inReader = new InputStreamReader(in, charset);
			bufReader  = new BufferedReader(inReader);
			
			String str = null;
			do {
				str = bufReader.readLine(); // 读完返回null。
				if(str != null) {
					sb.append(str);
				}
			}while(str != null); 
		
		} catch (FileNotFoundException | UnsupportedEncodingException e) {

			e.printStackTrace();
		} finally {
			if(null != bufReader) {
				bufReader.close();
			}
			if(null != inReader) {
				inReader.close();
			}
			if(null != in) {
				in.close();
			}
		}
		
		
		
		
		return sb.toString();
	}
	
	
	public static void writeFile(String fileName, String data, boolean append) throws IOException {
		FileWriter writer = null;
		try {
			// 创建一个文件输出流。append为true就是向文件中添加数据，为false就覆盖原文件。
			writer = new FileWriter(fileName, append); 
			writer.write(data);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != writer) {
				writer.close();
			}
		}
	}
	
	public static String read(String file) throws IOException {
		String data = null;
		
		FileReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new FileReader(file);
			char[] buffer = new char[4];
			int count = -1;
			while(-1 != (count=reader.read(buffer))) {
				sb.append(buffer, 0, count);    // 向sb对象中添加char[]中的数据。
			}
			
			data = sb.toString();  // 将StringBuffer中的数据转换为String
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != reader) {
				reader.close();
			}
		}
		
		return data;
	}
	
	

	public static void writeFile(String fileName, byte[] data) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName, false);// ====>file
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
