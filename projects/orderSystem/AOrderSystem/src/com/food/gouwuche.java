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
 * Servlet implementation class gouwuche
 */
@WebServlet("/gouwuche")
public class gouwuche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gouwuche() {
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
	      
	       System.out.println("foodid:"+foodid);
	      String num=request.getParameter("foodnum");
	      int foodnum=Integer.parseInt(num);
	      
	      System.out.println("输出食物数量:"+foodnum);
       HttpSession session=request.getSession();
	   String username=(String)session.getAttribute("username");
	   System.out.println("输出用户:"+username);
	    
	    String hotelid=(String) session.getAttribute("hotelid");
		session.setAttribute("hotelid", hotelid);

		
		
		
		String str=shopcarmodel.addshopcar(foodid, foodnum, username);
	    //String str=shopcarmodel.addshopcar(foodid, foodnum, username);
		System.out.println(str);
		
	       
		out.print(str);
	    //通过数据库取得foodname,向数据库中添加购物车的数据生成购物车数据
		//有购物车id，foodname，foodnumber
		
		
		
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
