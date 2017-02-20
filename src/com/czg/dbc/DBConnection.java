package com.czg.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 实现对数据库的操作
 * */
public class DBConnection {
//  配置驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
//	数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/hrm?autoReconnect=true&useSSL=false";
//	用户名和密码
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";
	private Connection conn = null;
	
	public DBConnection(){
		try {
			Class.forName(DBDRIVER); //加载驱动
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPWD); //连接数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
//	关闭连接
	public void closeConnection(){
		if(this.conn != null){
			try {
				this.conn.close();
				this.conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		DBConnection d = new DBConnection();
		System.out.println(d.getConnection());
		d.closeConnection();
	}
}
