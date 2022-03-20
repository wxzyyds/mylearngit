package com.itranswarp.learnjava;

public enum Week {
/**
 * 定义的enum类型总是继承自java.lang.Enum，且无法被继承；
只能定义出enum的实例，而无法通过new操作符创建enum的实例；
定义的每个实例都是引用类型的唯一实例；
可以将enum类型用于switch语句。
 */
	
	/**
	 * public final class Color extends Enum { // 继承自Enum，标记为final class
    // 每个实例均为全局唯一:
    public static final Color RED = new Color();
    public static final Color GREEN = new Color();
    public static final Color BLUE = new Color();
    // private构造方法，确保外部无法调用new操作符:
    private Color() {}
}
	 */
	
	MON(1,"周一"), TUE(2,"周二"), WED(3,"周三"), THU(4,"周四"), FRI(5,"周五"), SAT(6,"周六"), SUN(0,"周天");

    public final int dayValue;
    private final String chinese;
//    设顶实例字段后，根据实例字段个数生成，对应初始化实例字段构造器
    private Week(int dayValue, String chinese) {
        this.dayValue = dayValue;
		this.chinese = chinese;
    }
//    toString
    /*
     * 默认情况下，对枚举常量调用toString()会返回和name()一样的字符串。
     * 但是，toString()可以被覆写，而name()则不行。
     * 我们可以给Weekday添加toString()方法：
     */
    public String toString(){
		return chinese;
    	
    }
}
