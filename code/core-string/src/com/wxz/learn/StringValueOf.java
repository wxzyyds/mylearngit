package com.wxz.learn;

public class StringValueOf {

//	类型转换
//	字符串提供了valueOf静态方法，类名.静态方法
//	这是一个重载方法，编译器会根据参数自动选择合适的方法：
//	传入Object任意对象,基本类型和引用类型转为字符串
	public static void main(String[] args) {
		/*
		 *  %s：显示字符串；
			%d：显示整数；
			%x：显示十六进制整数；
			%f：显示浮点数。
		 */
	String s = "Hi %s, your score is %d!";
	System.out.println(String.valueOf(s));		
	String.valueOf(123); // "123"
	String.valueOf(45.67); // "45.67"
	String.valueOf(true); // "true"
	String.valueOf(new Object()); // 类似java.lang.Object@636be97c
	System.out.println(String.valueOf(true)+String.valueOf(new Object())+String.valueOf(45.67)+String.valueOf(123));
//	要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为int类型：
//	Integer.parseInt将英文、数字字符串转化为int类型，否则报NumberFormatException
	int n1 = Integer.parseInt("123");
	int n2 = Integer.parseInt("ff",16);
//	假设String参数是一个系统属性数值的名称，会读取该系统属性，然后把系统属性的值转换成一个数字。
//	n1 = Integer.getInteger("System").intValue();
	System.out.println(n1);
//	 Integer.valueOf参数必须合法不然抛出异常
	n1 =    Integer.valueOf("123156");
//	Integer包装器拆箱为int s转为Integer ->n1 int
	System.out.println(n1+"：8进制转换："+n2);
	/*
	 * int parseInt(String s) throws NumberFormatException
	 */
//	把字符串转换为boolean类型： Boolean.parseBoolean,为true不缺分大小写返回true，否则返回false
	boolean b1 = Boolean.parseBoolean("true"); // true
	boolean b2 = Boolean.parseBoolean("False"); // false
	System.out.println(b1+""+b2);
	b1 = Boolean.valueOf(s);
//	Boolean包装器拆箱为boolean,s转为 Boolean ->b1 boolean
//	当包装器返回对象为包装器类型，则指定基本类型会拆箱
	}
}
