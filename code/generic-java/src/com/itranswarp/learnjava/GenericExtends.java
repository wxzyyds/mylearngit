package com.itranswarp.learnjava;
//extends通配符   需要泛型类型读取

//<? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
public class GenericExtends {
/*
 * 定义一个泛型类Pair<T>
 * 类型为泛型类名Pair
 * 
 * 创造该泛型类实例，new Pair<String>()不能直接确定该实例为指定泛型类型<String>
 * 
 * 也就是new Pair<Integer>  new Pair<Number>(),不是同一类型
 * 
 * 所以在使用泛型类传入参数，使用extends通配符来指定，继承关系。以确认传人参数类型
 * 使用Pair<? extends Number>类型。
 * 这种使用<? extends Number>的泛型定义称之为上界通配符（Upper Bounds Wildcards），
 * 即把泛型类型T的上界限定在Number了。
 */
	
//	Pair<Number>类型写了一个静态方法，它接收的参数类型是Pair<Number>：
	public static void main(String[] args) {
		
		Pair3<Integer> p = new Pair3<>(123, 456);
		int n = add(p);
		System.out.println(n);
	}


        static int add(Pair3<? extends Number> p) {
        	Number first = p.getFirst();
        	Number last = p.getLast();
//        	p.setFirst(new Integer(first.intValue() + 100));
//        	p.setLast(new Integer(last.intValue() + 100));
        	
//        	<? extends Number>通配符的一个重要限制：
//        	方法参数签名setFirst(? extends Number)
//        	无法传递任何Number的子类型给setFirst(? extends Number)。
        	return p.getFirst().intValue() + p.getFirst().intValue();
        }
        
//        ？ extends 通配符的作用
//       方法参数类型List<? extends Integer>表明了该方法内部只会读取,不会修改。恶意调用set null除外
        
//        使用extends限定T类型
//        在定义泛型类型Pair<T>的时候，也可以使用extends通配符来限定T的类型：
//        public class Pair<T extends Number> { ... }
//        因此实例化对象时候，范围只允许在Number中，包含其子类
}
class Pair3<T> {
    private T first;
    private T last;
    public Pair3(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public void setFirst(Integer integer) {
		// TODO Auto-generated method stub
		
	}
	public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }

}