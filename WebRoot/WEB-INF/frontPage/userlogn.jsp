<%@ page language="java"  import="java.util.* ,com.ols.Bean.newsBean" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>西安科技大学-教职工理论学习平台</title>
  <link rel=stylesheet href="css/main_page.css" type="text/css">
  <script src="js/main_page_img1.js"></script>
  <script type="text/javascript">
  var curIndex = 0;
  var timeInterval = 2000;
  var arr = new Array();
  arr[0] = "img/adv1.jpg";
  arr[1] = "img/adv2.jpg";
  arr[2] = "img/adv3.jpg";
  arr[3] = "img/adv4.jpg";
  setInterval(changeImg,timeInterval);
  function changeImg() {
   var obj = document.getElementById("obj");
   if (curIndex == arr.length-1) {
    curIndex = 0;
   } else {
    curIndex += 1;
     }
   obj.src = arr[curIndex];
  }
  </script>	
  
 </head>
 <body>
  <div class="main_papg">
	<div class="title">
	<img src="img/container_bg.jpg" width=95% height=100% border=0;/>
	<!--end title--></div>

	<div class="choose">
		<ul class="navil">
			<li><a href="/OnLineStudy/menuServlet?select=m1">首页</a></li>
			<li><a href="/OnLineStudy/menuServlet?select=m2">教学队伍</a></li>
			<li><a href="/OnLineStudy/menuServlet?select=m3">学习资源</a></li>
			<li><a href="/OnLineStudy/menuServlet?select=m4">教学效果</a></li>
			<li><a href="/OnLineStudy/menuServlet?select=m5">课程支持</a></li>
			<li><a href="/OnLineStudy/menuServlet?select=m6" style="border-right:1px solid white;">课程特色</a></li>
		</ul>
	<!--end choose--></div>

	<div class="left">
		<div class="login">
			<span>
			<font>欢迎，请登录</font><br>
			</span>
			
			<font size="2">
			<%      
	             if((String)request.getParameter("message")!=null){
	            	%>
	            	 *<%=(String)request.getParameter("message")%>*
                    <%
	             }else{
	            	 %>
	            	    <br>
	            	 <%
	             }
	            	 
	         %>
	         </font>
	        
			<form  action="/OnLineStudy/userlognServlet" method="post">
				<p><input type="text" name="username" placeholder="请输入用户名"/></p>
				<p><input type="password" name="userpwd" placeholder="请输入密码"/></p>
				<input type="hidden" name="usertype" value="user">
				<p><input type="submit" class="bt_log" name="log_user" value=""/></p>
			</form>
			
		</div>
	<!--end left--></div>

	<div class="middle">
	  <img id = "obj" src="img/adv1.jpg" border = 0  width=100%; height=100% /> 
	<!--end middle--></div>

	<div class="right">
		<div class="right_head">
			<img src="img/nav_bg.jpg" />
			<span>新闻中心</span> 
		</div>
		<div class="right_main">
		   <%
		       ArrayList<newsBean> al=(ArrayList)request.getAttribute("news");
		      if(al.size()>0){
		    	  for(int i=0;i<al.size();i++){
			    	   newsBean news=al.get(i);
				        %>
						    <a class="right_main" href="<%=news.getNews_conn() %>">><%=news.getNews_title() %></a>
							<hr class="hr"/>
						<% 
			       }
		      }else{
		    	 %>
		    	   <h2>暂无数据</h2>
		    	 <%
		      }
		      
		   %>	
		</div>
	<!--end right--></div>
	<!--end main_page div--></div>
	<%@ include file="../publicPage/statement.jsp" %>
 </body>
</html>

