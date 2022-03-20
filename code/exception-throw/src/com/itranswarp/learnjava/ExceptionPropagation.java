package com.itranswarp.learnjava;

public class ExceptionPropagation {
/*
 * 当某个方法抛出了异常时，
 * 如果当前方法没有捕获异常，
 * 异常就会被抛到上层调用方法，
 * 直到遇到某个try ... catch被捕获为止：
 * 
 */
	
	@SuppressWarnings("finally")
	public static void main(String[] args) throws Exception {
//        try {
//            process1();
//        } catch (Exception e) {
////        	通过printStackTrace()可以打印出方法的调用栈
//            e.printStackTrace();
//        }
//        
//		try {
//			
//			process1(null);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
////如果new Throwable(e).getCause()返回null，说明已经是“根异常”了。'	
//			System.out.println(new Throwable(e).getCause());
//			;
//			e.printStackTrace();
//			
//		}
		
		
		 Exception origin = null;
	        try {
	            System.out.println(Integer.parseInt("abc"));
	        } catch (Exception e) {
	            origin = e;
	            throw e;
	        } finally {
	            Exception e = new IllegalArgumentException();
	            if (origin != null) {
	                e.addSuppressed(origin);
	            }
	            throw e;
	        }
    }

    static void process1() {
        process2();
    }

    static void process2() {
        Integer.parseInt(null); // 会抛出NumberFormatException
    }
    
    /*
     * 当发生错误时，例如，用户输入了非法的字符，我们就可以抛出异常。

如何抛出异常？参考Integer.parseInt()方法，抛出异常分两步：

创建某个Exception的实例；
用throw语句抛出。
下面是一个例子：


    }
}
     */
    
    void process2(String s) {
        if (s==null) {
            NullPointerException e = new NullPointerException();
            throw e;
        	}
    }
 //  异常类型“转换”catch捕获异常,又抛出异常,则异常转换

    static    void process1(String s) {
        try {
            process21(s);
        } catch (NullPointerException e) {
//        	所以为了能定位,案发现场,将e传入抛出的异常中
            throw new IllegalArgumentException(e);
           
        }
    }

    static void process21(String s) {
        if (s==null) {
            throw new NullPointerException();
        }
    }
    /*
     * 异常屏蔽
如果在执行finally语句时抛出异常，那么，catch语句的异常还能否继续抛出？
 try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException(e);//该异常不会抛出
        } finally {
            System.out.println("finally");
            throw new IllegalArgumentException();
        }
        finall抛出异常,catch执行,catch中异常不会抛出,被屏蔽
        因为只能抛出一个异常
        
        
     */
    
    /*
     * 在极少数的情况下，
     * 我们需要获知所有的异常。
     * 如何保存所有的异常信息？
     * 方法是先用origin变量保存原始异常，
     * 然后调用Throwable.addSuppressed()，
     * 把原始异常添加进来，最后在finally抛出：
     */
}
