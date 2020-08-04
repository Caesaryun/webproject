<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <jsp:include page="shopnavigation.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加菜品</title>
<style>

 
</style>
</head>
<body>

<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
         <div style="position:absolute;top:10px;width:1000px;height:50px;left:20px;background-color: white);
            box-shadow: 2px 2px 2px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"><font size="5" color="#000000">食品添加</font></div>     
            <div style="position:absolute;left:40px;top:90px;"> 
            
    <form action="http://localhost:8080/AOrderSystem/addfood" method="post">      
     菜名:<input type="text" name="foodname" required><br>
     价格:<input type="text" name="foodprice" required><br>
     成本:<input type="text" name="foodcost" required><br>
   <input type="submit" value="提交"><input type="reset" value="重置"><br>
   
   </form>
            
        </div>    
            
  </div>
</body>
</html>