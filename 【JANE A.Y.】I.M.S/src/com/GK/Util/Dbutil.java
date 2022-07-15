package com.GK.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbutil {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_studnet?useUnicode=true&characterEncoding=utf8"; // 数据库连接地址
	// "jdbc:mysql://localhost:3306/自己定义的数据库名称?useUnicode=true&characterEncoding=utf8"
	private String dbUserName = "root"; // 用户名

	private String dbPassword = "exoweareone12MS"; // 密码（按需修改）

	private String jdbcName = "com.mysql.cj.jdbc.Driver"; // 驱动名称

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);// 验证密码
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public static void main(String[] args) {
		Dbutil dbUtil = new Dbutil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
