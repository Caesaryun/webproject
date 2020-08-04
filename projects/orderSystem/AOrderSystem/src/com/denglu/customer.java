package com.denglu;

public class customer {
 private String name;
 private String pwd;
 private String phonenumber;  
 private String email; 
 
 public customer(String name,String pwd,String pnumber,String email) {
	 this.name=name;
	 this.pwd=pwd;
	 this.phonenumber=pnumber;
	 this.email=email;
	 
 }
 public customer() {
	 
 }
 public void setpnumber(String pnumber) {
	 this.phonenumber=pnumber;
 }
 public String getpnumber() {
	 return phonenumber;
 }
 public void setemail(String email) {
	 this.email=email;
 }
 public String getemail() {
	 return email;
 }
 public void setname(String name) {
	 this.name=name;
 }
 
 public String getname() {
	 return name;
 }
 
 public void setpwd(String pwd) {
	 this.pwd=pwd;
 }
 
 public String getpwd() {
	 return pwd;
 }
 
}
