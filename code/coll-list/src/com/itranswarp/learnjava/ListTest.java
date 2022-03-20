package com.itranswarp.learnjava;

import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = List.of(1, 2, 4, 5); 
//		使用迭代器是最快的遍历方式
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object.toString());
			
		}
//		foreach遍历对象的时候，只要是实现了Iterator接口的集合类，都会按迭代器方式去遍历；
//		java编译器会将foreach循环编译为迭代器方法
		for (Object object : list) {
			System.out.println(object);
		}
		
//		List和Array转换
//		list转Array
		Object obj[] = list.toArray();//该方法返回Obecjt类型数组，丢失类型信息
		Integer integer[] = list.toArray(new Integer[3]);
		Number number[] = list.toArray(new Number[3]);
		String str[] = list.toArray(new String[3]);//该方法，传入相同类型数组，最好复制数组长度与被转list大小相同
		
		Integer[] array = list.toArray(Integer[]::new);//一种写法
//		Array转List
		List<Integer> list2=List.of(new Integer[] {3,6,7,8});
	}

}
