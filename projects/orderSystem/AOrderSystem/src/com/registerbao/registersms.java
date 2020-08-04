package com.registerbao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Utility;
import com.util.ZxHttpUtil;
import com.util.pnumberpd;

/**
 * Servlet implementation class registersms
 */
@WebServlet("/registersms")
public class registersms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registersms() {
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
		
	       
	       
	       
	       
	       
	       
    	/*	String Account = "15524558529";   
		// 您的短信账号密码
		String Password = "123456QWe";
		// 是否需要状态报告
		String NeedStatus = "true";
		 //生成验证码
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);   
		*/
	    String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000); 
		String message = "感谢您注册Caesar云太白珍馐居，您的验证码是"+verifyCode+"，若不是本人操作，请忽略此短信。";//短信内容
		//String mobile = "18685952012";//要发送的手机号,多个手机号用,隔开
		
		String mobile=request.getParameter("mobile");
		
		System.out.print(message);
		System.out.print("你的电话号码:"+mobile);
		
		String rep=sendsms.sendmessage(message,mobile);  //调用发送短信即可
		System.out.println(rep);
		
		
		//得到电话号码直接给出验证码
    
     	//如果客户存执行发送验证码 且返回 该用户的类型 然后填写了验证码后通过该类型跳转到相应的用户界面
     
		/*
		System.out.print(verifyCode);
     	
     	out.print(verifyCode);   //返回验证码进行比较，若验证码一致则进行添加
     
     	
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
     	
    
    
     	
     */
     	
     
     
     
		 
	     
		/*
		 *   从jsp页面发送mobile过来，然后自己生成一个验证码 
		 *   且需要判断号码是否已经注册，且同时判断是属于商家还是客户
		 *   
		 */
		
		
	
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
