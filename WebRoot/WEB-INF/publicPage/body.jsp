<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
 <head>
  <title>跳转页</title>
   <link rel="stylesheet" href="css/main_page.css" type="text/css"/>
   <link rel="stylesheet" href="css/menu.css" type="text/css"/>
 </head>
 <body>    
     <%@ include file="head.jsp" %>
     <div class="size">
       <%
          String select=request.getParameter("select");
          if(select!=null){
        	   if(select.equals("m2")){
        		   
        		   %>
        		   教学队伍
        		   <%
        		   
        		   
        	   }else if(select.equals("m3")){
        		   
                   %>
        		   学习资源
        		   <%
        		   
        	   }else if(select.equals("m4")){
        		   
                   %>
        		   教学效果
        		   <%
        		   
        	   }else if(select.equals("m5")){
        		   
                   %>
        		   课程支持
        		   <%
        		   
        	   }else if(select.equals("m6")){
        		   
                   %>
        		   课程特色
        		   <%
        		   
        	   }else{
        		 //跳回主页
                 request.getRequestDispatcher("/OnLineStudy/indexServlet").forward(request, response);
        	   }
        	  
          }else{
        	//跳回主页
          	request.getRequestDispatcher("/OnLineStudy/indexServlet").forward(request, response);
          }
       %>
     </div>
 </body>
</html>