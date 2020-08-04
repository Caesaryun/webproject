package com.food;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.shop;
import com.denglu.sqldao;

public class foodshow {
	     private int foodid;  //食物的id键 唯一值
         private String foodname;  //菜的名称
         private String foodscore;  //菜的评分
         private double foodprice;  //菜的价格
         private String hotelname;  //属于那家商家
         private String imglocation;  //图片地址
         private String foodnum;         //食物选择的数量为了后面的购物车及订单服务
         private String numid;    //数量的id唯一标号也可以成为name的id号
         private double foodcost;  //成本
         
         private String priceid;  //价格的id
         private String costid;  //成本的id标识
         
         public void setpriceid(String priceid) {
        	 this.priceid=priceid;
         }
         public String getpriceid() {
        	 return priceid;
         }
         public void setcostid(String costid) {
        	 this.costid=costid;
         }
         public String getcostid() {
        	 return costid;
         }
         
         public void setfoodcost(double foodcost) {
        	 this.foodcost=foodcost;
         }
         public double getfoodcost() {
        	 return foodcost;
         }
         
         public foodshow(int foodid,String foodname,String foodscore,double foodprice,String hotelname,String imglocation) {
        	 this.foodid=foodid;
        	 this.foodname=foodname;
        	 this.foodscore=foodscore;
        	 this.foodprice=foodprice;
        	 this.hotelname=hotelname;
        	 this.imglocation=imglocation;
         }
         public foodshow() {
        	 
         }
         public void setnumid(String numid) {
        	 this.numid=numid;
         }
         public String getnumid() {
        	 return numid;
         }
         
         public void setfoodnum(String foodnum) {
        	 this.foodnum=foodnum;
         }
         public String getfoodnum() {
        	 return foodnum;
         }
         
         public void setfoodid(int id) {
        	 this.foodid=id;
         }
         public int getfoodid() {
        	 return foodid;
         }
         
         public void setimg(String img) {
        	 this.imglocation=img;
        }
         public String getimg() {
        	 return imglocation;
         }
         
         public void setfoodname(String foodname) {
        	 this.foodname=foodname;
         }
         public String getfoodname() {
        	 return foodname;
         }
         public void setfoodscore(String foodscore) {
        	 this.foodscore=foodscore;
         }
         public String getfoodscore() {
        	 return foodscore;
         }
         public void setfoodprice(double foodprice) {
        	 this.foodprice=foodprice;
         }
         public double getfoodprice() {
        	 return foodprice;
         }
         public void sethotelname(String hotelname) {
        	 this.hotelname=hotelname;
         }
         public String gethotelname() {
        	 return hotelname;
         }
}
/*
 * 通过商家的名字进行查询出所有的菜品
 */




/*class zsfood{
	
	public static ArrayList<foodshow> fw=new ArrayList<>();  //创建一个集合
	 //通过商家名称获取信息
	public static List<foodshow> getallfood(String hotelname){
 	     Connection conn=null;
   	 Statement st=null;
   	 ResultSet rs=null;
   	 try {
   		
   		// ArrayList<foodshow> fw=new ArrayList<>(); 
   		 conn=sqldao.getConnection();
   		 st=conn.createStatement();
   		 String sql="select*from foods where hotelname="+hotelname;  //查询出所有的菜的信息  
   		 rs=st.executeQuery(sql);
   		 while(rs.next()) {
   			foodshow fs=new foodshow();
   			fs.setfoodname(rs.getString(1));
   			fs.setfoodscore(rs.getString(2));
   			fs.setfoodprice(rs.getString(3));
   			fs.sethotelname(rs.getString(4));
   			
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
	
	
	
	
	
	
} */
