<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.Filter.mapmodel"
    import="com.Filter.hotelmany"  
    import="java.util.ArrayList"
    import="com.food.foodshow"
    import="com.food.foodutil"
    %>
 <jsp:include page="customernavigation.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

   .ul1{list-style-type:none;}
   .ul1 li{padding:16px;float:left;}
   .ul2{list-style-type:none;}
   .ul2 li{padding:14px;float:left;top:0px;}
   div{float:left;margin:10px;}
div dd{ margin:0px;font-size:10px;}
div dd.dd_name{color:blue;}
div dd.dd_city{color:#000;}



</style>
<script src="jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script>
//写关于局部刷新菜单 通过id号将所有的价格及菜的名称等添加到购物车，然后再确定订单才行
function gouwuche(foodnum,foodid){   //购物车函数使用ajax进行局部刷
	 //直接通过设置一个id值然后通过id值获取内容，每个的id值不一样，且传递到函数中
	 
	 //alert("数量："+foodnum.value);
     //alert("显示num"+foodnum.value)
	 //alert("显示id:"+foodid);  
	
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
      var yzm=xmlhttp.responseText;  //得到验证码
      alert(yzm);
     }
   }
 xmlhttp.open("GET","http://localhost:8080/AOrderSystem/gouwuche?foodid="+foodid+"&foodnum="+foodnum.value,true);   //通过foodid加入
 xmlhttp.send();
     
     
     
}



 
    $(function(){
        $(".add").click(function(){
            var t=$(this).parent().find('input[class*=text_box]');
            t.val(parseInt(t.val())+1)
            setTotal();
        })
        $(".min").click(function(){
            var t=$(this).parent().find('input[class*=text_box]');
            t.val(parseInt(t.val())-1)
            
            if(parseInt(t.val()) < 0){
                t.val(0);
            }
            setTotal();
        })
        function setTotal(){
            var s=0;
            $(".gm").each(function(){
                s+=parseInt($(this).find('input[class*=text_box]').val())*parseFloat($(this).find('span[class*=price]').text());
                parseInt($(this).find('input[class*=text_box]').text()); //将变化的数据填充到了input框中
            });
            $("#total").html(s.toFixed(2));
        }
        setTotal();
 
    })
    
  
<% String hd=request.getParameter("hotelid");
   mapmodel mdel=hotelmany.getdetailhotel(hd); //从这里获取到起送价格
   double qsprice=0;
   if(mdel!=null){
	   qsprice=mdel.gethotelqsprice();  //获取起送价格
   }
   %>

 //马上进行购买产品
function buyquick(foodnum,foodid,foodprice){
    	//将foodid及数量进行提交即可，且用户名也是需要插入的
        //就直接跳到订单的页面，且进行判断是否满足起送价格 如果起送价格小于那么就给予提示，且不跳转
        
        var sum=foodnum.value*foodprice;
       
        if(sum>=<%=qsprice%>){      //如果选择的食物价格大于起送或等于起送价格则跳转
        	window.location.href ="http://localhost:8080/AOrderSystem/orderservlet?foodid="+foodid+"&foodnum="+foodnum.value;  //跳转jsp   
        }
        else{
        	alert("不足起送价格，请再做选择!");
        }
        
        //window.location.href = 'order.jsp';  //跳转jsp        
    }


function lookshopcar(){
	
	window.location.href="showshopcar.jsp";
}


</script>



</head>

<body style="overflow-x: hidden">


<% String username=(String)session.getAttribute("username");
   session.setAttribute("username",username);
//发送username %>
<!-- 通过获取到店家的id后得到相应的店家信息，如名称，然后通过名称获取到相应的菜品 -->
<!--  -->

