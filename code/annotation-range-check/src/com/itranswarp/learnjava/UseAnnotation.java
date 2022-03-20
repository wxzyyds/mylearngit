package com.itranswarp.learnjava;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UseAnnotation {
/*
 * Java的注解本身对代码逻辑没有任何影响。根据@Retention的配置：

	SOURCE类型的注解在编译期就被丢掉了；编译器使用的注解
	CLASS类型的注解仅保存在class文件中，它们不会被加载进JVM；由工具处理.class文件使用的注解
	RUNTIME类型的注解会被加载进JVM，并且在运行期可以被程序读取。在程序运行期间能够读取的注解
 */
	
//	只讨论如何读取RUNTIME类型的注解。
//	注解定义后也是一种class
//	所有的注解都继承自java.lang.annotation.Annotation
//	读取注解，需要使用反射API
	
//	判断某个注解是否存在于Class、Field、Method或Constructor：
//
	public static void main(String[] args) {
		
		// 判断@Report是否存在于Person类:
//	Class.isAnnotationPresent(Class)
		Person.class.isAnnotationPresent(Report.class);
		// 获取Person定义的@Report注解:
		Report report = Person.class.getAnnotation(Report.class);
		int type = report.type();
		String level = report.level();
//		使用反射API读取Annotation有两种方法。方法一是先判断Annotation是否存在，如果存在，就直接读取：	
		Class cls = Person.class;
		if (cls.isAnnotationPresent(Report.class)) {
		     report = (Report) cls.getAnnotation(Report.class);
	
		}
//		第二种方法是直接读取Annotation，如果Annotation不存在，将返回null：
		 report = (Report) cls.getAnnotation(Report.class);
		if (report != null) {
			

		}
		
		
		
	}
	
//	读取方法、字段和构造方法的Annotation和Class类似。
//	但要读取方法参数的Annotation就比较麻烦一点，
//	因为方法参数本身可以看成一个数组，而每个参数又可以定义多个注解，所以，
//	一次获取方法参数的所有注解就必须用一个二维数组来表示。例如，对于以下方法定义的注解：

public void hello(@NotNull @Range1(max=5) String name, @NotNull String prefix) {
}


//	Field.isAnnotationPresent(Class)

public void getAnnoationMethod(){
	//要读取方法参数的注解，我们先用反射获取Method实例，然后读取方法参数的所有注解：
	//获取Method实例:
	Method m1 = null;
	try {
		m1 = Person.class.getDeclaredMethod("level",Report.class);
	} catch (NoSuchMethodException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//获取所有参数的Annotation:
	Annotation[][] annos = m1.getParameterAnnotations();
	//第一个参数（索引为0）的所有Annotation:
	Annotation[] annosOfName = annos[0];
	for (Annotation anno : annosOfName) {
	    if (anno instanceof Range) { // @Range注解
	        Range r = (Range) anno;
	    }
	    if (anno instanceof NotNull) { // @NotNull注解
	        NotNull n = (NotNull) anno;
	    }
	}
//		Method.isAnnotationPresent(Class)
}



//	Constructor.isAnnotationPresent(Class)
}
@interface NotNull{
	
}

@interface Range1{

	int max();
	
}
class userAnnotation{
//	 使用注解
//	 注解如何使用，完全由程序自己决定。例如，JUnit是一个测试框架，它会自动运行所有标记为@Test的方法。

//	 我们来看一个@Range注解，我们希望用它来定义一个String字段的规则：字段长度满足@Range的参数定义：

	 @Retention(RetentionPolicy.RUNTIME)
	 @Target(ElementType.FIELD)
	 public @interface Range {
	     int min() default 0;
	     int max() default 255;
	 }
//	 在某个JavaBean中，我们可以使用该注解：

	 public class Person {
	     @Range(min=1, max=20)
	     public String name;

	     @Range(max=10)
	     public String city;
	 }
//	 但是，定义了注解，本身对程序逻辑没有任何影响。
//	 我们必须自己编写代码来使用注解。
//	 这里，我们编写一个Person实例的检查方法，
//	 它可以检查Person实例的String字段长度是否满足@Range的定义：

//	 这样一来，我们通过@Range注解，配合check()方法，就可以完成Person实例的检查。
//	 注意检查逻辑完全是我们自己编写的，JVM不会自动给注解添加任何额外的逻辑。
	 void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
	     // 遍历所有Field:
	     for (Field field : person.getClass().getFields()) {
	         // 获取Field定义的@Range:
	         Range range = field.getAnnotation(Range.class);
	         // 如果@Range存在:
	         if (range != null) {
	             // 获取Field的值:
	             Object value = field.get(person);
	             // 如果值是String:
	             if (value instanceof String) {
	                 String s = (String) value;
	                 // 判断值是否满足@Range的min/max:
	                 if (s.length() < range.min() || s.length() > range.max()) {
	                     throw new IllegalArgumentException("Invalid field: " + field.getName());
	                 }
	             }
	         }
	     }
	 }
 }