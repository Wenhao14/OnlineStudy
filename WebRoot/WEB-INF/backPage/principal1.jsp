<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
  <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=1">班级管理</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=2">密码管理</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=3">选择学习资料</a></li>
		</ul>
	  <!--end menu--></div>

	  <div class="main_left">
		<ul>
			<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=1">班级管理</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=2">学员管理</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=3">学习情况查看</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=4">发布班级公告</a></li>
		</ul>
	  <!--end main_left--></div>
       
		<div class="main_right">
           <%
	         String s1=(String)request.getAttribute("s1");
	         if(s1!=null){
	        	 if(s1.equals("1")){
	        		 %> 
		      		   <%@ include file="principal1-1.jsp"%>
		             <%
	             }else if(s1.equals("2")){
	            	 %> 
		      		   <%@ include file="principal1-2.jsp"%>
		             <%
	             }else if(s1.equals("3")){
	            	 %> 
		      		   <%@ include file="principal1-3.jsp"%>
		             <%
	             }else{
	            	 %> 
		      		   <%@ include file="principal1-4.jsp"%>
		             <%
	             }
	         }
	       %>
		<!--end main_right--></div>

  <!--end main--></div>
