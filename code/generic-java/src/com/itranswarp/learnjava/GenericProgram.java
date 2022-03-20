package com.itranswarp.learnjava;
/*
 * 通常来说，泛型类一般用在集合类中，例如ArrayList<T>，我们很少需要编写泛型类。
 */
public class GenericProgram {
	
//	例如编写一个 Pair类 将所有String转为T,如Pair1

	
//	特别注意，泛型类型<T>不能用于静态方法
//	 public static Pair1<T> create(T first, T last) {
//	        return new Pair1<T>(first, last);
//	    }//erro
	// 对静态方法使用<T>:
    public static <T> Pair1<T> create(T first, T last) {
        return new Pair1<T>(first, last);
    }
}


class Pair {
    private String first;
    private String last;
    public Pair(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
}

class Pair1<T> {
    private T first;
    private T last;
    public Pair1(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}