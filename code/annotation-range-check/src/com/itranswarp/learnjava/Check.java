package com.itranswarp.learnjava;

public @interface Check {

	int min() default 0;

	int max() default 0;

	int value() default 0;

}
