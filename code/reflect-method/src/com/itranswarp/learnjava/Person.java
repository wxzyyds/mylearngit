package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Person {

	private String name="xiaohoong";
	private int age=99;
	

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	

	private void setName(String name) {
		this.name = name;
	}

	public int getScore(String a000) {
		return 99;
	}
	
	public int getGrade(int a000) {
		return 220;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void hello() {
		System.out.println("hello world");
	}

}