package com.itranswarp.learnjava;

import java.util.List;

//泛型的继承关系：Pair<Integer>不是Pair<Number>的子类
//<? super T>允许调用写方法T set(T)获取T的引用，但不允许调读写方法get()获取T的引用（获取Object除外）；
public class GenericSuper {

//	格式：Pair<? super Integer> p，即当调用方法传入参数有Number，有Integer
	
	
//	需要泛型类型set使用super通配符，而不能get
	
	
//	PECS原则
	
//	PECS原则：Producer Extends Consumer Super。
//	操作更为安全，并由编译器强制检查来实现的

//	即：如果需要返回T，它是生产者（Producer），要使用extends通配符；如果需要写入T，它是消费者（Consumer），要使用super通配符。
//例如以下例子，为java中Collection的copy方法	
	public class Collections {
	    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
	        for (int i=0; i<src.size(); i++) {
	            T t = src.get(i); // src是producer
	            dest.add(t); // dest是consumer
	        }
	    }
	}
	
//	无限定通配符
//	<? extends T>和<? super T>作为方法参数的作用。
//	实际上，Java的泛型还允许使用无限定通配符（Unbounded Wildcard Type），即只定义一个?
	void sample(Pair3<?> p) {
//		不允许调用set(T)方法并传入引用（null除外）；
//		不允许调用T get()方法并获取T引用（只能获取Object引用）
	}
	
	
//	那只能做一些null判断：

static boolean isNull(Pair3<?> p) {
    return p.getFirst() == null || p.getLast() == null;
}

//大多数情况下，可以引入泛型参数<T>消除<?>通配符：

static <T> boolean isNull2(Pair3<T> p) {
    return p.getFirst() == null || p.getLast() == null;
    
}
//    <?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类：
public static void main(String[] args) {
	Pair3<Integer> p = new Pair3<>(123, 456);
	Pair3<?> p2 = p; // 安全地向上转型
	System.out.println(p2.getFirst() + ", " + p2.getLast());
}
}
