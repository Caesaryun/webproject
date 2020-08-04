package com.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class mapFilter
 */
@WebFilter("/mapFilter")
public class mapFilter implements Filter {

    /**
     * Default constructor. 
     */
    public mapFilter() {
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
		String mapname = (String) ((HttpServletRequest)req).getSession().getAttribute("mapname");
		 
		 String requestURI = ((HttpServletRequest)req).getRequestURI();   //获得用户请求的uri
		
		 StringBuffer requesturl=((HttpServletRequest)req).getRequestURL();
		 
		 HttpServletResponse res = (HttpServletResponse)resp;
		 //getRequestURI() ，当用户不曾登录的时候，记住要访问的地址，然后登录成功后跳转到之前
		 //想要访问的地址
		  System.out.println("输出地址："+mapname);
		 
		  System.out.println("访问的URI路径为:"+requestURI);
         System.out.println("url路径："+requesturl);
		   
		 
		if(mapname==null||"".equals(mapname)) {
			   //没有取到mapname 
			  //传递uri  
			
	     ((HttpServletRequest)req).getSession().setAttribute("uri",requesturl.toString());
		 res.sendRedirect("../map.jsp?");   //跳转到地图页面 ，通过输入地址定位搜索店家，
		     //则返回到该页面登录页面
		}
		else {
			//得到用户名 可以继续操作
			 chain.doFilter(req,resp); 
		} 
		
		 
		
		
		
		
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
