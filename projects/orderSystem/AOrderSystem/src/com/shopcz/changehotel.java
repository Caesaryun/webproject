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
 * Servlet implementation class changehotel
 */
@WebServlet("/changehotel")
public class changehotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changehotel() {
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
		shopscz sz=shopfactory.getinstance().getshopcz();
	   String hotelid=request.getParameter("hotelid");
	   String hotelname=request.getParameter("hotelname");
	   String phone=request.getParameter("phone");
	   String adder=request.getParameter("adder");
	   String qsprice=request.getParameter("qsprice");
	   String yunprice=request.getParameter("yunprice");
		String packprice=request.getParameter("packprice");
		
		sz.changehotel(hotelid, hotelname, adder, phone, qsprice, yunprice, packprice);
		
		response.sendRedirect("shop/changehotel.jsp");
		
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
