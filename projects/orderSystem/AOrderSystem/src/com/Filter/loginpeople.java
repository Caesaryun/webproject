package com.Filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.sqldao;

public class loginpeople {
           private String username;
           public void setusername(String username) {
        	   this.username=username;
           }
           public String getusername() {
        	   return username;
           }
           
           
           
           
}
class loginutil{
	
	public static List<loginpeople> getcustomer(){
		   Connection conn=null;
		  	 Statement st=null;
		  	 ResultSet rs=null;
		  	 try {
		  		
		  		 ArrayList<loginpeople> log=new ArrayList<>(); 
		  		 conn=sqldao.getConnection();
		  		 st=conn.createStatement();
		  		 String sql="select*from customer";   //通过地址查询所有的店
		  		 rs=st.executeQuery(sql);
		  		 while(rs.next()) {
		  			
		  		    loginpeople ls=new loginpeople();
		  		    ls.setusername(rs.getString(1));
		  		    log.add(ls);
		  		 }
		  		 return log;
		  	 }catch(SQLException e) {
		  		 e.printStackTrace();
		  	 }finally {
		  		 sqldao.close(conn, st, rs);
		  	 }
		  	 return null;
		   }
	public static List<loginpeople> getshoper(){
		   Connection conn=null;
		  	 Statement st=null;
		  	 ResultSet rs=null;
		  	 try {
		  		
		  		 ArrayList<loginpeople> log=new ArrayList<>(); 
		  		 conn=sqldao.getConnection();
		  		 st=conn.createStatement();
		  		 String sql="select*from shop";   //通过地址查询所有的店
		  		 rs=st.executeQuery(sql);
		  		 while(rs.next()) {
		  			
		  		    loginpeople ls=new loginpeople();
		  		    ls.setusername(rs.getString(1));
		  		    log.add(ls);
		  		 }
		  		 return log;
		  	 }catch(SQLException e) {
		  		 e.printStackTrace();
		  	 }finally {
		  		 sqldao.close(conn, st, rs);
		  	 }
		  	 return null;
		   }
}