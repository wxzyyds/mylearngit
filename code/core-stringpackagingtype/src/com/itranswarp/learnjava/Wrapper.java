package com.itranswarp.learnjava;

public class Wrapper {
	
	public static void mian(String[] args) {
		Integer n = null;
		Integer n2 = new Integer(99);
		int n3 = n2.intValue();
		System.out.println(n);
		System.out.println(n2);
		System.out.println(n3);
	}
/*
 * Java的数据类型分两种：

	基本类型：byte，short，int，long，boolean，float，double，char

	引用类型：所有class和interface类型
 * 
 * 引用类型可以赋值为null，表示空不占用内存空间，但基本类型不能赋值为null：
 */
	String s = null;
//	int n = null; // compile error!
//	如何把一个基本类型视为对象（引用类型）？
//	定义一个Integer类，int私有化，构造器初始化实例字段
	
//	包装类型非常有用，Java核心库为每种基本类型都提供了对应的包装类型：
	
	   // 通过new操作符创建Integer实例(不推荐使用,会有编译警告):
//    Integer n1 = new Integer(i);
	
	/*
	 * 
	 * 包装类
	 * 1.使用equals去比较
	 * 2.按照语义编程，而不是针对特定的底层实现去“优化”。
	 * 3.使用静态实例化方法，去创建新的包装器对象
	 * 4.获取新实例的静态方法就是静态工厂
	 * 5.创建新对象时，优先选用静态工厂方法而不是new操作符。
	 */
//	进制转换Integer
	
	// boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
	Boolean t = Boolean.TRUE;
	Boolean f = Boolean.FALSE;
	// int可表示的最大/最小值:
	int max = Integer.MAX_VALUE; // 2147483647
	int min = Integer.MIN_VALUE; // -2147483648
	// long类型占用的bit和byte数量:
	int sizeOfLong = Long.SIZE; // 64 (bits)
	int bytesOfLong = Long.BYTES; // 8 (bytes)	
	
//	所有的整数和浮点数的包装类型都继承自Number，因此，可以非常方便地直接通过包装类型获取各种基本类型：

	// 向上转型为Number:
	Number num = Integer.getInteger("999");
	// 获取byte, int, long, float, double:
	byte b = num.byteValue();
	int n = num.intValue();
	long ln = num.longValue();
	float f2 = num.floatValue();
	double d = num.doubleValue();
	
}
