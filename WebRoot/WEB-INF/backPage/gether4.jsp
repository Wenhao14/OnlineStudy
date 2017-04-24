<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
 <script language="javascript" type="text/javascript" src="js/test.js"></script>
 <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li><a href="/OnLineStudy/getherFunction?Smenu=1">学习资料管理</a></li>
			<li><a href="/OnLineStudy/getherFunction?Smenu=2">修改密码</a></li>
			<li><a href="/OnLineStudy/getherFunction?Smenu=3">采集新闻</a></li>
			<li id="li1"><a href="/OnLineStudy/getherFunction?Smenu=4">添加小测试题</a></li>
		</ul>
	  <!--end menu--></div>
            <%
             String p_id=(String)request.getAttribute("p_id");
               if(p_id==null){
            	   %>
            	      <div class="main_down">
							<form action="/OnLineStudy/getherFunction?Smenu=f4" method="post" >
								<p><span class="span1">试卷科目：</span><input type="text" name="p_key" class="input1" id="title" onblur="isempty(this)"/></p>
								<p>
									<input type="submit" value="确定" />
									<input type="reset" value="取消" />
								</p>
							</form>
			            </div>
            	   <% 
               }else{
            	   %>
            	   <a href="/OnLineStudy/getherFunction?Smenu=4">返回添加新的试卷</a>
            	     <div class="main_down">
							<form action="/OnLineStudy/getherFunction?Smenu=f4" method="post" >
									<table>
										<tr>
											<td><span class="span1">题目：</span><input class="input2" name="q" type="text" onblur="isempty(this)"/></td>
										<tr>
										<tr>
											<td><span class="span1">A：</span><input class="input1" name="a" type="text" onblur="isempty(this)"/></td>
										<tr>
										<tr>
											<td><span class="span1">B：</span><input class="input1" name="b" type="text" onblur="isempty(this)"/></td>
										<tr>
										<tr>
											<td><span class="span1">C：</span><input class="input1" name="c" type="text" onblur="isempty(this)"/></td>
										<tr>
										<tr>
											<td><span class="span1">D：</span><input class="input1" name="d" type="text" onblur="isempty(this)"/></td>
										<tr>
										<tr>
											<td>
												<span class="span1">答案：</span>
												<input type="radio" name="r" value="A"/>A
												<input type="radio" name="r" value="B"/>B
												<input type="radio" name="r" value="C"/>C
												<input type="radio" name="r" value="D"/>D
											</td>
										<tr>
									</table>
									<input type="hidden" name="id" value="<%=p_id %>">
								<p>
									<input type="submit" value="确定" />
									<input type="reset" value="取消" />
								</p>
							</form>
			            </div>
            	   <%
               }
            		   
            %>

  <!--end main--></div>