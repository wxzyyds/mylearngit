package com.itranswarp.learnjava;

import java.lang.reflect.Constructor;

public class ReflectConstructorTest {
	 public static void main(String[] args) throws Exception {
//		 ，Java的反射API提供了Constructor对象
//		 通常使用new操作符创建新的实例：
		 Person p = new Person();
//		 通过反射来创建新的实例，可以调用Class提供的newInstance()方法：

//		  p = Person.class.newInstance();
//		  实际上,Java的反射API提供了Constructor对象,直接get一个Constructor对象,并调用该构造创建对象实例
		  /*
		   * 通过Class实例获取Constructor的方法如下：

			getConstructor(Class...)：获取某个public的Constructor；
			getDeclaredConstructor(Class...)：获取某个Constructor；
			getConstructors()：获取所有public的Constructor；
			getDeclaredConstructors()：获取所有Constructor。
			注意Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态的问题。

			调用非public的Constructor时，必须首先通过setAccessible(true)设置允许访问。setAccessible(true)可能会失败。
		   */
		  
		  Constructor constructor = p.getClass().getConstructor();//获取无参构造
		  
		  constructor = p.getClass().getConstructor(String.class);//获取单参String构造
		  
		  constructor = p.getClass().getConstructor(String.class,String.class);//获取两个参为String构造
		  constructor = p.getClass().getDeclaredConstructor(String.class,String.class);//获取非public两个参为String构造
//		使用newInstance传入构造参数来获取对象实例
		  constructor.newInstance(p);
//		  调用非public的Constructor时，必须首先通过setAccessible(true)设置允许访问。setAccessible(true)可能会失败。
//		  constructor.setAccessible(true);
		  
		  constructor.newInstance(p);
	 }
	}


	