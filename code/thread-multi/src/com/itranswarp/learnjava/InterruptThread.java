package com.itranswarp.learnjava;


public class InterruptThread {
	public static void main(String[] args) {
//		interrupt()中断线程
//		线程执行长时间任务，可能需要中断线程。
//		下载一个文件，时间过长，用户点击取消就是中断线程执行。
//		在其他线程执行对目标线程的interrupt（）方法，而目标线程反复检测自己的状态是不是interruptted状态

		getInterruptThread();
//		当监测到线程isInterrupted()或者只要捕获到join()方法抛出的InterruptException，线程立即中断

		interruptThreads();
		
//		常用中断线程的方法，设置标志位volatile boolean running = true;
//		volatile关键字解决的是可见性问题：当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值。
		try {
			setMark();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setMark() throws InterruptedException {
		  HelloThread2 t = new HelloThread2();
	        t.start();
	        Thread.sleep(1);
	        t.running = false; // 标志位置为false
	    
	}

	private static void interruptThreads() {
		// TODO Auto-generated method stub
		Thread t = new MyThread3();
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.interrupt(); // 中断t线程
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 等待t线程结束
		System.out.println("end");
	}

	private static void getInterruptThread() {
		// TODO 中断线程
		Thread thread = new MyThread2();
		thread.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thread.interrupt(); // 中断t线程
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 等待t线程结束
		System.out.println("end");

	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int n = 0;
//		监测是否中断进程
		while (!isInterrupted()) {
			n++;
			System.out.println(n + " hello!");
		}
	}
}

class MyThread3 extends Thread {
	@Override
	public void run() {
		Thread hello = new HelloThread();
		hello.start(); // 启动hello线程
		try {
			hello.join(); // 等待hello线程结束
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
		}
		hello.interrupt();

	}
}

class HelloThread extends Thread {
	public void run() {
		int n = 0;
		while (!isInterrupted()) {
			n++;
			System.out.println(n + " hello!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("捕获到join抛出的中断异常，");
				break;
			}
		}
	}
}


class HelloThread2 extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}