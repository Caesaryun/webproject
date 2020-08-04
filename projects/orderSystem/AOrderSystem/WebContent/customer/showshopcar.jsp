<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.food.shopcar"
    import="com.food.shopcarmodel"
    
    %>

<jsp:include page="customerfirst.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><style>
table.altrowstable {
font-family: verdana,arial,sans-serif;
font-size:13px;
color:#333333;
border-width: 3px;
border-color: #00CED1;
border-collapse: collapse;
}
table.altrowstable th {
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #00CED1;
}
table.altrowstable td {
border-width: 2px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
}
.oddrowcolor{
background-color:#d4e3e5;
}
.evenrowcolor{
background-color:#c3dde0;
}

</style>
<script>
function delshopcar(shopcarid){
	window.location.href="http://localhost:8080/AOrderSystem/cardelservlet?shopcarid="+shopcarid;
	
}
</script>
</head>
<body>

<% String username=(String)session.getAttribute("username");
   System.out.println("username:"+username);
    //通过用户名查询购物车
   
%>
<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
            <div style="position:absolute;left:30px;"> 
          <table  class="altrowstable"  id="alternatecolor"   border="2" >

<caption align="top"><font color='#000000' size="6">我的购物车</font></caption>

<tr>
     <td>商家名称</td>
     <td>食物名称</td>
     <td>食物单价（元）</td>
     <td>食物数量（份）</td>
     <td>配送价格（元）</td>
     <td>包装费用（元）</td> 
     <td>总价（元）</td>
     <td>操作</td>
     
  </tr>
     <% 
            
        for(int i=0;i<shopcarmodel.getallshopcar(username).size();i++){
    	     shopcar spr=shopcarmodel.getallshopcar(username).get(i);
    	 %>
     <tr>
     <td><%=spr.gethotelname() %></td>
     <td><%=spr.getfoodname() %></td>
     <td><%=spr.getfoodprice() %></td>
     <td><%=spr.getfoodnum() %></td>
     <td><%=spr.getyunprice() %></td>
     <td><%=spr.getpackprice() %></td>
     <td><%=spr.gettotalprice()%></td>
     <td><input type="button" onclick="" value="购买"><br>
         <input type="button" value="删除" onclick="delshopcar(<%=spr.getshopcarid()%>)"></td>
        
       <% } %>
       </tr> 
       </table>
      </div>
</div>
         

</body>
</html>