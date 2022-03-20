package com.itranswarp.learnjava;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//部分反射API为泛型Class<T>,Construct<T>

public class GenericAndReflection {
/*
 * ava的部分反射API也是泛型。例如：Class<T>就是泛型：
 */
// compile warning:
//Class clazz = String.class;
//String str = (String) clazz.newInstance();

// no warning:
//Class<String> clazz = String.class;
//String str = clazz.newInstance();

//	调用Class的getSuperclass()方法返回的Class类型是Class<? super T>：
	Class<? super String> sup = String.class.getSuperclass();
//	构造方法Constructor<T>也是泛型：

Class<Integer> clazz = Integer.class;
void getConstructor() {
	
	Constructor<Integer> cons = null;
	try {
		cons = clazz.getConstructor(int.class);
	} catch (NoSuchMethodException | SecurityException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Integer i = cons.newInstance(123);
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	我们可以声明带泛型的数组，但不能用new操作符创建带泛型的数组：

Pair3<String>[] ps = null; // ok
//Pair3<String>[] ps1 = new Pair3<String>[2]; // compile error!
//通过强制转型实现带泛型的数组：
@SuppressWarnings("unchecked")
Pair3<String>[] ps1 = (Pair3<String>[]) new Pair3[2];

Pair3[] arr = new Pair3[2];
Pair3<String>[] ps3 = (Pair3<String>[]) arr;

ps3[0] = new Pair3<String>("a", "b");
arr[1] = new Pair3<Integer>(1, 2);

// ClassCastException:
Pair3<String> p = ps[1];
String s = p.getFirst();


//不能直接创建泛型数组T[]，因为擦拭后代码变为Object[]：

//compile error:
//public class Abc<T> {
// T[] createArray() {
//     return new T[5];
// }

//必须借助Class<T>来创建泛型数组：

//T[] createArray(Class<T> cls) {
//    return (T[]) Array.newInstance(cls, 5);
//}


String[] ss = ArrayHelper.asArray("a", "b", "c");
Integer[] ns = ArrayHelper.asArray(1, 2, 3);
}

}
//还可以利用可变参数创建泛型数组T[]：

 class ArrayHelper {
    @SafeVarargs
    static <T> T[] asArray(T... objs) {
        return objs;
    }
}

