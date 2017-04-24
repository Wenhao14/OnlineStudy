<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html>
 <head>
     <link rel=stylesheet href="css/fuction.css" type="text/css">
 </head>
 <body>
   <div class="view">
   <%
      String select=request.getParameter("select");
       if(select!=null){
    	   if(select.equals("1")){
    		   %>
    		     <jsp:include page="video.jsp"></jsp:include>
    		   <% 
    		   
    	   }else if(select.equals("2")){
    		   %>
    		      <jsp:include page="know.jsp"></jsp:include>
    		   <%
    		   
    	   }else if(select.equals("3")){
    		   %>
    		     <jsp:include page="smalltest.jsp"></jsp:include>
    		   <% 
    	   }
       }else{
    	   
       }
   %>
    
   </div>
    <div class="mod" >
	    <img alt="宣传图片" src="img/m1.jpg">
	    <p>
	     <img alt="宣传图片" src="img/m2.jpg">
	    </p>
	    <P>
	    <img alt="宣传图片" src="img/m3.jpg">
	    </P>
    </div>
 </body>
</html>