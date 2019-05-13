package com.ace.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	public static String URL;//数据库地址
	public static String NAME;//用户名
	public static String PASSWORD;//密码
	public static String DRIVER;//驱动
	
	public static ResourceBundle rb = ResourceBundle.getBundle("com.vab.jabc.db-config");//配置信息
	
	private DBUtils() {}
	
	//静态块加载程序
	static {
		URL = rb.getString("jdbc.url");
		NAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
		DRIVER = rb.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//定义获取数据库连接的方法
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, NAME, PASSWORD);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
		return con;
	}
	
	/*
	 * 关闭数据库连接
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	
	public static void close(ResultSet rs,Statement stat,Connection conn) {
		try {
			if(rs!=null)rs.close();
			if(stat!=null)stat.close();
			if(conn!=null)conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stat,Connection conn) {
		try {
			if(stat!=null)stat.close();
			if(conn!=null)conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