<%
   
    String hotelid=request.getParameter("hotelid");
    
   //然后调用函数
    System.out.println(hotelid);
    mapmodel map=hotelmany.getdetailhotel(hotelid);
    String hotelname="xxxx";
    if(map!=null){
     hotelname=map.gethotelname();
    }
    
    if(map!=null){ 
    	 
    	//System.out.println("输出:"+map.gethotelqsprice());
   %>

<div  style="position:absolute;top:94px;left:0px;z-index:-1;">
 <img src="img/美食背景1.jpg" style="position:absolute;width:1300px;left:0px;"  height="150px;">
<font color="#000000" size="4">
<table style="position:absolute;top:10px;" width="750" height="60" cellpadding="2" padding="12px;" border="0">
<tr>
 
</tr>

<tr>
<td>
   店名:<%=map.gethotelname()%></td>
   </tr>
   
   <tr> <td>评分:<%=map.gethotelscore() %>分&nbsp&nbsp;地址:<%=map.gethoteladder() %></td></tr>
   <tr><td>电话:<%=map.gethotelnumber()%>&nbsp&nbsp;商店负责人:<%=map.gethotelboss() %></td></tr>
   <tr><td>起送价:<%=map.gethotelqsprice() %>元</td></tr>
   <tr><td>配送价:<%=map.gethotelyunprice() %>元&nbsp&nbsp&nbsp;包装费:<%=map.getpackprice() %>元</td></tr>
   
 <!-- 商品循环结束 -->
 <%  
      }
   %>
  </td>
  </tr>

</table>
</font>
</div>
     
    <div style="position:absolute;top:267px;left:200px;z-index:1;"><form action="#">
         
         <input type="button" value="评分排序" onclick="ok()">
         <input type="button" value="价格排序" onclick="ok()">
                          
        </form>
    
     </div>
  
 <!-- 通过商店名称得到所有的商品 -->
  <div > 
  
  
  <div style="position:absolute;top:240px;left:0px;">
   <h1><input type="button" value="所有商品"  onclick=""></h1>   
<hr>

  
           <font  size="6" color="red">
                           商品总价:<label id="total"></label>元
           </font>  
             
<table  width="440" height="60" cellpadding="0" border="0">
<tr>
<!--    商品循环开始  -->
 <%     
       
       
        ArrayList<foodshow> fswlist=foodutil.getallfood(hotelname);  //获取数据food根据店名
        if(fswlist!=null&&fswlist.size()>0){
        	for(foodshow fsw:fswlist)
        	{
        	 
    	     System.out.println(fsw.getfoodname());
    	  
      
 %>
 
  <tr>
  <td rowspan="6"><img style="width:100px;height:100px;" src="img/<%=fsw.getimg() %>"></td>
  </tr>
  <tr>
  <td><%=fsw.getfoodname() %></td>
  </tr>
  <tr><td>评分:<%=fsw.getfoodscore() %>分</td></tr>
  <tr><td>价格:<%=fsw.getfoodprice() %>元</td></tr>
  <tr><td><div  class="gm">
                          
          <span  class="price" style="display:none;"><%=fsw.getfoodprice()%></span>
    
         <input class="add" name="" type="button" value="+"  />
       <input type="text" class="text_box" id="<%=fsw.getnumid()%>"  value="<%=fsw.getfoodnum()%>">
                         <!--   <input class="text_box" name=""  type="text"   value="" /> -->
        <input class="min"      name=""     type="button"  value="-" />
                  <!--总价:<label id="total"></label>-->
                  
                        </div></td></tr>
  <tr>
   <td>
    <form >
    
     <input type="button"  onclick="gouwuche(<%=fsw.getnumid()%>,<%=fsw.getfoodid()%>)"     value="加入购物车"> 
     <input type="button"  onclick="buyquick(<%=fsw.getnumid()%>,<%=fsw.getfoodid()%>,<%=fsw.getfoodprice()%>)"     value="立即购买">
     <input type="button" onclick="lookshopcar()" value="查看购物车">
    </form>
     </td>
   </tr>
  
  
 <% } 
        }
 %> 
 
</table>        
            
   </div>
  

</div>
 
 
 
 
 
 
 
</body>



</html>
 
 
 