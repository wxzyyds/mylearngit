package com.itranswarp.learnjava;

import java.lang.reflect.Field;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
/**
 * 访问字段
 * 反射，首先代码非常繁琐，
 * 其次，它更多地是给工具或者底层框架来使用，
 * 目的是在
 * 不知道
 * 目标实例任何信息的情况下
 * ，获取特定字段的值。

此外，setAccessible(true)可使用private的前置参数可能会失败。
如果JVM运行期存在SecurityManager，
那么它会根据规则进行检查，
有可能阻止setAccessible(true)。
例如，某个SecurityManager
可能不允许对java和javax开头的package的类调用setAccessible(true)，
这样可以保证JVM核心库的安全。
 * @param args
 */
	public static void main(String[] args) {
		String name = "Xiao Ming";
		int age = 20;
		Person2 p = new Person2(name,age);
		// TODO: 利用反射给name和age字段赋值:
		Class<?> c= p.getClass();
		Field fieldName = null;
		Field fieldAge = null;
		try {
			fieldName = c.getDeclaredField("name");
			fieldAge = c.getDeclaredField("age");
			fieldName.setAccessible(true);
			fieldAge.setAccessible(true);
			fieldName.set(p,"Xiao Hong");
			fieldAge.set(p,30);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println(p.getName()); // "Xiao Ming"
			System.out.println(p.getAge()); // 20
			
		}
	}
}
