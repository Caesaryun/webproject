package com.customercz;

public class detailcustomer {
          private String usernameid;
          private String password;
          private String phonenumber;
          private String email;  
          private String location;  //地址
          private String realname; //真实的姓名
          
          public void setlocation(String location) {
        	  this.location=location;
          }
          public String getlocation() {
        	  return location;
          }
          public void setrealname(String name) {
        	  this.realname=name;
          }
          public String getrealname() {
        	  return realname;
          }
          
          
          public void setphone(String phone) {
        	  this.phonenumber=phone;
          }
          public String getphone() {
        	  return phonenumber;
          }
          public void setemail(String email) {
        	  this.email=email;
          }
          public String getemail() {
        	  return email;
          }
          
          
          public void setusername(String nameid) {
        	  this.usernameid=nameid;
          }
          public String getusernameid() {
        	  return usernameid;
          }
          public void setpassword(String password) {
        	  this.password=password;
          }
          public String getpassword() {
        	  return password;
          }
          
}
