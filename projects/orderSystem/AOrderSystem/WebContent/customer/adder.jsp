<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.orderpack.addermodel"
    import="com.food.adder"
    
    
    %>
 <jsp:include page="customerfirst.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title></title>
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="jqueryui/style.css">
  <style>
    body { font-size: 62.5%; }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  </style>
  <script>
  $(function() {
    var name = $( "#name" ),
      email = $( "#email" ),
      password = $( "#password" ),
      allFields = $( [] ).add( name ).add( email ).add( password ),
      tips = $( ".validateTips" );
 
    function updateTips( t ) {
      tips
        .text( t )
        .addClass( "ui-state-highlight" );
      setTimeout(function() {
        tips.removeClass( "ui-state-highlight", 1500 );
      }, 500 );
    }
 
    function checkLength( o, n, min, max ) {
      if ( o.val().length > max || o.val().length < min ) {
        o.addClass( "ui-state-error" );
        updateTips( "" + n + " 的长度必须在 " +
          min + " 和 " + max + " 之间。" );
        return false;
      } else {
        return true;
      }
    }
 
    function checkRegexp( o, regexp, n ) {
      if ( !( regexp.test( o.val() ) ) ) {
        o.addClass( "ui-state-error" );
        updateTips( n );
        return false;
      } else {
        return true;
      }
    }
 
    $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 300,
      width: 350,
      modal: true,
      buttons: {
        "创建一个地址": function() {
        	
          var bValid = true;
          allFields.removeClass( "ui-state-error" );
 
          bValid = bValid && checkLength( name, "username", 3, 16 );
          bValid = bValid && checkLength( email, "email", 6, 80 );
          bValid = bValid && checkLength( password, "password", 5, 50 );
 
          //alert(name.val());
          //alert(email.val());
          //alert(password.val());
          
         window.location.href =encodeURI("http://localhost:8080/AOrderSystem/adderservlet?name="+name.val()+"&adder="+email.val()+"&phone="+password.val());  //跳转jsp 
          
       
          
        },
        Cancel: function() {
          $( this ).dialog( "close" );
        }
      },
      close: function() {
        allFields.val( "" ).removeClass( "ui-state-error" );
      }
    });
 
    $( "#create-user" )
      .button()
      .click(function() {
        $( "#dialog-form" ).dialog( "open" );
      });
  });
  
 
 function selectadder(adderid){
	 //选择了地址id后就跳转到之前的订单页面，确认提交
	 //alert(adderid);
	 window.location.href=encodeURI("http://localhost:8080/AOrderSystem/customer/order.jsp?adderid="+adderid);  //跳转jsp 
 }
  
 
 
  
  </script>
</head>
<body >
<div style="position:absolute;top:100px;width:1100px;left:208px;height:500px;background-color: rgba(255, 255, 240, 0.4);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.3);
            border-radius: 2px;z-index:-1;">
            <div style="position:absolute;left:40px;"> 
       
                 
            
    <div id="dialog-form" title="创建新地址">
  <p class="validateTips">所有的表单字段都是必填的。</p>
 
  <form>
  <fieldset>
  
    <label for="name">姓名</label>
    <input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all">
    <label for="email">详细地址</label>
    <input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all">
    <label for="password">电话</label>
    <input type="text" name="password" id="password" value="" class="text ui-widget-content ui-corner-all">
    
  </fieldset>
  </form>
</div>
 
 
 
 
 
 
 
<div  id="users-contain" class="ui-widget">
  <h1>已有的地址：</h1>
  <table id="users" class="ui-widget ui-widget-content">
    <thead>
      <tr class="ui-widget-header ">
        <th>姓名</th>
        <th>详细地址</th>
        <th>电话</th>
        <th>选择地址</th>
        <th>删除</th>
      </tr>
    </thead>
    <tbody>
      <tr>
     
    <% try{ String username=(String)session.getAttribute("username");
    		System.out.println("adder:x"+username);
           for(int i=0;i<addermodel.getdetailadder(username).size();i++){
        	  
        	   adder as=addermodel.getdetailadder(username).get(i);
        	   System.out.println(as.getusername());
           
        %>
        <td><%=as.getrealname() %></td>
        <td><%=as.getadder() %></td>
        <td><%=as.getphone() %></td>
        <td><input type="button" onclick="selectadder(<%=as.getadderid()%>)" value="选择"> </td>
        <td><input type="button" onclick="" value="删除"></td>
      </tr>
       <%}}catch(Exception e){
    	   e.printStackTrace();
       }
       
        %>
    </tbody>
  </table>
</div>
<button id="create-user">创建新地址</button>  
   
    </div>
        
</div>
</body>
</html>