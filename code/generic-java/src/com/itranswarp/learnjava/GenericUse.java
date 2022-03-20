package com.itranswarp.learnjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericUse {
/*
 * Java标准库提供的ArrayList，它可以看作“可变长度”的数组，因为用起来比数组更方便。

实际上ArrayList内部就是一个Object[]数组，配合存储一个当前分配的长度，就可以充当“可变数组”：
 */
	public static void main(String[] args) {
//		**不定义泛型，泛型类型为Object
//		编译器产生警告Multiple markers at this line
//		- ArrayList is a raw type. References to generic type ArrayList<E> should be 
//		 parameterized
			ArrayList a = new ArrayList();
//			ArrayList存储String
			a.add("0");
//			a.add(new Integer("123"));
			// 获取到Object，必须强制转型为String:
			String first = (String) a.get(0);
//			String first2 = (String) a.get(1);
			
//			当我们定义泛型类型<Number>后，List<T>的泛型接口变为强类型List<Number>：

			List<Number> list = new ArrayList<Number>();
			list.add(new Integer(123));
			list.add(new Double(12.34));
			Number first1 = list.get(0);
			Number second = list.get(1);
			
//			接口也可以使用泛型
			
//			String 实现了 Comparable<String> 泛型集合接口，Arrays.sort(Object[])可以对任意数组进行排序，
//			但是待排序对象必须实现 Comparable<T>接口
			String[] ss = new String[] { "Orange", "Apple", "Pear" };
	        Arrays.sort(ss);
	        System.out.println(Arrays.toString(ss));
	        
	        Person[] ps = new Person[] {
	                new Person("Bob", 61),
	                new Person("Alice", 88),
	                new Person("Lily", 75),
	            };
	            Arrays.sort(ps);
	            System.out.println(Arrays.toString(ps));

	}
}
//当该类未能实现Comparable<T>接口，则无法使用Arrays  的排序
class Person implements Comparable<Person> {
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return this.name + "," + this.score;
    }
    
//    使用泛型接口，来进行自定义对象排序
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		 return this.name.compareTo(o.name);
	}
}