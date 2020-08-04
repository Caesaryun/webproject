package com.orderpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Filter.hotelmany;
import com.Filter.mapmodel;
import com.food.adder;
import com.orderpack.canjunum;
import com.registerbao.sendsms;
/**
 * Servlet implementation class orderdaoservlet
 */
@WebServlet("/orderdaoservlet")
public class orderdaoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderdaoservlet() {
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
        
		String timeid=request.getParameter("time");   //通过时间表查询到相应的送达时间
		String canjuid=request.getParameter("canju");  //通过餐具份数取到相应的份数值，进行插入订单
	   
	    
		canjunum cm=canjuutil.getcanjunum(canjuid);  //得到餐具数量
		String  canjunum=cm.getcanjunum();
		
	    arrivetime ame=arrivetimeutil.getatime(timeid);
	    String arrivetime=ame.gettime();     //到达时间
     
       
		 String bz=request.getParameter("bz");  //将备注传递到订单中
		//得到订单id，得到用户名，得到地址id
		
		String username=(String)session.getAttribute("username");  //用户名
		//out.print(username);
		String adderid=(String)session.getAttribute("adderid");  //地址id
		//out.print(adderid);
		String zsorderid=(String)session.getAttribute("zsorderid");  //暂时订单id
		//out.print(zsorderid);
		
	    String hotelname=ordersubmit.insertorderdao(username, zsorderid, adderid, bz,arrivetime, canjunum);
		//返回hotelname说明添加订单成功！
		mapmodel ml=hotelmany.gethotelphone(hotelname);  //通过hotelname查询相应的电话号码
	    String phone=ml.gethotelnumber();  //商家的电话号码
		String boss=ml.gethotelboss();
		
		adder as=addermodel.getidadder(adderid); 
		String yonghu=as.getrealname();
		
		//String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);   //验证码
		String message="尊敬的"+hotelname+""+boss+"店主，用户："+yonghu+"已经下单，请确认是否接单。";
		
	     
		String rep=sendsms.sendmessage(message,phone);  //调用发送短信即可
	    
		System.out.println(rep);
		
		
		
		
		response.getWriter().write("<html><body><div  style='position:absolute;\r\n" + 
				"            left:16%;\r\n" + 
				"            width: 65%;\r\n" + 
				"            top:1%;\r\n" + 
				"            display: flex;\r\n" + 
				"            justify-content: center;\r\n" + 
				"            align-items: center;\r\n" + 
				"            height: 50px;\r\n" + 
				"            background-color: rgba(255, 255, 25, 0.3);\r\n" + 
				"            box-shadow: 7px 7px 17px rgba(255, 255, 235, 0.5);\r\n" + 
				"            border-radius: 5px;'><font size='4' color='red'>提交订单成功！等待商家确认。现在自动跳转至主页,若未跳转点击<a href=\"http://localhost:8080/AOrderSystem/main.jsp\">太白珍馐居</a> </font></div></body></html>");
		
		response.setHeader("refresh","2;url=http://localhost:8080/AOrderSystem/main.jsp");
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
