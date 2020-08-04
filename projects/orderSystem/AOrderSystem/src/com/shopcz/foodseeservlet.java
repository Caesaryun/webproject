package com.shopcz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.foodshow;


/**
 * Servlet implementation class foodseeservlet
 */
@WebServlet("/foodseeservlet")
public class foodseeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public foodseeservlet() {
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
	      
	       int pageno=1;
	      HttpSession session=request.getSession();
		  int pagesize=4;
		 
		  //传递来pageno 及大小 
		  String pagenostr=request.getParameter("pageno");
		  String pagesizestr=request.getParameter("pagesize");
		  
	      session.setAttribute("pageno",pagenostr); //发送给filter
		  
		  
		  if(pagesizestr==null) {
			  pagesizestr="3";  //规定pagesizestr为3每页显示3
		  }
		  if(pagenostr==null) {
			  pagenostr="1";
		  }
		  
		  System.out.println("pagesizeaaaaaaaa:"+pagesizestr);
		  
		  pageno=Integer.parseInt(pagenostr);
		  pagesize=Integer.parseInt(pagesizestr);
		  
		  //String username=request.getParameter("username");
		  String username=(String) session.getAttribute("username");
		  
		  session.setAttribute("username",username);  //需要发送username
		  request.setAttribute("username",username);
		  
		  System.out.println("USERNAME:"+username);
		  
		  
		  List<foodshow> fy=lookfoodcz.getmanyfood(username,pagenostr,pagesizestr);
		  int count=lookfoodcz.getsize(username);  //这里是得到数据的多少
		  System.out.println("count:"+count);
		 
		  pagemodel pl=new pagemodel();
		  
		  pl.setpageno(pageno);
		  pl.setpagesize(pagesize);
		  pl.setresult(fy); //插入页面数据
		  pl.setcount(count);
		 
		  if(count%pagesize!=0) {
			  pl.setpagecount(count/pagesize+1);
			  
		  }
		  else {
			 pl.setpagecount(count/pagesize+1);
		  }
		   response.setCharacterEncoding("utf-8");
	    
		   //request.setAttribute("pageresult",pl);
	        
		     session.setAttribute("abc","123");
		     request.setAttribute("pageresult",pl);
	         
		     
		    	 
	         session.setAttribute("pageresult",pl);
		     response.sendRedirect("shop/lookfood.jsp");  //通过这玩意进行
		       
		     //  RequestDispatcher requestDispatcher=request.getRequestDispatcher("/shop/lookfood.jsp"); 
			  // requestDispatcher.forward(request,response);
	    
		 
	      
		
		
		
		
		
		
		
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
