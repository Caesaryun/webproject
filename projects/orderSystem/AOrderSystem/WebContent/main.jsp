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
           <li><img style="position:absolute;width:18px;height:20px;left:12px;z-index:0;" src="img/6.jpg"><a href="map.jsp">定位</a></li>
           <li><a href="sign_in.jsp"><font color="#FF5151">立即登录</font></a></li>
           <li><a href="register.jsp">注册</a></li>
           <li><b><a style="position:absolute;left:800px;top:2px;height:15.6px;" href="customer/customermain.jsp">我的太白珍馐居</a></b>
              <div style="position:absolute;left:810px;z-index:1;" class="down">
              <a href="customer/orderstate.jsp">我的订单</a>
              <a >我的收藏</a>
              <a >优惠券</a>
              <a href="customer/customermain.jsp">账户设置</a>
              </div>
           </li>
           <li><b><a style="position:absolute;left:960px;top:1.8px;" href="shop/changehotel.jsp">商家管理中心</a></b>
           <div style="position:absolute;left:960px;z-index:1;" class="down">
           <a href="sign_in.jsp">登录</a>
           <a href="http://localhost:8080/AOrderSystem/shop/insureorder.jsp">商品管理</a>
           <a >评价管理</a>
           <a >店员登录</a>
           </div>
           </li>
           </ul> 
           
            
   </div>
   
  
   
   
 <a href="main.jsp"><img style="position:absolute;height:43px;top:69.5px;left:87px;" src="img/商标.png"></a>
 
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
<div class="outer">
 
    <ul class="img">
        <li><a href="other/foods.jsp"><img style="width:689px;height:374px;" src="img/披萨.jpg"></a></li>
        <li><a href="other/foods.jsp"><img style="width:689px;height:374px;"  src="img/羊肉卷.jpg"></a></li>
        <li><a href="other/foods.jsp"><img style="width:689px;height:374px;" src="img/四川特色香锅.jpg"></a></li>
        
        
    </ul>
 <li><a href=""><img style="width:689px;height:374px;" src="img/四川特色香锅.jpg"></a></li>
 
    <ul class="num">
        <li class="current">1</li>
        <li>2</li>
        <li>3</li>
        
    </ul>
 
    <div class="left_btn btn"><</div>
    <div class="right_btn btn">></div>
</div>


</div>
   
   
   
 </div>
 
 
 <!-- -来写标题 -->
   <div style="position:absolute;top:142px;left:270px;width:800px;height:50px;background-color:white;">
   
   <ul class="list5">
   <div class="ex3">
    <li><a href="other/foods.jsp">默认</a></li>
    <li><a href="other/foods.jsp">销量</a></li>
    <li><a href="other/foods.jsp">价格</a></li>
    <li><a href="other/foods.jsp">好评最多</a></li>
    <li><a href="other/foods.jsp">冬日温暖-热酒御寒</a></li>
    <li><a href="shopregister.jsp">加盟珍馐居</a> <!-- 特色功能 --><!-- 目前只是一家分布于各个地方的连锁店的形式，然后还可以不断的扩展线下的店方便配送 -->
   </li></div>                     <!--去不同地方开然后进行配送 选择地址后可以实现
                                    给出地址后就给出最近的珍馐居店，金州区太白珍馐居，开发区太白珍馐居等，就ok了，
                                    然后再配送即可，我不做美团，我做的是一个线下线上皆有自己掌控的东西  -->
   </ul>
 </div>  
 
 
 
<div   style="position:absolute;top:140px;left:42px;width:230px;height:450px;background-color:white;
box-shadow:3px 2px 10px rgba(52,56,66,0.1);border-radius:2px;"> 
   <ul class="list4">
   <li><a><b>全部分类</b></a></li>
   
   
     <div class="ex2">
     <li><a  >优惠券</a></li>   <!-- 它就是一个按钮点击它就触发事件进行更新 -->
     <li><a >蛋糕甜点</a></li>
     <li><a >火锅</a></li>
     <li><a >小吃快餐</a></li>
     <li><a >日韩料理</a></li>
     <li><a >西餐</a></li>
     <li><a >粤菜</a>
     <li><a >川菜</a>
     </div>
     
   </li>
    
    
   </ul>
   </div>
   


   
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
<script src="js/jquery-3.4.1.min.js"></script>
<script>
     /*定义位置：由于图片个数与下侧顺序按钮数量一致，可通过位置进行关联*/
    var index=0;
     /*当鼠标放到顺序按钮上时：
     1.将当前这个顺序按钮增加样式为红色背景
     2.移除周围其他同级元素红色背景样式
     3.获取当前顺序按钮的index
     4.通过index获取该位置图片
     5.一秒钟渐入该图片
     6.一秒钟渐出其他相邻图片
     7.防止移动过快导致的效果闪现，使用stop方法
     */
    $(".num li").mousemove(function () {
            $(this).addClass("current").siblings().removeClass("current");
            index=$(this).index();
            $(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
    });
     /*设置每一秒钟自动轮播：
     1.获取当前位置序号：自加操作；当超过图片最大序号时序号设置为0
     2.设置下侧顺序按钮及轮播图显示
     */
    var time=setInterval(move,1000);
    function move() {
        index++;
        if (index==3){
            index=0;
        }
        $(".num li").eq(index).addClass("current").siblings().removeClass("current");
        $(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
    };
    /*当鼠标划入、划出轮播图区域时：
    1.划入时停止自动轮播
    2.划出时继续自动轮播
    */
    $(".outer").hover(function () {
        clearInterval(time);
    },
    function () {
        time=setInterval(move,1000);
    });
     /*点击右侧按钮时执行*/
    $(".right_btn").click(function () {
       move();
    });
     /*点击左侧按钮时执行*/
    function moveL() {
         index--;
        if (index==-1){
            index=2;
        }
        $(".num li").eq(index).addClass("current").siblings().removeClass("current");
        $(".img li").eq(index).stop().fadeIn(1000).siblings().stop().fadeOut(1000);
    }
    $(".left_btn").click(function () {
        moveL();
    });
    
</script>


</html>