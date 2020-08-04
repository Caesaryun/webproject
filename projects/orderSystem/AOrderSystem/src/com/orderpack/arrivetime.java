package com.orderpack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.denglu.sqldao;

public class arrivetime {
           private String arriveid;  //到达时间id
           private String atime;  //到达时间区间
           public  arrivetime(String id,String time) {
        	   this.arriveid=id;
        	   this.atime=time;
           }
           public arrivetime() {
        	   
           }
           public void setarriveid(String id) {
        	   this.arriveid=id;
           }
           public String getarriveid() {
        	   return arriveid;
           }
           public void setatime(String atime) {
        	   this.atime=atime;
           }
           public String gettime() {
        	   return atime;
           }
}
class arrivetimeutil{
	  public static arrivetime getatime(String arriveid) {
		 	 Connection conn=null;
				 Statement st=null;
				 ResultSet rs=null;
						 
				 
				 try {
					 conn=sqldao.getConnection();
					 st=conn.createStatement();
				     String sql="select *from arrive_time where arrivetimeid='"+arriveid+"'";
				     rs=st.executeQuery(sql);
				     System.out.println("输出到达时间id："+arriveid);	
					 if(rs.next()) {
				          arrivetime am=new arrivetime();
				          am.setatime(rs.getString(2));
				          return am;
				          
					  }
					 sqldao.close(conn, st, rs);  //关闭数据库
					    
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
				return null;
		       }
}
