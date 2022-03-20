package com.itranswarp.learnjava;

public class BaseException extends RuntimeException {

	/**
	 * @serialField UID
	 */
	@java.io.Serial
	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

}
