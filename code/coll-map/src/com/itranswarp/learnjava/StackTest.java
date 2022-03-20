package com.itranswarp.learnjava;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author wxz
 * 栈（Stack）是一种后进先出（LIFO：Last In First Out）的数据结构。
 * 比如沙漏，最后进去的沙子，最后出来
 * 
 * （LIFO：Last In First Out）
 * 实际JVM处理java方法的时候，就是使用Stack这种数据结构来维护方法调用层次
 */
public class StackTest {

	public static void main(String[] args)  {
//		Stack是这样一种数据结构：只能不断地往Stack中压入（push）元素，最后进去的必须最早弹出（pop）来：
		/*
		 * Stack只有入栈和出栈的操作：
 */
		
//		java集合类没有Stack类，但是可以使用Deque来模拟一个”Stack“，只调用push()/pop()/peek()方法
		
//			把元素压栈：push(E)；
//			把栈顶的元素“弹出”：pop()；
//			取栈顶元素但不弹出：peek()。
		;
		 System.out.println( binaryConversion(120, 6));
	}

//		准备带转换的整数x和转换进制y
	static String binaryConversion(int x,int y) {
//		求商a
		int a = x/y;
//		取余
		int b = x%y;
//		注意只调用push()/pop()/peek()方法		
		Deque<Integer> stackPress = new LinkedList<Integer>();
		if(a>0) {
			stackPress.push(b);
			binaryConversion(a,y);		
		}
		String str = "";
		while(stackPress.peek()!= null) {
			str+=stackPress.peek()+"";
			stackPress.pop();
		}
	    return str;
	}

	
}
 
