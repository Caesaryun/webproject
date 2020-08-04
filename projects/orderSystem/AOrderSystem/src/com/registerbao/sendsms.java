package com.registerbao;

import java.util.HashMap;
import java.util.Random;

import com.util.Utility;
import com.util.ZxHttpUtil;

public class sendsms {
	
	 /*
	 * 只需要传递mobile及message及boss
	 */
	
   public static String sendmessage(String message,String mobile) {
	    String Account = "15524558529";   
		// 您的短信账号密码
		String Password = "123456QWe";
		// 是否需要状态报告
		String NeedStatus = "true";
		 //生成验证码
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);   
		
		//String message = "您正在注册太白珍馐居，您的验证码是"+verifyCode+"，如非本人操作，请忽略本短信！";//短信内容
		//String mobile = "18685952012";//要发送的手机号,多个手机号用,隔开
		//String mobile=request.getParameter("mobile");
		System.out.print(message);
		System.out.print(mobile);
		//得到电话号码直接给出验证码
   
    	//如果客户存执行发送验证码 且返回 该用户的类型 然后填写了验证码后通过该类型跳转到相应的用户界面
    	System.out.print(verifyCode);
    	
    	//out.print(verifyCode);   //返回验证码进行比较，若验证码一致则进行添加
    
    	
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
        System.out.println("are you ok!");
		return rep;
		//out.print(rep);
   }
}
