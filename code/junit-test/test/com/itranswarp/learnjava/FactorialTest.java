package com.itranswarp.learnjava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class FactorialTest {

	@Test
	void testFact() {
		assertEquals(1, Factorial.fact(1));
		assertEquals(2, Factorial.fact(2));
		assertEquals(6, Factorial.fact(3));
		assertEquals(3628800, Factorial.fact(10));
		assertEquals(2432902008176640000L, Factorial.fact(20));
	}
	
	@Test
	void testNegative() {
//		assertThrows方法捕获异常，捕获i到通过测试（异常的类，和执行的代码）
		assertThrows(IllegalArgumentException.class, new Executable() {
	        @Override
	        public void execute() throws Throwable {
	            Factorial.fact(-555);
	        }
	    });
//		java8函数式编程
		  assertThrows(IllegalArgumentException.class, () -> {
		        Factorial.fact(-1);
		    });
	}

}
