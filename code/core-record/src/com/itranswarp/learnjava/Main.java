package com.itranswarp.learnjava;



/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args)   {
		  Point p = new Point(123, 456);
	        System.out.println(p.x());
	        System.out.println(p.y());
	        System.out.println(p);

//	    record java 14后引入的recod 
//	        ，使用record关键字，可以一行写出一个不变类
//	        和enum类似，我们自己不能直接从Record派生，只能通过record关键字由编译器实现继承。
	        Point2 p2 = new Point2(123, 456);
	        System.out.println(p2.x());
	        System.out.println(p2.y());
	        System.out.println(p2);
	        
	        Point2 p21 = Point2.of();
	        System.out.println(p21);
	}


}
