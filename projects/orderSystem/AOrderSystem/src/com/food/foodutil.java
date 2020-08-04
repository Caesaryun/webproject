package com.food;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.food.foodshow;

import com.denglu.sqldao;

public class foodutil {
	//public static ArrayList<foodshow> fw=new ArrayList<>();  //创建一个集合
	 //通过商家名称获取信息
	public static ArrayList<foodshow> getallfood(String hotelname){
	     Connection conn=null;
  	 Statement st=null;
  	 ResultSet rs=null;
  	 try {
  		
  		ArrayList<foodshow> fw=new ArrayList<>(); 
  		 conn=sqldao.getConnection();
  		 st=conn.createStatement();
  		 String sql="select*from food where hotelname='"+hotelname+"'";  //查询出所有的菜的信息  
  		 rs=st.executeQuery(sql);
  		 while(rs.next()) {
  			foodshow fs=new foodshow();
  			fs.setfoodid(rs.getInt(1));
  			fs.setfoodname(rs.getString(2));
  			fs.setfoodscore(rs.getString(3));
  			fs.setfoodprice(rs.getDouble(4));
  			fs.sethotelname(rs.getString(5));
  			fs.setimg(rs.getString(6));
  			fs.setfoodnum(rs.getString(7));
  			fs.setnumid(rs.getString(8));
  			System.out.println("输出菜的价格:"+fs.getfoodprice());
  			
  			fw.add(fs);
  		    
  			
  		   
  	   }
  		 return fw;
  	 }catch(SQLException e) {
  		 e.printStackTrace();
  	 }finally {
  		 sqldao.close(conn, st, rs);
  	 }
  	 return null;
   }
	
	//通过商家的名称获取商品信息
	
	
}
