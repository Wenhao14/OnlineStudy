<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel=stylesheet  type="text/css" href="css/back.css">
  <script language="javascript" type="text/javascript" src="js/pwd.js"></script>
  <title>系统后台管理</title>
 </head>
 <body>
<%
   String username=(String)request.getSession().getAttribute("username");
  if(username!=null){
	  %>
	      <div class="head">
			<span>欢迎您，<%=username+"    " %></span>
			<a href="/OnLineStudy/adminFunction?Smenu=0">退&nbsp;出</a>
		  <!--end head--></div>
		        <%
		           String Smenu=request.getParameter("Smenu");
		        if(Smenu!=null){
		        	 if(Smenu.equals("1")){
				         %> 
		        		   <%@ include file="principal1.jsp"%>
                         <%
			           }else if(Smenu.equals("2")){
		        	     %> 
	        		       <%@ include file="principal2.jsp"%>
                         <%
			           }else{
			        	 %> 
		        		  <%@ include file="principal3.jsp"%>
                         <%
			           }
		        }else{
		        	%>  
					  <div class="menu">
						<ul class="navil1">
							<li><a href="/OnLineStudy/principalFunction?Smenu=1">班级管理</a></li>
							<li><a href="/OnLineStudy/principalFunction?Smenu=2">密码管理</a></li>
							<li><a href="/OnLineStudy/principalFunction?Smenu=3">选择学习资料</a></li>
						</ul>
					  <!--end menu--></div>
					  <%@ include file="welcome.jsp" %>
		        	<%
		        }
		          
		        %>
	  <%
  }else{
	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp").forward(request, response);
  }
%>
  
 </body>
</html>
