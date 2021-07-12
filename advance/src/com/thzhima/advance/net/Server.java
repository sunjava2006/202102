package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket s = null;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter bfwriter = null;
		
	    try {
			server = new ServerSocket(9999);
			s = server.accept(); // 监听，获取对方的连接。
			in = s.getInputStream();
			inReader = new InputStreamReader(in, "utf-8");
			reader = new BufferedReader(inReader);
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			bfwriter = new BufferedWriter(outWriter);
			
			String msg = reader.readLine();
			System.out.println(msg);
			
			bfwriter.write("你好。\r\n");
			bfwriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bfwriter != null) {
				bfwriter.close();
			}
			if(null != outWriter) {
				outWriter.close();
			}
			if(null != out) {
				out.close();
			}
			if(reader != null) {
				reader.close();
			}
			if(inReader != null) {
				inReader.close();
			}
			if(in != null) {
				in.close();
			}
			
			if(null != s) {
				s.close();
			}
			
			if(null != server) {
				server.close();
			}
			
		}
	}

}
