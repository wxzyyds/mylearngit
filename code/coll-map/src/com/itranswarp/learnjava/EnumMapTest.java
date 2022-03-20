package com.itranswarp.learnjava;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

/**
 * 
 * @author wxz
 *Map是一种映射表，可以通过key快速查找value。
 *而hashMap是一种通过key计算出hashCode()，通过空间换时间的方式，直接定位到value所在的数组的索引，因此查取效率较高。
 *另一种情况：当key的对象是enum类型，可以使用java提供的EnumMap，他在内部以一个紧凑的数组存储value，并根据enum类型的key
 *直接定位到value所对的索引，无需计算hashcode（）,效率最高且不浪费空间
 */
public class EnumMapTest {
	  public static void main(String[] args) {  
		  Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
	      map.put(DayOfWeek.MONDAY, "星期一");
	      map.put(DayOfWeek.TUESDAY, "星期二");
	      map.put(DayOfWeek.WEDNESDAY, "星期三");
	      map.put(DayOfWeek.THURSDAY, "星期四");
	      map.put(DayOfWeek.FRIDAY, "星期五");
	      map.put(DayOfWeek.SATURDAY, "星期六");
	      map.put(DayOfWeek.SUNDAY, "星期日");
	      System.out.println(map);
	      System.out.println(map.get(DayOfWeek.MONDAY));
      }
}
