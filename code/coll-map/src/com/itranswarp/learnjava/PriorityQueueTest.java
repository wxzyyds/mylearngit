package com.itranswarp.learnjava;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author wxz
 * queue是一种队列 
 * queue是一种集合，先进先出。类似地铁过安检的操作，即就是添加在队列最后，获取到队列最前。
 * 而priorityQueue则实现了一种优先队列。
 * 从队首获取元素的时候总是获取优先级最高的元素。
 * PriorityQueue默认按照元素比较顺序排序（必须实现Comparable接口），
 * 也可以通过Comparator自定义排序算法（元素不必实现Comparable接口）
 * 
 * 
 */
public class PriorityQueueTest {
//以银行排队业务为例，实现一个PriorityQueue：
	public static void main(String[] args)  {

//		PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，
//		对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
//		要使用PriorityQueue，我们就必须给每个元素定义“优先级”。
		 // 添加3个元素到队列:
		Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A10000"));
        q.offer(new User("Alice", "A222"));
        q.offer(new User("Boss", "V11"));
        q.offer(new User("Boss2", "V12"));
        q.offer(new User("Boss3", "V1"));
        q.offer(new User("Boss4", "V4"));
//        System.out.println(q.poll()); // Boss/V1
        while (q.peek()!=null) {
//			q.poll()
			System.out.println(q.poll());
			
		}
//        System.out.println(q.poll()); // Bob/A1
//        System.out.println(q.poll()); // Alice/A2
//        System.out.println(q.poll()); // null,因为队列为空
		
	}
}
 class UserComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		if (o1.number.charAt(0)== o2.number.charAt(0)) {
//			如果票开头都是相同字母，则直接号的比较大小；
			return o1.number.toCharArray().length==o2.number.length()?o1.number.compareTo(o2.number):o1.number.toCharArray().length>o2.number.length()?1:-1;
		
		}
//		如果开头是V优先级最高
		if(o1.number.charAt(0)== 'V') {
			return -1;
		}else {
			return 1;
		}
	}

//	public int compare(User u1, User u2) {
//        if (u1.number.charAt(0) == u2.number.charAt(0)) {
//            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
//            return u1.number.compareTo(u2.number);
//        }
//        if (u1.number.charAt(0) == 'V') {
//            // u1的号码是V开头,优先级高:
//            return -1;
//        } else {
//            return 1;
//        }
//    }
	
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}
