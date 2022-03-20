package com.itranswarp.learnjava;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CatchesTest {

	public static void main(String[] args) throws Exception{
//		多个catch语句只会执行一个
		
//		子类异常必须在父类异常之前捕获
		
//		finally语句
//		无论是否有异常发生，如果我们都希望执行一些语句，例如清理工作，怎么写？

//可以把执行语句写若干遍：正常执行的放到try中，每个catch再写一遍
//		直接使用finally语句来,消除重复代码,finally语句块保证有无错误都会执行
		   try {
		        process1();
		        process2();
		        process3();
//		    } catch (IOException e) {
		        System.out.println("IO error");
//		    } catch (UnsupportedEncodingException e) { // 永远捕获不到
//		        System.out.println("Bad encoding");
		    }
		   finally {
			System.out.println("excute end");
		}
		}
	/*
	 * 某些情况下，可以没有catch，只使用try ... finally结构。例如：

void process(String file) throws IOException {
    try {
        ...
    } finally {
        System.out.println("END");
    }
}
因为方法声明了可能抛出的异常，所以可以不写catch。
	 */

	private static void process3() {
		// TODO Auto-generated method stub
		
	}

	private static void process2() {
		// TODO Auto-generated method stub
		
	}

	private static void process1() {
		// TODO Auto-generated method stub
		
	}
/*
 * 捕获多种异常
如果某些异常的处理逻辑相同，
但是异常本身不存在继承关系，
那么就得编写多条catch子句：

public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (IOException e) {
        System.out.println("Bad input");
    } catch (NumberFormatException e) {
        System.out.println("Bad input");
    } catch (Exception e) {
        System.out.println("Unknown error");
    }
}
因为处理IOException
和NumberFormatException
的代码是相同的，
所以我们可以把它两用|合并到一起：

public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (IOException | NumberFormatException e) { // IOException或NumberFormatException
        System.out.println("Bad input");
    } catch (Exception e) {
        System.out.println("Unknown error");
    }
 */
}
