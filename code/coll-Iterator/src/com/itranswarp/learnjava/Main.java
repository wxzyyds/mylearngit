package com.itranswarp.learnjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Java的集合类都可以使用for each循环，
 * List、Set和Queue会迭代每个元素，
 * Map会迭代每个key。
 * 
 * 而通用迭代方法称之为迭代器，
 */
public class Main {
	public static void main(String[] args) {
//		list
		List<String> list = List.of("Apple","Banana","Pear");
		for (String string : list) {
			System.out.println(string);
		}
//		该代码能编译通过原因，是因为编译器将Foreach()循环通过iterator迭代器编译为普通for循环
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
//于自定义的集合类，实现Iterable接口 implements Iterable<T>，使用Iterator对象迭代内部数据：implements Iterator<T> 
        ReverseList<String> rlist = new ReverseList<>();
        rlist.add("Apple");
        rlist.add("Orange");
        rlist.add("Pear");
        for (String s : rlist) {
            System.out.println(s);
        }
	}

}
//自定义集合类
class ReverseList<T> implements Iterable<T> {

    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

/*
 * 在编写Iterator的时候，
 * 我们通常可以用一个内部类来实现Iterator接口，
 * 这个内部类可以直接访问对应的外部类的所有字段和方法。
 * 例如，上述代码中，内部类ReverseIterator可以用ReverseList.this获得当前外部类的this引用，
 * 然后，通过这个this引用就可以访问ReverseList的所有字段和方法。
 */
    class ReverseIterator implements Iterator<T> {
        int index;

        ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}
