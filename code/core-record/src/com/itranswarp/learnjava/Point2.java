package com.itranswarp.learnjava;

/**
 * * 一般一行代码就可以使用一个不变类
 * @author wxz
 *
 */
public record Point2(int x, int y) {
/**
 
 * 可以加入Compact  构造方法来检测参数	
 * @param x
 * @param y
 */
	public Point2 {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
	
//	record的Point仍然可以添加静态方法。一种常用的静态方法是of()方法，用来创建Point
	public static Point2 of() {
        return new Point2(0, 0);
    }
}
