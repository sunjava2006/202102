package com.wangrui.javaadvance.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	
	public static String stdIn() throws IOException {
		System.out.println("输入信息：");
		String s = "good";
		InputStreamReader inReader = null;
		BufferedReader bufReader = null;
		
		try {
			inReader = new InputStreamReader(System.in);
			bufReader = new BufferedReader(inReader);
			s = bufReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if(null != bufReader) {
//				bufReader.close();
//			}
//			if(null != inReader) {
//				inReader.close();
//			}
		}
		
		return s;
	}
	
	
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter bufWriter = null;
		try {
			byte[] ip = new byte[] {127,0,0,1};
			InetAddress address = InetAddress.getByAddress(ip);
			InetSocketAddress serverAddress = new InetSocketAddress(address, 9090);
			
			socket = new Socket(); // 连接服务端
			socket.connect(serverAddress, 3000);
			System.out.println(" isConnected: " + socket.isConnected());
			
			//---------------------- 从socket中获取IO流 -----------------------------
			out = socket.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			bufWriter = new BufferedWriter(outWriter);
			
			//--------------------发送-------------------
			String msg = "";
			while(true) {
				msg = Client.stdIn();
				System.out.println(msg+":"+msg.length());
				bufWriter.write(msg+"\n");
			    bufWriter.flush();
			    if("over".equals(msg)) {
			    	break;
			    }
			}
			
			
		} catch (Exception e) {
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
			if(null != socket) {
				socket.close();
			}
		}
		
		
		
		
	}
}
