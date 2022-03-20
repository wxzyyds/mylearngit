package com.itranswarp.learnjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author wxz 
 * PrintStream是一种FilterOutputStream，它在OutputStream的接口上，额外提供了一些写入各种数据类型的方法：
 * 写入int：print(int)
 * 写入boolean：print(boolean)
 * 写入String：print(String)
 * 写入Object：print(Object)，实际上相当于print(object.toString())
 * ...
 * 以及对应的一组println()方法，它会自动加上换行符。
 * 
 */
public class PrintStreamAndWriteTest {

	

	public static void main(String[] args) throws IOException {
		System.out.println();//系统默认提供的PrintStream
		System.out.print(12345); // 输出12345
		System.out.print(new Object()); // 输出类似java.lang.Object@3c7a835a
		System.out.println("Hello"); // 输出Hello并换行
		/*
		 * PrintStream和OutputStream相比，
		 * 添加了一组print()/println()方法，
		 * 打印各种数据类型，
		 * 不会抛出IOException
		 */
//		PrintWriter
		/*
		 * PrintStream最终输出的总是byte数据，
		 * 而PrintWriter则是扩展了Writer接口，
		 * print()/println()方法最终输出的是char数据。
		 * 两者的使用方法几乎是一模一样的：
		 */
		
		 StringWriter buffer = new StringWriter();
	        try (PrintWriter pw = new PrintWriter(buffer)) {
	            pw.println("Hello");
	            pw.println(12345);
	            pw.println(true);
	        }
	        System.out.println(buffer.toString());

	}
	

	

}
