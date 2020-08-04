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
 * Servlet Filter implementation class shoploginfilter
 */
@WebFilter("/shoploginfilter")
public class shoploginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public shoploginfilter() {
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
       String username = (String) ((HttpServletRequest)req).getSession().getAttribute("username");
		 
		 String requestURI = ((HttpServletRequest)req).getRequestURI();   //获得用户请求的uri
		
		 StringBuffer requesturl=((HttpServletRequest)req).getRequestURL();
		 
		 HttpServletResponse res = (HttpServletResponse)resp;
		 //getRequestURI() ，当用户不曾登录的时候，记住要访问的地址，然后登录成功后跳转到之前
		 //想要访问的地址
		  System.out.println("输出Filterusername："+username);
		 
		  /*
		   * 通过给予用户名遍历查询出相应的用户名才能访问
		   */
          

          
		if(username==null||"".equals(username)) {
			 
	     ((HttpServletRequest)req).getSession().setAttribute("uri",requesturl.toString());
		 res.sendRedirect("../sign_in.jsp?");   //跳转到登录页面
		     //则返回到该页面登录页面
		}
		//这里是商家的验证
		try {
		for(int i=0;i<loginutil.getshoper().size();i++) {
			 loginpeople ls=loginutil.getshoper().get(i);
			 if(username.equals(ls.getusername())) {
				 chain.doFilter(req,resp); 
			 }
		}
		
		for(int j=0;j<loginutil.getcustomer().size();j++) {
			 loginpeople les=loginutil.getcustomer().get(j);
			 if(username.equals(les.getusername())) {
				 ((HttpServletRequest)req).getSession().setAttribute("msg","yes");
				 res.sendRedirect("../sign_in.jsp");
			 }
		}  
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
