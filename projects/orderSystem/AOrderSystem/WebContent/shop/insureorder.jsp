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
<title>查看订单的同时进行订单的确认</title>
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
function changeaccept(orderid,acceptid)
{
	 alert(orderid);
	 alert(acceptid.value); 
	 window.location.href=encodeURI("http://localhost:8080/AOrderSystem/changeaccept?orderid="+orderid+"&acceptid="+acceptid.value);   //直接提交给该servlet
}

function changerefuse(orderid,acceptid){
	 alert(orderid);
	 alert(acceptid.value); 
	 window.location.href=encodeURI("http://localhost:8080/AOrderSystem/changeaccept?orderid="+orderid+"&acceptid="+acceptid.value);   //直接提交给该servlet
}
</script>
<meta http-equiv="refresh" content="10">

</head>
<body>

<% String username=(String)session.getAttribute("username");
   session.setAttribute("username",username);
    System.out.println("insure:"+username);
%>

<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
         <div style="position:absolute;top:10px;width:1000px;height:50px;left:20px;background-color: white);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"><font size="5" color="#000000"> 最近24小时内新订单</div>     
          <div style="position:absolute;top:80px;left:20px;"> 
           <table  class="altrowstable"  id="alternatecolor"   border="2" >

            <tr><td>订单号</td>
                <td>食物名称</td>
                <td>总价(元)</td>
                <td>食物数量</td>
                <td>下单时间</td>
                <td>送货地址</td>
                <td>顾客名称</td>
                <td>顾客电话</td>
                <td>送货时间</td>
                <td>餐具数量</td>
                <td>备注</td>
                <td>订单状态</td>
                <td>操作</td>
            </tr>
         
         
           <% 
               session.setAttribute("username",username);
               
               pageorder ps=(pageorder)session.getAttribute("pageresult");
               int count=0;
               try{
               
              
                count=ps.getpagecount();    //总页数
               for(int i=0;i<ps.getresult().size();i++){
            	   orderclass fs=ps.getresult().get(i);  //
            	   
            	 %> 
             <tr>
              <td><%=fs.getorderid() %></td>
              <td><%=fs.getfoodname() %></td>
              <td><%=fs.getsumprice() %></td>
              <td><%=fs.getfoodnum() %></td>
              <td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fs.gettime()) %></td>
              <td><%=fs.getadder() %></td>
              <td><%=fs.getrealname() %></td>
              <td><%=fs.getphone()%></td>
              <td><%=fs.getarrivetime() %></td>
              <td><%=fs.getcanjunum() %></td>
              <td><%=fs.getbz() %></td>
              <td><%=fs.getacceptorder() %></td>
              <td><input type="button"  onclick="changeaccept(<%=fs.getorderid()%>,<%=fs.getacceptid()%>)" id="<%=fs.getacceptid() %>" value="商家已接单">
              <input type="button" id="<%=fs.getrefuseid()%>"   onclick="changerefuse(<%=fs.getorderid() %>,<%=fs.getrefuseid()%>)" value="商家不接单"></td>           
              <td></td>
    
             </tr>
             <%} }catch(Exception e){
            	 e.printStackTrace();
             }
             
             %>
          
          
          </table> 
        <div style="position:absolute;left:300px;">
        <font size="4">
          <%   for(int i=1;i<=count;i++){
          %>
            
        	  <a href="http://localhost:8080/AOrderSystem/shoporder?pageno=<%=i %>">第<%=i %>页</a>  
              <% } %>
              <br>
               总共<%=count %>页</font>   
          </div>
           
             </div>
  </div>
  
  
  
</body>
</html>