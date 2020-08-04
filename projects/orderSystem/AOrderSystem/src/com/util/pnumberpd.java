package com.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.*;

/*
 * 实现传入电话号码然后与数据库进行匹配是否存在，若存在且返回相应的用户类型商家或客户
 * 且通过创建商家的时候进行数据库权限的锁定，比如一些表不能访问，一些功能没有权限等
 * 
 */
public class pnumberpd {
	     public static List<customer> getcustomerall(){
	     Connection conn=null;
  	 Statement st=null;
  	 ResultSet rs=null;
  	 try {
  		
  		 ArrayList<customer> cm=new ArrayList<>(); 
  		 conn=sqldao.getConnection();
  		 st=conn.createStatement();
  		 String sql="select*from customer";  //
  		 rs=st.executeQuery(sql);
  		 while(rs.next()) {
  			customer cr=new customer();
  			cr.setname(rs.getString(1));
  			cr.setpwd(rs.getString(2));
  			cr.setpnumber(rs.getString(3));
  			cr.setemail(rs.getString(4));  
  			cm.add(cr);
  	   }
  		 return cm ;
  	 }catch(SQLException e) {
  		 e.printStackTrace();
  	 }finally {
  		 sqldao.close(conn, st, rs);
  	 }
  	 return null;
      }
	     public static List<shop> getshopall(){
	  	     Connection conn=null;
	    	 Statement st=null;
	    	 ResultSet rs=null;
	    	 try {
	    		
	    		 ArrayList<shop> sp=new ArrayList<>(); 
	    		 conn=sqldao.getConnection();
	    		 st=conn.createStatement();
	    		 String sql="select*from shop";  
	    		 rs=st.executeQuery(sql);
	    		 while(rs.next()) {
	    			shop s=new shop();
	    			s.setusername(rs.getString(1));
	    			s.setpassword(rs.getString(2));
	    		    s.setpnumber(rs.getString(3));
	    		    s.setemail(rs.getString(4));
	    		    
	    			sp.add(s);
	    		   
	    	   }
	    		 return sp;
	    	 }catch(SQLException e) {
	    		 e.printStackTrace();
	    	 }finally {
	    		 sqldao.close(conn, st, rs);
	    	 }
	    	 return null;
	     }  
      public static String pnumbergetuser(String pnumber) {
    	     // System.out.print("执行了吗");
    	       StringBuffer sb=new StringBuffer();
    	       boolean cpd=false;
    	       for(int i=0;i<getcustomerall().size();i++) {
    	    	   customer cs=getcustomerall().get(i);
    	    	   if(cs.getpnumber().equals(pnumber)) {
    	    		   //说明存在该用户则给出存在信号
    	    		   cpd=true;
    	    		   sb.append("cnumbercz");   //客户电话号码存在
    	    	   }
    	       }
    	      //判断商家电话号码是否存在
    	      for(int i=0;i<getshopall().size();i++) {
    	    	  shop sx=getshopall().get(i);
    	    	  if(sx.getpnumber().equals(pnumber)) {
    	    		  cpd=true;   
    	    		  sb.append("shopncz");   //商家电话号码存在
    	    		  
    	    	  }
    	      }
    	      if(!cpd) {
    	    	  //如果都不存在
    	    	  sb.append("nonumber");   //都不存在
    	      }
    	      return sb.toString(); 
      }
}
