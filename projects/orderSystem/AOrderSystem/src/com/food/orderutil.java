package com.food;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Filter.mapmodel;
import com.denglu.sqldao;
import com.food.orderclass;
import com.denglu.customer;

public class orderutil {
	 
	
	  public static customer getdetailcustomer(String username) {
		  Connection conn=null;
			 Statement st=null;
			 ResultSet rs=null;
			 try {
				conn=sqldao.getConnection();
				 st=conn.createStatement();
				 String sql="select*from customer where username='"+username+"'";   //通过foodid查询出所有的数据
				 rs=st.executeQuery(sql);
				 if(rs.next()) {
					customer cs=new customer();
				   
					cs.setpnumber(rs.getString(3));   //查到电话号码
					 //System.out.println("输出菜品:"+fs.getfoodname());
					return cs;
				  }
				 
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }finally {
				 sqldao.close(conn, st, rs);
			 }
			 return null;
		     }
		  
	 
	  /*
	   *  通过用户名查询到地址且只查询到一个
	   */
	  public static adder getdetailadder(String username){
		     Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
		 try {
			conn=sqldao.getConnection();
			 st=conn.createStatement();
			 String sql="select*from adder where username='"+username+"'";   //通过foodid查询出所有的数据
			 
			 rs=st.executeQuery(sql);
			 if(rs.next()) {
				adder aer=new adder();
				
				aer.setusername(rs.getString(2));
				aer.setadder(rs.getString(3));
				
			    //System.out.println("输出菜品:"+fs.getfoodname());
				return aer;
			  }
			
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn, st, rs);
		 }
		 
		 return null;
	     }
	  
           /*
            *  首先得到foodid，及用户名，及foodnum 后
            */
	     /*
	      * 这是一个临时的订单管理，通过用户名查询到相应的订单信息
	      */
	     public static ArrayList<orderclass> orderzs=new ArrayList<>();  //建立一个公共的暂时的集合
	     public static String addorderzs(String foodid,int foodnum,String username) {
	    	 //通过foodid查询到 商家的运费，及包装费 
             mapmodel mol=shopcarmodel.getdetailhotel(foodid);  //得到hotel数据
		     double hotelyunprice=mol.gethotelyunprice();  //运费
		     double packprice=mol.getpackprice();         //包装费
		     
		     System.out.println("输出包装费用x:"+packprice);
		     
		     //通过foodid查询到菜品的详细信息，如价格等
		       foodshow fow=shopcarmodel.getdetailfood(foodid);  //得到菜品详细信息
			    String foodname=fow.getfoodname();  //得到名称
			    double foodprice=fow.getfoodprice();  
			    String hotelname=fow.gethotelname(); 
		     
			    System.out.println("xx:"+hotelname);
			    
			    //通过用户名查询到地址
			  //adder ader=getdetailadder(username);
			  //String dizhi=ader.getadder();
			  
			  
			    //通过用户名查到电话号码
			  customer cer=getdetailcustomer(username);
			  String phone=cer.getpnumber();
			  System.out.println("输出电话:"+phone);
			  
		     double sprice=foodprice*foodnum+hotelyunprice+packprice; //
		     System.out.println("总价:"+sprice);
		     
		     orderclass os=new orderclass();
		     os.sethotelname(hotelname);  //加入hotelname
		     os.setfoodname(foodname);
		     os.setfoodprice(foodprice);
		     os.setfoodnum(foodnum);
		     os.setpeisong(hotelyunprice); //配送费
		     os.setcustomername(username);
		     os.setphone(phone);
		     
		     os.setsumprice(sprice);  //总价格
		     os.setpackprice(packprice);
		     
		     orderzs.add(os);   //添加到暂时的集合中
		     
		     StringBuffer sb=new StringBuffer();
		     sb.append("addokorder");
		     
		     return  sb.toString();
	     }
	     /*
	      *         通过username取到暂时的订单（还未提交的订单）
	      */
	     
	     
	     
	     /*
	      *  先从orderzs集合中取出数据，放到一个新的集合中，再返回来即可
	      */
	     
	     
	 public static ArrayList<orderclass> getallorderzs(String username) {
		 System.out.println("这是new集合:"+username);
		   ArrayList<orderclass> orde=new ArrayList<>();
		      for(int i=0;i<orderzs.size();i++) {
		    	  orderclass ocs=orderzs.get(i);
		    	  if(ocs.getcustomer().equals(username)) {
		    		 orderclass oxs=new orderclass();
		    		 oxs.setcustomername(ocs.getcustomer()); 
		    		 oxs.setfoodname(ocs.getfoodname());
		    		 oxs.setfoodnum(ocs.getfoodnum());
		    		 oxs.setfoodprice(ocs.getfoodprice());
		    		 oxs.sethotelname(ocs.gethotelname());
		    		 oxs.setpackprice(ocs.getpackprice());
		    		 oxs.setpeisong(ocs.getpeisong());
		    		 oxs.setphone(ocs.getphone());
		    		 oxs.setsumprice(ocs.getsumprice());
		    		 
		    		 orde.add(oxs);
		    		
		    	  }
		      }
		      
		      return orde;
		      
	 }
	
}
