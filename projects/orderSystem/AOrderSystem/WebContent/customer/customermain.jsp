<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="com.customercz.cardelete"
    import="com.customercz.detailcustomer"    %>
    <jsp:include page="customerfirst.jsp"></jsp:include>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
          <div style="position:absolute;left:40px;top:40px;">
       <form action="http://localhost:8080/AOrderSystem/changegukeid" method="post">
        <table>
         <% String username=(String)session.getAttribute("username");
            System.out.println("qqq:"+username);
             detailcustomer ds=cardelete.getdetailgk(username);
             if(ds!=null){
        	  
        	  %>
         
        
        <tr><td>用户名</td><td><%=ds.getusernameid() %></td></tr>
        <tr><td>姓名</td><td><input type="text" name="realname" value="<%=ds.getrealname() %>" required></td></tr>
        <tr><td>地址</td><td><%=ds.getlocation() %></td></tr>
         <tr><td>电话</td><td><input type="text" name="phone" value="<%=ds.getphone() %>" required></td></tr>
          <tr><td>邮箱</td><td><input type="text" name="email" value="<%=ds.getemail() %>" required ></td></tr>
          <tr><td>操作</td><td><input type="submit" value="确认修改"></td>
        <%} %>
        </table>    
        </form>
            </div>
            </div>
</body>
</html>