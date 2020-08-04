package com.assitantshop;



public class factory {
	 private factory() {
		 
	 }
    public static factory getinstance() {
    	return new factory();
    }
	
	public  assitantcz getassitant() {   
		
    	  return new assitantutil();
    	  
	 }
}
