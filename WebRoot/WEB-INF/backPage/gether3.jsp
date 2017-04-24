<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
  <div class="main">
	  <div class="menu">
		<ul class="navil1">
			<li ><a href="/OnLineStudy/getherFunction?Smenu=1">学习资料管理</a></li>
			<li><a href="/OnLineStudy/getherFunction?Smenu=2">修改密码</a></li>
			<li id="li1"><a href="/OnLineStudy/getherFunction?Smenu=3">采集新闻</a></li>
			<li id="li1"><a href="/OnLineStudy/getherFunction?Smenu=4">添加小测试题</a></li>
		</ul>
	  <!--end menu--></div>

			<div class="main_down">
				<form action="/OnLineStudy/getherFunction?Smenu=f2" method="post">
					<p><span class="span1">标题：</span><input type="text" name="title" class="input1" /></p>
					<p><span class="span1">链接：</span><input type="text" name="conn" class="input2" /></p>
					<p class="buttom">
						<input type="submit" value="确定" />
						<input type="reset" value="取消" />
					</p>
				</form>
			<!--end right_main--></div>

  <!--end main--></div>