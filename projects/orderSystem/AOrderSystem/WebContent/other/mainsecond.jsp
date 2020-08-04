<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>太白珍馐居---缘来的味道</title>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="jqueryui/style.css">
   <script>
  $(function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "explode",
        duration: 1000
      }
    });
 
    $( "#opener" ).click(function() {
      $( "#dialog" ).dialog( "open" );
    });
  });
  
  </script>
  <style>
  a{ text-decoration: none; }
  
  .list3{padding-left:30px;list-style-type:none;}
  .list3 li{float:left;}
  .list3 li a{padding:15px;line-height:10px;color:#000000;}
  .list3 li a:hover{background:#FFD306;color:#fff;}
  
  
.list3 .down{background-color:white; display:none;position:absolute;top:47.5px;width:125px;font-size:15px; }
.list3 .down a{color:#000000; padding-left: 26px; display: block;}

.list4{list-style-type:none;}
.list4 li{margin-top:10px;}
.list4 li a{padding:14px;color:#000000;}

.ex2 li a{font-size:13px;}
.list4 a:hover{color:#FF8040;}
.ex2 a:active{font-family:'楷体';}
.ex2 a:hover,
.ex2 a:active {font-size:120%;}


.list5{list-style-type:none;}
.list5 li{float:left;}
.list5 li a{padding:23px;color:#000000;}
.list5 a:hover{color:#ff8040;}
.list5 a:active{font-family:'黑体';}
.ex3 a:hover,
.list5 a:active{font-size:120%;}


 .outer{
        height: 420px;
        width: 690px;
        margin: 5px auto;
        margin-top:2px;
        margin-left:270px;
        position:relative;
       
    }
     
    .img li{
        position: absolute;
        top: 0;
        left: 0;
    }
    
    .num{
        position: absolute;
        text-align: center;
        width: 100%;
        bottom: 30px;
    }
  
    .num li{
        display: inline-block;
        width: 20px;
        height: 20px;
        background-color: darkgray;
        color: white;
        text-align: center;
        line-height: 20px;
        border-radius: 50%;
        margin: 0 20px;
    }
    
    .btn{
        position: absolute;
        width: 20px;
        height: 50px;
        background-color: darkgray;
        color: white;
        text-align: center;
        line-height: 50px;
        top: 50%;
        margin-top: -25px;
        display: none;
    }
     
    .left_btn{
        left: 0;
    }
     
    .right_btn{
        right: 0;
    }
    
    .outer:hover .btn{
        display: inline-block;
        cursor: pointer;
    }
   
    .current{
        background-color: red!important;
    }




  </style>
  
  <script>
  $(function () {
	  $(".list3 li").hover(function () {
	    //这里使用了easing插件
	    $(this).find(".down").stop().slideDown({duration:400,easing:"easeInOutCirc"});
	  }, function () {
	    $(this).find(".down").stop().slideUp({duration:400,easing:"easeInOutCirc"});
	  });
	});
  
  
  </script>
</head>
<body>


<div style="position:absolute;border:2px;width:100%;height:43px;background-color:#F0F0F0	 ;
            box-shadow: 3px 2px 10px rgba(52, 56, 66, 0.1);
            border-radius: 2px;left:0px;top:0px;">
           <ul class="list3">
           <li><img style="position:absolute;width:18px;height:20px;left:12px;z-index:0;" src="img/6.jpg"><a href="http://localhost:8080/AOrderSystem/map.jsp">定位</a></li>
           <li><a href="http://localhost:8080/AOrderSystem/sign_in.jsp"><font color="#FF5151">立即登录</font></a></li>
           <li><a href="register.jsp">注册</a></li>
           <li><b><a style="position:absolute;left:800px;top:2px;height:15.6px;" href="http://localhost:8080/AOrderSystem/customer/customermain.jsp">我的太白珍馐居</a></b>
              <div style="position:absolute;left:810px;z-index:1;" class="down">
              <a href="http://localhost:8080/AOrderSystem/customer/orderstate.jsp">我的订单</a>
              <a >我的收藏</a>
              <a >优惠券</a>
              <a >账户设置</a>
              </div>
           </li>
           <li><b><a style="position:absolute;left:960px;top:1.8px;" href="http://localhost:8080/AOrderSystem/shop/changehotel.jsp">商家管理中心</a></b>
           <div style="position:absolute;left:960px;z-index:1;" class="down">
           <a href="http://localhost:8080/AOrderSystem/sign_in.jsp">登录</a>
           <a href="http://localhost:8080/AOrderSystem/shop/lookfood.jsp">商品管理</a>
           <a >评价管理</a>
          
           
           </div>
           </li>
           </ul> 
           
            
   </div>
   
  
   
   
 <a href="http://localhost:8080/AOrderSystem/main.jsp"><img style="position:absolute;height:43px;top:69.5px;left:87px;" src="img/商标.png"></a>
 
 <form action=""> <!-- 局部刷新的方式进行搜索菜品-->
 <input style="position:absolute;top:75px;left:380px;width:450px;height:33px;border:0.5px solid #FFD306"  type="text" name="search" placeholder="食物关键字">
 <input style="position:absolute;top:74px;left:830.5px;border-color: cornsilk;
            background-color: #FFD306;
            color:#000000;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 38px;font-size: 16px;" type="submit" value="搜索" onclick="">
 </form>
 
 
<!-- 这里进行主要的框架 中间部分 -->
<div style="position:absolute;top:190px;left:0px;border:2px;width:100%;height:700px;background-color:#F0F0F0	 ;
            box-shadow: 3px 2px 10px rgba(52, 56, 66, 0.1);
            border-radius: 2px;">
  
<!-- 中间用来写滚动图片 -->

</div>
   
   
   
 </div>
 
 
 <!-- -来写标题 -->
   
 
 


   
<!-- 这里即是最下面的东西 也即是最低部的部分-->

<div style="position:absolute;top:969px;border:2px;left:0px;width:100%;height:600px;background-color:#F0F0F0	 ;
            box-shadow: 3px 2px 10px rgba(52, 56, 66, 0.1);
            border-radius: 2px;">
            
            
            
            </div>

<div  id="dialog" title="Basic dialog">
  <p>(1)用户若未能按时的收到食物，请及时的进行反馈，或者稍等外卖小哥几分钟，或许他正在拯救世界呢！</p>
</div>
 
<button style="position:absolute;left:1100px;border-color: cornsilk;
            background-color: rgba(100, 149, 237, .7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 31px;
            font-size: 16px;top:2.6px;" id="opener">常见问题</button>
 


</body>



</html>