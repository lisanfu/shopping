package com.ay.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnDB {
	private static final String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8";
	private static final String driver = "com.mysql.jdbc.Driver";
	/**
	 * 获取连接方法
	 * 
	 * */
	public static Connection getConn()
	{
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","lifuyuan");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	/**关闭连接
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn)
	{
		try {
			if(rs != null)
			{
				rs.close();
			}
			if(stmt != null)
			{
				stmt.close();
			}
			if(conn != null)
			{
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
