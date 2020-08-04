package com.food;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Filter.mapmodel;
import com.denglu.sqldao;
import com.food.shopcar;

public class shopcarmodel {
	  /*
	   * 首先查询到所有的数据通过foodid
	   */
	  
	public static foodshow getdetailfood(String foodid){
	     Connection conn=null;
	 Statement st=null;
	 ResultSet rs=null;
	 try {
		
		 
		 conn=sqldao.getConnection();
		 st=conn.createStatement();
		 String sql="select*from food where foodid='"+foodid+"'";   //通过foodid查询出所有的数据
		 rs=st.executeQuery(sql);
		 if(rs.next()) {
			foodshow fs=new foodshow();
			fs.setfoodid(rs.getInt(1));
			fs.setfoodname(rs.getString(2));  //
			fs.setfoodscore(rs.getString(3));
			fs.setfoodprice(rs.getDouble(4));
			fs.sethotelname(rs.getString(5));
			fs.setimg(rs.getString(6));
		    //System.out.println("输出菜品:"+fs.getfoodname());
			return fs;
		     
			
		   
	   }
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 sqldao.close(conn, st, rs);
	 }
	 return null;
     }
	
	/*
	 * 通过foodid查询到hotelname然后通过hotelname查询到运费及配送费
	 */
	
  public static mapmodel getdetailhotel(String foodid){
	     Connection conn=null;
	 Statement st=null;
	 ResultSet rs=null;
	 try {
		
		 //通过foodid查询到相应的hotelname,再通过hotelname得到所有的信息，如配送费运费等，
		 conn=sqldao.getConnection();
		 st=conn.createStatement();
	String sql="select*from hotels where hotelname=(select hotelname from food where foodid='"+foodid+"')";   //通过foodid查询出所有的数据
		 rs=st.executeQuery(sql);
		 if(rs.next()) {
			mapmodel ml=new mapmodel();
			ml.sethotelyunprice(rs.getDouble(9));  //得到运费
            ml.setpackprice(rs.getDouble(10));  //得到包装费	
		    //System.out.println("输出菜品:"+fs.getfoodname());
            System.out.println("运费:"+ml.gethotelyunprice());
            return ml;
			
		    }
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 sqldao.close(conn, st, rs);
	 }
	 return null;
    }
	
	
	
	  //还应该通过foodid查询到相应商家的配送费用及其包装费用
	
	
	
	
	  //还有用户名相当于用户id
	   public static String addshopcar(String foodid,int foodnum,String username) {
		   /*
		    * 通过foodid查询到所有的数据然后进行添加
		    */
		    System.out.println("foodid:"+foodid);
		     mapmodel mol=getdetailhotel(foodid);  //得到hotel数据
		     
		     double hotelyunprice=mol.gethotelyunprice();  //运费
		     double packprice=mol.getpackprice();         //包装费
		     
		    foodshow fow=getdetailfood(foodid);  //得到菜品详细信息
		    String foodname=fow.getfoodname();  //得到名称
		    double foodprice=fow.getfoodprice();  
		    String hotelname=fow.gethotelname(); 
		    System.out.println("单价:"+foodprice);
		    
		    double totalprice=foodnum*foodprice+hotelyunprice+packprice;
		   
		    System.out.println("输出某件商品的总价钱："+totalprice);
		    
		    StringBuffer sb=new StringBuffer();
			 Connection conn=null;
			 Statement st=null;
			 ResultSet rs=null;
			 try {
				 conn=sqldao.getConnection();
				 st=conn.createStatement();
			
				 //String sql="UPDATE customer SET password='"+pwd+"'WHERE phonenumber='"+pnumber+"'";
                //插入数据
			      String sql="INSERT INTO shopcar(foodname,foodnum,foodprice,foodid,username,hotelname,totalprice,hotelyunprice,packprice)values('"+foodname+"','"+foodnum+"','"+foodprice+"','"+foodid+"','"+username+"'"
			      		+ ",'"+hotelname+"','"+totalprice+"','"+hotelyunprice+"','"+packprice+"')";
				 
				 st.execute(sql);   //
				 sqldao.close(conn, st, rs);  //关闭数据库
				 sb.append("addshopcarok");     //添加成功
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			 return sb.toString();
	}
	   
	   /*
	    * 通过用户名查询到所有的购物车信息
	    */
	   public static List<shopcar> getallshopcar(String username){
		   Connection conn=null;
			 Statement st=null;
			 ResultSet rs=null;
			 try {
				ArrayList<shopcar> scar=new ArrayList<>();
				 //通过foodid查询到相应的hotelname,再通过hotelname得到所有的信息，如配送费运费等，
				 conn=sqldao.getConnection();
				 st=conn.createStatement();
			String sql="select*from shopcar where username='"+username+"'";  
				 rs=st.executeQuery(sql);
				 while(rs.next()) {
					shopcar sr=new shopcar();
				    sr.setshopcarid(rs.getInt(1));
				    sr.setfoodname(rs.getString(2));
				    sr.setfoodnum(rs.getInt(3));
				    sr.setfoodprice(rs.getDouble(4));
				    sr.setusername(rs.getString(6));
                    sr.sethotelname(rs.getString(7));
                    sr.settoalprice(rs.getDouble(8));
                    sr.setyunprice(rs.getDouble(9));
                    sr.setpackprice(rs.getDouble(10));
                    scar.add(sr);
		            
					
				    }
				 return scar;
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }finally {
				 sqldao.close(conn, st, rs);
			 }
			 return null;
		    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
