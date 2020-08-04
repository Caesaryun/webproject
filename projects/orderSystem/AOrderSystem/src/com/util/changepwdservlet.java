package com.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changepwdservlet
 */
@WebServlet("/changepwdservlet")
public class changepwdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepwdservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//将密码进行修改即可两个都有且建立方法
		String usertype=request.getParameter("usertype");  //用户类型
		String pnumber=request.getParameter("pnumber");   
		String pwd=request.getParameter("quepwd");
		factorychangepwd fd=new factorychangepwd();
		changepassword cd=fd.getxgtype(usertype);
	    String str=cd.changemima(pnumber, pwd);
		if(str.equals("changeok")) {
		    System.out.print("修改成功！");
		    request.getRequestDispatcher("sign_in.jsp").forward(request,response);
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
