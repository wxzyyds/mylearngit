package com.itranswarp.learnjava;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	static final Log log = LogFactory.getLog(Main.class);
/*
 * 反射就是Reflection，Java的反射是指
 * 程序在运行期可以
 * 拿到一个对象的所有信息。
 */
	public static void main(String[] args) throws Exception{
		Class cls = String.class; // 获取到String的Class
		
		String s = "";
		Class cls2 = s.getClass(); // s是String，因此获取到String的Class
		System.out.println(s);
	    
		Class cls3 = Class.forName("java.lang.String");
//		以上三种方法获取的是同一个实例
//		cls.getSuperclass()可以获取父类实例
		Class superCls = cls.getSuperclass();
		System.out.println(superCls);
		Class superO = superCls.getSuperclass();
		System.out.println(superO);
		
		 Class i = Integer.class;
	        Class n = i.getSuperclass();
	        System.out.println(n);
	        Class o = n.getSuperclass();
	        System.out.println(o);
	        System.out.println(o.getSuperclass());
/*
 * 获取interface
由于一个类可能实现一个或多个接口，
通过Class我们就可以查询到实现的接口类型。
例如，查询Integer实现的接口：	    
 */
	   ;
	    for (Class cls1 :  i.getInterfaces()) {
			System.out.println(cls1);
//			interface java.lang.Comparable
//			interface java.lang.constant.Constable
//			interface java.lang.constant.ConstantDesc
//			如果一个类没有实现任何interface，那么getInterfaces()返回空数组。
		}
	    /*
	     * 继承关系
当我们判断一个实例是否是某个类型时，正常情况下，使用instanceof操作符：
	     */
//	    根据实例对象 通过instanceof是否和莫种类型是is-a关系
	    Object n1 = Integer.valueOf(123);
	    boolean isDouble = n1 instanceof Double; // false
	    boolean isInteger = n1 instanceof Integer; // true
	    boolean isNumber = n1 instanceof Number; // true
	    boolean isSerializable = n1 instanceof java.io.Serializable; // true
	    System.out.println(isDouble);
	    System.out.println(isInteger);
	    System.out.println(isNumber);
	    System.out.println(isSerializable);
	    
	 // Integer i = ? isAssignableFrom方法判断该类型是否可以转型
	   log.info(Integer.class.isAssignableFrom(Integer.class));  // true，因为Integer可以赋值给Integer
	    // Number n = ?
	   log.info( Number.class.isAssignableFrom(Integer.class)); // true，因为Integer可以赋值给Number
	    // Object o = ?
	   log.info( Object.class.isAssignableFrom(Integer.class)); // true，因为Integer可以赋值给Object
	    // Integer i = ?
	   log.info( Integer.class.isAssignableFrom(Number.class)); // false，因为Number不能赋值给Integer
	}
}
