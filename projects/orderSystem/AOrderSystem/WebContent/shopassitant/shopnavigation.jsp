<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .menubar{list-style-type:none;}

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
       <li><a style="position:absolute;top:4.3px;left:230px;color:#000000" href="">商家信息</a></li>
       <li><a style="position:absolute;top:4.3px;left:340px;color:#000000" href="">人工服务</a></li>
       <li><a style="position:absolute;top:4.3px;left:800px;color:#000000" href="">规则中心</a></li>
       <li><a style="position:absolute;top:4.3px;left:990px;color:#000000;"><b>
       <img style="position:absolute;width:17.5px;height:17.5px;right:100px;top:1.9px;" src ="img/头像.jpg" />
              商家:<%=username %></b>
         <div class="down"  style="position:absolute;left:990px;z-index:1;">
         <a href="">商家信息</a>

         <a href="">我的商店地址</a>
         <a href="">退出</a>         
         </div>
       </a>
            
         
        </li>
       </ul>  
         
         
        </div>
<div style="position:absolute;top:35px;width:100%;height:59px;left:0px; background-color:#FFA042;
         border-radius: 1px;">
         <ul class="list">
                    <li><a href="">我的商店</a></li>
                    <li><a href="http://localhost:8080/AOrderSystem/main.jsp">首页</a></li>
                    <li><a><b>账户设置</b>
                    <div  class="down">
                    
                    <a href="">店铺管理</a>
                    
                    <a href="">添加菜单</a>
                    <a href="">修改菜单</a>
                    <a href="">查看订单</a>
                    <a href="">查看销量</a>
                    <a href="">其他</a>                    
                  </div>
                    </a></li>
                    <li><a href=""><b>消息</b>
                    <div class="down">
                    <a><b>订单消息</b><div class="down">
                    <a href=""></a>
                
                    </div> </a>
                    <a><b>互动消息</b>
                    <div class="down">
                    <a href="">评论</a>
                    <a href="">私信</a>
                    </div>
                    </a>
                    
                    </div>
                    
                    </a>
                  <li>
                  <form action="">
            <input placeholder="xxx" style="position:absolute;left:830px;width:200px;height:29px;
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
         
         
    <div style="position:absolute;top:100px;width:200px;height:500px;background-color: rgba(255, 255, 240, 0.3);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 5px;">    
<span style="font-size:18px;">
	<div class="menu">
		<ul class="menubar">
			<li class="menu-value">
		    <li ><a href=""><font color="#000000">全部功能</font></a> </li><br>
		   
			<li ><a ><font >店铺订单</font></a></li>
			<li><a href="lookorders.jsp"><font size="2" color="#000000">新订单</font></a></li>
			<li><a href=""><font size="2" color="#000000">近三个月订单</font></a></li>
			<br>
			
			<li>商店收益</li>
			<li><a href=""><font size="2" color="#000000">总销售额</font></a></li>
			<li><a href=""><font size="2" color="#000000">利润</font></a></li>
		   <br>
		   <li>店铺管理</li>
		    <li><a href="changehotel.jsp"><font color="#000000" size="2">店铺信息修改</font></a></li>
		   <li><a href="addfood.jsp"><font color="#000000" size="2">菜品添加</font></a></li>
		   <li><a href=""><font color="#000000" size="2">菜品修改</font></a></li>
		    <li><a href="lookfood.jsp"><font color="#000000" size="2">查看菜品</font></a></li>
	      <br>
		   <li>地址管理</li>
		   <li><a href=""><font color="#000000" size="2">修改地址</font></a></li>
           <br>
		 
	</div>
	</span>
	</div>
         

</body>
	

</html>