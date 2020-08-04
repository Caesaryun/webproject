package com.denglu;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.denglu.signwork;
/**
 * Servlet implementation class signservlet
 */
@WebServlet("/signservlet")
public class signservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signservlet() {
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
	       
	        
	       
			
			
		 HttpSession session=request.getSession();
			 //发送username 给filter
	     
		  String url=(String)session.getAttribute("uri");   //得到从jsp处传递来的 uri
	      
		  String urlxinxi=(String)session.getAttribute("urlxinxi");  //得到food传来的店家id
	      System.out.println("打印id:"+urlxinxi); 
	      
		   String hotelname=(String)session.getAttribute("hotelname");  //得到hotelname
           session.setAttribute("hotelname",hotelname);  //发送hotelname
			
           			System.out.println("打印想要访问的url:"+url);
			
	       
	       String radiozhi=request.getParameter("radiozhi");   //获取到那radio的值判断用户类型
	       String username=request.getParameter("username");
	       String pwd=request.getParameter("password");
	      
	       
	       
	       session.setAttribute("username",username);  //发送了用户名
	       
	       
	       
	       
	       vcffactory vf=new vcffactory();
	       people p1=vf.getpeople(radiozhi);   //传递选择的radiozhi 商家或者客户
	       String str=p1.signin(username, pwd);
	       
	         //发送username给过滤器
	        
			
			
		   boolean panduan=false;   //判断是否执行传递来的 uri
		   
	       if(str.equals("customerok")) {
	    	   //转换到顾客的页面
	    	   
	    	   if(url!=null) {
	    		   panduan=true;   //执行这里则不执行下方
	    		   response.sendRedirect(url+"?username="+username+"&hotelid="+urlxinxi);   //跳转到之前相访问的页面 
	    		  // request.getRequestDispatcher(url+"?username="+username).forward(request,response);
	    	   }
	    	        //out.print("欢迎使用系统客户："+username);
	    	   
	    	   if(!panduan) {
	    	   request.getRequestDispatcher("customer/customermain.jsp?username="+username).forward(request,response);
	    	   }
	       }
	       
	       
	       if(str.equals("shopok")) {
	    	   //out.print("欢迎使用系统商家:"+username);
	    	   response.sendRedirect("shop/changehotel.jsp");
	    	   
	       }
	       if(str.equals("noshop")) {
	    	    //out.print("不存在该商家用户，请联系系统管理员电话");
	    	    request.setAttribute("msgshop", "yes");
				request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	       }
	       if(str.equals("shoppwdwrong")) {
	    	   //out.print("密码错误！可选择找回密码");
	    	   request.setAttribute("msgshoppwd", "yes");
	    	   request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	       }
	       if(str.equals("nocustomer")) {
	    	  // out.print("客户不存在，请注册！");
	    	   request.setAttribute("msgcustomer", "yes");
	    	   request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	       }
	       if(str.equals("pwdcustomerwrong")) {
	    	   //out.print("密码错误！");
	    	   request.setAttribute("msgcustomerpwd", "yes");
	    	   request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	       }
	       
	       
	       //若用户名密码等都错误，则执行跳转回登录页面
	    /*   if(!panduan) {
	    	    request.setAttribute("msg", "yes");
				request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	       } */
	   
	       
	     
	      
	       
	       
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
