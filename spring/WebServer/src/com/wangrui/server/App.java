package com.wangrui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

	public static void main(String[] args) throws IOException {
		
		//   http应用层协议
		//   tcp/ip 网络通信
		
		ServerSocket ss = null;// 服务端Socket就是监听请求的Socket。
		Socket s = null; // 表示一个通信连接
		InputStream in = null; // 字节输入流
		InputStreamReader inReader = null;
		BufferedReader bfReader = null;
		OutputStream out = null;
		try {
			ss = new ServerSocket(9999); // 创建在9999端口进行监听监听Socket。
			s = ss.accept(); // 监听并接受一个连接请求
			in = s.getInputStream(); // 从连接中获取输入流
			inReader = new InputStreamReader(in);
			bfReader = new BufferedReader(inReader);
			
			
//			String str = "";
//			int countHead = 0;
//			do {
//				str = bfReader.readLine();
//				System.out.println(str);
//				
//				if("".equals(str)) {
//					countHead++;
//				}
//			}while(true);
			System.out.println(in.available());
			byte[] data = new byte[1024*1024];
			int count = in.read(data);
			String str = new String(data, 0, count);
			System.out.println(str);
			
			//==============================================
			out = s.getOutputStream();
			out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes("utf-8"));
			out.write("Content-Type: application/json;charset=utf-8\r\n\r\n".getBytes("utf-8"));
			out.write("{\"name\":\"wang\"}\r\n\r\n".getBytes("utf-8"));
			out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close();
			}
			if(null != bfReader) {
				bfReader.close();
			}
			if(null != inReader) {
				inReader.close();
			}
			if(null != in) {
				in.close();
			}
			if(null != s) {
				s.close();
			}
			if(null != ss) {
				ss.close();
			}
		}
		
	}
}
