<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>西安科技大学-教职工理论学习平台</title>
  <link rel=stylesheet href="css/choose_page.css" type="text/css">
 </head>
 <body>
    <%
        String username=(String)request.getSession().getAttribute("username");
        if(username!=null){
        	%>
        	    <div class="main_page">
	<div class="head">
	<img src="img/container_bg.jpg" width=95% height=100% border=0;/>
	<!--end head--></div>

	<div class="welcome">
		<div class="quit">
			<font>欢迎您，[<%=username %>]</font>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnLineStudy/usernewsServlet?select=0">退&nbsp;出</a>
		<!--end euit--></div>
	<!--end welcome--></div>
	
	<div class="button">
		
		<div class="left">
			<a href="/OnLineStudy/userFunctionServlet?select=u1"><img src="img/e_title.jpg"/></a>
			<img src="img/eimg01.jpg"/>
			<a href="/OnLineStudy/userFunctionServlet?select=u2"><img src="img/choose_1.jpg"/></a>
            <a href="/OnLineStudy/userFunctionServlet?select=u3"><img src="img/choose_2.jpg"/></a>

			<div class="nav">
			  <ul>
				<li>
				 <img src="img/choose_3.jpg"/>
				  <ul>
					<li><a href="/OnLineStudy/userFunctionServlet?select=u5">心得体会</a></li>
					<li><a href="/OnLineStudy/userFunctionServlet?select=u6">小试牛刀</a></li>
				  </ul>
				</li>

			  </ul>
			 </div>
			<a href="/OnLineStudy/userFunctionServlet?select=u7"><img src="img/choose_4.jpg"/></a>
		<!--end left--></div>
            
		<div class="right">
	       <%
	         String select=request.getParameter("select");
	         if(select!=null){
	        	 if(select.equals("u2")){
	        		 %>
		        	   <%@ include file="../publicPage/message.jsp" %>
		        	 <% 
	        	 }else if(select.equals("u3")){
	        		 %>
		        	   <%@ include file="../publicPage/videostudy.jsp" %>
		        	 <% 
	        	 }else if(select.equals("u5")){
	        		 %>
		        	   <%@ include file="../publicPage/know.jsp" %>
		        	 <% 
	        	 }else if(select.equals("u6")){
	        		 %>
		        	   <%@ include file="../publicPage/smalltest.jsp" %>
		        	 <% 
	        	 }else if(select.equals("u7")){
	        		 %>
		        	  <%@ include file="bbs.jsp" %>
		        	 <% 
	        	 }else{
	        		 %>
		        	   <%@ include file="../publicPage/classindex.jsp" %>
		        	 <% 
	        	 }
	        	 
	         }else{
	        	 %>
	        	   <%@ include file="../publicPage/classindex.jsp" %>
	        	 <% 
	         }
	       %>
		<!--end right--></div>

	<!--end button--></div>

  <!--end main_page--></div>
        	<% 
        }else{
        	request.getRequestDispatcher("/indexServlet").forward(request, response);
        }
    %>
  <%@ include file="../publicPage/statement.jsp" %>
 </body>
</html>
