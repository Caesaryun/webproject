package com.shopcz;



public class shopfactory {
	private shopfactory() {
		
	}
	public static shopfactory getinstance() {
		return new shopfactory();
	}
	public  shopscz getshopcz() {   
    	  return new shoputil();
	 }
   	
}
