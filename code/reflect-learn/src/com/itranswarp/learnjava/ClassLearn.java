package com.itranswarp.learnjava;

public class ClassLearn {
/*
 * 除了int等基本类型外，Java的其他类型全部都是class（包括interface）。例如：

	String
	Object
	Runnable
	Exception
 */
	
	public static Object getClasses() {
//		class（包括interface）的本质是数据类型（Type）
		return new Object();
//		无继承关系的数据类型无法赋值
//		String s = new Integer("asaa");
//		class是由JVM在执行过程中动态加载的
//		JVM在第一次读取到一种class类型时，将其加载进内存
//		每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来。注意：这里的Class类型是一个名叫Class的class
		/*public final class Class<T> implements java.io.Serializable,
        GenericDeclaration,
        Type,
        AnnotatedElement,
        TypeDescriptor.OfField<Class<?>>,
        Constable {...}*/
	}
	
	
	public static Object getStringClass() {
		return null;
//		当JVM加载String类时，它首先读取String.class文件到内存，然后，为String类创建一个Class实例并关联起来
//		
//		由于CLass的构造方法私有化,则java程序无法使用new去创建该对象实例
		
//		而虚拟机内部实现了该构造方法Class type = new Class("");获取了class实例
		
		//		JVM持有的每个Class实例都指向一个数据类型（class或interface）
		
		/*
		 * private Class(ClassLoader loader, Class<?> arrayComponentType) {
        // Initialize final field for classLoader.  The initialization value of non-null
        // prevents future JIT optimizations from assuming this final field is null.
        classLoader = loader;
        componentType = arrayComponentType;
    }
		 */
	}
}