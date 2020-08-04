<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
    import="com.food.orderutil"  
    import="com.food.adder"
    import="com.food.orderclass"
    import="com.orderpack.addermodel"  
    
    %>
    <jsp:include page="customerfirst.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style type="text/css">
body {       background-image: url(img/12.jpg);    
                    background-size:cover;/*         图像不重复显示  */
                    height:100%;
                    width:100%;
                    background-repeat:no-repeat;
                    min-width:1200px;
        }
#login { 
            position:absolute;
            top:70px;
            left:290px;
            width: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 420px;
            background-color: rgba(255,255,255,0);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 5px;
           
        }
       .button {
            border-color: cornsilk;
            background-color: rgba(100, 149, 237, .7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
           height:28px;
            font-size: 16px;
        } 
       
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

</script>

</script>
</head>
<body>

<div style="position:absolute;top:100px;width:1100px;left:208px;height:450px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
   <%  
      String username=(String)session.getAttribute("username"); 
      System.out.println("用户："+username);
      String adderid=request.getParameter("adderid");  //获取到adderid
      System.out.println("axxxxx:"+adderid);
     
      if(adderid==null){
    	 adderid="12";
       }
    	    
    	System.out.println(adderid);
      
      
      int  adid=Integer.parseInt(adderid);
      
       
      
      String dizhi="noadder";  //首先地址
     for(int i=0;i<addermodel.getdetailadder(username).size();i++){
        	adder as=addermodel.getdetailadder(username).get(i);
        	dizhi=as.getadder();
        	
        	if(as.getadderid()==adid){
        		
        		dizhi=as.getadder();
        		System.out.println("dizhi");
        		break;
        	}
        	//只需要一个就行
        }
       
        session.setAttribute("dizhi", dizhi);     //发送地址名称
        session.setAttribute("adderid",adderid);  //发送地址id
       
      
    
 %>
   <a style="position:absolute;left:40px;" href="http://localhost:8080/AOrderSystem/customer/adder.jsp">收货地址管理:<%=dizhi %></a>
   
 <div style="position:absolute;left:40px;top:20px;">
<table  class="altrowstable"  id="alternatecolor"   border="2" >

<caption align="top"><font color='#000000' size="6">确认订单</font></caption>

<tr>
     <td>商家名称</td>
     <td>食物名称</td>
     <td>食物单价（元）</td>
     <td>食物数量（份）</td>
     <td>配送价格（元）</td>
     <td>包装费用（元）</td> 
     <td>总价（元）</td>
     <td>提交订单</td>
     <td>删除</td>
  </tr>
  <tr>
  <%    int zsorderid=0;  //暂时订单id  //通过用户名查询到其的暂时订单，避免出错
        for(int i=0;i<orderutil.getallorderzs(username).size();i++){
               orderclass oders=orderutil.getallorderzs(username).get(i);
               System.out.println("size:"+orderutil.getallorderzs(username).size());
               zsorderid=i; //传递该暂时的id号过去，之后添加数据库时候，只需要相应的条添加即可
	  %>
  <td><%=oders.gethotelname() %></td>
  <td><%=oders.getfoodname() %></td>
  <td><%=oders.getfoodprice() %></td>
  <td><%=oders.getfoodnum() %></td>
  <td><%=oders.getpeisong() %></td>
  <td><%=oders.getpackprice() %></td>
  <td><%=oders.getsumprice() %></td>
  
  <td><a href="http://localhost:8080/AOrderSystem/orderyz?zsorderid=<%=zsorderid%>">提交订单</a> </td> <!-- 先提交到servlet里面确定地址是否填写，若没有则跳转到地址填写 -->
  <td><input type="button" onclick=""  value="提交"></td>
  </tr>
  <%} %>
  </table>
 </div>
  
  </div>
</body>
<script>
 

</script>





</html>