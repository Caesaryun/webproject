<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.customercz.pageorder" 
     import="com.food.orderclass" 
    import="java.text.SimpleDateFormat"
%>    
<jsp:include page="customerfirst.jsp"></jsp:include>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>近三个月订单</title>
<style>
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

function delorder(orderid){
	window.location.href="http://localhost:8080/AOrderSystem/delorder?orderid="+orderid;
}

</script>
<meta http-equiv="refresh" content="10">
</head>
<body>
<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: white);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
            
      <div style="position:absolute;top:10px;width:1000px;height:50px;left:20px;background-color: white);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"><font size="5" color="#000000">近三个月订单</font></div>
      <div  style="position:absolute;top:84px;width:1000px;left:20px;height:600px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.3);
            border-radius: 2px;">
           <table  class="altrowstable"  id="alternatecolor"   border="2" >

            <tr><td>下单时间</td>
                <td>订单内容</td>
                <td>价格(元)</td>
                <td>商家</td>
                <td>商家电话</td>
               <td>订单状态</td>
               <td>操作</td>
            </tr>
        <% 
         String username=(String)session.getAttribute("username");
         System.out.println("sssss"+username);
         pageorder ps=(pageorder)session.getAttribute("pageresult");
         int count=ps.getpagecount(); //总的页数
          for(int i=0;i<ps.getresult().size();i++){
        	  orderclass oss=ps.getresult().get(i);
             
        	%>
       <tr><td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(oss.gettime()) %></td>
       <td><%=oss.getfoodname() %><%=oss.getfoodnum() %>份<br>
                订单号:<%=oss.getorderid() %></td>
       <td><%=oss.getsumprice() %></td>
       <td><%=oss.gethotelname() %></td>
       <td><%=oss.gethotelphone() %>
       <td><%=oss.getacceptorder() %></td>
       <td><input type="button"  value="订单完成"><br>
           <input type="button"  onclick="delorder(<%=oss.getorderid()%>)" value="删除订单"><br>
           </td>
       </tr>
       <%} %>
        </table>
        <div style="position:absolute;left:250px;"> 
          <font size="4">
          <%   for(int i=1;i<=count;i++){
          %>
            
        	  <a href="http://localhost:8080/AOrderSystem/gukeservletorder?pageno=<%=i %>">第<%=i %>页</a>  
              <% } %>
              <br>
               总共<%=count %>页</font> 
        
        </div>
      </div>     
            
   
            </div>
</body>
</html>