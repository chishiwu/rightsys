package com.dfrz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDataBase {
	String driverClass="com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/ss?useUnicode=true&characterEncoding=utf-8";// 连接URL
	String user="root";
	String password="root";
	/**
	 * 获取连接
	 * @return
	 */
	public Connection getCon(){
		//1.获取连接
		Connection con=null;
		try {
			//0.驱动加载
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	/**
	 * 释放资源
	 * @param con
	 * @param stmt
	 * @param rs
	 */
	public void closeAll(Connection con,Statement stmt,ResultSet rs){
		try {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
