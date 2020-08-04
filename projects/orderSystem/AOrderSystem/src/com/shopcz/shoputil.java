package com.shopcz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Filter.mapmodel;  //饭店的类
import com.denglu.customer;
import com.denglu.sqldao;
import com.food.foodshow;
import com.food.orderclass;

/*
 * 定义了商家操作的接口 
 * 
 * sql语句查询24小时的记录：SELECT *FROM `order` WHERE ordertime>=(NOW()-INTERVAL 10 HOUR)
 * 查询近三个月的记录：SELECT *FROM `order` WHERE QUARTER(ordertime)=QUARTER(NOW())
 */




interface shopscz{  //其余的信息就直接进行赋值即可
	public void addfood(String foodname,double foodprice,String username,double foodcost);
    public mapmodel gethotel(String username);   //查询到店名通过用户名也就是老板名称id
    public List<foodshow> getfood();  //获取food信息
    public String createnumid();      //创建一个numid
    public void changefood(String foodid,String price,String cost,String foodname);
    public List<orderclass> getorderdetail(String username,String pageno,String pagesize);       //通过用户名，查询出hotelname然后再加入页码即可流出一个pagesize
    public int getsize(String username);  //求得order表的中的数据多少
    public void changeaccept(String orderid,String orderstate);        //通过传入orderid,然后自动将对应订单状态改为接单或
    public void changehotel(String hotelid,String hotelname,String adder,String phone,String qsprice,String yunprice,String packprice);
    public void createassitant(String assitantname,String password,String username);
    public mapmodel gethotelname(String username);
    public  void delfood(String foodid);
    public  List<orderclass> getorderdesc(String username,String pageno,String pagesize); //
    public int getordersailsize(String username); //查询出数据条数
    //SELECT foodname,SUM(foodnumber)  FROM `order` GROUP BY foodname ORDER BY SUM(foodnumber) DESC 
    
    public List<orderclass> getallorderdetail(String username,String pageno,String pagesize); //查看所有已经接单的信息
    public int getallorderdsize(String username);  /*查询所有已经接单的数据的大小*/
    
    
}



public class shoputil implements shopscz{
	
