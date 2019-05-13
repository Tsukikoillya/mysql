package com.ace.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	public static String URL;//���ݿ��ַ
	public static String NAME;//�û���
	public static String PASSWORD;//����
	public static String DRIVER;//����
	
	public static ResourceBundle rb = ResourceBundle.getBundle("com.vab.jabc.db-config");//������Ϣ
	
	private DBUtils() {}
	
	//��̬����س���
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
	
	//�����ȡ���ݿ����ӵķ���
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, NAME, PASSWORD);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		return con;
	}
	
	/*
	 * �ر����ݿ�����
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
