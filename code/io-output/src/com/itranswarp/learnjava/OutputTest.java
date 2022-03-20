package com.itranswarp.learnjava;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author wxz
 * OutputStream就是Java标准库提供的最基本的输出流。字节流,byte整形
 * 它位于java.io这个包里。
 * java.io包提供了所有同步IO的功能。
 * OutputStream并不是一个接口，而是一个抽象类，它是所有输入流的超类
 * 最重要的方法write();
 */
public class OutputTest {

	public static void main(String[] args) throws IOException {
//		读取文件的FileOutputStream对象 OutputStream input = new FileOutputStream();
//		writeFile();
		
		
//		try(io流对象)，对象实现了java.lang.AutoCloseable接口自动写入finally,
//		autoFinally();
		
		
//		更高效率写入文件流，网络流的方式，	使用 .getBytes()方法获取所有字节数组,一次性写入	
//		bufferTest();
		

//		在调用OutputStream的write()方法写入数据时，我们说write()方法是阻塞（Blocking）的
//		大白话，因为执行io程序代码比普通代码慢，且无法确定write执行时间，所以说write时阻塞的
//		blockingTest();
		
	
//		输入流outputStream的相关实现类
//		outputStreamImp();
		
		
		
//		try(操纵多个实现了AutoCloseable接口的文件对象)
	useAutoCloseableFiles();	
	}
	
	public static void writeFile() throws IOException {
	    // 创建一个FileOutputStream对象:
//		IO流在获取对象的时候，若对象实例不存在，会报IO异常，无读写权限导致写入失败。因此正确处理IOException
		OutputStream output = new FileOutputStream("C:\\Users\\86180\\Desktop\\111.html");
		try {
		
		        output.write("调用write方法写入 ".getBytes("UTF-8")); // 调用write方法写入
		        output.flush();//强制输出缓冲区内容到输出管道
//		       OutputStream还提供了一个flush()方法，它的目的是将缓冲区的内容真正输出到目的地。
		        output.write("flush()强制输出缓冲区内容到输出到目的地 ".getBytes());
		        
		        output.write("bye ".getBytes());
		  
		  
		} finally {
			// TODO: handle finally clause
			if (output != null) { output.close(); } // 关闭流，释放读取占用的内存资源，使用try finally 保证当IO处理异常后正确关闭
		}

		
		
	}
	
	public static void autoFinally() throws IOException {
		OutputStream output = new FileOutputStream("C:\\\\Users\\\\86180\\\\Desktop\\\\111.html");
//		使用try{}finally{}比较复杂，java 7引入了新的try(resource)语法，让编译器自动写入finally来从容释放资源
		try(output){
			output.write("try(io流对象)，对象实现了java.lang.AutoCloseable接口自动写入finally,".getBytes());
		}// 编译器在此自动为我们写入finally并调用close()
//		编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口
//		如果实现了，就自动加上finally语句并调用close()方法。
//		InputStream和OutputStream都实现了这个接口，因此，都可以用在try(resource)中。
		
	}
	public static void bufferTest() throws IOException {
//		在写出流的时候，
//		最高效的方法：
//		一次性读取多个字节到缓冲区，
//		对于文件和网络流来说，
//		利用缓冲区一次性写入多个字节效率往往要高很多。
//		InputStream提供了两个重载方法来支持读取多个字节：
//		public int read(byte b[]) 读取若干字节并填充到byte[]数组，返回读取的字节数
//		public int read(byte b[], int off, int len) 指定byte[]数组的偏移量和最大填充数,返回读取的字节数
		OutputStream output = new FileOutputStream("C:\\Users\\86180\\Desktop\\111.html");
		//		使用 .getBytes()方法获取所有字节数组
		try(output){
			output.write("每次写入一个字节非常麻烦，更常见的方法是一次性写入若干字节。这时，可以用OutputStream提供的重载方法void write(byte[])来实现：".getBytes());		
		}
	}

	public static void blockingTest() throws IOException {
		/*
		 * 在调用OutputStream的write()方法写入数据时，
		 * 我们说write()方法是阻塞（Blocking）的。
		 */
		OutputStream output = new FileOutputStream("C:\\\\Users\\\\86180\\\\Desktop\\\\111.html");
		
		try(output){
			output.write("JavaProject".getBytes());//同理OutputStream的write()方法是阻塞的
			  
		}
	}
	
	public static void outputStreamImp() throws IOException {
		/*
		 * FileOutputStream 建立内存到文件的输出流output
		 * 
		 * ByteArrayOutputStream 在内存中模拟一个缓存输出流output
		 * 
		 * 
		 */
		  byte[] data;
		  ByteArrayOutputStream  output = new  ByteArrayOutputStream();
        try (output) {
        	output.write("ByteArrayOutputStream 在内存中模拟一个缓存输出流output".getBytes());
        	data = output.toByteArray();
            }
        System.out.println(new String(data,"UTF-8"));
        }
	public static void useAutoCloseableFiles() throws FileNotFoundException, IOException {
//	同时操作多个AutoCloseable资源时，在try(resource) { ... }语句中可以同时写出多个资源，用;隔开。例如，同时读写两个文件：
		// 读取input.txt，写入output.txt:
		try (InputStream input = new FileInputStream("C:\\Users\\86180\\Desktop\\微信图片_20210828235943.jpg");
		     OutputStream output = new FileOutputStream("C:\\Users\\86180\\Desktop\\111.html"))
		{
		    input.transferTo(output); // transferTo的作用是?将输入流转到输出流
		}
	}
	}
	

