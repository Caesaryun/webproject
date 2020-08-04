<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.food.orderutil"
    import="com.food.orderclass"
    
    %>
    <jsp:include page="customerfirst.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function okorder()
{   
	
	 var time=document.getElementById("select1").value; //送达时间
	 var canju=document.getElementById("select2").value;  //餐具份数
	 if(time==-1||canju==-1){
		 alert("请选择送达时间或者餐具份数！");
		 
	 }
	 else{
	 document.ordertj.action="http://localhost:8080/AOrderSystem/orderdaoservlet?time="+time+"&canju="+canju;   //直接提交给该servlet
     document.ordertj.method="post";
	 document.ordertj.submit(); 
	 }
	 //window.location.href=encodeURI("http://localhost:8080/AOrderSystem/orderdaoservlet?time="+time+"&canju="+canju+"&bz=");  //跳转jsp 

	
}



</script>
</head>
<body>
<% String zsorderid=(String)session.getAttribute("zsorderid");  //暂时的订单id
   String adderid=request.getParameter("adderid");  //地址id
   String username=(String)session.getAttribute("username");
   session.setAttribute("username",username);
   session.setAttribute("zsorderid",zsorderid);
   session.setAttribute("adderid",adderid);
   
   //通过订单id查询到商家
  int zsaid=0;
   
   try{
     zsaid=Integer.parseInt(zsorderid);  //转换orderid
   }catch(Exception e){
	   e.printStackTrace();
   }
  
   String hotelname=null;
   for(int i=0;i<orderutil.getallorderzs(username).size();i++){
	   orderclass oxs=orderutil.getallorderzs(username).get(i);
	         if(zsaid==i){  //得到指定的订单id
	        	 hotelname=oxs.gethotelname();  //获取到相应的hotelname
	        	 System.out.println(zsaid+"暂时订单xxx：");
	          }
          }
   
   
   
 %>
   
<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
 <!-- 带着订单id，及地址id，然后显示出来第一个 -->   
 <div  style="position:absolute;left:40px;"> 
        <h1>支付</h1>
           
        <div style="position:absolute;top:100px;width:400px;left:10px;;height:100px;background-color:;">
        <form name="ordertj">
          <ul><li>其他信息</li>
          <li>配送方式&nbsp&nbsp本订单由【<%=hotelname %>】配送 </li>          
         
          <li>送达时间
          <select  id="select1" name="select1">
          <option value="-1">时间</option>
          
          <option value="t1">30分钟以内</option>
          <option value="t2">50分钟以内</option>
          <option value="t3">60分钟以内</option>
          </select>
          </li>
          <li>订单备注<input type="text" id="bz"  name="bz"></li>
         <li>餐具份数 <select id="select2" name="select2">
             <option value="-1">未选择</option>
             <option value="tw1">无需餐具</option>
             <option value="tw2">1份</option>
             <option value="tw3">2份</option>
             <option value="tw4">3份</option>
             <option value="tw5">4份</option>
            
          </select>
          </li>
         
         
          </ul>
           <input type="button" value="确认支付"  onclick="okorder()">  
           </form>
       </div>
        </div>
</div>
</body>
</html>