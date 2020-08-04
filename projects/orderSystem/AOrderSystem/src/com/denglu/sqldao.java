package com.denglu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sqldao {
	private static final String driver="com.mysql.cj.jdbc.Driver"; 
	private static final String URL="jdbc:mysql://localhost:3306/订餐管理系统?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai";
	
	//private static final String URL="jdbc:mysql://123.56.127.215:3306/订餐管理系统?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai";
	//private static final String driver="com.mysql.jdbc.Driver"; 
	//private static final String URL="jdbc:mysql://45.63.27.47:3306/订餐管理系统";
	
	
	//private static final String URL="jdbc:mysql://45.63.27.47:3306/testfirst";
	
	private static final String USERNAME="root";
	private static final String PASSWORD="123456";
	
	static{//静态块只执行一次，完成注册
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection conn, Statement st, ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(st!= null)
				st.close();
			if(conn!=null)
				conn.close();				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
