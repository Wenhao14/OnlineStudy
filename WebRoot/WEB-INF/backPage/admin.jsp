<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel=stylesheet  type="text/css" href="css/admin.css">
    <script  type="text/javascript" src="js/pwd.js"></script>
  <title>系统后台管理</title>
 </head>
 <body>
<% 
    String username=(String)request.getSession().getAttribute("username");
    if(username!=null){
    	%>
    	   <div class="head">
			<span>欢迎您，<%=username+"     " %></span>
			<a href="/OnLineStudy/adminFunction?Smenu=0">退&nbsp;出</a>
		  <!--end head--></div>
		    <%
		       String Smenu=request.getParameter("Smenu");
		        if(Smenu!=null){
		            if(Smenu.equals("1")){
		            	%>
				          <%@ include file="admin1.jsp" %>
		            	<%
		            }else if(Smenu.equals("2")){
		            	%>
			              <%@ include file="admin2.jsp" %>
		        	    <%
		            }else{
		            	%>
			              <%@ include file="admin3.jsp" %>
		        	    <%
		            }
		        }else{
		        	%>
		              <div class="menu">
						<ul class="navil1">
							<li><a href="/OnLineStudy/adminFunction?Smenu=1">用户管理</a></li>
							<li><a href="/OnLineStudy/adminFunction?Smenu=2">密码管理</a></li>
							<li><a href="/OnLineStudy/adminFunction?Smenu=3">查看学习情况</a></li>
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