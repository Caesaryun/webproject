package com.shopcz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Filter.mapmodel;
import com.denglu.sqldao;
import com.food.foodshow;

public class lookfoodcz {
	
	 //传入用户名然后得到店名，然后根据店名得到所有的菜品信息
	//页号，多少页，pagesize每一页的内数据多少条
	
	public static List<foodshow> getmanyfood(String username,String pno,String psize) {
		 int pageno=Integer.parseInt(pno);
		 int pagesize=Integer.parseInt(psize); //转换
		
		 PreparedStatement ps=null;
		 Connection conn=null;
		 
		 //Statement st=null;
		 
		 ResultSet rs=null;                       //一个店名可以被多个商家用户名拥有
		 try {                                       //每个商家用户名只能管理一个店名，可以申请多个管理员拥有该店名
			 ArrayList<foodshow> fsw=new ArrayList<>();
			 conn=sqldao.getConnection();
			// st=conn.createStatement();    //使用LIMIT进行操作即可
   String sql="select*from food where hotelname=(select hotelname from hotels where hotelboss='"+username+"') LIMIT ?,?";
             ps=conn.prepareStatement(sql);
   
             ps.setInt(1, (pageno-1)*pagesize);
             ps.setInt(2, pagesize);
             rs=ps.executeQuery();
             
			 while(rs.next()) {
				foodshow fw=new foodshow();
				fw.setfoodid(rs.getInt(1));
				fw.setfoodname(rs.getString(2));
				fw.setfoodscore(rs.getString(3));
				fw.setfoodprice(rs.getDouble(4));
				fw.sethotelname(rs.getString(5));
				fw.setimg(rs.getString(6));
				fw.setnumid(rs.getString(7));
			     
			    fw.setnumid(rs.getString(8));  //获取到numid
			    fw.setfoodcost(rs.getDouble(9));
			    fw.setpriceid(rs.getString(10));
			    fw.setcostid(rs.getString(11));
			    
				 fsw.add(fw);
				
			  }
			 return fsw;
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn, ps, rs);
		 }
		 return null;
	    }
	
	   
	 public static int getsize(String username) {
		 
		  Connection conn=null;
	    	 Statement st=null;
	    	 ResultSet rs=null;
	    	 int count=2;
	    	 try {
	    		
	    		
	    		 conn=sqldao.getConnection();
	    		 st=conn.createStatement();
	    		 String sql="SELECT COUNT(*) as totalsize  FROM food WHERE hotelname=(select hotelname from hotels where hotelboss='"+username+"')";  
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
	
	 public static mapmodel gethoteldetail(String username){
		   Connection conn=null;
			 Statement st=null;
			 ResultSet rs=null;
			 try {
				conn=sqldao.getConnection();
				 st=conn.createStatement();
				 String sql="select*from hotels where hotelboss='"+username+"'";   //通过foodid查询出所有的数据
				 rs=st.executeQuery(sql);
				 if(rs.next()) {
					mapmodel mls=new mapmodel();
					mls.sethotelid(rs.getInt(1));
				    mls.sethotelname(rs.getString(2));
				    mls.sethotelnumber(rs.getString(3));
				    mls.sethotelboss(rs.getString(4));
				    mls.sethoteladder(rs.getString(5));
				    mls.sethotelscore(rs.getString(6));
					mls.sethotelimg(rs.getString(7));
					mls.sethotelqsprice(rs.getDouble(8));
					mls.sethotelyunprice(rs.getDouble(9));
					mls.setpackprice(rs.getDouble(10));
					
					return mls;
				  }
				 
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }finally {
				 sqldao.close(conn, st, rs);
			 }
			 return null;
		     }
		  
	
}
