package com.Filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.shop;
import com.denglu.sqldao;

public class mapmodel {
	private int hotelid;  //饭店的id
    private String hotelname;  //饭店名称
    private String hotelnumber;  //饭店电话
    private String hotelboss;  //饭店老板的用户名且是唯一的
    private String hotelscore;  //饭店评分
    private String hoteladder;  //饭店地址
    private String hotelimg;    //饭店的图片
    private double hotelqsprice;   //饭店起送价格
    private double hotelyunprice;   //饭店的配送价格
    private double packprice;    //包装费
    
	public mapmodel(int hotelid,String hotelname,String hotelnumber,String hotelboss,String hotelscore,String hoteladder,String hotelimg,double hotelqsprice,double hotelyunprice,double packprice) {
		this.hotelname=hotelname;
		this.hotelnumber=hotelnumber;
		this.hotelboss=hotelboss;
		this.hoteladder=hoteladder;
		this.hotelid=hotelid;
		this.hotelscore=hotelscore;
		this.hotelimg=hotelimg;
		this.hotelqsprice=hotelqsprice;
		this.hotelyunprice=hotelyunprice;
		this.packprice=packprice;
	}
	public mapmodel() {
		
	}
	public void setpackprice(double packprice) {
		this.packprice=packprice;
	}
	public double getpackprice() {
		return packprice;
	}
	
	public void sethotelyunprice(double hotelyunprice) {
		this.hotelyunprice=hotelyunprice;
	}
	public double gethotelyunprice() {
		return hotelyunprice;
	}
	public void sethotelqsprice(double hotelqsprice) {
		this.hotelqsprice=hotelqsprice;
	}
	public double gethotelqsprice() {
		return hotelqsprice;
	}
	public void sethotelid(int id) {
		this.hotelid=id;
	}
	public int gethotelid() {
		return hotelid;
	}
	public void sethotelscore(String hotelscore) {
		this.hotelscore=hotelscore;
	}
	public String gethotelscore() {
		return hotelscore;
	}
	public void sethotelimg(String hotelimg) {
		this.hotelimg=hotelimg;
	}
	public String gethotelimg() {
		return hotelimg;
	}
	public void sethotelname(String name) {
		this.hotelname=name;
	}
	public String gethotelname() {
		return hotelname;
	}
	public void sethotelnumber(String hotelnumber) {
		this.hotelnumber=hotelnumber;
	}
	public String gethotelnumber()
	{
		return hotelnumber;
	}
	public void sethotelboss(String boss) {
		this.hotelboss=boss;
	}
	public String gethotelboss() {
		return hotelboss;
	}
	public void sethoteladder(String hoteladder) {
		this.hoteladder=hoteladder;
		
	}
	
	public String gethoteladder() {
		return hoteladder;
	}
	
	
}


/*
class mapdw{
	   //通过地址关键字查询店家
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
	 */
	 
/*	public static String searchhotel(String mapname) { //通过地址查询到店名，然后给出店名
		   
		   StringBuffer sb=new StringBuffer();
		  
		   
		    for(int i=0;i<getall().size();i++) {
			       mapmodel mp=getall().get(i);
			      if(mp.gethoteladder().equals(mapname)) {
			    	  //得到店的名称然后输出到新的页面
			    	 sb.append(mp.gethotelname()+".");
			      }
		    	}
		   return sb.toString();
	}
	
	  
	
	
	
}
*/



