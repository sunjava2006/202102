package com.wangrui.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

import org.junit.Test;

public class NonBlockingSocketNIO {

	@Test
	public void client() throws IOException {
		SocketChannel schannel = null;
		FileChannel inChannel = null;
		try {
			schannel = SocketChannel.open(new InetSocketAddress(9999));
			schannel.configureBlocking(false);
			
			ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
			inChannel = FileChannel.open(Paths.get("d:/没骨.mp4"), StandardOpenOption.READ);
			System.out.println("inChannel.size():"+inChannel.size());
			long  size = 0;			
			while(-1 != inChannel.read(buffer)) {
				buffer.flip();
				System.out.println("发送："+buffer.limit());
				size += buffer.limit();
				schannel.write(buffer);
				buffer.clear();
			}
			schannel.shutdownOutput();
			System.out.println("总发送："+size);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != inChannel) {
				inChannel.close();
			}
			if(null != schannel) {
				schannel.close();
			}
		}
		System.out.println("===============client end=====================");
	}
	
	
	
	@Test
	public void server() throws IOException, InterruptedException {
		ServerSocketChannel sschannel = null;
		try {
			sschannel = ServerSocketChannel.open();
			sschannel.configureBlocking(false);  // 注册为非阻塞的channel。
			sschannel.bind(new InetSocketAddress(9999));
			
			
			Selector selector = Selector.open(); // 选择器
			sschannel.register(selector, SelectionKey.OP_ACCEPT); // serverSocketChannel 向 selector 注册ACCEPT事件
	
			
            while(selector.select()>0) {
            	
            	Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            	
            	while(iter.hasNext()) {
            		
            		SelectionKey sk = iter.next();
            		
            		if(sk.isAcceptable()) {
            			System.out.println("isAcceptable");
            			
                		SocketChannel schannel = sschannel.accept(); // 获取 socketChannel
                		schannel.configureBlocking(false);
                		schannel.register(selector, SelectionKey.OP_READ);
                		System.out.println("--------------------------------------------------注册OP_READ");
                		
                	}
                	else if(sk.isReadable()) {
                		System.out.println("isReadable");
                		ByteBuffer buffer = ByteBuffer.allocate(100);
                	
                		FileChannel outChannel = FileChannel.open(Paths.get("d:/6.mp4"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
                		SocketChannel schannel = (SocketChannel) sk.channel();
                		long size = 0;
                		int count = 0;
                		int length  =0;
                		while(-1 != (length = schannel.read(buffer))) {
                			count++;
                			buffer.flip();
                			byte[] data = new byte[length];
                			System.out.println("接收: " + buffer.position() +", "+ buffer.limit()+", "+buffer.capacity());
                			size+=buffer.limit();
                			buffer.get(data, 0, length);
                			ByteBuffer dst = ByteBuffer.allocate(length);
                			dst.put(data);
                			outChannel.write(dst);
                			buffer.clear();
//                			buffer.compact()
                		}
                		System.out.println("总接收：" + size);
                		outChannel.close();
                		schannel.close();

                		System.out.println("count: "+ count);
                		
                	}
            		
            		iter.remove();
            		System.out.println("iter.remove");
            		
            		Thread.sleep(10000);
            	}
            	
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sschannel.close();
		}
		
		
		
	}
}
