package com.itranswarp.learnjava;

import java.lang.reflect.Field;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Person p1 = new Person("Bob", "Beijing", 20);
		Person p2 = new Person("", "Shanghai", 20);
		Person p3 = new Person("Alice", "Shanghai", 199);
		for (Person p : new Person[] { p1, p2, p3 }) {
			try {
				check(p);
				System.out.println("Person " + p + " checked ok.");
			} catch (IllegalArgumentException e) {
				System.out.println("Person " + p + " checked failed: " + e);
			}
		}
	}

	static void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
		for (Field field : person.getClass().getFields()) {
			Range range = field.getAnnotation(Range.class);
			if (range != null) {
				Object value = field.get(person);
//		使用@Range注解来检查Java Bean的字段。如果字段类型是String，就检查String的长度，如果字段是int，就检查int的范围。
				 if (value instanceof String) {
	                 String s = (String) value;
	                 // 判断值是否满足@Range的min/max:
	                 if (s.length() < range.min() || s.length() > range.max()) {
	                     throw new IllegalArgumentException("Invalid field: " + field.getName()+"《---》  String ->为空 《---》 length->为"+s.length());
	                 } else {
	                	 System.out.println(" String length->"+s.length());
	                 }
	             }
				
				if(value instanceof Integer)
				{
					 int i = (int) value;
	                 // 判断值是否满足@Range的min/max:
	                 if (i < range.min() ||i > range.max()) {
	                     throw new IllegalArgumentException("Invalid field: " + field.getName()+"《---》 Integer range:["+range.min()+"~"+range.max()+"]");
	                 }
	                 else {
	                	 System.out.println("Invalid field: " + field.getName()+"《---》 Integer range:["+range.min()+"~"+range.max()+"]");
	                 }
					
				}
			}
		}
	}
}
