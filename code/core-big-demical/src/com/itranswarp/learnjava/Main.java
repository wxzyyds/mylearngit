package com.itranswarp.learnjava;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

	public static void main(String[] args){
//		BigDecimal用于表示任意大小的且精度完全正确的浮点数，extends Number不可变类
		
		
		BigDecimal bd = new BigDecimal("123.4567");
//		multiply乘法
		System.out.println(bd.multiply(bd));
//		BigDecimal用scale()表示小数位数，例如：
		System.out.println(bd.scale());//计算小数点后有几位
//		通过BigDecimal的stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal：
		BigDecimal bd2 = new BigDecimal("213213.21000000");
		System.out.println(bd2.scale());
		bd2 = bd2.stripTrailingZeros();//计算小数点后去掉末尾0后的真实位数
		System.out.println(bd2.scale());
		
		BigDecimal bd3 = new BigDecimal("21321321000000");
		System.out.println(bd3.scale());
		bd3 = bd3.stripTrailingZeros();//计算小数点后去掉末尾0后的真实位数
		System.out.println(bd3.scale());//如果sclae返回附属，说明该数是个整数
//		对一个BigDecimal设置它的scale，如果精度比原始值低，那么按照指定的方法进行四舍五入或者直接截断：
		System.out.println(bd2.setScale(4));//返回新的bigdemical对象
		BigDecimal bbc = setScale(new BigDecimal("123.456789"),4,false);//true四舍五入，截断false
		System.out.println(bbc);
		
/*
 * 	对BigDecimal做加、减、乘时，精度不会丢失
 * 但是做除法时，存在无法除尽的情况
 * 这时，就必须指定精度以及如何进行截断：
 */
		BigDecimal bigDecimal = divide(new BigDecimal("123.456"), new BigDecimal("23.456789"),10, true);
		System.out.println(bigDecimal);
//		如果不指定精度，和如何截断
		new BigDecimal("123.456").divide(new BigDecimal("23.456789"),10,RoundingMode.HALF_UP); // 报错：ArithmeticException，算数异常，因为除不尽
//	进行除法运算并且求取余数
		 BigDecimal n = new BigDecimal("12.345");
	        BigDecimal m = new BigDecimal("0.12");
		 BigDecimal[] dr = n.divideAndRemainder(m);
		    System.out.println(dr[0]); // 102
	        System.out.println(dr[1]); // 0.105
/*
 * 调用divideAndRemainder()方法时，
 * 返回的数组包含两个BigDecimal，
 * 分别是商和余数，其中商总是整数，余数不会大于除数。
 * 我们可以利用这个方法判断两个BigDecimal是否是整数倍数
 */
	        BigDecimal n1 = new BigDecimal("12.75");
	        BigDecimal m1 = new BigDecimal("0.15");
	        BigDecimal[] dr1 = n1.divideAndRemainder(m1);
	        if (dr1[1].signum() == 0) {
	            // n是m的整数倍
	        	System.out.println( "n是m的整数倍");
	        }
	        else
	        {
	        	System.out.println( "n不是m的整数倍");
	        }
/*
 * 比较BigDecimal
在比较两个BigDecimal的值是否相等时，
要特别注意，使用equals()方法不但要求两个BigDecimal的值相等，
还要求它们的scale()相等：
 */
	        BigDecimal d1 = new BigDecimal("123.456");
	        BigDecimal d2 = new BigDecimal("123.45600");
	        System.out.println(d1.equals(d2)); // false,因为scale不同
	        System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
//	     使用compareTo（）方法来比较两个大小，根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于   
	        System.out.println(d1.compareTo(d2)); // 0     
	        
	}

public static BigDecimal setScale(BigDecimal d1,int scale,boolean b) {
	  
      BigDecimal d2 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
      BigDecimal d3 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
    
	return b?d2:d3;	
}

public static BigDecimal divide(BigDecimal d1,BigDecimal d2,int n,boolean b) {
	  
	BigDecimal d3 = d1.divide(d2, n, RoundingMode.HALF_UP); // 根据指定位数,保留10位小数并四舍五入
	BigDecimal d4 = d1.divide(d2, n,RoundingMode.DOWN); // 根据指定位数直接截断
  
	return b?d3:d4;	
}

public static BigDecimal[] divideAndRemainder(BigDecimal d1,BigDecimal d2) {
	  
	  d1= new BigDecimal("12.345");
      d2 = new BigDecimal("0.12");
      BigDecimal[] dr = d1.divideAndRemainder(d2);
      System.out.println(dr[0]); // 102
      System.out.println(dr[1]); // 0.105
  
	return dr;	
}
}
