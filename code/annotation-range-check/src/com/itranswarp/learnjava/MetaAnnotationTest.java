package com.itranswarp.learnjava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author wxz
 *在自定义注解时候，元注解
 */
public class MetaAnnotationTest {
/*
 * Java标准库已经定义了一些元注解，我们只需要使用元注解，通常不需要自己去编写元注解。
 */
	
	/*
	 * 最常用的元注解是@Target。使用@Target可以定义Annotation能够被应用于源码的哪些位置：
	 * 类或接口：ElementType.TYPE；
		字段：ElementType.FIELD；
		方法：ElementType.METHOD；
		构造方法：ElementType.CONSTRUCTOR；
		方法参数：ElementType.PARAMETER。
		
		@Retention定义了Annotation的生命周期：
		仅编译期：RetentionPolicy.SOURCE
		仅class文件：RetentionPolicy.CLASS；
		运行期：RetentionPolicy.RUNTIME。
		如果@Retention不存在，则该Annotation默认为CLASS。
		
		@Repeatable
使用@Repeatable这个元注解可以定义Annotation是否可重复。这个注解应用不是特别广泛。

@Inherited
使用@Inherited定义子类是否可继承父类定义的Annotation。
@Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，
并且仅针对class的继承，
对interface的继承无效：
	 */
}
//	例如，定义注解@Report可用在方法上，我们必须添加一个@Target(ElementType.METHOD)：
@Target(ElementType.METHOD)
@interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

//定义注解@Reports可用在方法或字段上，可以把@Target注解参数变为数组{ ElementType.METHOD, ElementType.FIELD }：
//@Target定义的value是ElementType[]数组，只有一个元素时，可以省略数组的写法。
@Target({ElementType.METHOD,ElementType.FIELD})
@interface Reports {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

//通常我们自定义的Annotation都是RUNTIME，所以，务必要加上@Retention(RetentionPolicy.RUNTIME)这个元注解：

@Retention(RetentionPolicy.RUNTIME)
 @interface Report3 {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

@Repeatable(Reportes.class)
@Target(ElementType.TYPE)
 @interface Reportt {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

@Target(ElementType.TYPE)
 @interface Reportes {
	Reportt[] value();
}

//经过@Repeatable修饰后，在某个类型声明处，就可以添加多个@Report注解：

@Reportt(type=1, level="debug")
@Reportt(type=2, level="warning")
class Hello2 {}


@Inherited //定义子类是否可以继承父类定义的Annotation
@Target(ElementType.TYPE)
 @interface ReportI {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

//在使用的时候，如果一个类用到了@Report：

@ReportI(type=1)
 class Person2 {
}
//则它的子类默认也定义了该注解：@ReportI(type=1)

 class Student extends Person2 {
}