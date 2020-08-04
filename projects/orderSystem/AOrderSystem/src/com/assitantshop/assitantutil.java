package com.assitantshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.customer;
import com.denglu.sqldao;
import com.food.orderclass;

interface assitantcz{
	public List<assitant> getassitant();
	public String login(String username,String password);   //登录验证的方法
	public List<orderclass> getorderdetail(String username,String pageno,String pagesize);
	 //这个username找到hotelname
	public int getsize(String username);
	public void changeaccept(String orderid,String orderstate);
}
public class assitantutil implements assitantcz {
	
	 public void changeaccept(String orderid,String orderstate) {
		  
	     Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
		 
		 try {
			 conn=sqldao.getConnection();//
			 st=conn.createStatement();
			 String sql="UPDATE `order` SET acceptorder='"+orderstate+"' WHERE orderid='"+orderid+"'";
			 st.executeUpdate(sql);
			}catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn, st, rs);
		 } 
	  
  }
	
	 public int getsize(String username) {
		 System.out.println("username:xxxxx:"+username);
		 Connection conn=null;
    	 Statement st=null;
    	 ResultSet rs=null;
    	 int count=2;
    	 try {
    		
    		
    		 conn=sqldao.getConnection();
    		 st=conn.createStatement();
    		 String sql="SELECT COUNT(*) as totalsize FROM `order` WHERE ordertime>=(NOW()-INTERVAL 24 HOUR) AND  acceptorder='未接单' AND  hotelname=(SELECT hotelname FROM shopassitant WHERE username='"+username+"')";  
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
	 
	
	public List<orderclass> getorderdetail(String username,String pageno,String pagesize){
		 ArrayList<orderclass> os=new ArrayList<>();
		 int pageno1=Integer.parseInt(pageno);
		 int pagesize1=Integer.parseInt(pagesize); //转换
		 System.out.println("username:"+username);
		 PreparedStatement ps=null;
		 Connection conn=null;
		 
		 //Statement st=null;
		 
		 ResultSet rs=null;                       //一个店名可以被多个商家用户名拥有
		 try {                                       //每个商家用户名只能管理一个店名，可以申请多个管理员拥有该店名
			 ArrayList<orderclass> ocls=new ArrayList<>();
			 conn=sqldao.getConnection();
			// st=conn.createStatement();    //使用LIMIT进行操作即可
  String sql="SELECT*FROM `order` WHERE  ordertime>=(NOW()-INTERVAL 24 HOUR) AND  acceptorder='未接单' AND hotelname=(SELECT hotelname FROM shopassitant WHERE username='"+username+"') LIMIT ?,?";
            ps=conn.prepareStatement(sql);
             System.out.println("ok!xxxxx");
            ps.setInt(1, (pageno1-1)*pagesize1);
            ps.setInt(2, pagesize1);
           
            rs=ps.executeQuery();
            
			 while(rs.next()) {
				orderclass ors=new orderclass();
			    ors.setorderid(rs.getInt(1));
			    System.out.print("idxxx"+ors.getorderid());
			    ors.sethotelname(rs.getString(2));
			    ors.setfoodname(rs.getString(3));
			    ors.setfoodprice(rs.getDouble(4));
			    ors.setfoodnum(rs.getInt(5));
			    ors.settime(rs.getTimestamp(6));
               ors.setpeisong(rs.getDouble(7));
               ors.setcustomername(rs.getString(8));
               ors.setadder(rs.getString(9));
               ors.setphone(rs.getString(10));
               ors.setsumprice(rs.getDouble(11));
               ors.setpackprice(rs.getDouble(12));
               ors.setarrivetime(rs.getString(13));
               ors.setcanjunum(rs.getString(14));
               ors.setbz(rs.getString(15));
               ors.setrealname(rs.getString(16));
               ors.setacceporder(rs.getString(17));  //
               ors.sethotelname(rs.getString(18));
               ors.setacceptid(rs.getString(19));
               ors.setrefuseid(rs.getString(20));
               ocls.add(ors);
               
			 }
			 return ocls;
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn, ps, rs);
		 }
		 return null;
	    }
	
	
	
	
	
	public List<assitant>  getassitant(){
		 Connection conn=null;
	   	 Statement st=null;
	   	 ResultSet rs=null;
	   	 try {
	   		
	   		 ArrayList<assitant> at=new ArrayList<>(); 
	   		 conn=sqldao.getConnection();
	   		 st=conn.createStatement();
	   		 String sql="select*from shopassitant";  //
	   		 rs=st.executeQuery(sql);
	   		 while(rs.next()) {
	   			assitant cr=new assitant();
	   			cr.setusername(rs.getString(1));
	   			cr.setpassword(rs.getString(2));
	   			at.add(cr);
	   	   }
	   		 return at;
	   	 }catch(SQLException e) {
	   		 e.printStackTrace();
	   	 }finally {
	   		 sqldao.close(conn, st, rs);
	   	 }
	   	    return null;
	}
	
	
    public  String login(String username,String password) {
    	System.out.println(password);
    	StringBuffer sb=new StringBuffer();
    	   for(int i=0;i<getassitant().size();i++) {
    		   assitant as=getassitant().get(i);
    		  
    		   if(as.getusername().equals(username)&&as.getpassword().equals(password)){
    			  System.out.println("ok!!");
    			  sb.append("ok");
    		   }
    	   }
    	   return sb.toString();
    }
   
}
