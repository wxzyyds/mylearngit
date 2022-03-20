package com.itranswarp.learnjava;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
/*
 * 在计算机程序运行的过程中，总是会出现各种各样的错误。
 * 
 * 有一些错误是用户造成的
 * 	// 假设用户输入了abc：
		String s = "abc";
		int n = Integer.parseInt(s); // NumberFormatException!
		
		读写某个文件的内容，但是用户已经把它删除了：
		// 用户删除了该文件：
String t = readFile("C:\\abc.txt"); // FileNotFoundException!
 * 有一些错误是随机出现，并且永远不可能避免的。比如：

网络突然断了，连接不到远程服务器；
内存耗尽，程序崩溃了；
用户点“打印”，但根本没有打印机；
 */
	public static void main(String[] args) throws FileNotFoundException {
		
//		一个健壮的程序必须处理各种各样的错误。
		String s = "abc";
//		错误，就是程序调用某个函数的时候，如果失败了，就表示出错.
//		int n = Integer.parseInt(s); // NumberFormatException!
		
//		调用方如何获知调用失败的信息？有两种方法：

//方法一：约定返回错误码。

//例如，处理一个文件，如果返回0，表示成功，返回其他整数，表示约定的错误码：
//	使用int类型的错误码，想要处理就非常麻烦。这种方式常见于底层C函数。	
		int code = processFile("C:\\test.txt");
		if (code == 0) {
		    // ok:
		} else {
		    // error:
		    switch (code) {
		    case 1:
		        // file not found:
		    case 2:
		        // no read permission:
		    default:
		        // unknown error:
		    }
		}
	}

	

//	static int stringToInt(String s) {
//		return Integer.parseInt(s);
//	}
	
//	方法二：在语言层面上提供一个异常处理机制。
//	Java内置了一套异常处理机制，总是使用异常来表示错误。
//	异常是一种class，因此它本身带有类型信息。异常可以在任何地方抛出，但只需要在上层捕获，这样就和方法调用分离了
	private static int processFile(String string) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try {
			int s = processFile("C:\\test.txt");
			// ok:
		} catch (SecurityException e) {
			// no read permission:
		} catch (IOException e) {
			// io error:
		} catch (Exception e) {
			// other error:
		}
		return 0;
	}
}