	public int getallorderdsize(String username){
		 Connection conn=null;
    	 Statement st=null;         /* 查找所有订单的数量*/
    	 ResultSet rs=null;
    	 int count=2;
    	 try {
    		
    		
    		 conn=sqldao.getConnection();
    		 st=conn.createStatement();
    		 String sql="SELECT COUNT(*) as totalsize FROM `order` WHERE  hotelname=(SELECT hotelname FROM hotels WHERE hotelboss='"+username+"')";  
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
	
	   /*查找所有的订单，不管是否接单，进行查询*/
	public List<orderclass> getallorderdetail(String username,String pageno,String pagesize){
		
		 System.out.println("输出pageno::"+pageno);
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
   String sql="SELECT*FROM `order` WHERE   hotelname=(SELECT hotelname FROM hotels WHERE hotelboss='"+username+"') LIMIT ?,?";
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
	
	
	public int getordersailsize(String username) {
		 System.out.println("username:xxxxx:"+username);
		 Connection conn=null;
    	 Statement st=null;
    	 ResultSet rs=null;
    	 int count=2;
    	 try {
    		
    		//直接不要重复的foodname 
    		 conn=sqldao.getConnection();
    		 st=conn.createStatement();
    		 String sql="SELECT COUNT(DISTINCT(foodname)) as totalsize FROM `order`  WHERE  hotelname=(SELECT hotelname FROM hotels WHERE hotelboss='"+username+"')";  
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
	
	
	//统计出所有下单的的食物的销售数量，及其下单的总和，不一定说一定卖出去，只是统计至少有人下单买这个东西，而由于商家问题并未接单，或者顾客退单
	public List<orderclass> getorderdesc(String username,String pageno,String pagesize){
		
		
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
   String sql="SELECT foodname,SUM(foodnumber) as sailnum,SUM(sumprice) as sailprice,foodprice as price FROM `order` WHERE   hotelname=(SELECT hotelname FROM hotels WHERE hotelboss='"+username+"') GROUP BY foodname ORDER BY SUM(foodnumber) DESC LIMIT ?,?";
             ps=conn.prepareStatement(sql);
              System.out.println("ok!xxxxx");
             ps.setInt(1, (pageno1-1)*pagesize1);
             ps.setInt(2, pagesize1);
            
             rs=ps.executeQuery();
             
			 while(rs.next()) {
				orderclass ors=new orderclass();
			   
			    ors.setfoodname(rs.getString("foodname"));
                ors.setfoodnum(rs.getInt("sailnum")); //销量
                ors.setsumprice(rs.getDouble("sailprice"));
                ors.setfoodprice(rs.getDouble("price")); //单价
                
                System.out.println("总销量:"+ors.getfoodnum());  
                
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
	
	
	public void delfood(String foodid) {
		  Connection conn=null;
 		   Statement st=null;
 		   ResultSet rs=null;
 	    try {  //首先插入店员表，将密钥assitantid也同样插入其中
 	 		  conn=sqldao.getConnection();
 			  st=conn.createStatement();
 		      String sql="delete from food where foodid='"+foodid+"'";
 			  st.execute(sql);   //
 			  sqldao.close(conn, st, rs);  //关闭数据库
 			 
 		 }catch(SQLException e) {
 			 e.printStackTrace();
 		 }
	}
	
	
	
	public mapmodel gethotelname(String username){
	     Connection conn=null;
	 Statement st=null;
	 ResultSet rs=null;
	 try {
		
		
		 conn=sqldao.getConnection();
		 st=conn.createStatement();
		 String sql="select*from hotels where hotelboss='"+username+"'";   //通过地址查询所有的店
		 rs=st.executeQuery(sql);
		 if(rs.next()) {
			mapmodel m=new mapmodel();
			m.sethotelname(rs.getString(2));  //获取到名称
			m.sethotelnumber(rs.getString(3));  //查询到相应的电话号码
			m.sethotelboss(rs.getString(4));  //查询到商家名称
	        return m;
		    }
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 sqldao.close(conn, st, rs);
	 }
	 return null;
      }
	
	
	
	
	public void createassitant(String assitantname,String password,String username) {
		   
		  
		 mapmodel m=gethotelname(username);  
		 String hotelname=m.gethotelname();  //得到hotelname
		
		   
		   Connection conn=null;
  		   Statement st=null;
  		   ResultSet rs=null;
  	    try {  //首先插入店员表，将密钥assitantid也同样插入其中
  	 		  conn=sqldao.getConnection();
  			  st=conn.createStatement();
  		      String sql="INSERT INTO shopassitant(username,password,hotelname)value('"+assitantname+"','"+password+"','"+hotelname+"')";
  			  st.execute(sql);   //
  			  sqldao.close(conn, st, rs);  //关闭数据库
  			 
  		 }catch(SQLException e) {
  			 e.printStackTrace();
  		 }
  		}
	
	
	
	
	 public void changehotel(String hotelid,String hotelname,String adder,String phone,String qsprice,String yunprice,String packprice) {
		 Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
		 double qprice=Double.parseDouble(qsprice);
		 double yprice=Double.parseDouble(yunprice);
		 double pprice=Double.parseDouble(packprice);
		 try {
			 conn=sqldao.getConnection();//
			 st=conn.createStatement();
			 String sql="UPDATE `hotels` SET hotelname='"+hotelname+"',hotelnumber='"+phone+"',hoteladder='"+adder+"',hotelqsprice='"+qprice+"',hotelyunprice='"+yprice+"',packprice='"+packprice+"' WHERE hotelid='"+hotelid+"'";
			 st.executeUpdate(sql);
			}catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn, st, rs);
		 } 
	 }
	 
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
    		 String sql="SELECT COUNT(*) as totalsize FROM `order` WHERE ordertime>=(NOW()-INTERVAL 24 HOUR) AND  acceptorder='未接单' AND  hotelname=(SELECT hotelname FROM hotels WHERE hotelboss='"+username+"')";  
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
   String sql="SELECT*FROM `order` WHERE  ordertime>=(NOW()-INTERVAL 24 HOUR) AND  acceptorder='未接单' AND hotelname=(SELECT hotelname FROM hotels WHERE hotelboss='"+username+"') LIMIT ?,?";
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
	
	
	public void changefood(String foodid,String foodprice,String foodcost,String foodname) {
		   double price=0;
		   double cost=0;
		
			  price=Double.parseDouble(foodprice);
			  cost=Double.parseDouble(foodcost);
		
			  System.out.println("xx:"+cost);
		  
	       
		
		
		
		 Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
		 
		 try {
			 conn=sqldao.getConnection();//
			 st=conn.createStatement();
			 String sql="UPDATE food SET foodcost='"+cost+"',foodprice='"+price+"',foodname='"+foodname+"' WHERE foodid='"+foodid+"'";   //通过foodid查询出所有的数据
			 st.executeUpdate(sql);
			 System.out.println("ok!!!!");
			 System.out.println(foodname);
			
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn, st, rs);
		 }
		 
	}
	
	
	
	public List<foodshow> getfood() {
		 Connection conn=null;
		 Statement st=null;
		 ResultSet rs=null;
		 try {
			 ArrayList<foodshow> fsw=new ArrayList<>();
			 conn=sqldao.getConnection();
			 st=conn.createStatement();
			 String sql="select*from food";   //通过foodid查询出所有的数据
			 rs=st.executeQuery(sql);
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
				 fsw.add(fw);
				
			  }
			 return fsw;
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 sqldao.close(conn, st, rs);
		 }
		 return null;
	    }
	
	  public String createnumid() {
		    //产生随机的id然后查询表与之前从id进行比较，若相同则又只需随机id
		  String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000); 
		  String numid="a"+verifyCode;
		  System.out.println(numid);
		  
		  for(int i=0;i<getfood().size();i++) {
			  foodshow fs=getfood().get(i);
			  if(numid.equals(fs.getnumid())) {
				  createnumid();
			  }
		  }
		  return numid;
	  }
	  
	  
	   public mapmodel gethotel(String username){
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
				    mls.sethotelname(rs.getString(2));
				   
					 
					return mls;
				  }
				 
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }finally {
				 sqldao.close(conn, st, rs);
			 }
			 return null;
		     }
		  
	   
       public void addfood(String foodname,double foodprice,String username,double foodcost) {
    	    //通过username查询到相应的店名，然后进行
    	   System.out.println("username:"+username);
    	   
    	   String foodscore="4.6";
    	   mapmodel shopname=gethotel(username);
    	   String hotelname=shopname.gethotelname();  //获取店名
    	   String imglocation="4x.jpg";  //图的地址 这里可以将图片上传到数据库中
    	   String foodnum="0";  //这个是为了加减选择框
    	   String numid=createnumid(); //得到一个numid;
    	   String priceid=createnumid();  //得到一个随机priceid
    	   String costid=createnumid();  //得到一个随机的costid
    	   Connection conn=null;
  		   Statement st=null;
  		   ResultSet rs=null;
  	  try {
  			  conn=sqldao.getConnection();
  			  st=conn.createStatement();
  		      String sql="INSERT INTO food(foodname,foodscore,foodprice,hotelname,imglocation,foodnum,numid,foodcost,priceid,costid)values('"+foodname+"','"+foodscore+"','"+foodprice+"','"+hotelname+"','"+imglocation+"','"+foodnum+"','"+numid+"','"+foodcost+"','"+priceid+"','"+costid+"')";
  			  st.execute(sql);   //
  			  sqldao.close(conn, st, rs);  //关闭数据库
  			 
  		 }catch(SQLException e) {
  			 e.printStackTrace();
  		 }
  		
            
          }
}
