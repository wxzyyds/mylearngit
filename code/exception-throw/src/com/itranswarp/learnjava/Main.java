package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		try {
			System.out.println(tax(2000, 0.1));
			System.out.println(tax(-200, 0.1));
			System.out.println(tax(2000, -0.1));
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	
	}

	static double tax(int salary, double rate) {
		// TODO: 如果传入的参数为负，则抛出IllegalArgumentException
		if(salary<0 || rate <0) {
			throw new IllegalArgumentException("参数不能为负");
//			相关涉及到checked exception方法,抛出异常,如果不抛出,无法确定异常抛出位置
//			最上层catch 捕获异常
//			e.printStackTrace()来打印异常方法栈,最终确定错误位置
//			多catch个异常,可以统提前创建exception对象,add添加,catch异常信息一最终finall统一判断打印,一般不会用到
		}
		return salary * rate;
	}
}
