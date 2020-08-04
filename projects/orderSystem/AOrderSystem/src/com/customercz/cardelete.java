package com.customercz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.customer;
import com.denglu.sqldao;
import com.food.shopcar;

public class cardelete {
	
          public static String delshopcar(String id) {
        	 Connection conn=null;
 			 Statement st=null;
 			 ResultSet rs=null;
 			 try {
 				
 				 conn=sqldao.getConnection();
 				 st=conn.createStatement();
 			     String sql="delete from shopcar where shopcarid='"+id+"'";  
 				 st.executeUpdate(sql);
 			     StringBuffer sb=new StringBuffer();
 			     sb.append("delok");
 			     return sb.toString();
 			 }catch(SQLException e) {
 				 e.printStackTrace();
 			 }finally {
 				 sqldao.close(conn, st, rs);
 			 }
 			 return null;
 		    }
 	   
          public static String delorder(String id) {
        	 int orderid=Integer.parseInt(id);
        	 
         	 Connection conn=null;
  			 Statement st=null;
  			 ResultSet rs=null;
  			 try {
  				
  				 conn=sqldao.getConnection();
  				 st=conn.createStatement();
  			     String sql="DELETE FROM `order` WHERE orderid='"+orderid+"'";  
  			     
  				 st.executeUpdate(sql);
  				System.out.println(orderid);
  			     StringBuffer sb=new StringBuffer();
  			     sb.append("delok");
  			     return sb.toString();
  			 }catch(SQLException e) {
  				 e.printStackTrace();
  			 }finally {
  				 sqldao.close(conn, st, rs);
  			 }
  			 return null;
  		    }
  	   
         public static detailcustomer  getdetailgk(String username){
        	 Connection conn=null;
           	 Statement st=null;
           	 ResultSet rs=null;
           	 try {
           		
           		 ArrayList<detailcustomer> der=new ArrayList<>(); 
           		 conn=sqldao.getConnection();
           		 st=conn.createStatement();
           		 String sql="SELECT * FROM adder a,customer c WHERE a.username=c.username AND a.username='"+username+"'";  //
           		 rs=st.executeQuery(sql);
           		 
           		 if(rs.next()) {
           			detailcustomer ds=new detailcustomer();
           			ds.setusername(rs.getString("username"));
           			ds.setemail(rs.getString("email"));
           			ds.setlocation(rs.getString("location"));
           			ds.setphone(rs.getString("phonenumber"));
           			ds.setrealname(rs.getString("name"));
           			return ds;
           			
           	   }
           		
           	 }catch(SQLException e) {
           		 e.printStackTrace();
           	 }finally {
           		 sqldao.close(conn, st, rs);
           	 }
           	 return null;
            }
         
       public static void  changegkid(String username,String realname,String phone,String email) {
    	   Connection conn=null;
  		 Statement st=null;
  		 ResultSet rs=null;
  		
  		 try {
  			 conn=sqldao.getConnection();//
  			 st=conn.createStatement();
  			 String sql="UPDATE customer SET phonenumber='"+phone+"',email='"+email+"'";
  			 st.executeUpdate(sql);
  			}catch(SQLException e) {
  			 e.printStackTrace();
  		 }finally {
  			 sqldao.close(conn, st, rs);
  		 } 
  		 
  		 try {
  			 conn=sqldao.getConnection();//
  			 st=conn.createStatement();
  			 String sql="UPDATE adder SET phone='"+phone+"',name='"+realname+"' where username='"+username+"'";
  			 st.executeUpdate(sql);
  			}catch(SQLException e) {
  			 e.printStackTrace();
  		 }finally {
  			 sqldao.close(conn, st, rs);
  		 } 
  		 
  		 
  		 
  	 
       }
        	  
          
}
