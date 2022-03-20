package com.itranswarp.learnjava;

public class MathTest {
//math用于数学计算的工具类
//	提供了大量的数学方法便于我们实现

	public static void main(String[] args) {
//求绝对值
		System.out.println(getAbsoluteValue(-1999));
//		取两个数最大值
		System.out.println(getMaxOrMin(-1999,456464,true));
//		取两个数最小值
		System.out.println(getMaxOrMin(-1999,456464,false));
//		求25的16次方
		System.out.println(getPow(25,16));
//		求360000的开方
		System.out.println(getSqrt(360000));
//		计算E的36次方
		System.out.println(getExp(36));
//		计算e为底，10为指数的值
		System.out.println(getLog(10));
//		计算10为底，100为指数的值
		System.out.println(getLog10(100));
//计算120°的cos值
		System.out.println(getTrigonometric(120,"cos"));
//		获取e的数学常量值
		System.out.println(getConstants("e"));
		System.out.println(getConstants("E"));
//		获取Π的数学常量值
		System.out.println(getConstants("pi"));
		System.out.println(getConstants("pI"));
//		获取 o~5的随机数
		System.out.println(getMathRadom(5));
//		计算// 区间在[MIN, MAX)的随机数 10~60
		System.out.println(getSection(10, 60));
	}

	/**
	 * @param
	 * @return
	 */
	public static int getAbsoluteValue(int i) {
//		求绝对值：Math.abs();
		return Math.abs(i);

	}

	/**
	 * 
	 * @param i
	 * @param i2
	 * @param a
	 * @return
	 */
	public static int getMaxOrMin(int i, int i2, Boolean a) {
//		取最大或最小值：Math.max(int x,int y);Math.min(int x,int y);
		if (a) {
			return Math.max(i, i2);
		}
		return Math.min(i,i2);

	}

	/**
	 * 
	 * @param i
	 * @param i2
	 * @return
	 */
	public static double getPow(double i, double i2) {
//		计算x的n次方：Math.pow(double x,double y)

		return Math.pow(i, i2);

	}

	public static double getSqrt(double i) {
//		计算√x：Math.sqrt(double i)；		
		return Math.sqrt(i);

	}

	public static double getExp(double i) {
//		计算ex次方：Math.exp(double i)；		
		return Math.exp(i);

	}

	public static double getLog(double i) {
//		计算e为底的对数：Math.log(double i)；		
		return Math.log(i);

	}

	public static double getLog10(double i) {
//		计算以10为底的对数：：Math.log10(double i)；		
		return Math.log10(i);

	}

	public static double getTrigonometric(double i, String a) {
		/*
		 * Math.sin(3.14); // 0.00159... Math.cos(3.14); // -0.9999... Math.tan(3.14);
		 * // -0.0015... Math.asin(1.0); // 1.57079... Math.acos(1.0); // 0.0
		 */
		switch (a) {
		case "cos":
			i = Math.cos(i);
			break;
		case "sin":
			i = Math.sin(i);
			break;
		case "tan":
			i = Math.tan(i);
			break;
		case "asin":
			i = Math.asin(i);

			break;
		case "acos":
			i = Math.acos(i);
			break;
		default:
			System.out.println("请选择三角函数计算公式");
			break;
		}
		return i;
	}

	public static double getConstants(String consName) {
		/*
		 * math提供数学常量 double pi = Math.PI; // 3.14159... double e = Math.E; //
		 * 2.7182818... Math.sin(Math.PI / 6); // sin(π/6) = 0.5
		 */
		if ("pi".equalsIgnoreCase(consName)) {
			return  Math.PI;
		} else if ("e".equalsIgnoreCase(consName)) {
			return Math.E;
		}else {
			
			return 0;
		}
	}
	public static double getMathRadom(int i) {
		/*
		 * math提供Radom获取随机数 
		 * 生成一个随机数x，x的范围是0 <= x < 1
		 */
//		Math.random(); // 0.53907... 每次都不一样

			return Math.random()*i;
	

	}
	
	public static long getSection(int min,int max) {
		/*
		 * math提供Radom获取随机数 
		 * 生成一个随机数x，x的范围是0 <= x < 1
		 * 
		 * 使用的Math.random()实际上内部调用了Random类，所以它也是伪随机数，只是我们无法指定种子,系统时间
		 */
//			计算某个区间的某个随机数，
		

			return (long) (Math.random()*(max-min)+min);
	

	}

}
