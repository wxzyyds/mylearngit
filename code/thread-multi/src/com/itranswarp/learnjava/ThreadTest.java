package com.itranswarp.learnjava;

public class ThreadTest {
public static void main(String[] args) {
//	创建新线程
	getThread();//拉起自动结束
//	创建自定义线程
//	1.继承Thread类，复写run方法
//	Start（）方法会自己调用run()方法
	getThreadExcute();
//	2.创建Thread时，传入Runnable实例
	getThreadRunnable();
	
//	3.lamda表达式简写匿名内部类
	getThreadByLamda();
	
//	模拟并发的效果，我们可以在线程中调用Thread.sleep()，强迫当前线程暂停一段时间：
	
	getConcurrent();
	
//	线程优先级
	setThreadPriority(1);
}

private static void setThreadPriority(int i) {
	// TODO Auto-generated method stub
	 Thread t = new Thread(() -> {
         System.out.println("start new t!wait!");
         try {
 			Thread.sleep(1000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     });
	 
	 t.setPriority(i);
	 Thread t2 = new Thread(() -> {
         System.out.println("start new t2!wait!");
         try {
 			Thread.sleep(1000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     });
	 
	 Thread t3 = new Thread(() -> {
         System.out.println("start new t3!wait!");
         try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     });
	 t.start();
	 t2.start();
	 t3.start();
}

private static void getConcurrent() {
	// TODO Auto-generated method stub
	 Thread t = new Thread(() -> {
         System.out.println("start new thread!wait!");
        
     });
     t.start(); // 启动新线程
     try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     System.out.println(" thread!end!");
}

private static void getThreadByLamda() {
	// TODO Auto-generated method stub
	 Thread t = new Thread(() -> {
         System.out.println("start new thread!");
     });
     t.start(); // 启动新线程
}

private static void getThreadRunnable() {
	// TODO 匿名内部类的方式或者实现Runnable接口的子类
	Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("传入runnable创建一个线程，并start");
		}
	});
	thread.start();
}

private static void getThreadExcute() {
	// TODO Auto-generated method stub
	Thread thread = new MyThread();
	thread.start();
}

private static void getThread() {
	// TODO Auto-generated method stub
	Thread thread = new Thread();
	thread.start();//启动一个线程
	
}


}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
