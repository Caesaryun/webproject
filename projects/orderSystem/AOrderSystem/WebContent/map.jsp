<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=134db1b9cf1f1f2b4427210932b34dcb"></script>
    <title>单击获取点击的经纬度</title>
</head>
<body>
    <div id="allmap" style="width:400px;height:400px;"></div>
    <div>
       <label>经度</label>
       <span id="jing_du"></span>
       <label>纬度</label>
       <span id="wei_du"></span>
       
    </div>
    <!-- 进行通过输入地址进行店家的确定 -->
    <div style="position:absolute;left:450px;width:340px;height:340px;top:30px; background-color: rgba(75, 81, 95, 0.3);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 5px;">
            <div style="position:absolute;top:40px;"> 
     <form action="mapservlet" method="post">
      <%   
        String uri=(String)session.getAttribute("uri");
        System.out.println("想访问的页面:"+uri);
     %> 
     
     <% 
         //传递uri值
           session.setAttribute("uri",uri);
        
        %>
        
       <input style="position:absolute;left:50px;top:50px;  margin-left: 15px;"
       type="text" name="mapname" placeholder="请输入您所在地址"><br>
       
       <input style="position:absolute;left:218px;top:48px;" type="submit" value="确定">   
     
      </form></div>

     </div>
     
   <div style="position:absolute;top:0px;left:450px;"><a href="main.jsp"><font size="4" >回到首页</font></a></div>  
</body>
 
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");            
    map.centerAndZoom("大连大学",12); 
     
    var point = new BMap.Point(121.82236761672296,39.10186066453083);
    map.centerAndZoom(point, 15);
     
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);               // 将标注添加到地图中
    marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
     
    //单击获取点击的经纬度
    map.addEventListener("click",function(e){
        var jing_du_value = e.point.lng ;
        var wei_du_value =  e.point.lat;
        //alert(e.point.lng + "," + e.point.lat);
        var jing_du = document.getElementById("jing_du");
        var wei_du = document.getElementById("wei_du");
        jing_du.innerHTML= jing_du_value;
        wei_du.innerHTML= wei_du_value;
    });
     
     
    //提升框
    var opts = {
      width : 200,     // 信息窗口宽度
      height: 100,     // 信息窗口高度
      title : "标题" , // 信息窗口标题
      enableMessage:true,//设置允许信息窗发送短息
      message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
    }
    var infoWindow = new BMap.InfoWindow("地址：大连大学", opts);  // 创建信息窗口对象 
    marker.addEventListener("click", function(){          
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    });
     
    // 百度地图API功能
    map.centerAndZoom(point,8); 
    setTimeout(function(){
        map.setZoom(14);   
    }, 2000);  //2秒后放大到14级
    map.enableScrollWheelZoom(true);
</script>
 
</html>
