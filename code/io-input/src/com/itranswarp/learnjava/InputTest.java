package com.itranswarp.learnjava;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wxz
 * InputStream就是Java标准库提供的最基本的输入流。字节流,byte整形
 * 它位于java.io这个包里。
 * java.io包提供了所有同步IO的功能。
 * InputStream并不是一个接口，而是一个抽象类，它是所有输入流的超类
 */
public class InputTest {

	public static void main(String[] args) throws IOException {
//		读取文件的FileInpuitStream对象 InputStream input = new FileInputStream();
//		readFile();
		
		
//		try(io流对象)，对象实现了java.lang.AutoCloseable接口自动写入finally,
//		autoFinally();
		
		
//		更高效率读取文件流，网络流的方式，read(byte [] b)，read(byte b[], int off, int len)指定byte缓冲区，返回读取字节数		
//		bufferTest();
		

//		在调用InputStream的read()方法读取数据时，我们说read()方法是阻塞（Blocking）的
//		大白话，因为执行io程序代码比普通代码慢，且无法确定read执行时间，所以说read时阻塞的
//		blockingTest();
		
	
//		输入流inputStream的相关实现类
		inputStreamImp();
		
		
	}
	
	public static void readFile() throws IOException {
	    // 创建一个FileInputStream对象:
//		IO流在获取对象的时候，若对象实例不存在，会报IO异常，无读写权限导致写入失败。因此正确处理IOException
		InputStream input = new FileInputStream("F:\\JavaProject\\liaoxuefengjava\\io-file\\bin\\com\\itranswarp\\learnjava\\Main.class");
		try {
			for (;;) {
		        int n = input.read(); // 反复调用read()方法，直到返回-1
		        if (n == -1) {
		            break;
		        }
		        System.out.println(n); // 打印byte的值
		    }
		} finally {
			// TODO: handle finally clause
			if (input != null) { input.close(); } // 关闭流，释放读取占用的内存资源，使用try finally 保证当IO处理异常后正确关闭
		}

		
		
	}
	
	public static void autoFinally() throws IOException {
		InputStream input = new FileInputStream("F:\\JavaProject\\liaoxuefengjava\\io-file\\bin\\com\\itranswarp\\learnjava\\Main.class");
//		使用try{}finally{}比较复杂，java 7引入了新的try(resource)语法，让编译器自动写入finally来从容释放资源
		try(input){
			 int n;
		        while ((n = input.read()) != -1) {
		            System.out.println(n);
		        }
		}// 编译器在此自动为我们写入finally并调用close()
//		编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口
//		如果实现了，就自动加上finally语句并调用close()方法。
//		InputStream和OutputStream都实现了这个接口，因此，都可以用在try(resource)中。
		
	}
	
	public static void bufferTest() throws IOException {
//		在读取流的时候，
//		最高效的方法：
//		一次性读取多个字节到缓冲区，
//		对于文件和网络流来说，
//		利用缓冲区一次性读取多个字节效率往往要高很多。
//		InputStream提供了两个重载方法来支持读取多个字节：
//		public int read(byte b[]) 读取若干字节并填充到byte[]数组，返回读取的字节数
//		public int read(byte b[], int off, int len) 指定byte[]数组的偏移量和最大填充数,返回读取的字节数
		InputStream input = new FileInputStream("F:\\JavaProject\\liaoxuefengjava\\io-file\\bin\\com\\itranswarp\\learnjava\\Main.class");
//		先定义缓冲区
		try(input){
			byte b[] =new byte [3000];
			int n;
			while ((n = input.read(b)) != -1) { // 读取到缓冲区
				System.out.println("read " + n + " bytes.");
			}			
		}
	}
	
	public static void blockingTest() throws IOException {
		/*
		 * 在调用InputStream的read()方法读取数据时，
		 * 我们说read()方法是阻塞（Blocking）的。
		 */
		InputStream input = new FileInputStream("F:\\JavaProject\\liaoxuefengjava\\io-file\\bin\\com\\itranswarp\\learnjava\\Main.class");
		try(input){
			byte b[] =new byte [3000];
			int n;
			while ((n = input.read(b)) != -1) { // 当读取(到缓冲区)的时候，必须等待read()方法返回才能执行下一行代码
				System.out.println("read " + n + " bytes.");
			}			
		}
	}
	
	public static void inputStreamImp() throws IOException {
		/*
		 * FileInputStream 从文件获取输入流input
		 * 
		 * ByteArrayInputStream 在内存中模拟一个缓存输入流input，应用不多
		 * 
		 * 
		 */
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input = new ByteArrayInputStream(data)) {//模拟构造一个输入流，并read读取
            int n;
            while ((n = input.read()) != -1) {//read读取输入流
                System.out.println((char)n);
            }
        }
	}
	

}
