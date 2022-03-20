package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Throwable {
//		需要抛出异常时，尽量使用JDK已定义的异常类型。例如，参数检查不合法，应该抛出IllegalArgumentException
		
		String token = login("n", "password");
		
		System.out.println("Token: " + token);
	}

	static String login(String username, String password) throws Exception {
		if (username.equals("admin")) {
			if (password.equals("password")) {
				return "xxxxxx";
			} else {
				// 抛出LoginFailedException:
				throw new LoginFailedException("Bad username or password.");
			}
		} else {
			// 抛出UserNotFoundException:
			throw new UserNotFoundException("User not found.");
		}
	}
}
