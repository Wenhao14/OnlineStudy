<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>

  <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li><a href="/OnLineStudy/adminFunction?Smenu=1">用户管理</a></li>
			<li id="li1"><a href="/OnLineStudy/adminFunction?Smenu=2">密码管理</a></li>
			<li><a href="/OnLineStudy/adminFunction?Smenu=3">查看学习情况</a></li>
		</ul>
	  <!--end menu--></div>

	  <div class="main_left">
		<ul>
			<li><a href="/OnLineStudy/adminFunction?Smenu=2&s1=1" style="margin-left:30%">修改密码</a></li>
			<li><a href="/OnLineStudy/adminFunction?Smenu=2&s1=2" style="margin-left:30%">重置密码</a></li>
		</ul>
	  <!--end main_left--></div>
      <div class="main_right">
        <div class="right_main">
		<%
		  String s1=(String)request.getAttribute("s1");
		  if(s1.equals("1")){
			  %>
						<form action="/OnLineStudy/adminFunction?Smenu=f1" method="post">
							<p><span class="span1">原密码：</span><input type="password" name="oldpwd" class="input1" id="laterpwd"/></p>
							<p><span class="span1">新的密码：</span><input type="password" name="newpwd" class="input1" id="newpwd1"/></p>
							<p><span class="span1">确认密码：</span><input type="password" name="newpwd1" class="input1" id="newpwd2"/></p>
							<p>
								<input type="submit" value="确定" />
								<input type="reset" value="取消" />
							</p>
						</form>
			   <%
			  
		  }else{
			  %>
			     
					<form action="/OnLineStudy/adminFunction?Smenu=f2" method="post" onsubmit="return check2()">
						<p><span class="span1">用户名：</span><input type="text" name="user" class="input1" id="username"/></p>
						<p>
							<span>类型：</span>
							<input type="radio" name="usertype" value="principal" id="class_manager"/><span>班级管理员</span>
							<input type="radio" name="usertype" value="gether" id="date_manager"/><span>资料采集员</span>
						</p>
						<p>
							<input type="submit" value="确定" />
							<input type="reset" value="取消" />
						</p>
					</form>
			   
			  <%
		  } 
		%>
		 <!--end right_main--></div>
		<!--end main_right--></div>

  <!--end main--></div>
