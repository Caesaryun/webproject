<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
    import="com.Filter.mapmodel"
    import="com.Filter.hotelmany" 
    %>
    <%@ page import="java.sql.*"%>
    
<jsp:include page="mainsecond.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{float:left;margin:10px;}
div dd{ margin:0px;font-size:10px;}
div dd.dd_name{color:blue;}
div dd.dd_city{color:#000;}


</style>
</head>
<body style="overflow-x: hidden">



 
  
 <% 
  
   String hoteladder=(String)session.getAttribute("mapname");
   //String hoteladder=request.getParameter("mapname");  //获取到地址
   System.out.println("输出地址:"+hoteladder);
 %> 
 
 <div  style="position:absolute;top:170px;">
 <h1><font color="red" size="5"><%=hoteladder %></font><font size="5">的商店</font></h1>
<hr width="1000">

<table width="750" height="60" cellpadding="0" border="0">
<tr>
<td><!-- 商店循环开始 -->
 <% 
         
        for(int i=0;i<hotelmany.getall(hoteladder).size();i++)
       {
    	 mapmodel mapl=hotelmany.getall(hoteladder).get(i);
    	  System.out.println(mapl.gethotelname());
      
 %>
 <div>
   <dl>
   
   <dt>
   <a href="http://localhost:8080/AOrderSystem/customer/buyfood.jsp?hotelid=<%=mapl.gethotelid()%>">   <!--通过id然后得到相应的店铺详细信息获取到相应id值然后得到详细的信息 -->
   
   <img src="img/<%=mapl.gethotelimg() %>"  width="120" height="120"></a>
   </dt>
   <dd class="dd_name"><%=mapl.gethotelname() %></dd>
   <dd class="dd_city">评分:<%=mapl.gethotelscore() %>分&nbsp&nbsp;地址:<%=mapl.gethoteladder() %></dd>
   
   </dl>
 </div>
 <!-- 商品循环结束 -->
 <%  
      }
   %>
  </td>
  </tr>

</table>

</div>
  
  








</body>
</html>