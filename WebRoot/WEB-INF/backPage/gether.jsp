<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel=stylesheet  type="text/css" href="css/back.css">
  <title>系统后台管理</title>
 </head>
 <body>
<%
   String username=(String)request.getSession().getAttribute("username");
   if(username!=null){
	   %>
	       <div class="head">
				<span>欢迎您，<%=username %></span>
				<a href="/OnLineStudy/adminFunction?Smenu=0">退&nbsp;出</a>
			  <!--end head--></div>
			  <%
			      String Smenu=request.getParameter("Smenu");
			      if(Smenu!=null){
			    	  if(Smenu.equals("1")){
			    		  %>
				            <%@ include file="gether1.jsp" %>
			        	  <%
			    	  }else if(Smenu.equals("2")){
			    		  %>
				            <%@ include file="gether2.jsp" %>
			        	  <%
			    	  }else if(Smenu.equals("3")) {
			    		  %>
				            <%@ include file="gether3.jsp" %>
			        	  <%
			    	  }else{
			    		  %>
				            <%@ include file="gether4.jsp" %>
			        	  <%
			    	  }
			      }else{
			    	  %>
			    	      <div class="menu">
							<ul class="navil1">
								<li><a href="/OnLineStudy/getherFunction?Smenu=1">学习资料管理</a></li>
								<li><a href="/OnLineStudy/getherFunction?Smenu=2">修改密码</a></li>
								<li><a href="/OnLineStudy/getherFunction?Smenu=3">采集新闻</a></li>
								<li><a href="/OnLineStudy/getherFunction?Smenu=4">添加小测试题</a></li>
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
