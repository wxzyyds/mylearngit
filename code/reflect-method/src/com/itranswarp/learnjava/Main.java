package com.itranswarp.learnjava;

import java.lang.reflect.Method;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception {
		String name = "Xiao Ming";
		int age = 20;
		Person p = new Person();
		// TODO: 利用反射调用setName和setAge方法:
		Method getNameMethod = p.getClass().getDeclaredMethod("setName",String.class);
		Method setAgeName = p.getClass().getMethod("setAge",int.class);
		System.out.println(getNameMethod.toString()); 
		System.out.println(setAgeName.toString()); 
		
		getNameMethod.setAccessible(true);
		getNameMethod.invoke(p, name);
		setAgeName.invoke(p, age);
		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
	}
}
