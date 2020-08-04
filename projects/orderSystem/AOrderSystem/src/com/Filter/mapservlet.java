package com.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Filter.*;

/**
 * Servlet implementation class mapservlet
 */
@WebServlet("/mapservlet")
public class mapservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mapservlet() {
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
			 
	       String url=(String)session.getAttribute("uri");  //取得之前想访问的链接url
		   String mapname=request.getParameter("mapname");
		    
		   session.setAttribute("mapname",mapname);  //传递给filter 也能传递给jsp
		   
	       /*
	             *     比如说得到大连开发区， 那么便匹配   开发区太白珍馐居
	        */
		   System.out.println("输出地址："+mapname);  //发送地址
	       
		  //就是将地址发送给foods.jsp页面
		    
		  request.getRequestDispatcher("other/foods.jsp?mapname="+mapname).forward(request,response);
	        //  response.sendRedirect(url+"?hotelname=太白振兴局");  //同时传递hotel名称
		    
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
