package com.orderpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.adder;
import com.food.orderutil;

/**
 * Servlet implementation class orderyz
 */
@WebServlet("/orderyz")
public class orderyz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderyz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 订单验证，其地址是否填写，然后决定是否付款，若地址填写则进行付款页面，之后订单生成，结束
		 */
		
		response.setContentType("text/html;charset=UTF-8");
	       PrintWriter out = response.getWriter();		
	       request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		   String username=(String)session.getAttribute("username");  //获取到用户名
		   
		   
		   String adderid=(String)session.getAttribute("adderid");
		   String location=(String)session.getAttribute("dizhi");
		   
		   
		   
		   String zsorderid=request.getParameter("zsorderid");
		   session.setAttribute("zsorderid",zsorderid); //发送暂时订单id
		   
		   System.out.println("暂时的订单id："+zsorderid);
		   
		   /*
		    * 通过用户名取到最后一个id
		    */
		   //如果存在location,且adderid没有固定,则执行该步骤
		   
		  if(!location.equals("noadder")&&adderid.equals("12"))
		  {
			  int aid=0;
		   for(int i=0;i<addermodel.getdetailadder(username).size();i++) {
			   adder adtwo=addermodel.getdetailadder(username).get(i);
			    aid=adtwo.getadderid();   //取到aid 传递到插入函数中,且取到最后一条
			    
		     }
		   //session.setAttribute("adderid",aid);  //发送默认地址id 
		   
		   
		   
		   
		     response.sendRedirect("customer/pay.jsp?adderid="+aid);    //支付页面
		     out.print("这里存在地址，却没有指定地址id");
		  }
		  
		  if(!adderid.equals("12")) {
			  session.setAttribute("adderid",adderid);  //发送确认的地址id
			  
			  
			  response.sendRedirect("customer/pay.jsp?adderid="+adderid);
			  //发送暂时的订单id
			  out.println("这里存在adderid!"+adderid);
		  }
		   
		   
		     //若地址为空，则跳转到地址管理，给出提示，没有地址,让页面暂停一下给出提示，然后自动跳转
			   //到地址管理
		   
		   
	      if(location.equals("noadder")) {
				response.getWriter().write("<html><body><div  style='position:absolute;\r\n" + 
						"            left:22%;\r\n" + 
						"            width: 45%;\r\n" + 
						"            top:1%;\r\n" + 
						"            display: flex;\r\n" + 
						"            justify-content: center;\r\n" + 
						"            align-items: center;\r\n" + 
						"            height: 50px;\r\n" + 
						"            background-color: rgba(255, 255, 25, 0.3);\r\n" + 
						"            box-shadow: 7px 7px 17px rgba(255, 255, 235, 0.5);\r\n" + 
						"            border-radius: 5px;'><font size='4' color='red'>地址未填写,三秒跳转,若未跳转点击<a href=\"customer/adder.jsp\">订单管理</a> </font></div></body></html>");
				
				response.setHeader("refresh","2;url=customer/adder.jsp");
			  }
			  
				//response.sendRedirect("customer/adder.jsp");
			
			   
		   
		   
		   
		   
		   
		/*   if(adderid==null) {
			   //跳转到订单管理进行地址选择，或者填写
			   request.getRequestDispatcher("customer/adder.jsp?").forward(request,response);
		   }
		   adder ader=orderutil.getdetailadder(username);  //获取到地址
		   System.out.println("这里是orderya:"+username);
		   
		   //response.sendRedirect("customer/adder.jsp");
		   request.getRequestDispatcher("customer/adder.jsp?").forward(request,response);
		   String dizhi = null;
		   try {
		      dizhi=ader.getadder();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   System.out.println(dizhi);
		   if(dizhi==null) {
			   response.sendRedirect("customer/adder.jsp");  //跳转到地址填写页面
		   }else {
			   
		   }
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
