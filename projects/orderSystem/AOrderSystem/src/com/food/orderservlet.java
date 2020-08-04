package com.food;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class orderservlet
 */
@WebServlet("/orderservlet")
public class orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderservlet() {
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
	       
	       String foodid=request.getParameter("foodid");
	       String num=request.getParameter("foodnum");
	       int foodnum=Integer.parseInt(num);
	       HttpSession session=request.getSession();
		   String username=(String)session.getAttribute("username");  //获取到用户名
		   //添加到一个集合中暂时的集合中，然后显示该集合，再确定是否提交订单
		   //若提交则提交到数据库即可，且添加到集合中，还需要将所有，配送价格等都需要弄好，
		   //且再确定提交订单的时候需要确认是否有地址，若用户没有存入地址则暂停
		  System.out.println("order:"+foodid+foodnum+username);
		    
		  String str=orderutil.addorderzs(foodid, foodnum, username);
		  System.out.println(str);		   
		  response.sendRedirect("customer/order.jsp");
		
		
		
		
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
