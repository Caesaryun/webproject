<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


a{ text-decoration: none; }

.list{padding-left:30px;list-style-type:none;}
.list li{float:left;}

.list li a{ padding: 0 36px; color:white;line-height:32px; display: block; transition: 0.3s; }
.list li a:hover{background:#484891; color:#fff;}

.list li a.on{background:#484891; color:#fff; }
.list b{display: block;}
.list .down{background-color:#FFA042; display: none; }
.list .down a{ color: #000000; padding-left: 30px; display: block; }


.list2{list-style-type:none;}
.list2 li{float:left;}
.list2 li a{padding:0 25px;display:block;}

.list2 li a.on{ background:white; color:#fff; }

.list2 .down{background-color:white; display: none;top:25px;font-size:19px; }
.list2 .down a{color: #000000; padding-left: 28px; display: block;}


</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>  
<script type="text/javascript" src="http://gsgd.co.uk/sandbox/jquery/easing/jquery.easing.1.3.js"></script>  

<script>


$(function () {
	  $(".list li").hover(function () {
	    //这里使用了easing插件
	    $(this).find(".down").stop().slideDown({duration:400,easing:"easeInOutCirc"});
	  }, function () {
	    $(this).find(".down").stop().slideUp({duration:400,easing:"easeInOutCirc"});
	  });
	});
	
$(function () {
	  $(".list2 li").hover(function () {
	    //这里使用了easing插件
	    $(this).find(".down").stop().slideDown({duration:400,easing:"easeInOutCirc"});
	  }, function () {
	    $(this).find(".down").stop().slideUp({duration:400,easing:"easeInOutCirc"});
	  });
	});



</script>
<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="jqueryui/style.css">
</head>
<body>
<!-- 客户的导航栏，主要的功能等 -->
<!-- 首先得有查看 -->

<%  
      //发送从filter处得到的uri给servlet
    String username=(String)session.getAttribute("username");
    //String username=request.getParameter("username");  //从这里接收到登录传来的用户信息然后
    //username="小明";                            //
%>

<div style="position:absolute;top:0px;width:100%;height:10px;left:0px; background-color:	;
         border-radius: 0px;">
       <ul class="list2">
      
       
       
       <li><a style="position:absolute;top:4.3px;left:51px;color:#000000;" href="http://localhost:8080/AOrderSystem/main.jsp">太白珍馐居首页</a></li>
       <li><a style="position:absolute;top:4.3px;left:230px;color:#000000" href="/customer/orderstate.jsp">我的订单</a></li>
       <li><a style="position:absolute;top:4.3px;left:340px;color:#000000" >人工服务</a></li>
       <li><a style="position:absolute;top:4.3px;left:800px;color:#000000" >规则中心</a></li>
       <li><a style="position:absolute;top:4.3px;left:990px;color:#000000;"><b>
       <img style="position:absolute;width:17.5px;height:17.5px;right:100px;top:1.9px;" src ="img/头像.jpg" />
              用户:<%=username %></b>
         <div class="down"  style="position:absolute;left:990px;z-index:1;">
         <a href="customermain.jsp">个人信息</a>
         <a >我的收藏</a>
         <a href="adder.jsp">我的地址</a>
         <a href="exit.jsp">退出</a>         
         </div>
       </a>
            
         
        </li>
       </ul>  
         
         
        </div>
<div style="position:absolute;top:35px;width:100%;height:59px;left:0px; background-color:#FFA042;
         border-radius: 1px;">
         <ul class="list">
                    <li><a href="customermain.jsp">我的太白珍馐居</a></li>
                    <li><a href="http://localhost:8080/AOrderSystem/main.jsp">首页</a></li>
                    <li><a><b>账户设置</b>
                    <div  class="down">
                    
                    <a href="customermain.jsp">个人信息</a>
                    <a href="adder.jsp">修改地址</a>
                    <a >修改头像昵称</a>
                    <a >修改登录密码</a>
                    <a >密保问题设置</a>
                    <a >消息设置</a>
                    <a >其他</a>                    
                  </div>
                    </a></li>
                    <li><a ><b>消息</b>
                    <div class="down">
                    <a><b>服务消息</b><div class="down">
                    <a  >物流情况</a>
                
                    </div> </a>
                    <a><b>互动消息</b>
                    <div class="down">
                    <a >评论</a>
                    <a >私信</a>
                    </div>
                    </a>
                    
                    </div>
                    
                    </a>
                  <li>
                  <form action="">
            <input placeholder="食物名称" style="position:absolute;left:830px;width:200px;height:29px;
            color:#000000;
            border-style: hidden;
            border-radius: 5px;
            font-size: 16px;" type="text"  name="food">
           <input  style="position:absolute;left:1032px;height:20px;top:14.9px;border-color: cornsilk;
            background-color: rgba(100, 149, 237, 0.7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 31px;
            font-size: 16px;" type="submit" value="搜索"> 
                  </form>
                  </li> 
         </ul>
   
      
         
         </div>

</body>
	

</html>