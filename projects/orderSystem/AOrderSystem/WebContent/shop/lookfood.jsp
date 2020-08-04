<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.shopcz.shopfactory"
    import="com.food.foodshow"
    import="com.shopcz.shoputil"
    import="java.util.ArrayList"
    import="com.shopcz.lookfoodcz"
    import="com.shopcz.pagemodel"
    %> 
    
 <jsp:include page="shopnavigation.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
function changefood(nameid,foodid,costid,priceid){
	// alert(costid.value);
	// alert(priceid.value);
	// alert(foodid);
	// alert(nameid.value);
	  
	window.location.href=encodeURI("http://localhost:8080/AOrderSystem/changefood?price="+priceid.value+"&cost="+costid.value+"&foodid="+foodid+"&foodname="+nameid.value);   //直接提交给该servlet
     
	
}

function delfood(foodid){
	alert(foodid)
	  
	window.location.href=encodeURI("http://localhost:8080/AOrderSystem/delfood?foodid="+foodid);   //直接提交给该servlet
     
	
}




</script><meta http-equiv="refresh" content="10000">
</head>
<body>
<% String abc=(String)session.getAttribute("abc");
  System.out.println("abc::::"+abc);
%>

<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
         <div style="position:absolute;top:10px;width:1000px;height:50px;left:20px;background-color: white);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"><font size="5" color="#000000"> 所有商品</div>     
          <div style="position:absolute;top:80px;left:20px;"> 
           <table  class="altrowstable"  id="alternatecolor"   border="2" >

            <tr><td>食物名称及样式</td>
                <td>食物评分</td>
                <td>价格(元)</td>
                <td>店铺名称</td>
                <td>菜品成本(元)</td>
              
               <td>操作</td>
               <td>删除</td>
            </tr>
         
         
           <%  String username=(String)session.getAttribute("username");
               session.setAttribute("username",username);
               System.out.println("username::"+username);
               pagemodel ps=(pagemodel)session.getAttribute("pageresult");
              
               
              // pagemodel ps=(pagemodel)request.getAttribute("pageresult");
               int count=0;
               try{
               
               System.out.println("print:"+ps);
                count=ps.getpagecount();    //总页数
               for(int i=0;i<ps.getresult().size();i++){
            	   foodshow fs=ps.getresult().get(i);  //
            	   System.out.println(fs.getcostid());
            	 %> 
             <tr>
            
       <td rowspan="1"><img style="width:20px;height:20px;" src="img/<%=fs.getimg() %>">
       <input type="text"  id="<%=fs.getnumid()%>" value="<%=fs.getfoodname() %>"></td>
          <td><%=fs.getfoodscore() %></td>
          <td><input type="text" name="foodprice" id="<%=fs.getpriceid() %>" value="<%=fs.getfoodprice() %>" ></td>
          <td><%=fs.gethotelname() %></td>
          <td><input type="text"  id="<%=fs.getcostid() %>" value="<%=fs.getfoodcost() %>"></td>
          
          <td>
             <input type="button" onclick="changefood(<%=fs.getnumid()%>,<%=fs.getfoodid()%>,<%=fs.getcostid()%>,<%=fs.getpriceid()%>)" value="确认修改"> 
             
               </td>
             <td> <input type="button" onclick="delfood(<%=fs.getfoodid()%>)" value="删除"></td>
            
             
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
            
        	  <a href="http://localhost:8080/AOrderSystem/foodseeservlet?pageno=<%=i %>">第<%=i %>页</a>  
              <% } %>
              <br>
                  
          </div>
            
             </div>
  </div>
  
  
  
</body>
</html>