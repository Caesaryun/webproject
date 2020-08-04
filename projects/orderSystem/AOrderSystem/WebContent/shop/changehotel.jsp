<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  
    
    import="com.shopcz.lookfoodcz"
    import="com.Filter.mapmodel"  
    %> 
    <jsp:include page="shopnavigation.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改店面信息</title>

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

function changehotel(id){
	
	 document.form10.action="http://localhost:8080/AOrderSystem/changehotel?hotelid="+id;   //直接提交给该servlet
	 document.form10.method="post";
	 document.form10.submit(); 
}


</script>
</head>
<body>

<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
         <div style="position:absolute;top:10px;width:1000px;height:50px;left:20px;background-color: white);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"><font size="5" color="#000000"> 所有商品</div>     
          <div style="position:absolute;top:80px;left:20px;"> 
      
      <form name="form10" >
      
           <table  class="altrowstable"  id="alternatecolor"   border="2" >
<%   String username=(String)session.getAttribute("username");
      
      System.out.println(username);
      mapmodel m=lookfoodcz.gethoteldetail(username);
      if(m!=null){
    	 
    
%>

<tr><td>图片</td><td><img   style="width:89px;height:50px;" src="img/<%=m.gethotelimg() %>"></td></tr>
<tr><td>店名</td><td><input type="text" name="hotelname" value="<%=m.gethotelname() %>"></td></tr>
<tr><td>店长</td><td><%=m.gethotelboss() %></td></tr>
<tr><td>电话</td><td><input type="text" name="phone" value="<%=m.gethotelnumber() %>"></td></tr>
<tr><td>地址</td><td><input type="text" name="adder" value="<%=m.gethoteladder() %>"></td></tr>
<tr><td>起送价格</td><td><input type="text" name="qsprice" value="<%=m.gethotelqsprice() %>"></td></tr>
<tr><td>配送价格</td><td><input type="text" name="yunprice" value="<%=m.gethotelyunprice()%>"></td></tr>
<tr><td>包装费用</td><td><input type="text" name="packprice" value="<%=m.getpackprice() %>"></td></tr>

<tr><td>操作</td><td><input type="button" onclick="changehotel(<%=m.gethotelid() %>)"  value="确认修改"></td></tr>
<% } %>
</table>
</form>
</div>
</div>
</body>
</html>