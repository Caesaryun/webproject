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
 * Servlet implementation class addfood
 */
@WebServlet("/addfood")
public class addfood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addfood() {
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
		String price=request.getParameter("foodprice");
		String username=(String) session.getAttribute("username");
		String cost=request.getParameter("foodcost");
		double foodprice=0;
		double foodcost=0;
		try {
	     foodprice=Double.parseDouble(price);
	     foodcost=Double.parseDouble(cost);
		}catch(Exception e) {
			e.printStackTrace();
		}
		shopscz sz=shopfactory.getinstance().getshopcz();
		sz.addfood(foodname, foodprice, username, foodcost);
		//hx.getshopcz().addfood(foodname, foodprice, username, foodcost);

		System.out.println("ok");
		response.sendRedirect("shop/addfood.jsp");
		
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
