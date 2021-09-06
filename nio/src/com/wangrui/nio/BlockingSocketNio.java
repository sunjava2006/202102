package com.wangrui.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class BlockingSocketNio {
	
	
	
	@Test
	public void atestCharsetEncoder() throws CharacterCodingException {
		Charset charset = Charset.forName("utf-8");
		System.out.println(charset.name());
		
		CharsetEncoder encoder = charset.newEncoder();
		CharsetDecoder decoder = charset.newDecoder();
		
		CharBuffer inCharBuffer = CharBuffer.allocate(1024);
		inCharBuffer.put("大家好");
		inCharBuffer.flip();
		
		ByteBuffer byteBuffer = encoder.encode(inCharBuffer);
		System.out.println(byteBuffer.limit());
		
		CharBuffer outCharBuffer = decoder.decode(byteBuffer);

		System.out.println(outCharBuffer.limit());
		char[] data = new char[outCharBuffer.limit()];
		outCharBuffer.get(data);
		System.out.println(new String(data));

		
	}
	
	@Test
	public void bServer() throws IOException{
		System.out.println("=-----------server start-------------------");
		ServerSocketChannel ssChannel = null;
		SocketChannel schannel = null;
		try {
			ssChannel = ServerSocketChannel.open();
			ssChannel.bind(new InetSocketAddress(9999));
			schannel = ssChannel.accept();
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
		    schannel.read(buffer);
		    Charset charset = Charset.forName("utf-8");
		    buffer.flip();
		    CharBuffer data = charset.newDecoder().decode(buffer);
		    
		    char[] dst = new char[data.limit()];
		    data.get(dst);
		    System.out.println(new String(dst));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != schannel) {
				schannel.close();
			}
			if(null != ssChannel) {
				ssChannel.close();
			}
		}
	}

	@Test
	public void client() throws IOException {
		System.out.println("--------client start-----------");
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open(new InetSocketAddress(9999));
			Charset charset = Charset.forName("utf-8");
			CharsetEncoder encoder = charset.newEncoder();
			
			CharBuffer inCharBuffer = CharBuffer.allocate(1024);
			inCharBuffer.put("大家好");
			inCharBuffer.flip();
			
			ByteBuffer data = encoder.encode(inCharBuffer);
			
			socketChannel.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socketChannel.close();
		}
	}
}
