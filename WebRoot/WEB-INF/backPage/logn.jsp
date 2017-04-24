<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>后台管理登录</title>
  <link rel=stylesheet href="css/login.css" type="text/css">
   <script language="javascript">  
	function myReload() {  
	    document.getElementById("CreateCheckCode").src = document  
	            .getElementById("CreateCheckCode").src  
	            + "?nocache=" + new Date().getTime();  
	}  
</script>  
 </head>
 <body onload="createCode()">
			<div class="head">
			<p>教师理论平台管理</p>
			</div>
			<form  action="/OnLineStudy/adminLogn" method="post" class="login">
				<p><span class="span1">用户名:</span>
				<input class="input1" type="text" name="username" placeholder="请输入您的用户名">
				</p>
				<p><span class="span1">密码:</span>
				<input class="input1" type="password" name="userpwd"  placeholder="请输入您的密码">
				</p>
				<p><span class="span1">用户类型：</span>
							<label><input name="radio" type="radio" value="admin" >管理员</label>
							<label><input name="radio" type="radio" value="gether">资料采集员</label>
							<label><input name="radio" type="radio" value="principal">班级管理员</label>
				</p>
				<p><span class="span1">验证码：</span>
					<input class="input1"  type="text" name="textrand" width="150" placeholder="验证码不区分大小写" />  
                    <img src="/OnLineStudy/PictureCheckCode" id="CreateCheckCode" align="middle" width="80" height="30">  
                    <a href="" onclick="myReload()"> 看不清,换一个</a>  
				</p>
				
				<p class="ok">
					    <%      
			             if((String)request.getParameter("message")!=null){
			            	%>
			            	 <font color="red"><%=(String)request.getParameter("message")%></font>*<br>
		                    <%
			             }else{
			            	 %>
			            	    <br>
			            	 <%
			             }
			            	 
		                %>
				   <input  type="submit" value="登录" />
				   <input type="reset" value="取消" />
				</p>
			</form>
 </body>
</html>
