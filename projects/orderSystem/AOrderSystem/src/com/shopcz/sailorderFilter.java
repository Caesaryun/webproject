package com.shopcz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.customercz.pageorder;
import com.food.foodshow;
import com.food.orderclass;

/**
 * Servlet Filter implementation class sailorderFilter
 */
@WebFilter("/sailorderFilter")
public class sailorderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public sailorderFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 int pageno=1; 
		  int pagesize=3;
		 
		  //传递来pageno 及大小 
		 
		  resp.setContentType("text/html;charset=UTF-8");
	    
		 
		   
		   
		  PrintWriter out = resp.getWriter();		
	      req.setCharacterEncoding("utf-8");
		  HttpSession session=((HttpServletRequest) req).getSession();
		  String pagenostr=(String)session.getAttribute("pageno");  ///获取页码
		  if(pagenostr==null) {
			  pagenostr="1";  //显示第一条，打开jsp则显示第一条
		  }
			String pagesizestr="3";  //规定每一次的page显示3条数据
		   
		
		  pageno=Integer.parseInt(pagenostr);
		  pagesize=Integer.parseInt(pagesizestr);
		  
		  String username=(String)session.getAttribute("username");
		 session.setAttribute("username",username);
		  
		  shopscz sz=shopfactory.getinstance().getshopcz();
		 
		  List<orderclass> fy=sz.getorderdesc(username, pagenostr, pagesizestr);
		  int count=sz.getordersailsize(username);    //这里是得到数据的多少
		 
		  System.out.println("数量:"+count);
		  
		  pageorder pl=new pageorder();
		  
		  pl.setpageno(pageno);
		  pl.setpagesize(pagesize);
		  pl.setresult(fy); //插入页面数据
		  pl.setcount(count);
		 System.out.println("this is a ordersailfilter"+count);
		  if(count%pagesize!=0) {
			  pl.setpagecount(count/pagesize+1);
			  System.out.println("大小："+pl.getpagecount());
		  }
		  else {
			 pl.setpagecount(count/pagesize+1);
		  }
		  
		   resp.setCharacterEncoding("utf-8");
	       req.setAttribute("pageresult",pl);  //发送数据到jsp，在jsp运行前先执行一遍它
           session.setAttribute("pageresult",pl);
	    
		  
		   chain.doFilter(req, resp);
		   
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
