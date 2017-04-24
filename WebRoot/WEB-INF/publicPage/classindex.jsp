<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <link rel=stylesheet href="css/class.css" type="text/css">
				<div class="right_head">
					<img src="img/class.jpg"/>
				<!--end right head--></div>

				<div class="right_main">

					<div class="main_head">
						<img src="img/a.gif" />
						<font>如若不能正常打开视频，请升级浏览器</font>
					<!--end main_head--></div>
					
					<div class="main_main">	
						<div class="text">
						 <%
						    if(request.getAttribute("notice")!=null){
						    	%>
						    	  <%=request.getAttribute("notice") %>
						    	<%
						    }else{
						    	%>
						    	  <h3>暂未公告</h3>
						    	<% 
						    	
						    }
						 %>
							
						<!--end text--><div>
					<!--end main_main--></div>

			<!--end right--></div>
	<!--end main_page--></div>
	</div>
	
	
	