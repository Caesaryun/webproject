package com.denglu;

public class shop {
     private String username;   //商家的用户名
     private String password;  //密码
     private String phonenumber;   //电话号码
     private String email;   //邮箱
     public shop(String username,String password,String phonenumber,String email) {
    	 this.username=username;
    	 this.password=password;
    	 this.phonenumber=phonenumber;
    	 this.email=email;
     }
     public shop() {
    	 
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
     public void setusername(String name) {
    	 this.username=name;
     }
     public String getusername() {
    	 return username;
     }
     public void setpassword(String password) {
    	 this.password=password;
     }
     public String getpassword() {
    	 return password;
     }
     
     
}
