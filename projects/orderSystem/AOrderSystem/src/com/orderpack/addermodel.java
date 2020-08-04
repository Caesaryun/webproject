package com.orderpack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.denglu.sqldao;
import com.food.adder;
import com.food.orderclass;

public class addermodel {
	   /*
	  *    通过名称查询到其地址的详细信息
	  */
	public static ArrayList<adder> getdetailadder(String username){
		System.out.println("adder:name"+username);
	     Connection conn=null;
	 Statement st=null;
	 ResultSet rs=null;
	 try {
		conn=sqldao.getConnection();
		 st=conn.createStatement();
		 String sql="select*from adder where username='"+username+"'";   //通过foodid查询出所有的数据
		 ArrayList<adder> ad=new ArrayList<>();
		 
		 rs=st.executeQuery(sql);
		while(rs.next()) {
			adder aer=new adder();
			aer.setadderid(rs.getInt(1));  //获取地址id
			aer.setusername(rs.getString(2));
			aer.setadder(rs.getString(3));
			aer.setphone(rs.getString(4));
			aer.setrealname(rs.getString(5));
			
			System.out.println("dizhi:"+aer.getadder());
			System.out.println("真实名字:"+aer.getrealname());
			ad.add(aer);
		    //System.out.println("输出菜品:"+fs.getfoodname());
			
		  }
		return ad;
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 sqldao.close(conn, st, rs);
	 }
	 
	 return null;
    }
	
	
   /*
    * 就写关于添加地址的的方法通过username进行添加
    * 
    */
	
	public static String  addadder(String usernameid,String adder,String phone,String realname) {
		 
		  Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
		 StringBuffer sb=new StringBuffer();
		 
		 
		 try {
			 conn=sqldao.getConnection();
			 st=conn.createStatement();
		
			 //String sql="UPDATE customer SET password='"+pwd+"'WHERE phonenumber='"+pnumber+"'";
            //插入数据
			 //插入地址
		      String sql="INSERT INTO adder(username,location,phone,name)values('"+usernameid+"','"+adder+"','"+phone+"','"+realname+"')";
			  st.execute(sql);   //
			 sqldao.close(conn, st, rs);  //关闭数据库
			 sb.append("addadderok");     //添加成功
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return sb.toString();
          }
	
	/*
	 * 通过地址id得到相应的信息,因为一个用户可以拥有多个地址，故而通过id获取相应的地址
	 */
	public static adder getidadder(String adderid) {
		     Connection conn=null;
			 Statement st=null;
			 ResultSet rs=null;
			 try {
				conn=sqldao.getConnection();
				 st=conn.createStatement();
				 String sql="select*from adder where adderid='"+adderid+"'";   //通过foodid查询出所有的数据
				 
				 rs=st.executeQuery(sql);
				 if(rs.next()) {
					adder aer=new adder();
					
					aer.setusername(rs.getString(2));
					aer.setadder(rs.getString(3));
					aer.setphone(rs.getString(4));
					aer.setrealname(rs.getString(5));
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
	
	
}
