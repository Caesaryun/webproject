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
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/loginFilter")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
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
		 
		  System.out.println("访问的URI路径为:"+requestURI);
          System.out.println("url路径："+requesturl);
          
         // String urlxinxi=((HttpServletRequest)req).getQueryString();  //
          String urlxinxiqg=((HttpServletRequest)req).getParameter("hotelid"); //获取到hotelid
          System.out.println("现在的urlxinxi:"+urlxinxiqg);
         // String []urlxinxiqg=urlxinxi.split("\\=");
          
        //  System.out.println("filte中切割后:"+urlxinxiqg[1]);
         String hotelname = (String) ((HttpServletRequest)req).getSession().getAttribute("hotelname"); //获取店名
       
         // System.out.println("输出foods店："+hotelname);
          //让username进行比较，若username不等于数据库中的数据则跳到别的页面，
          
		if(username==null||"".equals(username)) {
			  //没有取到用户名 
			//传递uri  //同时传递url中携带的id值过去
		 ((HttpServletRequest)req).getSession().setAttribute("hotelname",hotelname);
	     ((HttpServletRequest)req).getSession().setAttribute("urlxinxi",urlxinxiqg);
	     ((HttpServletRequest)req).getSession().setAttribute("uri",requesturl.toString());
		 res.sendRedirect("../sign_in.jsp?");   //跳转到登录页面
		     //则返回到该页面登录页面
		}
		
		 //顾客的判断
	   try {
		for(int i=0;i<loginutil.getcustomer().size();i++) {
		            loginpeople lx=loginutil.getcustomer().get(i);
		            if(username.equals(lx.getusername())) {
		            	chain.doFilter(req, resp);
		            }
		}
		
		//else if(username.equals("Tom")){
			//得到用户名 可以继续操作
			// chain.doFilter(req,resp); 
		//}
		
		for(int j=0;j<loginutil.getshoper().size();j++) {
			loginpeople lss=loginutil.getshoper().get(j);
			if(username.equals(lss.getusername())) {
				
				res.sendRedirect("../sign_in.jsp");
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
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
