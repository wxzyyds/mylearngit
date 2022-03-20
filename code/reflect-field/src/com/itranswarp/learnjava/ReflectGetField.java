package com.itranswarp.learnjava;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectGetField {
	 public static void main(String[] args) throws Exception {
	        Class<Student> stdClass = Student.class;
	        // 获取public字段"score":

	        System.out.println(stdClass.getField("score"));
	        // 获取继承的public字段"name":
//	        System.out.println(stdClass.getField("name"));
	        // 获取private字段"grade":
	        System.out.println(stdClass.getDeclaredField("grade"));
	        /*
	         * 一个Field对象包含了一个字段的所有信息：

				getName()：返回字段名称，例如，"name"；
				getType()：返回字段类型，也是一个Class实例，例如，String.class；
				getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
	         */
	        
	        Field f = String.class.getDeclaredField("value");
	        f.getName(); // "value"
	        f.getType(); // class [B 表示byte[]类型
	        int m = f.getModifiers();
//	        Modifier封装了所有修饰符的类,提供is方法来进行修饰符判断
	        Modifier.isFinal(m); // true
	        System.out.println( Modifier.isFinal(m));
	        Modifier.isPublic(m); // false
	        System.out.println( Modifier.isPublic(m));
	        Modifier.isProtected(m); // false
	        System.out.println( Modifier.isProtected(m));
	        Modifier.isPrivate(m); // true
	        System.out.println( Modifier.isPrivate(m));
	        Modifier.isStatic(m); // false
	        System.out.println( Modifier.isStatic(m));
	        
	        Object p = new Person("Xiao Ming");
	        Class c = p.getClass();
	        
	        Field f1 = c.getDeclaredField("name");
	        f1.setAccessible(true);
	        Object value = f1.get(p);
	        System.out.println(value); // "Xiao Ming"
	    }
	}

	class Student extends Person {
	    public int score;
	    private int grade;
	    public Student() {
			super();
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
	}
	
	class Person {
		private String name;
		public Person() {
			// TODO Auto-generated constructor stub
		}
		public Person(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}


		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}
}