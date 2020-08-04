package com.food;

import java.util.Date;

public class orderclass {
       private String hotelname;  //订单中必须有的店名
       private String foodname;   //订单中的菜名
       private double foodprice;   //订单菜品单价
       private int foodnum;       //订单的菜品数量
       private double peisongprice;   //配送的价格
       private String customername;    //订单主人的名称 也就是id
       private String adder;          //订单的地址
       private String phone;     //订单的电话号码
       private double sumprice;   //总价钱
       private double packprice;   //包装费用
      
       private String acceptorder;   //是否接单
       private String bz;  //备注
       private String canjunum;  //餐具数量
       private String arrivetime;  //到达时间的区间
       private String realname;  //真实的姓名
       private Date time;
       private int orderid;  //订单id
       private String hotelphone;  //商家电话号码
       private String acceptid;  //是否接单的id
       private String refuseid; //不解的的id
       public void setrefuseid(String refuseid) {
    	   this.refuseid=refuseid;
       }
       public String getrefuseid() {
    	   return refuseid;
       }
       public void setacceptid(String id) {
    	   this.acceptid=id;
       }
       public String getacceptid() {
    	   return acceptid;
       }
       public void sethotelphone(String phone) {
    	   this.hotelphone=phone;
       }
       public String gethotelphone() {
    	   return hotelphone;
       }
       public void settime(Date time) {
    	   this.time=time;
       }
       public Date gettime() {
    	   return time;
       }
       
       public void setorderid(int orderid) {
    	   this.orderid=orderid;
       }
       public int getorderid() {
    	   return orderid;
       }
       public void setacceporder(String accept) {
    	   this.acceptorder=accept;
       }
       public String getacceptorder() {
    	   return acceptorder;
       }
       
       public void setrealname(String name) {
    	   this.realname=name;
       }
       public String getrealname() {
    	   return realname;
       }
       public void setarrivetime(String time) {
    	   this.arrivetime=time;
       }
       public String getarrivetime() {
    	   return arrivetime;
       }
       public void setbz(String bz) {
    	   this.bz=bz;
       }
       public String getbz() {
    	   return bz;
       }
       public void setcanjunum(String canjunum) {
    	   this.canjunum=canjunum;
       }
       public String getcanjunum() {
    	   return canjunum;
       }
        
       
public orderclass(String hotelname,String foodname,double foodprice,int foodnum,double peisongprice,String customername,String adder,String phone,double sumprice,double packprice)
       {
    	this.hotelname=hotelname;
    	this.foodname=foodname;
    	this.foodprice=foodprice;
    	this.foodnum=foodnum;
    	this.peisongprice=peisongprice;
    	this.customername=customername;
    	this.adder=adder;
    	this.phone=phone;
    	this.sumprice=sumprice;
    	this.packprice=packprice;
       }
       public orderclass() {
    	   
       }
       
     public void sethotelname(String hotelname) {  
    	 this.hotelname=hotelname;
     }
     public String gethotelname() {
    	 return hotelname;
     }
      public void setfoodname(String foodname) {
    	  this.foodname=foodname;
      }
      public String getfoodname() {
    	  return foodname;
      }
      public void setfoodprice(double foodprice) {
    	  this.foodprice=foodprice;
      }
       public double getfoodprice() {
    	   return foodprice;
       }
       public void setfoodnum(int num) {
    	   this.foodnum=num;
       }
       public int getfoodnum() {
    	   return foodnum;
       }
       public void setpeisong(double peisong) {
    	   this.peisongprice=peisong;
       }
       public double getpeisong() {
    	   return peisongprice;
       }
       public void setcustomername(String name) {
    	   this.customername=name;
       }
       public String getcustomer() {
    	   return customername;
       }
       public void setadder(String adder) {
    	   this.adder=adder;
       }
       public String getadder() {
    	   return adder;
       }
       public void setphone(String phone) {
    	   this.phone=phone;
       }
       public String getphone() {
    	   return phone;
       }
       public void setsumprice(double sumprice) {
    	   this.sumprice=sumprice;
       }
       public double getsumprice() {
    	   return sumprice;
       }
      public void setpackprice(double packprice) {
    	  this.packprice=packprice;
      }
      public double getpackprice() {
    	  return packprice;
      }
}
