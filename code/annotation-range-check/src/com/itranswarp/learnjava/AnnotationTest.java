package com.itranswarp.learnjava;

public class AnnotationTest {
/*
 * 什么是注解（Annotation）？
 * 注解是放在Java源码的类、
 * 方法、
 * 字段、
 * 参数前的一种特殊“注释”：
 *     @Stable
    private final byte[] value;
    
    注解则可以被编译器打包进入class文件，因此，注解是一种用作标注的“元数据”。
    @Resource("hello")//是一种用作标注的“元数据”,标注类
	public class Hello {
	    @Inject//是一种用作标注的“元数据”,标注字段
	    int n;

	    @PostConstruct////是一种用作标注的“元数据”,标注方法
	    public void hello(@Param//是一种用作标注的“元数据”,标注参数
	     String name) {
	        System.out.println(name);
	    }

	    @Override//注解是一种用作标注的元数据，标注方法。
	    public String toString() {
	        return "Hello";
	    }
	}
 */
	
	/*
	 * 注解的作用
从JVM的角度看，
注解本身对代码逻辑没有任何影响，
如何使用注解完全由工具决定。
	 */
	
//	一.由编译器使用的注解，在编译后，不会被编译进.class文件
//	@Override：让编译器检查该方法是否正确地实现了覆写；
//	@SuppressWarnings：告诉编译器忽略此处代码产生的警告。
	
//	二.由工具处理.class文件使用的注解
//	有些工具会在加载class的时候，
//	对class做动态修改，
//	实现一些特殊的功能。
//	这类注解会被编译进入.class文件，
//	但加载结束后并不会存在于内存中。
//	这类注解只被一些底层库使用，
//	一般我们不必自己处理。
	
//	三、在程序运行期间能够读取的注解
//	在加载后一直存在于JVM中，这也是最常用的注解。这是Java代码读取该注解实现的功能，JVM并不会识别该注解
//	@interface定义一个.java文件，为注解类
//	int min()；int man()；int value();定义注解参数
//	default 0 来添加注解默认值
	/*
	 * 配置参数可以包括：
	 * 所有基本类型；
		String；
		枚举类型；
		基本类型、String、Class以及枚举的数组。
	 */
	  @Check(min=0, max=100, value=55)
	    public int n;

	    @Check(value=99)
	    public int p;

	    @Check(99) // @Check(value=99)
	    public int x;

	    @Check
	    public int y;
	
	
	
}
