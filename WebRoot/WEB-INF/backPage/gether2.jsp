<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
 <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li ><a href="/OnLineStudy/getherFunction?Smenu=1">学习资料管理</a></li>
			<li id="li1"><a href="/OnLineStudy/getherFunction?Smenu=2">修改密码</a></li>
			<li><a href="/OnLineStudy/getherFunction?Smenu=3">采集新闻</a></li>
			<li id="li1"><a href="/OnLineStudy/getherFunction?Smenu=4">添加小测试题</a></li>
		</ul>
	  <!--end menu--></div>

			<div class="main_down">
				<form action="/OnLineStudy/getherFunction?Smenu=f1" method="post" >
					<p><span class="span1">原密码：</span><input type="password" name="oldpwd" class="input1" id="laterpwd"/></p>
					<p><span class="span1">新的密码：</span><input type="password" name="newpwd" class="input1" id="newpwd1"/></p>
					<p><span class="span1">确认密码：</span><input type="password" name="newpwd1" class="input1" id="newpwd2"/></p>
					<p>
						<input type="submit" value="确定修改" />
						<input type="reset" value="取消" />
					</p>
				</form>
		
            </div>

  <!--end main--></div>