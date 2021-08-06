package com.wangrui.javaadvance.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket socket = null;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader bufReader = null;

		try {
			server = new ServerSocket(9090);// 在9090端口创建监听服务
			System.out.println("--------accept----------");

			while (true) {
				socket = server.accept(); // 监听

				System.out.println(" socket at server isConnected: " + socket.isConnected());

				// ---------------------- 从socket中获取IO流 -----------------------------
				in = socket.getInputStream();
				inReader = new InputStreamReader(in, "utf-8");
				bufReader = new BufferedReader(inReader);

				// =====================读出数据=====================
				String str = null;
				while (true) {
					str = bufReader.readLine();
					
					System.out.println(str + ":" + str.length());
					if ("over".equals(str)) {
						break;
					}
				}
				if (null != bufReader) {
					bufReader.close();
				}
				if (null != inReader) {
					inReader.close();
				}
				if (null != in) {
					in.close();
				}

				if (null != socket) {
					socket.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (null != server) {
				server.close();
			}
		}
	}
}
