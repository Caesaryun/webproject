package com.denglu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.denglu.sqldao;
import com.denglu.shop;

import com.denglu.customer;

public class signwork {
       
}
/*
 * 不论客户或者商家都满足人这个对象
 * 故而可以得到一个接口其中包含登录方法
 * 
 */


interface people{
	public  String signin(String x,String y);  
	
}


/*
 * 商家实现的接口
 * 
 * 
 */
 

class shopVerification  implements people{  
	
	public static List<shop> getall(){
  	     Connection conn=null;
    	 Statement st=null;
    	 ResultSet rs=null;
    	 try {
    		
    		 ArrayList<shop> sp=new ArrayList<>(); 
    		 conn=sqldao.getConnection();
    		 st=conn.createStatement();
    		 String sql="select*from shop";  
    		 rs=st.executeQuery(sql);
    		 while(rs.next()) {
    			shop s=new shop();
    			s.setusername(rs.getString(1));
    			s.setpassword(rs.getString(2));
    		    s.setpnumber(rs.getString(3));
    		    s.setemail(rs.getString(4));
    		    
    			sp.add(s);
    		   
    	   }
    		 return sp;
    	 }catch(SQLException e) {
    		 e.printStackTrace();
    	 }finally {
    		 sqldao.close(conn, st, rs);
    	 }
    	 return null;
     }
	
	/*
	 *  商家不应该可以直接进行申请，应该是系统交付的时候就给予了注册，而只有商家进入
	 *  了其系统界面才能得到创建其他商家的权限。
	 */
	
	public  String signin(String name,String pwd) { //商家的登录验证
		   boolean p1=false;  
		   boolean pd=false;
		   StringBuffer sb=new StringBuffer();
		   String s1;
		   String s2;
		   String s3;
		   String s4;
		   
		for(int i=0;i<getall().size();i++) {
			
		    	       shop sx=getall().get(i);
		    	       s1=sx.getusername();
		    	       s2=sx.getpnumber();
		    	       s3=sx.getemail();
		    	       s4=sx.getpassword();
		 
		    	     if(s1.equals(name)||s2.equals(name)||s3.equals(name)) {
		    	    	
		    	    	   p1=true;
		    	    	  if(s4.equals(pwd)) {
		    	    		  
		    	    		  pd=true;
		    	    		  sb.append("shopok");
		    	    	  }
		    	     }
		    }
		   
		   
		 if(!p1) {
			  pd=true;
			  sb.append("noshop");     //不存在该商家用户，请联系系统管理员，给出电话号码！
			}
		 if(!pd) {
			 sb.append("shoppwdwrong");  //返回密码错误！
			 }
		
		 
		return sb.toString();
	}
		
}



/*
 *  客户实现people接口中的验证方法
 */
class customerverifycode implements people{   
	
	public static List<customer> getall(){
 	     Connection conn=null;
   	 Statement st=null;
   	 ResultSet rs=null;
   	 try {
   		
   		 ArrayList<customer> cm=new ArrayList<>(); 
   		 conn=sqldao.getConnection();
   		 st=conn.createStatement();
   		 String sql="select*from customer";  //
   		 rs=st.executeQuery(sql);
   		 while(rs.next()) {
   			customer cr=new customer();
   			cr.setname(rs.getString(1));
   			cr.setpwd(rs.getString(2));
   			cr.setpnumber(rs.getString(3));
   			cr.setemail(rs.getString(4));  
   			cm.add(cr);
   	   }
   		 return cm ;
   	 }catch(SQLException e) {
   		 e.printStackTrace();
   	 }finally {
   		 sqldao.close(conn, st, rs);
   	 }
   	 return null;
    }
	
	
	
	public  String signin(String name,String pwd) {
		   boolean p2=false;
		   boolean p3=false;  
		    StringBuffer sb=new StringBuffer();
		    String de1;
		    String de2;
		    String de3;
		    String de4;
		for(int i=0;i<getall().size();i++) {
		    	  customer cx=getall().get(i);
		    	  de1=cx.getname();
		    	  de2=cx.getpnumber();
		    	  de3=cx.getemail(); 
		    	  de4=cx.getpwd();
		    	  if(de1.equals(name)||de2.equals(name)||de3.equals(name)) {
		    		 
		    		     p2=true;
		    		  if(de4.equals(pwd)) {
		    			 p3=true;
		    			sb.append("customerok");
		    			
		    		  }
		    	  }
		    	  
		    	  
		     }
		    
		if(!p2) {
			p3=true;   //若p2执行则不执行p3
		    sb.append("nocustomer");    //不存在该顾客，请注册
		}
		if(!p3) {
			sb.append("pwdcustomerwrong");   //密码错误
		}
		   return sb.toString();
	}
}





