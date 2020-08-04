package com.denglu;
import com.denglu.shop;
import com.denglu.signwork;


/*
 * 通过前台传入radiozhi（单选框中的值）
 * 传到工厂中进行判断，若为customer则返回客户的实现类
 * 反之返回商家的实现类
 */



public class vcffactory {
      public  people getpeople(String radiozhi) {   
    	 
    	  if(radiozhi==null) {
    		  return null;
    	  }
    	  if(radiozhi.equals("customer")) {
    		 // System.out.print("工厂模式之顾客");
    		  return new customerverifycode();   
    		  
    	  }
    	  if(radiozhi.equals("shopkeeper")) {
    		 // System.out.print("工厂模式之商家");
    		  return new shopVerification(); 
    	  }
    	  
    	  return null;
      }
}