package com.itranswarp.learnjava;

public class EnumTest {
//	// 每个实例均为全局唯一:
		public static final int SUN = 0;
	    public static final int MON = 1;
	    public static final int TUE = 2;
	    public static final int WED = 3;
	    public static final int THU = 4;
	    public static final int FRI = 5;
	   
		public static final int SAT = 6;
//	    但实际上java提供了emun类来定义这种规定性的常量
		 private EnumTest() {
				
			}
}
