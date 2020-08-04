package com.orderpack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.denglu.sqldao;

/*
 * 餐具的类
 */
public class canjunum{
         private String  canjuid;  //餐具的id
         private String  canjunum;  //餐具的数量
         public canjunum(String canjuid,String canjunum) {
        	 this.canjuid=canjuid;
        	 this.canjunum=canjunum;
         }
         public canjunum() {
        	 
         }
         public void setcanjuid(String id) {
        	 this.canjuid=id;
         }
         public String getcanjuid() {
        	 return canjuid;
         }
         public void setcanjunum(String num) {
        	 this.canjunum=num;
         }
         public String getcanjunum() {
        	 return canjunum;
         }
}
//餐具的功能实现

