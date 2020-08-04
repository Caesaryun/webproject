package com.shopcz;

import java.util.List;

import com.food.foodshow;



public class pagemodel {
	 private int count;
     private int pageno;
     private int pagesize;
     private int pagecount;  //总页数
     private List<foodshow> result;  //页面数据
     
     
     public void setresult(List<foodshow> list) {
   	  this.result=list;
     }
     public List<foodshow> getresult() {
   	  
   	  return result;
     }
     public void setpagesize(int pagesize) {
   	  this.pagesize=pagesize;
     }
     public int getpagesize() {
   	  return pagesize;
     }
     public void setpagecount(int pagecount) {
   	  this.pagecount=pagecount;
     }
     public int getpagecount() {
   	  return pagecount;
     }
     public void setcount(int count) {
   	  this.count=count;
     }
     public int getcount() {
   	  return count;
     }
     public void setpageno(int pageno) {
   	  this.pageno=pageno;
     }
     public int getpageno() {
   	  return pageno;
     }
     
}
