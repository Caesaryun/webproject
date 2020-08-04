package com.food;

/*
 *  地址类，通过用户名id进行查询，
 */
public class adder {
	  private int adderid;   //地址的唯一id
      private String username;  //用户名
      private String adder;  //地址
      private String phone;  //电话号码
      private String realname;  //真实订单姓名
      
      public adder(int id,String name,String adder,String phone,String realname) {
    	  this.adderid=id;
    	  this.phone=phone;
    	  this.realname=realname;
    	  this.adder=adder;
    	  this.username=name;
      }
      public void setadderid(int id) {
    	  this.adderid=id;
      }
      public int getadderid() {
    	  return adderid;
      }
      public void setphone(String phone) {
    	  this.phone=phone;
      }
      public String getphone() {
    	  return phone;
      }
      public void setrealname(String name) {
    	  this.realname=name;
      }
      public String getrealname() {
    	  return realname;
      }
      
      public adder() {
    	  
      }
      public void setusername(String username) {
    	  this.username=username;
      }
      public String getusername() {
    	  return username;
      }
      public void setadder(String adder) {
    	  this.adder=adder;
    	  
      }
      public String getadder() {
    	  return adder;
      }
}
