package com.itranswarp.learnjava;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

//Java语言的泛型实现方式是擦拭法（Type Erasure）。
//编译过程中将相关泛型类型擦拭为对应类型
public class GenericRubbing {

//1	泛型实现的所有工作是由编译器完成，代码编译
	
//	2使用泛型的时候，我们编写的代码也是编译器看到的代码：

	Pair2<String> p = new Pair2<>("Hello", "world");
	String first = p.getFirst();
	String last = p.getLast();
	
//3	所以虚拟机看到的 <T>均为Objcet类型
	
	
//	4所以安全的向下转换，均有虚拟机完成
//	而虚拟机执行的代码并没有泛型：

	Pair2 p2 = new Pair2("Hello", "world");
	String first2 = (String) p.getFirst();
	String last2 = (String) p.getLast();
	
//5	因此泛型的局限
//	1.首先T类型实现实例，不能是基本数据类型。因为基本数据类型不是Object类型
//	Pair<int> p = new Pair<>(1, 2); // compile error!
	
//	局限二：无法取得带泛型的Class
//	
//	 Pair2<String> p1 = new Pair2<>("Hello", "world");
//     Pair2<Integer> p12 = new Pair2<>(123, 456);
//     Class c1 = p1.getClass();
//     Class c2 = p12.getClass();
//     System.out.println(c1==c2);// true
//     System.out.println(c1==Pair.class); // true
	
	public static void main(String[] args) {
		 Pair2<String> p1 = new Pair2<>("Hello", "world");
	     Pair2<Integer> p12 = new Pair2<>(123, 456);
	     Class c1 = p1.getClass();
	     Class c2 = p12.getClass();
	     System.out.println(c1.getName());// true
	     System.out.println(c2.getName());// true
	     System.out.println(c1==c2);// true
	     System.out.println(c1==Pair2.class); // true	
//	     获取到的是不带泛型的CLass
//	     局限三：无法判断带泛型的类型：
	     Pair2<Integer> p = new Pair2<>(123, 456);
	  // Compile error:
//	  if (p instanceof Pair2<String>) {
//	  }
//	     局限四：不能直接实例化T类型：new T()
//	     要实例化T类型，我们必须借助额外的Class<T>参数：
//	     借助Class<T>参数并通过反射来实例化T类型，使用的时候，也必须传入Class<T>。例如：

//	     Pair2<String> pair = new Pair2<>(String.class);    
	     
//  泛型继承	     
//	     父类的类型是Pair<Integer>，子类的类型是IntPair，可以这么继承：

//	     public class IntPair extends Pair<Integer> {
//	     }
	     
//	     使用的时候，因为子类IntPair并没有泛型类型，所以，正常使用即可：

//IntPair ip = new IntPair(1, 2);
	     
//	     父类泛型类中T无法获取T的类型，但是子类继承泛型类必须指定T的类型。子类可以获取到父类的泛型类型
	     Class<IntPair> clazz = IntPair.class;
	        Type t = clazz.getGenericSuperclass();
	        if (t instanceof ParameterizedType) {
	            ParameterizedType pt = (ParameterizedType) t;
	            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
	            Type firstType = types[0]; // 取第一个泛型类型
	            Class<?> typeClass = (Class<?>) firstType;
	            System.out.println(typeClass); // Integer
	        }

	}
}


 class Pair2<T> {
    private T first;
    private T last;
    public Pair2(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    
    public Pair2() {
        // Compile error:
//        first = new T();
//        last = new T();
    	
    	/*
    	 * 上述代码无法通过编译，因为构造方法的两行语句：

			first = new T();
			last = new T();
			擦拭后实际上变成了：
			
			first = new Object();
			last = new Object();
    	 */
    }
    public Pair2(Class<T> clazz) throws InstantiationException, IllegalAccessException {
    	first = clazz.newInstance();
    	last = clazz.newInstance();
    }
}
 
 class IntPair extends Pair2<Integer>{
	 public IntPair(Integer first, Integer last) {
	        super(first, last);
	    }
 }