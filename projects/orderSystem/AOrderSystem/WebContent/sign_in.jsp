<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录验证</title>
<style>
 body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100%;
        }
 * {
            margin: 0;
            padding: 0;
        }
         
        html {
            height: 100%;
            width: 100%;
            overflow: hidden;
            margin: 0;
            padding: 0;
            background: url(img/3x.jpg) no-repeat 0px 0px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            -moz-background-size: 100% 100%;
        }  #login {
            position:absolute;
            left:43%;
            width: 37%;
            top:22%;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 330px;
            background-color: rgba(75, 81, 95, 0.3);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 5px;
        }
         
        #name{
            margin-left: 50px;
            color: red;
        }
         
        p {
            margin-top: 30px;
            margin-left: 20px;
            color: azure;
        }
         
        input {
            margin-left: 15px;
            border-radius: 5px;
            border-style: hidden;
            height: 30px;
            width: 200px;
            background-color: rgba(216, 191, 216, 0.5);
            outline: none;
            color: #f0edf3;
            padding-left: 10px;
           
        }
         
        .button {
            border-color: cornsilk;
            background-color: rgba(100, 149, 237, .7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 31px;
            font-size: 16px;
           
        }
    .shortselect{  
    font-size:15px;
    color: white;
    border: 0; background: transparent;
    appearance:none;
       -moz-appearance:none; /* Firefox */
       -webkit-appearance:none; /* Safari 和 Chrome */
   
}

</style>
<!-- 书写直接从输入用户名便进行系统数据的调取进行查询是否存在 -->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<!-- 使用jquery -->

<script>

function ok(){
  
	var temp=document.getElementsByName("radiouser");
	var pan=false;
	for(i=0;i<temp.length;i++){
		if(temp[i].checked){         //检测是否被选中
			//alert("您选择了"+temp[i].value);
		
			document.form1.action="signservlet?radiozhi="+temp[i].value;
			
			 document.form1.method="post";
			 document.form1.submit();
			 pan=true;
		}
	}
	if(!pan){
		//alert("请点击下方按钮选择(商家或客户)！");
		document.getElementById("typeno").style.display="";
	    setTimeout(function(){document.getElementById("typeno").style.display="none"},10000);
	}
	
}


</script>


</head>
<body>
  <% String urlxinxi=(String)session.getAttribute("urlxinxi");   //得到传递过来的店家的id值
     session.setAttribute("urlxinxi",urlxinxi);  //发送信息值
     String hotelname=(String)session.getAttribute("hotelname");
     session.setAttribute("hotelname",hotelname); //发送hotelname给servlet
   %>




<%   
String uri=(String)session.getAttribute("uri");
System.out.println("之前想访问的页面:"+uri);
     %>

<div   style="position:absolute;top:33%;left:5%;width:180px;height:70px;">
<span style="color:white;letter-spacing:11px;">最称心的美食只会在民间在一个遍寻不着的处所在最市井的街巷里往往藏着人间最好的美味</span>  </div>
<div> <a href="main.jsp"><img style="position:absolute;top:25px;width:180px;height:60px;left:40px;" src="img/2x.png"></img></a></div>
 <div id="login">
       
       <form name="form1" >
        
        <% 
         //传递uri值
           session.setAttribute("uri",uri);
        
        %>
        
        
        <div  id="typeno" style="position:absolute;display:none;top:9%;left:25%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp请选择用户类型(商家/客户)!</font></div>
        <div  id="customerno" style="position:absolute;display:none;top:9%;left:25%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp用户名不存在，请选择注册!</font></div>
        <div  id="shopno" style="position:absolute;display:none;top:9%;left:25%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp用户名不存在，请先成为商家!</font></div>
           <div  id="pwdno" style="position:absolute;display:none;top:9%;left:20%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp密码错误!</font></div>
             <div style="position:absolute;top:17%;left:25.3%;"><font color="white" size="3">账号登录</font></div>
            <div  style="position:absolute;right:28.4%;top:17%;"><a style="text-decoration:none"   href="phonesign_in.jsp"><font color="white">手机号验证码登录</font></a></div>
            <p> 
               <input placeholder="用户名/手机号/邮箱"  id="username"  name="username" type="text" required ><label id="name"></label></p>
 
            <p>  <input placeholder="密码"  required  name="password" type="password"><label id="password"></label><a style="text-decoration:none"  href="findpwd.jsp"><font size="2" color="white">找回密码</font></a></p>
           <div style="position:absolute;right:38%;">  <input style="width:10px;height:10px;"  type="radio" name="radiouser" value="shopkeeper"  ><font color="white">商家</font>
           <input type="radio" style="width:14px;height:10px;" name="radiouser"  value="customer"><font color="white">客户</font>
          
           </div>
           
            <div style="text-align: center;margin-top: 30px;">
                <input  style="position:absolute;left:22.3%;" type="submit" class="button" value="登录"  onclick="ok()" >
               <input style="position:absolute;left:45%;" type="reset" class="button" value="重置"><br>
               <br>
                <a style="text-decoration:none"  href="register.jsp"><font  color="white" size="3">没有账号?</font><font color="ffff66">立即注册</font>   </a>
            </div>
            
        </form >
    </div>


<% String msg=(String)session.getAttribute("msg");
    
%>


</body>
<script >
var msgshop="<%=request.getAttribute("msgshop")%>";

if(msgshop=='yes'){
	document.getElementById("shopno").style.display="";
    setTimeout(function(){document.getElementById("shopno").style.display="none"},10000);
	
	//不存在该商家用户
}

var msgshoppwd="<%=request.getAttribute("msgshoppwd")%>";
if(msgshoppwd=='yes'){
	document.getElementById("pwdno").style.display="";
    setTimeout(function(){document.getElementById("pwdno").style.display="none"},10000);
	//alert("密码错误！请点击找回密码！");
}
var msgcustomer="<%=request.getAttribute("msgcustomer")%>";
if(msgcustomer=='yes'){
	//alert("不存在该用户名，请选择注册！");  //顾客用户名不存在则选择注册
	document.getElementById("customerno").style.display="";
    setTimeout(function(){document.getElementById("customerno").style.display="none"},10000);
	
}

var msgcustomerpwd="<%=request.getAttribute("msgcustomerpwd")%>";
if(msgcustomerpwd=='yes'){
	document.getElementById("pwdno").style.display="";
    setTimeout(function(){document.getElementById("pwdno").style.display="none"},10000);
	  // alert("密码错误！请点击找回密码！");
}


var msg="<%=request.getAttribute("msg")%>";
if(msg=='yes'){
	
    alert("没有访问此页面的权限！自动返回登录页面！")
	//alert("密码错误！请点击找回密码！");
}

var msgshop="<%=request.getAttribute("addshopok")%>";
if(msgshop=='yes'){
	
    alert("成功注册成商家，现在进行登录吧！");
	//alert("密码错误！请点击找回密码！");
}

</script>



</html>