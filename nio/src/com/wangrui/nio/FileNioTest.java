package com.wangrui.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileNioTest {
	
	
	public static void finoutChanel() throws IOException {
		long start = System.currentTimeMillis();
		
		FileInputStream fin = null;
		FileOutputStream fout = null;
		FileChannel finChannel = null;
		FileChannel foutChannel = null;
		try {
//			fin = new FileInputStream("d:/没骨.mp4");
//			fout = new FileOutputStream("d:/2.mp4");
			
			
			finChannel = FileChannel.open(Paths.get("d:/没骨.mp4"), StandardOpenOption.READ) ;//fin.getChannel();
			foutChannel = FileChannel.open(Paths.get("d:/22.mp4"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);//fout.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			System.out.println(buffer.isDirect());
			
			while(finChannel.read(buffer) != -1) {
				buffer.flip();
				foutChannel.write(buffer);
				buffer.clear();
			}
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(foutChannel != null) {
				foutChannel.close();
			}
			if(finChannel != null) {
				finChannel.close();
			}
			if(fout != null) {
				fout.close();
			}
			if(fin != null) {
				fin.close();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("非直接字节缓冲区，用时：" + (end-start));
	}

	
	public static void memoMapChannel() throws IOException {
		long start = System.currentTimeMillis();
		
		Path sourcePath = Paths.get("d:/没骨.mp4");
		Path targetPath = Paths.get("d:/3.mp4");
		FileChannel finChannel = null;
		FileChannel foutChannel = null;
		try {
			finChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
			foutChannel = FileChannel.open(targetPath, StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);
			
			MappedByteBuffer inbuffer = finChannel.map(MapMode.READ_ONLY, 0, finChannel.size());
			MappedByteBuffer outbuffer = foutChannel.map(MapMode.READ_WRITE, 0, finChannel.size());
			
			byte[] dst = new byte[inbuffer.capacity()];
			inbuffer.get(dst);
			outbuffer.put(dst);
			
			System.out.println(inbuffer.isDirect());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != foutChannel) {
				foutChannel.close();
			}
			if(null != finChannel) {
				finChannel.close();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("直接字节缓冲区，用时：" + (end-start));
	}
	
	
	public static void channelTransfor() throws IOException {
		long start = System.currentTimeMillis();
		FileChannel finChannel = null;
		FileChannel foutChannel = null;
		try {
			finChannel = FileChannel.open(Paths.get("d:/没骨.mp4"), StandardOpenOption.READ);
			foutChannel = FileChannel.open(Paths.get("d:/4.mp4"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			
			finChannel.transferTo(0, finChannel.size(), foutChannel);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != foutChannel) {
				foutChannel.close();
			}
			if(null != finChannel) {
				finChannel.close();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("直接字节缓冲区 transferTo，用时：" + (end-start));
	}
	
	
	public static void scatterAndGather() throws IOException {
		RandomAccessFile rafReader = null;
		RandomAccessFile rafWriter = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			rafReader = new RandomAccessFile("d:/没骨.mp4", "r");
			rafWriter = new RandomAccessFile("d:/5.mp4", "rw");
			
			inChannel = rafReader.getChannel();
			outChannel = rafWriter.getChannel();
			
			double size = inChannel.size();
			System.out.println(size);
			
			int arrayLength = 1024*1024*10;
			
			ByteBuffer[] buffers = new ByteBuffer[2];
			for(int i=0; i<2; i++) {
				ByteBuffer  b = ByteBuffer.allocate(arrayLength);
				buffers[i] = b;
				System.out.println(b.capacity()+"," +b.position()+","+b.limit());
			}
			System.out.println("-----------------------------------");


			
			// 分散读取
			long count = -1;
			while(-1 != (count = inChannel.read(buffers))) {
				System.out.println("读出："+count);
				for(ByteBuffer b : buffers) {
					b.flip();
					System.out.println(b.capacity()+"," +b.position()+","+b.limit());
				}
				
				// 合并写入
				long c = outChannel.write(buffers);
				System.out.println("写入："+c);
				for(ByteBuffer b : buffers) {
					b.clear(); // 清除各buffer的状态。以便重新读入数据。
					
				}
			}
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(outChannel != null) {
				outChannel.close();
			}
			if(inChannel != null) {
				inChannel.close();
			}
			if(rafWriter != null)
				rafWriter.close();
			if(rafReader != null)
				rafReader.close();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		finoutChanel();
//		memoMapChannel();
//		channelTransfor();
		
//		scatterAndGather();
		
	}
}
