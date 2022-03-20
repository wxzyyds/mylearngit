package com.itranswarp.learnjava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	static final Log log = LogFactory.getLog(Main.class);
/*
 * 反射就是Reflection，Java的反射是指
 * 程序在运行期可以
 * 拿到一个对象的所有信息。
 */
	public static void main(String[] args) throws Exception{
	/*
	 * 由于接口不能直接实例化,但是可以通过实现类向上转.而一般情况下,我们需要编写具体的实现类
	 * 动态代理是不用编写某个接口的实现类,通过Proxy.newProxyInstance在程序运行时候动态的创建一个该接口的实现.
	 * 这种没有实现类但是在运行时期动态创建接口对象实例的方式我们叫动态代理
	 */
	
		InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
//        1.可以通过匿名内部类的方式获取一个接口对象
        new Hello(){

			@Override
			public void morning(String name) {
				// TODO Auto-generated method stub
				
			}

			public void getHello() {
			System.out.println("你好");
				
			}
        }.getHello() ;
//   2.可以通过Proxy.newProxyInstance(ClassLoader,接口.class,handler)m来实现简单的动态代理     
        Hello hello = (Hello) Proxy.newProxyInstance(
            Hello.class.getClassLoader(), // 传入ClassLoader
            new Class[] { Hello.class }, // 传入要实现的接口
            handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
        /*
         * 动态代理实际上是JVM在运行期动态创建class字节码并加载的过程，
         * 把上面的动态代理改写为静态实现类大概长这样：
         * public class HelloDynamicProxy implements Hello {
         *     InvocationHandler handler;
         *     public HelloDynamicProxy(InvocationHandler handler) {
         *         this.handler = handler;
         *     }
         *     public void morning(String name) {
         *         handler.invoke(
         *                this,
         *               Hello.class.getMethod("morning", String.class),
         *                          new Object[] { name });
         *    }
         *  }
         */
	}
}
interface Hello {
    void morning(String name);
}