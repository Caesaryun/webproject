<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>验证码登录</title>
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
            background-color:  rgba(75, 81, 95, 0.3);
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
        position:absolute;
            border-color: cornsilk;
            background-color: rgba(100, 149, 237, .7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 211px;
            height: 31px;
            left:22.3%;
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

<script>
var usertype;   //用户类型
var yzm;       //验证码 


function getyzm()
{	
	var pnumber=document.getElementById("pnumber");  //获取电话号码
	var mobile=pnumber.value;
	
	
   var xmlhttp;    
  
 if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    //  document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
     var x=xmlhttp.responseText;
     var y=x.split(",");    //以逗号作为分割
     usertype=y[0];   //用户类型
     yzm=y[1];  //验证码
    
     if(usertype=='nonumber'){
    	    document.getElementById("sjhwzc").style.display="";
    	    setTimeout(function(){document.getElementById("sjhwzc").style.display="none"},10000);
    	    //提示手机号未注册
     }
     if(usertype=='shopncz'){
    	 
    	 document.getElementById("testyzm").style.display="";
    	 //倒计时
    	 var num=60;
    	 var interval=setInterval(function(){
    	 	if(num==0){
    	 	clearInterval(interval);
    	 	}
    	 	numDiv.innerHTML=num--;
    	 },1000);
  		 setTimeout(function(){document.getElementById("testyzm").style.display="none"},60000);
    	
  
     }
     if(usertype=='cnumbercz'){
    	 
    	 document.getElementById("testyzm").style.display="";
    	 var num=60;
    	 var interval=setInterval(function(){
    	 	if(num==0){
    	 	clearInterval(interval);
    	 	}
    	 	numDiv.innerHTML=num--;
    	 },1000);
  		 setTimeout(function(){document.getElementById("testyzm").style.display="none"},60000);
     }
     // alert("usertyep"+usertype);
    // alert("yzm"+yzm);
     
    }
  }
xmlhttp.open("GET","sendsms?mobile="+mobile,true);
xmlhttp.send();
}

function loginyzm(){
	    var jym=document.getElementById("jym");
	    var yanzm=jym.value; 
	    var p=false;
	    if(yanzm==yzm){
	    	 p=true;
	    	 document.form1.action="loginsecond?usertype="+usertype;
			 document.form1.method="post";
			 document.form1.submit();
	    }
	    if(!p){
	    	//验证码不对则显示不正确
	    	document.getElementById("yzmwrong").style.display="";
    	    setTimeout(function(){document.getElementById("yzmwrong").style.display="none"},10000);
	    	
	    }
}





</script>

</head>
<body>

<div   style="position:absolute;top:33%;left:5%;width:180px;height:70px;">
<span style="color:white;letter-spacing:11px;">最称心的美食只会在民间在一个遍寻不着的处所在最市井的街巷里往往藏着人间最好的美味</span>  </div>
<div> <a href="main.jsp"><img style="position:absolute;top:25px;width:180px;height:60px;left:40px;" src="img/2x.png"></img></a></div>
<div id="login">
        <form  action=""  name="form1" method="post" >
        <div  id="yzmwrong" style="position:absolute;display:none;top:38%;left:25%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp验证码填写错误!</font></div>
        <div  id="sjhwzc" style="position:absolute;display:none;top:10%;left:25%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp手机号未注册!</font></div>
    <div style="position:absolute;top:17%;left:25.8%;"><font color="white" size="3">账号登录</font></div>
    <div style="position:absolute;right:29%;top:17%;"><a style="text-decoration:none" href="sign_in.jsp"><font size="3" color="white">普通方式登录</font></a></div>
            
          
            <p> 
            <input   placeholder="手机号"  id="pnumber"  name="pnumber" type="text" required   onkeyup="value=value.replace(/[^(\d)]/g,'')" ><label id="name"></label> 
            </p>
            
         <p>
        
         <input id="jym" style="width:80px;"  placeholder="验证码"  required  name="yzm" type="text">   
         <input   style="position:absolute;left:41.7%;width:120px;" type="button"  onclick="getyzm()" value="获取验证码"> <label id="password"></label>
          <div style="position:absolute;display:none;left:33%;top:55%;color:white;"  id="testyzm"><font size="2">验证码已发送！</font><span id="numDiv">60</span></div>
         </p>
          
           
            <div style="text-align: center;margin-top: 30px;">
                <input type="submit" class="button" value="登录"  onclick="loginyzm()"><br>
                <br>
                <a style="text-decoration:none"  href="register.jsp"><font  color="white" size="3">用户不存在?</font><font color="ffff66">立即注册</font>   </a>
                <br>
               
            </div>
            
        </form >
    </div>

</body>



</html>