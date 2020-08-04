package com.orderpack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.denglu.sqldao;

public class canjuutil{
    //通过餐具id查询到相应的餐具数量
    public static canjunum getcanjunum(String canjuid) {
 	 Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
				 
		 
		 try {
			 conn=sqldao.getConnection();
			 st=conn.createStatement();
		     String sql="select *from canju_num where canjuid='"+canjuid+"'";
		     rs=st.executeQuery(sql);
		     System.out.println("输出餐具id："+canjuid);	
			 if(rs.next()) {
		          canjunum cj=new canjunum();
		          cj.setcanjunum(rs.getString(2));
		          return cj;
			  }
			 sqldao.close(conn, st, rs);  //关闭数据库
			    
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		return null;
       }
  
}

