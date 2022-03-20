package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
//	编译器可以在编译期自动检查出所有可能的潜在错误。


	public static void main(String[] args) {
//	实例化enmu类对象，是一种引用类型
		Week day = Week.SUN;//每个emun常量相当于相当于一个enmu类型的实例，只不过实例字段常量化
		if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
//            枚举类中新增的变量，务必声明为final，使其再运行时不能修改
// enum定义的枚举类是一种引用类型，但是每个emun对象即emun常量再jvm中只有唯一一个实例，所有可以用==相比           
        }
//		enum定义的类型就是class
		
//		name()返回常量名
		  System.out.println("name()方法返回常量名->"+day.name());
//ordinal()	返回定义的常量的顺序，从0开始计数，例如：
	System.out.println("ordinal()方法定义的常量的顺序->"+day.ordinal());
//	改变枚举常量定义的顺序就会导致ordinal()返回值发生变化,建议按顺序定义
	
	/*
	 * 如果不小心修改了枚举的顺序，
	 * 编译器是无法检查出这种逻辑错误的。
	 * 要编写健壮的代码，
	 * 就不要依靠ordinal()的返回值。
	 * 因为enum本身是class，
	 * 所以我们可以定义private的构造方法，
	 * 并且，给每个枚举常量添加字段：
	 */
//	判断枚举常量的名字，要始终使用name()方法，绝不能调用toString()
	
//	switch
//	最后，枚举类可以应用在switch语句中。因为枚举类天生具有类型信息和有限个枚举常量，所以比int、String类型更适合用在switch语句中：
	switch(day) {
    case MON:
    case TUE:
    case WED:
    case THU:
    case FRI:
        System.out.println("Today is " + day.name() + ". Work at office!");
        break;
    case SAT:
    case SUN:
        System.out.println("Today is " + day.name() + ". Work at home!");
        break;
    default:
        throw new RuntimeException("cannot process " + day);
    }
	}
}
