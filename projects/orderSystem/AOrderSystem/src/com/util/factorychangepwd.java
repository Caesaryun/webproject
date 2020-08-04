package com.util;

public class factorychangepwd {  //传入用户类型
      public  changepassword getxgtype(String usertype) {
    	  if(usertype.equals("shopncz")) {   //为商家则传递商家
    		  return new shopchangepwd();
    	  }
    	  if(usertype.equals("cnumbercz")) {
    		  return new gukepwdchange();
    	  }
    	  return null;
      }
}
