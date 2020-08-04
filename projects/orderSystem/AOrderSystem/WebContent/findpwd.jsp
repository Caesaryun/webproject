<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>找回密码</title>
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
            left:38%;
            width: 37%;
            top:22%;
            display: flex;
            justify-content: center;
            align-items: center;
            height:310px;
            background-color: rgba(75, 81, 95, 0.3);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 5px;
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
           
        } .button {
            border-color: cornsilk;
            background-color: rgba(100, 149, 237, .7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 31px;
            font-size: 16px;
           
        }
        
</style>
<script> //取得验证码
var usertype;   //用户类型
var yzm;       //验证码 

function getjym()
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
    	    document.getElementById("sjherror").style.display="";
    	    setTimeout(function(){document.getElementById("sjherror").style.display="none"},10000);
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
xmlhttp.open("GET","findpwdservlet?mobile="+mobile,true);
xmlhttp.send();
}


function checkyzm(){
    var jym=document.getElementById("jym");
    var newpwd=document.getElementById("newpwd");
	var quepwd=document.getElementById("quepwd");
	var npwd=newpwd.value;
	var qpwd=quepwd.value;
	
    var yanzm=jym.value; 
    var p=false;
   if(npwd==qpwd){
    
	  if(yanzm==yzm){
    	 p=true;
    	 
    	  //验证码正确跳转到servlet中将密码存好，然后自动跳转到登录页面让其进行登录
    	 document.form2.action="changepwdservlet?usertype="+usertype;
		 document.form2.method="post";
		 document.form2.submit();
    }
   }
    if(!p){
    	//验证码不对则显示不正确
    	document.getElementById("yzmwrong").style.display="";
	    setTimeout(function(){document.getElementById("yzmwrong").style.display="none"},10000);
    	
    }
}


	


</script>

</head>
<body><div>
<a href="main.jsp">
<img style="position:absolute;top:25px;width:180px;height:60px;left:40px;" src="img/2x.png">
</img> </a></div>
<div   style="position:absolute;top:33%;left:5%;width:180px;height:70px;">
<span style="color:white;letter-spacing:11px;">最称心的美食只会在民间在一个遍寻不着的处所在最市井的街巷里往往藏着人间最好的美味</span>  </div>
<form  action=""  name="form2" >
<div  id="login"> 

<div  id="yzmwrong" style="position:absolute;display:none;top:18%;left:21%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp验证码填写错误!</font></div>
<div  id="sjherror" style="position:absolute;display:none;top:18%;left:21%;border-style:solid; border-width:1px; border-color:rgba(216, 191, 216, 0.5);width:207.5px;height:20px; background:#FFF8DC; background-color: ffffcc;">
        <font size="2" >&nbsp手机号未注册或填写错误!</font></div>    
 <h1 style="position:absolute;text-align: center; color: aliceblue;top:6%;left:31%;">找回密码</h1>
<input  id="pnumber" style="position:absolute;top:25%;left:17%;" type="text" name="pnumber" placeholder="手机号">
<p><input id="jym" style="position:absolute;width:80px;top:40%;left:17%;"  placeholder="验证码"  required  name="yzm" type="text">
 <input  style="position:absolute;left:36%;top:40%;width:120px;" type="button"  onclick="getjym()" value="获取验证码"> <label id="password"></label>
  <div style="position:absolute;display:none;left:33%;top:49.5%;color:white;"  id="testyzm"><font size="2">验证码已发送！</font><span id="numDiv">60</span></div>
  <input id="newpwd" style="position:absolute;left:17%;top:55%;width:200px;"  type="text" name="newpwd" placeholder="新密码">
  <input  id="quepwd" style="position:absolute;left:17%;top:70%;width:200px;" type="text" name="quepwd" placeholder="确认密码"  >
 <input  style="position:absolute;left:17%;width:210px;top:85%;" type="submit" class="button" value="提交"  onclick="checkyzm()">


</div>
</form>
</body>
</html>