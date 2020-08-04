package com.registerbao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.denglu.sqldao;

public class registerlei {
	/*
	 * 因为注册用户只有客户才可以
	 * 因为该网站仅是个人商店所使用故而不对外进行商家注册
	 * 
	 */
          public static String  adduser(String username,String pwd,String pnumber,String email) {
        	  StringBuffer sb=new StringBuffer();
				 Connection conn=null;
				 Statement st=null;
				 ResultSet rs=null;
				 try {
					 conn=sqldao.getConnection();
					 st=conn.createStatement();
				
					 //String sql="UPDATE customer SET password='"+pwd+"'WHERE phonenumber='"+pnumber+"'";
                      //插入数据
					 String sql="INSERT INTO customer(username,password,phonenumber,email)values('"+username+"','"+pwd+"','"+pnumber+"','"+email+"')";
					
					 st.execute(sql);   //
					 sqldao.close(conn, st, rs);  //关闭数据库
					 sb.append("addok");     //添加成功
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
				 return sb.toString();
		}
          public static  String gethotelname() {
        	  String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        	  String hotelname="太白珍馐居"+verifyCode;
        	  System.out.println("taibxxxx:"+hotelname);
        	  return hotelname;
          }
          
          
          public static  String addshop(String username,String pwd,String pnumber,String email) {
        	  StringBuffer sb=new StringBuffer();
				 Connection conn=null;
				 Statement st=null;
				 ResultSet rs=null;
			    String hotelname=gethotelname();//随机生成一个店名后面再改
			    String hoteladder="开发区";
			    String hotelscore="5.0";
			    String hotelimg="2x.jpg";
			    double hotelqsprice=12;
			    double hotelyunprice=2;
			    double packprice=2;  //默认的
			    
				 try {
					 conn=sqldao.getConnection();
					 st=conn.createStatement();
				
					 //String sql="UPDATE customer SET password='"+pwd+"'WHERE phonenumber='"+pnumber+"'";
                      //插入数据
					 String sql="INSERT INTO shop(username,password,phonenumber,email)values('"+username+"','"+pwd+"','"+pnumber+"','"+email+"')";
					 
					 st.execute(sql);   //
					 sqldao.close(conn, st, rs);  //关闭数据库
					
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
				 
				 System.out.println("这是社！！！！");
				 
				 try {
				 
				 conn=sqldao.getConnection();
				 st=conn.createStatement();
				 String sql="INSERT INTO hotels(hotelname,hotelnumber,hotelboss,hoteladder,hotelscore,hotelimg,hotelqsprice,hotelyunprice,packprice)values('"+hotelname+"','"+pnumber+"','"+username+"','"+hoteladder+"','"+hotelscore+"','"+hotelimg+"','"+hotelqsprice+"','"+hotelyunprice+"','"+packprice+"')";
				
				 st.execute(sql);   //
				 sqldao.close(conn, st, rs);  //关闭数据库
			       sb.append("addshopok");
			   }catch(SQLException e) {
				 e.printStackTrace();
			    }
				  return sb.toString();
		}
          
           
          
          
          
}
