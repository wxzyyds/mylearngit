package com.itranswarp.learnjava;

import java.lang.reflect.Field;

public class ReflectSetField {
	 public static void main(String[] args) throws Exception {
		 Person21 p = new Person21("Xiao Ming");
	        System.out.println(p.getName()); // "Xiao Ming"
	        Class<?> c = p.getClass();
	        Field f = c.getDeclaredField("name");
	        f.setAccessible(true);
	        f.set(p, "Xiao Hong");
	        System.out.println(p.getName()); // "Xiao Hong"
	}

}
	class Person21 {
		private String name;
		public Person21() {
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}
		public Person21(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}

}