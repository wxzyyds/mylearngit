package com.itranswarp.learnjava;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * @author wxz 
 * 
 * Reader是字符流char的输入接口，用于读取文件
 * Write是字符流char的输出接口，用于写入文件
 */
public class ReadAndWriteTest {

	/*
	 *	
	 * InputStream							Reader
	 * 字节流，以byte为单位					字符流，以char为单位
	 * 读取字节（-1，0~255）：int read()		读取字符（-1，0~65535）：int read()
	 * 读到字节数组：int read(byte[] b)		读到字符数组：int read(char[] c)
	 */

	public static void main(String[] args) throws IOException {
//		FileReader是Reader的一个子类，
//一个个读取字符
		FileReader fileReader = new FileReader("src/readme.txt", StandardCharsets.UTF_8);//指定编码格式
		try (fileReader) {
		    // TODO
			for (;;) {
				int n = fileReader.read(); // 反复调用read()方法，直到返回-1
				if (n == -1) {
					break;
				}
				System.out.print((char)n); // 打印char
			}
//		设置缓冲区一次性读取多个char数组，
			
			try (fileReader) {
				char[] buffer = new char[1000];
				int n;
				while ((n = fileReader.read(buffer)) != -1) {
					System.out.println("read " + n + " chars.");
				}
		    }
		} //默认 关闭流

	        
//	        CharArrayReader在内存中模拟一个Reader，将一个char【】数组变为Reader，ByteArrayInputStream功能一样
	        try (Reader reader = new CharArrayReader("Hello".toCharArray())) {
	        	int n1;
		        while ((n1 = reader.read()) != -1) {
		            System.out.println("read " + n1 + " chars.");
		        }
	        }
//	StringReader,直接将string作为数据源，
	        try (Reader reader = new StringReader("Hello")) {
	        	int n1;
		        while ((n1 = reader.read()) != -1) {
		            System.out.println("read " + n1 + " chars.");
		        }
	        }
	        
//InputStreamReader是一个转换器，把任何InputStream转换为Reader
	     // 持有InputStream:
	        InputStream input = new FileInputStream("src/readme.txt");
	        Reader reader = new InputStreamReader(input, "UTF-8");
	        try ( reader) {
	        	int n1;
		        while ((n1 = reader.read()) != -1) {
		            System.out.print((char)n1 );
		        }
	        }
	        /**
	         * Reader是带编码转换器的InputStream，
	         * byte转换为char，
	         * Writer就是带编码转换器的OutputStream，
	         * 把char转换为byte并输出。
	         */
	        
//	        OutputStream								Writer
//	        字节流，以byte为单位							字符流，以char为单位
//	        写入字节（0~255）：void write(int b)			写入字符（0~65535）：void write(int c)
	        try(Writer write = new FileWriter("src/readme.txt", StandardCharsets.UTF_8)){
											        	write.write('H'); // 写入单个字符
//	        写入字节数组：void write(byte[] b)			写入字符数组：void write(char[] c)
											        	write.write("Hello".toCharArray()); // 写入char[]
//	        无对应方法									写入String：void write(String s)
											        	write.write("world"); // 写入String
	        }
	        
// CharArrayWriter可以在内存中创建一个Writer，它的作用实际上是构造一个缓冲区，可以写入char，最后得到写入的char[]数组，这和ByteArrayOutputStream
	
	        try(Writer write = new CharArrayWriter()){
	        	write.write(65);
	        	write.write(66);
	        	write.write(67);
	        	char[] data = ((CharArrayWriter) write).toCharArray(); // { 'A', 'B', 'C' }
	        	System.out.println(data);
	        }
	        
//	        StringWriter类似CharArrayWriter在内存中创建一个Writer，写入字符串stringWriter在内部维护了一个StringBuffer
	        
	        try(Writer write = new StringWriter()){
	        	write.write("aaaaaaaaaaaaaaaaaaaa");
	        	write.write("cccccccccccccc");
	        	write.write("ddddddddddddddddddd");
	        	String data = write.toString(); 
	        	System.out.println(data);
	        }
	        
//	        OutputStreamWriter就是一个将任意的OutputStream转换为Writer的转换器
//	        没文件自动创建文件
	        
	        try (Writer writer = new OutputStreamWriter(new FileOutputStream("copy.txt"), "UTF-8")) {
	            // TODO:字节流转化为字符输出流
	        	writer.append("你").append("是").append("hellokitty");
	        	
	        }
	}
	

	

}
