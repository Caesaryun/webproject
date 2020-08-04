package com.orderpack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Filter.hotelmany;
import com.Filter.mapmodel;
import com.denglu.sqldao;
import com.food.orderutil;
import com.shopcz.shopfactory;

import com.food.orderclass;
import com.food.adder;
import com.food.foodshow;

public class ordersubmit {
	//将订单插入数据库
	public static String insertorderdao(String username,String zsorderid,String adderid,String bz,String time,String canjunum) {
		 StringBuffer sb=new StringBuffer();
		 int zsaid=Integer.parseInt(zsorderid);  //暂时订单的id
		 
		 if("".equals(bz)) {
			 bz="没有备注";
		 }
		 String acceptorder="未接单";  //看到这然后决定是否接单条消息
		 
		 String hotelname=null;
		 String foodname=null;
		 double foodprice=0;
		 int foodnumber=0;
		 double peisongprice=0;
		 double sumprice=0;  //
		 double packprice=0;
		 
		 String location=null;  //地址 通过地址id查询到地址及phone
		 String phone=null;  //电话
		 String realname=null;  //真实的姓名，从地址表中得知
		 System.out.println("这是："+username);
		 System.out.println("zaorderid:"+zsaid);
		 for(int i=0;i<orderutil.getallorderzs(username).size();i++){
			
			   orderclass oxs=orderutil.getallorderzs(username).get(i);
			         if(zsaid==i){  //得到指定的订单id
			        	 System.out.println(i);
			        	 hotelname=oxs.gethotelname();
			        	 foodname=oxs.getfoodname();
			        	 foodprice=oxs.getfoodprice();
			        	 foodnumber=oxs.getfoodnum();
			        	 peisongprice=oxs.getpeisong();
			        	 sumprice=oxs.getsumprice();
			        	 packprice=oxs.getpackprice();
			          }
		          }
		  
		    System.out.println("暑促"+hotelname);
		    
	     	adder as=addermodel.getidadder(adderid);  //通过地址id获取到相应地址
		   
	     	location=as.getadder();
		    phone=as.getphone();
		    realname=as.getrealname();
		    System.out.println(location);
		    //System.out.println("真实姓名:"+realname);
		    
		    //System.out.println("备注："+bz);
		    mapmodel ml=hotelmany.gethotelphone(hotelname);  //通过hotelname查询相应的电话号码
		    String hotelphone=ml.gethotelnumber();  //商家的电话号码
		 
		  
		    
		    String acceptid=createnumid(); //得到一个numid;
	    	String refuseid=createnumid();  //得到一个随机priceid
	    	   
		    
		    
		    
		     Connection conn=null;
			 Statement st=null;
			 ResultSet rs=null;
			 try {
				 conn=sqldao.getConnection();
				 st=conn.createStatement();
			
				 //String sql="UPDATE customer SET password='"+pwd+"'WHERE phonenumber='"+pnumber+"'";
               //插入数据
               //String sql="insert into order(hotelname,foodname)values('"+hotelname+"','"+foodname+"')";
				String sql="INSERT INTO `order`(hotelname,foodname,foodprice,foodnumber,peisongprice,customername,customeradder,customernumber,sumprice,packprice,arrivetime,canjunum,beizhu,realname,acceptorder,hotelnumber,acceptid,refuseid)VALUES('"+hotelname+"','"+foodname+"','"+foodprice+"','"+foodnumber+"','"+peisongprice+"','"+username+"','"+location+"','"+phone+"','"+sumprice+"','"+packprice+"','"+time+"','"+canjunum+"','"+bz+"','"+realname+"','"+acceptorder+"','"+hotelphone+"','"+acceptid+"','"+refuseid+"')";
				
				 st.execute(sql);   //
				 sqldao.close(conn, st, rs);  //关闭数据库
				 sb.append(hotelname);  //返回hotelname通过hotelname查询到商家电话号码
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			
			 
		return sb.toString();
		
	}
       
	//顾客查询的订单 根据username查询出来即可
	
	public static List<orderclass>  getallorder(String username,String pageno,String pagesize){
		
		 int pageno1=Integer.parseInt(pageno);
		 int pagesize1=Integer.parseInt(pagesize); //转换
		 System.out.println("username:"+username);
		 PreparedStatement ps=null;
		 Connection conn=null;
		 
		 //Statement st=null;
		 
		 ResultSet rs=null;                       //一个店名可以被多个商家用户名拥有
		 try {                                       //每个商家用户名只能管理一个店名，可以申请多个管理员拥有该店名
			 ArrayList<orderclass> orders=new ArrayList<>();
			 conn=sqldao.getConnection();
			// st=conn.createStatement();    //使用LIMIT进行操作即可
       String sql="SELECT *FROM `order` where customername='"+username+"' LIMIT ?,?";
             ps=conn.prepareStatement(sql);
            
             ps.setInt(1, (pageno1-1)*pagesize1);
             ps.setInt(2, pagesize1);
            
             rs=ps.executeQuery();
             
			while(rs.next()) {
				orderclass os=new orderclass();
				
			    os.setorderid(rs.getInt(1));
			    os.sethotelname(rs.getString(2));
			    os.setfoodname(rs.getString(3));
			    os.setfoodprice(rs.getDouble(4));
			    os.setfoodnum(rs.getInt(5));
			    os.settime(rs.getTimestamp(6));
			    os.setpeisong(rs.getDouble(7));
			    os.setcustomername(rs.getString(8));
			    os.setadder(rs.getString(9));
			    os.setphone(rs.getString(10));
			    os.setsumprice(rs.getDouble(11));
			    os.setpackprice(rs.getDouble(12));
			    os.setarrivetime(rs.getString(13));
			    os.setcanjunum(rs.getString(14));
			    os.setbz(rs.getString(15));
			    os.setrealname(rs.getString(16));
				os.setacceporder(rs.getString(17));
				os.sethotelphone(rs.getString(18));
	            orders.add(os);  //			
			  }
			return  orders;
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn,ps, rs);
		 }
		 
		 return null;
	    }
	
	
	 public static int getgukeordersize(String username) {
		 System.out.println("username:xxxxx:"+username);
		 Connection conn=null;
    	 Statement st=null;
    	 ResultSet rs=null;
    	 int count=2;
    	 try {
    		
    		
    		 conn=sqldao.getConnection();
    		 st=conn.createStatement();
    		 String sql="SELECT COUNT(*) as totalsize FROM `order` WHERE customername='"+username+"'";  
    		 rs=st.executeQuery(sql);
    		 
    		 while(rs.next()) {
    			count=rs.getInt("totalsize");
    		  
    	   }
    		 return count;
    	 }catch(SQLException e) {
    		 e.printStackTrace();
    	 }finally {
    		 sqldao.close(conn, st, rs);
    	 }
    	 return -1;
	     }
	 
	
	
	    
	  public  static String createnumid() {
		    //产生随机的id然后查询表与之前从id进行比较，若相同则又只需随机id
		  String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000); 
		  String numid="axs"+verifyCode;
		  System.out.println(numid);
		  return numid;
	  }
	
	
	
}
