package com.Filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.sqldao;

public class hotelmany {
	
	public static List<mapmodel> getall(String hoteladder){
	     Connection conn=null;
  	 Statement st=null;
  	 ResultSet rs=null;
  	 try {
  		
  		 ArrayList<mapmodel> ml=new ArrayList<>(); 
  		 conn=sqldao.getConnection();
  		 st=conn.createStatement();
  		 String sql="select*from hotels where hoteladder='"+hoteladder+"'";   //通过地址查询所有的店
  		 rs=st.executeQuery(sql);
  		 while(rs.next()) {
  			mapmodel m=new mapmodel();
  			m.sethotelid(rs.getInt(1));
  			m.sethotelname(rs.getString(2));
  			m.sethotelnumber(rs.getString(3));
  			m.sethotelboss(rs.getString(4));
  			m.sethoteladder(rs.getString(5));
  			m.sethotelscore(rs.getString(6));
  			m.sethotelimg(rs.getString(7));
  		    m.sethotelqsprice(rs.getDouble(8));
  		    m.sethotelyunprice(rs.getDouble(9));
  		    m.setpackprice(rs.getDouble(10));
  		    
  		    ml.add(m);   //添加到集合中
  			
  		   
  	   }
  		 return ml;
  	 }catch(SQLException e) {
  		 e.printStackTrace();
  	 }finally {
  		 sqldao.close(conn, st, rs);
  	 }
  	 return null;
   }
	
	
  // 根据商铺的id获取详细信息
	public static mapmodel getdetailhotel(String hotelid){
	     Connection conn=null;
 	 Statement st=null;
 	 ResultSet rs=null;
 	 try {
 		
 		 ArrayList<mapmodel> ml=new ArrayList<>(); 
 		 conn=sqldao.getConnection();
 		 st=conn.createStatement();
 		 String sql="select*from hotels where hotelid='"+hotelid+"'";   //通过地址查询所有的店
 		 rs=st.executeQuery(sql);
 		 if(rs.next()) {
 			mapmodel m=new mapmodel();
 			m.sethotelid(rs.getInt(1));
 			m.sethotelname(rs.getString(2));
 			m.sethotelnumber(rs.getString(3));
 			m.sethotelboss(rs.getString(4));
 			m.sethoteladder(rs.getString(5));
 			m.sethotelscore(rs.getString(6));
 			m.sethotelimg(rs.getString(7));
 			m.sethotelqsprice(rs.getDouble(8));
 			m.sethotelyunprice(rs.getDouble(9));
 			m.setpackprice(rs.getDouble(10));
 			
 			System.out.println("输出配送价格:"+m.gethotelyunprice());
 			
 			System.out.println("输出boss："+m.gethotelboss());
 			return m;
 		     //添加到集合中
 			
 		   
 	   }
 		 
 	 }catch(SQLException e) {
 		 e.printStackTrace();
 	 }finally {
 		 sqldao.close(conn, st, rs);
 	 }
 	 return null;
  }
	
	/*
	 * 通过hotelname获取到相应的电话号码及相应的商家名称
	 */
	
	public static mapmodel gethotelphone(String hotelname){
	     Connection conn=null;
	 Statement st=null;
	 ResultSet rs=null;
	 try {
		
		
		 conn=sqldao.getConnection();
		 st=conn.createStatement();
		 String sql="select*from hotels where hotelname='"+hotelname+"'";   //通过地址查询所有的店
		 rs=st.executeQuery(sql);
		 if(rs.next()) {
			mapmodel m=new mapmodel();
			m.sethotelnumber(rs.getString(3));  //查询到相应的电话号码
			m.sethotelboss(rs.getString(4));  //查询到商家名称
	        return m;
		    }
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 sqldao.close(conn, st, rs);
	 }
	 return null;
 }
	
	
	
	 
}
