package com.itranswarp.learnjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	static Calculator calculator;

	@BeforeAll
	public static void initCalculator() {
		calculator = new Calculator();
	}

	@BeforeEach // 初始化代码
	public void setUp() {
		this.calculator = new Calculator();
	}

	@AfterEach // 清理资源
	public void tearDown() {
		this.calculator = null;
	}

	@AfterAll
	public static void dropCalculator() {

	}

	@Test // @BeforeEach和@AfterEach会“环绕”在每个@Test方法前后。
	void testAdd() {
		assertEquals(100, this.calculator.add(100));
		assertEquals(150, this.calculator.add(50));
		assertEquals(130, this.calculator.add(-20));
	}

	@Test // @BeforeEach和@AfterEach会“环绕”在每个@Test方法前后。
	void testSub() {
		assertEquals(-100, this.calculator.sub(100));
		assertEquals(-150, this.calculator.sub(50));
		assertEquals(-130, this.calculator.sub(-20));
	}
	/**
	 * invokeBeforeAll(CalculatorTest.class); for (Method testMethod :
	 * findTestMethods(CalculatorTest.class)) { var test = new CalculatorTest(); //
	 * 创建Test实例 invokeBeforeEach(test); invokeTestMethod(test, testMethod);
	 * invokeAfterEach(test); } invokeAfterAll(CalculatorTest.class);
	 */
}
