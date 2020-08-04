<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="customernavigation.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

  .menubar{list-style-type:none;}
   

</style>
  
</head>
<body  style="overflow-x: hidden">
<% String username=(String)session.getAttribute("username");
   session.setAttribute("username",username);
 %>
<div style="position:absolute;top:100px;width:200px;height:500px;background-color: rgba(255, 255, 240, 0.3);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 5px;">    
<span style="font-size:18px;">
	<div class="menu">
		<ul class="menubar">
			<li class="menu-value">
		    <li ><a href="customermain.jsp"><font color="#000000">全部功能</font></a> </li><br>
		   
			<li ><a ><font >我的订单</font></a></li>
			
			<li><a href="orderstate.jsp"><font size="2" color="#000000">近三个月订单</font></a></li><br>
			<li>我的资产</li>
			<li><a><font size="2" color="#000000">我的余额</font></a></li>
			<li><a><font size="2" color="#000000"></font></a></li>
		   <br>
		   <li>我的资料</li>
		   <li><a href="customermain.jsp"><font color="#000000" size="2">个人资料</font></a></li>
		   <li><a href="adder.jsp"><font color="#000000" size="2">地址管理</font></a></li>
		   <br>
		   <li>我的购物车</li>
		   <li><a href="showshopcar.jsp"><font color="#000000" size="2">查看购物车</font></a></li>
		  
      
	</div>
	</span>
	</div>

            
<!-- -分割线 -->   









</body>

</html>