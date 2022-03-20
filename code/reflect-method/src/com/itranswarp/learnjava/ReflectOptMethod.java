package com.itranswarp.learnjava;

import java.lang.reflect.Method;

public class ReflectOptMethod {
	 public static void main(String[] args) throws Exception {
//		 先获取该类的Class实例
		 Class<Person> stdClass = Person.class;
	        // 获取public方法getScore，参数为String:
	        System.out.println(stdClass.getMethod("getScore", String.class));//没有该方法会报NoSuchMethodException
	        // 获取继承的public方法getName，无参数:
	        System.out.println(stdClass.getMethod("getName"));//没有该方法会报NoSuchMethodException
	        // 获取private方法getGrade，参数为int:
	        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));//没有该方法会报NoSuchMethodException
	   
	 /*
	  * 一个Method对象包含一个方法的所有信息：

		getName()：返回方法名称，例如："getScore"；
		getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
		getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
		getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
		返回一个该方法实例
	  */
	        
	        
//	        调用方法
	     // String对象:
	        String s = "Hello world";
	        // 获取String substring(int)方法，参数为int:
	        Method m = String.class.getMethod("substring", int.class);
	        // 在s对象上调用该方法并获取结果:
	        String r = (String) m.invoke(s, 6);//substring方法调用
	        // 打印调用结果:
	        System.out.println(r);
	        
	        // 获取String substring(int,int)方法，参数为int:
	        Method m2 = String.class.getMethod("substring", int.class,int.class);
	        System.out.println(m2.toString());
//	        对Method实例调用invoke就相当于调用该方法，invoke的第一个参数是对象实例
	        System.out.println( m2.invoke(s, 0,6));
	        
//	        调用静态方法,不用指定实例对象,传入null
	     // 获取Integer.parseInt(String)方法，参数为String:
	        Method m3 = Integer.class.getMethod("parseInt", String.class);
	        System.out.println(m3.toString());
	        // 调用该静态方法并获取结果:
	        Integer n = (Integer) m3.invoke(null, "12345");
	        // 打印调用结果:
	        System.out.println(n);
	       
//	 调用非public方法
//	 通过Method.setAccessible(true)允许其调用
	        Person p = new Person();
	        Method m4 = p.getClass().getDeclaredMethod("setName", String.class);
//	        如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)
//	        某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全。
	        m4.setAccessible(true);
	        m4.invoke(p, "Bob");
	        System.out.println(p.getName());
//	        polymorphic 多态
//	        当使用反射调用一个class的方法的时候,在invoke第一个参数传入他的子类,如果方法父类,子类存在,调用的则是该class子类的方法
	        Method m5 = Person.class.getMethod("hello");
	        m5.invoke(new Student());
	 }
	}
class Student extends Person{
	@Override
	public void hello() {
		System.out.println("hello world");
	}
}

	