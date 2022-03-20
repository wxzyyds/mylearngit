package com.itranswarp.learnjava;

public class UserNotFoundException extends BaseException {
	@java.io.Serial
	private static final long serialVersionUID = 6027056797426145875L;
	private static final String userNotFoundException = "UserNotFoundException";
	public UserNotFoundException() {
		this(userNotFoundException);
	}
	public UserNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

}
