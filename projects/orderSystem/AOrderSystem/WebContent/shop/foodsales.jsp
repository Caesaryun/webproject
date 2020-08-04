<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="com.customercz.pageorder" 
     import="com.food.orderclass" 
    import="java.text.SimpleDateFormat"
    %>
    
 <jsp:include page="shopnavigation.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>销售额的排行,统计出每一个食物的销售额</title><style>

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
</head>
<body>
<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
         <div style="position:absolute;top:10px;width:1000px;height:50px;left:20px;background-color: white);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"><font size="5" color="#000000">销售情况</font></div>     
            <div style="position:absolute;left:40px;top:90px;"> 
            下单数量排行从高到低
            <table  class="altrowstable"  id="alternatecolor"   border="2" >
            <tr>
            
             <td>食物名称</td>
             <td>下单数量</td>
             <td>单价(元)</td>
             <td>下单总额(元)</td>
            </tr>
           
            <%  String username=(String)session.getAttribute("username");
                pageorder ps=(pageorder)session.getAttribute("pageresult");
                int count=ps.getpagecount();
                for(int i=0;i<ps.getresult().size();i++){
                	orderclass os=ps.getresult().get(i);
                
           %>
            <tr><td><%=os.getfoodname() %></td>
            <td><%=os.getfoodnum() %></td>
            <td><%=os.getfoodprice()%></td>
            <td><%=os.getsumprice() %></td>            
            
            </tr>
            <%} %>
            
            </table>
            
            
           
        <font size="4">
          <%   for(int i=1;i<=count;i++){
          %>
            
        	  <a href="http://localhost:8080/AOrderSystem/ordersail?pageno=<%=i %>">第<%=i %>页</a>  
              <% } %>
              <br>
               总共<%=count %>页</font>   
         
         
            
            
            
            </div>
            </div>
            
</body>
</html>