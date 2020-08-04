package com.shopcz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class changefood
 */
@WebServlet("/changefood")
public class changefood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changefood() {
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
		  String foodname=request.getParameter("foodname");
		  
		  System.out.println("得到:"+foodname);
		  
		  out.println(foodname);
		  String foodid=request.getParameter("foodid");
		  String cost=request.getParameter("cost");
		  String price=request.getParameter("price");
		  System.out.println(foodid+","+cost+","+price);
		    //传如foodid通过foodid进行修改数据
		
		 
	       shopscz sz=shopfactory.getinstance().getshopcz();
		   sz.changefood(foodid,price,cost, foodname);
		  response.sendRedirect("shop/lookfood.jsp");
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
