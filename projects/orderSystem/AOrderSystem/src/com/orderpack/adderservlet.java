package com.orderpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adderservlet
 */
@WebServlet("/adderservlet")
public class adderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adderservlet() {
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
		   String username=(String)session.getAttribute("username");    //用户名id
		   //System.out.println("用户名xxxxx"+username);
		   String realname=request.getParameter("name");
		   //System.out.println("name:"+realname);
		   out.print(realname);
		   String dizhi=request.getParameter("adder");
		   out.print(dizhi);
		   String phone=request.getParameter("phone");
		   out.println(phone);
		  
		  String str=addermodel.addadder(username,dizhi, phone,realname);
		  System.out.println(str);
		
		  response.sendRedirect("customer/adder.jsp");
		
		
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
