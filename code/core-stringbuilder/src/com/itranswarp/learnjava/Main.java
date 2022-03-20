package com.itranswarp.learnjava;



/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		String[] fields = { "name", "position", "salary" };
		String table = "employee";
		String insert = buildInsertSql2(table, fields);
		System.out.println(insert);
		System.out.println(
				"INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)".equals(insert) ? "测试成功" : "测试失败");
	}
	/**
	 * 
	 * @param table
	 * @param fields
	 * @return insertsql
	 */
	static String buildInsertSql(String table, String[]fields) {
		// TODO:声明一个StringBuilder，append
		StringBuilder stringBuilder = new StringBuilder("INSERT INTO ");
		
		return 	stringBuilder.append(table)
				.append(" (")
				.append(String.join(", ", fields))
				.append(") VALUES (?, ?, ?)")
				.toString();
	}
	
	/**
	 * 
	 * @param table
	 * @param fields
	 * @return
	 */
	static String buildInsertSql2(String table, String[]fields) {
		// TODO:声明一个StringBuilder，使用占位符，并用String的格式化方法
		StringBuilder stringBuilder = new StringBuilder("INSERT INTO %s (%s) VALUES (?, ?, ?)");
		
		return 	String.format(stringBuilder.toString(), table,String.join(", ",fields));
	}
	
	/**
	 * 
	 * @param table
	 * @param fields
	 * @return
	 */
	static String buildInsertSql3(String table, String[]fields) {
		// TODO:声明一个StringBuilder，使用占位符，并用String的格式化方法
		StringBuilder stringBuilder = new StringBuilder("INSERT INTO %s (%s) VALUES (?, ?, ?)");
		String sql = "";
		return 	sql.formatted(stringBuilder.toString(), table,String.join(", ",fields));
	}

}
