<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <jsp:include page="shopnavigation.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创建一个店员</title>
</head>
<body>
<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
         <div style="position:absolute;top:10px;width:1000px;height:50px;left:20px;background-color: white);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"><font size="5" color="#000000">创建店员</div>     
 <div style="position:absolute;top:80px;left:20px;"> 




<form  action="http://localhost:8080/AOrderSystem/createassitant" method="post">
<input type="text" name="username" placeholder="输入店员名称" required><br>
<input type="password" name="password" placeholder="输入密码" required><br>
<input type="submit" value="确认创建"> <br>
</form>
</div>
</div>
</body>




</html>