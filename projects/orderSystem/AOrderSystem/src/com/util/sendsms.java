package com.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.util.*;
import com.util.pnumberpd;
/**
 * Servlet implementation class sendsms
 */
@WebServlet("/sendsms")
public class sendsms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendsms() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html;charset=UTF-8");
	       PrintWriter out = response.getWriter();		
	       request.setCharacterEncoding("utf-8");
		
		String Account = "15524558529";   
		// 您的短信账号密码
		String Password = "123456QWe";
		// 是否需要状态报告
		String NeedStatus = "true";
		 //生成验证码
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);   
		
		String message = "您正在登录太白珍馐居，您的验证码是"+verifyCode+"，如非本人操作，请忽略本短信！";//短信内容
		//String mobile = "18685952012";//要发送的手机号,多个手机号用,隔开
		String mobile=request.getParameter("mobile");
		
		//需要调用一个方法得出该号码是否存在 
        String str=pnumberpd.pnumbergetuser(mobile);  
        if(str.equals("cnumbercz")) {
        	//如果客户存执行发送验证码 且返回 该用户的类型 然后填写了验证码后通过该类型跳转到相应的用户界面
        	System.out.print(verifyCode);
        	out.print(str+",");
        	out.print(verifyCode);
          String ts =  Utility.getNowDateStr();//时间戳
   		 
   		 
    		Password = Utility.getMD5(Account + Password + ts);// Md5签名(账号+密码+时间戳)
    		HashMap params = new HashMap(); 
    		//请求参数 
    		params.put("account",Account);
    		params.put("pswd",Password);
    		params.put("mobile",mobile);
    		params.put("msg",message);
    		params.put("ts",ts);
    		params.put("needstatus",NeedStatus);
    	 String rep = ZxHttpUtil.sendPostMessage("http://139.196.108.241:8080/Api/HttpSendSMYzm.ashx", params, "UTF-8");
           
    	  out.print(rep);
        	
        }
        if(str.equals("shopncz")) {
        	//System.out.print(str);
        	  //这是商家
        	out.print(str+",");   //以逗号作为分割点
        	out.print(verifyCode);
        	System.out.print(verifyCode);
        //	String ts =  Utility.getNowDateStr();//时间戳
   		 
   		 
    	/*	Password = Utility.getMD5(Account + Password + ts);// Md5签名(账号+密码+时间戳)
    		HashMap params = new HashMap(); 
    		//请求参数 
    		params.put("account",Account);
    		params.put("pswd",Password);
    		params.put("mobile",mobile);
    		params.put("msg",message);
    		params.put("ts",ts);
    		params.put("needstatus",NeedStatus);
    	//	String rep = ZxHttpUtil.sendPostMessage("http://139.196.108.241:8080/Api/HttpSendSMYzm.ashx", params, "UTF-8");
           */
    	//	out.print(rep);
        }
        if(str.equals("nonumber")) {
        	System.out.print(str);
        	out.print(str);
        }
		 
	     
		/*
		 *   从jsp页面发送mobile过来，然后自己生成一个验证码 
		 *   且需要判断号码是否已经注册，且同时判断是属于商家还是客户
		 *   
		 */
		
		
	/*	String ts =  Utility.getNowDateStr();//时间戳
		 
		 
		Password = Utility.getMD5(Account + Password + ts);// Md5签名(账号+密码+时间戳)
		HashMap params = new HashMap(); 
		//请求参数 
		params.put("account",Account);
		params.put("pswd",Password);
		params.put("mobile",mobile);
		params.put("msg",message);
		params.put("ts",ts);
		params.put("needstatus",NeedStatus);
		String rep = ZxHttpUtil.sendPostMessage("http://139.196.108.241:8080/Api/HttpSendSMYzm.ashx", params, "UTF-8");
       
		out.print(rep);
		
	 */	
		
		
		
		
		
		
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
