package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException  {
		Socket s = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter bfwriter = null;
		
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		try {
			InetAddress address = InetAddress.getByAddress(new byte[] {127,0,0,1});
			InetSocketAddress socketAddress = new InetSocketAddress(address, 9999);
			s =  new Socket();
			s.connect(socketAddress, 1200);
			
			in = s.getInputStream();
			inReader = new InputStreamReader(in, "utf-8");
			reader = new BufferedReader(inReader);
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			bfwriter = new BufferedWriter(outWriter);
			
			bfwriter.write("hello");
			bfwriter.newLine();
			bfwriter.flush();
			
			String msg = reader.readLine();
			System.out.println("返回的消息："+msg);
			
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
		}
		
	}
}
