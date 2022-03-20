package com.itranswarp.learnjava;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author wxz
 * queue是一种队列 
 * queue是一种集合，先进先出。类似地铁过安检的操作，即就是添加在队列最后，获取到队列最前。
 * 
 * 
 */
public class QueueTest {
	@SuppressWarnings("unused")
	public static void main(String[] args)  {
	/*
	 * 队列接口Queue定义了以下几个方法：
		int size()：获取队列长度；
		boolean add(E)/boolean offer(E)：添加元素到队尾；
		E remove()/E poll()：获取队首元素并从队列中删除；
		E element()/E peek()：获取队首元素但并不从队列中删除。
	 */
//		对于具体的实现类，有的Queue有最大长度限制，有的没有
//		调用add来添加元素，添加失败抛出异常
		Queue<String> q = new LinkedList<String>();
		try {
		    q.add("Apple");
		    System.out.println("添加成功");
		} catch(IllegalStateException e) {
		    System.out.println("添加失败");
		}
//		调用offer()方法来添加元素，当添加失败时，它不会抛异常，而是返回false：
		
		if(q.offer("Orange")) {
			System.out.println("SUCCESS");
		}else {
			System.out.println("FAILLED");
		}
		
		if(q.offer(null)) {
			System.out.println("SUCCESS");
		}else {
			System.out.println("FAILLED");
		}
//		取出队首元素，remove一个空队列会抛出异常/poll()取队首元素,并删除
		try {
		    String s=q.remove();
		    System.out.println("队首元素获取成功: "+s);
		} catch(IllegalStateException e) {
		    System.out.println("队首元素获取失败: ");
		}
		

		String s=q.poll();
		if(s==null) {
			System.out.println("队首元素获取FAILLED: "+s);
		}else {
			System.out.println("队首元素获取SUCCESS: "+s);
		}
//	取出队首元素不删除，element()会抛出异常/peek()取队首元素
		q.poll();
		q.offer("wxz");
		try {
		    String s2=q.element();
		    System.out.println("队首元素获取成功: "+s2);
		} catch(IllegalStateException e) {
		    System.out.println("队首元素获取失败: ");
		}
		String s1=q.peek();
		if(s1==null) {
			System.out.println("队首元素获取FAILLED: "+s1);
		}else {
			System.out.println("队首元素获取SUCCESS: "+s1);
		}
		
		// 这是一个List:
		@SuppressWarnings("unused")
		List<String> list = new LinkedList<>();
		// 这是一个Queue:
		Queue<String> queue = new LinkedList<>();
		
//		始终按照面向抽象编程的原则编写代码，可以大大提高代码的质量。
	}
}

