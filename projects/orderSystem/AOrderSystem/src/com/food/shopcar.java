package com.food;

public class shopcar {
	private int shopcarid;  //购物车id
 private String foodname;  //食物的名称
 private int foodnum;   //食物的数量
 private double foodprice;  //食物的价格
 private int foodid;  //食物的id,通过该id可以查询到其是那个商家的
 private String username;  //客户的id，通过该id名称可以查询到其的购物车数据
private String hotelname;  //商店的名称 
private double totalprice;  //商品的总价格  
private double hotelyunprice;  //商品的运费
private double packprice;  //包装费用
public void setshopcarid(int id) {
	this.shopcarid=id;
}
public int getshopcarid() {
	return shopcarid;
}
public void setyunprice(double yunprice) {
	this.hotelyunprice=yunprice;
}
public double getyunprice() {
	return hotelyunprice;
}
public void setpackprice(double packprice) {
	this.packprice=packprice;
}
public double getpackprice() {
	return packprice;
}

public void sethotelname(String hotelname) {
	this.hotelname=hotelname;
}
public String gethotelname() {
	return hotelname;
}

public void settoalprice(double totalprice) {
	this.totalprice=totalprice;
}

public double gettotalprice() {
	return totalprice;
}

 public void setfoodid(int id) {
	 this.foodid=id;
 }
 public int getfoodid() {
	 return foodid;
 }
 public void setusername(String username) {
	 this.username=username;
 }
 public String getusername() {
	 return username;
 }
 
 
 
 
 public void setfoodname(String foodname) {  
	 this.foodname=foodname;
 }
 public String getfoodname() {
	 return foodname;
 }
 public void setfoodnum(int foodnum) {
	 this.foodnum=foodnum;
 }
 public int getfoodnum() {
	 return foodnum;
 }
 public void setfoodprice(double foodprice) {
	 this.foodprice=foodprice;
 }
 public double getfoodprice() {
	 return foodprice;
 }
 
}




