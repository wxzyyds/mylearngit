package com.itranswarp.learnjava;

public class ThreadStatus {
	public static void main(String[] args) {
//		java程序一个线程对象只能调用一次Start启动新线程
//		吊起结束过程中，线程有以下状态
		
//		new：新创建未执行
//		Runnable：运行中的线程，正在执行run（）
//		Blocked:运行的线程，因为某些操作线程被阻塞挂起
//		Waiting：运行中的线程，因为某些操作等待中
//		Timed waiting：运行中的线程因为Sleep()执行等待着
//		Terminated:线程终止，run()方法执行完毕
		
		  Thread t = new Thread(() -> {
	            System.out.println("hello");
	        });
	        System.out.println("start");
	        t.start();
	        try {
				t.join();//通过join方法使当前线程执行完成，再执行下一个线程
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("end");
	}
}
