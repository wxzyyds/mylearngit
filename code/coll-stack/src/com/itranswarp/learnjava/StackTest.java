package com.itranswarp.learnjava;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wxz 栈（Stack）是一种后进先出（LIFO：Last In First Out）的数据结构。 比如沙漏，最后进去的沙子，最后出来
 * 
 *         （LIFO：Last In First Out） 实际JVM处理java方法的时候，就是使用Stack这种数据结构来维护方法调用层次
 */
public class StackTest {

	public static void main(String[] args) {

		String hex = toHex(12500);
		System.out.println(hex);
		if (hex.equalsIgnoreCase("30D4")) {
			System.out.println("测试通过");
		} else {
			System.out.println("测试失败");
		}
	}

	static String toHex(int n) {
//		Integer自带进制转化方法  String a = Integer.toUnsignedString(n,16);
		Map<Integer, String> map = new HashMap<>();
		map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
//		求商a
		int a = n / 16;
//		取余
		String b = n % 16 + "";
		if(Integer.valueOf(b)>10) {
			b = map.get(Integer.valueOf(b));
		}
		String c = "";
		
		if (a >0) {
			c=toHex(a);
		}
		
		return c+b;
	}
}
