package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.customer;
import com.denglu.sqldao;

public class changepwd {
	
        
}

/*
 * 修改密码的接口 
 * 因为第一次通过获取验证码的时候得到了用户的类型然后再传递用户类型过来
 * 直接送入需要修改密码的用户类型即可 
 */
interface changepassword{  
	public String changemima(String pnumber,String pwd);
}
/*
 * 顾客实现该接口修改密码
 */
class gukepwdchange implements changepassword{
	 
	   public String changemima(String pnumber,String pwd) {
		       StringBuffer sb=new StringBuffer();
				 Connection conn=null;
				 Statement st=null;
				 ResultSet rs=null;
				 try {
					 conn=sqldao.getConnection();
					 st=conn.createStatement();
					// String sqx="update flower set num='"+huanum+"' where name='"+o.gethuaname()+"'";	   
					 String sql="UPDATE customer SET password='"+pwd+"'WHERE phonenumber='"+pnumber+"'";
					 st.execute(sql);   //
					 sqldao.close(conn, st, rs);  //关闭数据库
					 sb.append("changeok");  //修改成功
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
				 return sb.toString();
		}
		 
	 }
	 
	 
class shopchangepwd implements  changepassword{
	  public String changemima(String pnumber,String pwd) {
		  StringBuffer sb=new StringBuffer();
			 Connection conn=null;
			 Statement st=null;
			 ResultSet rs=null;
			 try {
				 conn=sqldao.getConnection();
				 st=conn.createStatement();
				// String sqx="update flower set num='"+huanum+"' where name='"+o.gethuaname()+"'";	
			 String sql="UPDATE shop SET password='"+pwd+"'WHERE phonenumber='"+pnumber+"'";
				// String sql="update shop set password='"+pwd+"'where phonenumber='"+pnumber+"'";
				 st.execute(sql);   //
				 sqldao.close(conn, st, rs);  //关闭数据库
				 sb.append("changeok");  //修改成功
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			 return sb.toString();
	}
	 
	  
}


