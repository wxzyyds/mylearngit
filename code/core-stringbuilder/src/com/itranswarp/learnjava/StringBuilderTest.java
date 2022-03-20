package com.itranswarp.learnjava;
/*
 * 高效拼接字符串，可变字符串，并未定义final修饰的对象
 */
public class StringBuilderTest {
	public static void main(String[] args) {
		/*
		 * String做了特殊处理，使得我们可以直接用+拼接字符串。

考察下面的循环代码：
以+直接拼接字符串，
在循环中，每次循环都会创建新的字符串对象
扔掉旧的字符串。
绝大部分字符串都是临时对象，
浪费内存，还会影响GC效率。
		 */
		String s = "";
		for (int i = 0; i < 20; i++) {
			s = s + "," + i;
		}
		
		System.out.println(s);
//		可变对象，可以预分配缓冲区，往StringBuilder中新增字符时，不会创建新的临时对象
		var stringBuilder = new StringBuffer("...........");
		for (int i = 0; i < 20; i++) {
			stringBuilder.append(",").append(i);
		}
		System.out.println(stringBuilder);
//		StringBuilder还可以进行链式操作：链式操作 .连接起来的操作方法称为链式操作
//		链式操作的关键是，定义的append()方法会返回this可以不断调用自身的其他方法。
		var sb = new StringBuilder(1024);
        sb.append("Mr ")
          .append("Bob")
          .append("!")
//          insert插入方法，指定位置插入
          .insert(0, "Hello, ");
        System.out.println(sb.toString());
        Adder adder = new Adder();
        adder.add(3)
             .add(5)
             .inc()
             .add(10);
        System.out.println(adder.value());
//        StringConcatFactory
        /*
         * 对于普通的字符串+操作，
         * 并不需要我们将其改写为StringBuilder，
         * 因为Java编译器在编译时就自动把多个连续的
         * +操作编码为StringConcatFactory的操作。
         * 在运行期，StringConcatFactory会自动把字符串连接操作优化为数组复制或者StringBuilder操作。
         * */
//        StringBuffer，这是Java早期的一个StringBuilder的线程安全版本，
//它通过同步来保证多个线程操作StringBuffer也是安全的，但是同步会带来执行速度的下降。
//        StringBuilder和StringBuffer接口完全相同，现在完全没有必要使用StringBuffer
		
	}
}
