package com.itranswarp.learnjava;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * @author wxz
 *Map是一种映射表，可以通过key快速查找value。
 *一般来说复写equals方法的同时也必须复写hashCode方法
 *、因是它内部通过空间换时间的方法，用一个大数组存储所有value，并根据key直接计算出value应该存储在哪个索引
 *即就是hashmap中依据key的hash值来确定value存储位置，
 *
 */
public class OverideEqualsAndHashCode {
	  public static void main(String[] args) {
	        Map<String, Person> map = new HashMap<>();
	        map.put("a", new Person(12, "张三"));
	        map.put("b", new Person(23, "王二"));
	        map.put("c", new Person(33, "李壮"));
	        
	        System.out.println("**===****"+"a"==new String("a"));
	        System.out.println("**equals*****"+"a".equals(new String("a")));
	        /*
	         * 把不同的key具有相同的hashCode()的情况称之为哈希冲突。
	         * 
	         * 如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
	         * 因为在冲突的时候，一种最简单的解决办法是用List存储hashCode()相同的key-value。显然，如果冲突的概率越大，这个List就越长，Map的get()方法效率就越低，
	         */
	       
	    }
	
}
class	  Person {
	  int age;
	  String name;
	  @Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
}