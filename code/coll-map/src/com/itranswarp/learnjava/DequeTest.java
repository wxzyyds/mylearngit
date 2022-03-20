package com.itranswarp.learnjava;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author wxz
 * 两头进，两头出叫双端队列（Double Ended Queue），Deque
 * 功能：
 * 既可以添加到队尾，也可添加到队首。
 * 既可以获取到队尾，也可以获取到队首。
 * 
 * 
 */
public class DequeTest {

	public static void main(String[] args)  {

//		Queue提供的add()/offer()方法在Deque中也可以使用，但是，使用Deque，最好不要调用offer()，而是调用offerLast()
		  Deque<String> deque = new LinkedList<>();
	        deque.offerLast("A"); // A
	        deque.offerLast("B"); // A <- B
	        deque.offerFirst("C"); // C <- A <- B
	        System.out.println(deque.pollFirst()); // C, 剩下A <- B
	        System.out.println(deque.pollLast()); // B, 剩下A
	        System.out.println(deque.pollFirst()); // A
	        System.out.println(deque.pollFirst()); // null
	        
	        /*
	         * 发现LinkedList真是一个全能选手，
	         * 它即是List，又是Queue，还是Deque。
	         * 但是我们在使用的时候，总是用特定的接口来引用它，
	         * 这是因为持有接口说明代码的抽象层次更高，
	         * 而且接口本身定义的方法代表了特定的用途。
	         */
	     // 推荐的写法：面向抽象编程
	        Deque<String> d2 = new LinkedList<>();
	        d2.offerLast("z");
	}
}
 
