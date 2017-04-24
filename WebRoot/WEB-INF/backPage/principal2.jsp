<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
 <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li><a href="/OnLineStudy/principalFunction?Smenu=1">班级管理</a></li>
			<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=2">密码管理</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=3">选择学习资料</a></li>
		</ul>
	  <!--end menu--></div>
	  <div class="main_left">
		<ul>
			<li><a href="/OnLineStudy/principalFunction?Smenu=2&s1=1">修改密码</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=2&s1=2">重置学员密码</a></li>
		</ul>
	  <!--end main_left--></div>

		<%
		   String s1=(String)request.getAttribute("s1");
		   if(s1.equals("1")){
			   %>
			       <div class="main_right">

					<div class="right_main">
						<form action="/OnLineStudy/principalFunction?Smenu=f1" method="post" onsubmit="return check3()">
							<p><span class="span1">原密码：</span><input type="password" name="oldpwd" class="input1" id="laterpwd"/></p>
							<p><span class="span1">新的密码：</span><input type="password" name="newpwd" class="input1" id="newpwd1"/></p>
							<p><span class="span1">确认密码：</span><input type="password" name="newpwd1" class="input1" id="newpwd2"/></p>
							<p>
								<input type="submit" value="确定" />
								<input type="reset" value="取消" />
							</p>
						</form>
					<!--end right_main--></div>
		
				 <!--end main_right--></div>
			   <%
		   }else{
              %>
	           <div class="main_right">
	
				<div class="right_main">
					<form  action="/OnLineStudy/principalFunction?Smenu=f2" method="post" onsubmit="return check4()">
						<p><span>输入用户名:</span><input type="text" name="user" class="input1" id="learner"/></p>
						<p>
							<input type="submit" value="确定" />
							<input type="reset" value="取消" />
						</p>
					</form>
				<!--end right_main--></div>
	
			    <!--end main_right--></div>  
			<%
		   }
		%>

  <!--end main--></div>