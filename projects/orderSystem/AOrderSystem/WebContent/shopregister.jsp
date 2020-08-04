<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成为商家</title>
<script>
var yzm;

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
      yzm=xmlhttp.responseText;  //得到验证码
      
   
    
    
     
    }
  }
xmlhttp.open("GET","registersms?mobile="+mobile,true);
xmlhttp.send();
}

function checkthing(){
     var newpwd=document.getElementById("createpwd");
     var nd=newpwd.value;
     var surepwd=document.getElementById("surepwd");
     var nd2=surepwd.value;
     var ym=document.getElementById("yzm");
     var ym2=ym.value;
    
     
     if(nd==nd2){
    	 if(yzm==ym2){
    		 document.form3.action="shopregister";   //直接提交给该servlet
 			 document.form3.method="post";
			 document.form3.submit(); 
    	}
     }
	
}


</script>


</script>
</head>
<body>


<div style="position:absolute;width:100%;height:70px;top:0px;left:0px; background-color: rgba(255, 255, 255, 0.1);
            box-shadow: 3px 3px 10px rgba(52, 56, 66, 0.1);
            border-radius: 2px;"> 

<a  style="position:absolute;left:193px;top:20px;text-decoration:none;" href="main.jsp"><font style="font-family: 楷体,楷体_GB2312;" color="red" size="5">太白珍馐居</font></a>
<a style="position:absolute;left:840px;top:24.2px;"><font size='3'>已有账号?</a>
<a  style="position:absolute;left:910px;top:20px;text-decoration:none;" href="sign_in.jsp"><font  style="font-family: 楷体,楷体_GB2312;" color="red"  size="5">登录</font></a>

</div>
<form   name="form3" >
<div style="position:absolute;top:110px;left:90px;">
<font style="position:absolute;left:150px;top:12px;width:70px;">用户名称</font><input style="position:absolute;left:226px;width:240px;height:25px" type="text" name="username"><br>
<br>
<br>
<font style="position:absolute;left:150px;top:60px;width:70px;">电子邮箱</font><input style="position:absolute;left:226px;width:240px;height:25px" type="text" name="email"><br>
<br>
<br>
<font style="position:absolute;left:165px;top:117px;width:70px;">手机号</font><input style="position:absolute;left:226px;width:240px;height:25px" type="text" id="pnumber" name="pnumber"><br>
<br>
<input  style="position:absolute;left:226px;width:242px;height:24px;top:150px;" type="button" onclick="getjym()" value="获取验证码">
<br>
<br>
<font style="position:absolute;left:165px;top:192px;width:70px;">验证码</font><input style="position:absolute;left:226px;width:240px;height:25px" type="text"  id="yzm"  name="yzm"><br>
<br>
<br>
<font style="position:absolute;left:150px;top:246px;width:70px;">创建密码</font><input style="position:absolute;left:226px;width:240px;height:25px" type="text" id="createpwd" name="pwd"><br>
<br>
<br>
<font style="position:absolute;left:150px;top:300px;width:70px;">确认密码</font><input style="position:absolute;left:226px;width:240px;height:25px" type="text" id="surepwd"   name="surepwd"><br>
<br>
<br>
<input style="position:absolute;left:226px;width:240px;height:34px;border-color: cornsilk;
            background-color: rgba(100, 149, 237, 0.7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;" type="submit" onclick="checkthing()"  value="同意以下协议并注册"><br>
<br>
<a href=""><font  style="position:absolute;left:226px;width:240px;height:25px;" color="#ff6600" >《太白珍馐居网商家协议》</font></a><br>
<a href=""><font style="position:absolute;left:226px;width:240px;height:25px;" color="#ff6600" >《太白珍馐居网隐私协议》</font></a>
</div>

</form>



</body>
</html>