package com.registerbao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class shopregister
 */
@WebServlet("/shopregister")
public class shopregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopregister() {
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
	       
		String username=request.getParameter("username");  //用户名
		String pwd=request.getParameter("pwd");
		String pnumber=request.getParameter("pnumber");
		String email=request.getParameter("email");
		System.out.println(username);
	    System.out.println("xxx:"+pwd);
	    String str=registerlei.addshop(username, pwd, pnumber, email);
		if(str.equals("addshopok")) {
			System.out.println("恭喜成为商家,现在对你的店进行操作吧！");
			request.setAttribute("addshopok","yes");
			
			  RequestDispatcher requestDispatcher=request.getRequestDispatcher("/sign_in.jsp"); 
			  requestDispatcher.forward(request,response);
		}
		
		
		
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
