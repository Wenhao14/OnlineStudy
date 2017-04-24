<%@ page language="java"  import="java.util.* ,com.ols.Bean.userBean" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <link rel=stylesheet href="css/part_reg.css" type="text/css">
  <script language="javascript" type="text/javascript" src="js/reg.js"></script>
 </head>
 <body>

				<div class="right_head">
					<img src="img/part1.jpg"/>
				<!--end right head--></div>
                   <%
                       String mselect=(String)request.getAttribute("mselect");
                   if(mselect!=null){
                	   if(mselect.equals("m1")){
                		   userBean news=(userBean)request.getAttribute("news");
                		   %>
                		      <div class="right_main">

						<div class="main_head">
							<ul class="navil">
								<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u2&mselect=m1">完善信息</a></li>
								<li><a href="/OnLineStudy/userFunctionServlet?select=u2&mselect=m2">修改密码</a></li>
							</ul>
						<!--end main_head--></div>

				<div class="main_main">
					<form class="form1" method="post" onsubmit="return check1()" action="/OnLineStudy/usernewsServlet?select=1">

						<p><span class="span1">姓名：</span><input class="input1" type="text" name="name" id="name" value="<%=news.getS_name() %>" onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" /></p>
                           <% 
                              if(news.getS_sex().equals("男")){
                            	  %>
                            	     <p><span class="span1">性别：</span>
									 <input type="radio" name="sex" value="男" id="male" checked />
									 <label for="male">男</label>
									 <input type="radio" name="sex" value="女" id="female" />
									 <label for="female">女</label></p>
                            	  <% 
                            	  
                              }else if(news.getS_sex().equals("女")){
                            	  %>
                            	     <p><span class="span1">性别：</span>
								     <input type="radio" name="sex" value="男" id="male" />
								     <label for="male">男</label>
								     <input type="radio" name="sex" value="女" id="female" checked />
								     <label for="female">女</label></p>
                            	  <% 
                              }else{
                            	  %>
                            	     <p><span class="span1">性别：</span>
								     <input type="radio" name="sex" value="男" id="male" />
								     <label for="male">男</label>
								     <input type="radio" name="sex" value="女" id="female"/>
								     <label for="female">女</label></p>
                            	  <% 
                              }
                           %>
						

						<p><span class="span1">部门：</span><input class="input1" type="text" name="dept" id="department" value="<%=news.getS_section()%>"  /></p>

						<p><span class="span1">手机号码：</span><input class="input1" type="text" name="phone" id="phone" value="<%=news.getS_phone()%>" onkeyup="value=value.replace(/[^\d]/g,'')" /></p>

						<p><span class="span1">邮箱：</span><input class="input1" type="text" name="mail" id="mymail" value="<%=news.getS_mile()%>"  onblur="isEmail()"/></p>

						<p><input type="submit" name="sub" value="保存"/>
							<input type="reset" name="reset" value="重置"/></p>

					</form>
				<!--end main_main--></div>

				<!--end right_main--></div>
                		   <%
                	   }else{
                		   %>
             		      <div class="main_head">
							<ul class="navil">
								<li><a href="/OnLineStudy/userFunctionServlet?select=u2&mselect=m1">完善信息</a></li>
								<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u2&mselect=m2">修改密码</a></li>
							</ul>
						<!--end main_head--></div>

				   <div class="main_main">
					<form class="form2" method="post" onsubmit="return check2()" action="/OnLineStudy/usernewsServlet?select=2">
                        <p><span class="span1">旧密码：</span><input class="input1" type="password" name="oldpwd" id="oldpwd" placeholder="请输入原密码"/></p>
                         
						<p><span class="span1">新密码：</span><input class="input1" type="password" name="newpwd" id="password" placeholder="请输入新密码"/></p>

						<p><span class="span1">重复新密码：</span><input class="input1" type="password" name="id_conform" id="conform" placeholder="请再次输入新密码" /></p>

						<p><input type="submit" name="sub" value="修改"/>
							<input type="reset" name="reset" value="重置"/></p>

					</form>
				<!--end main_main--></div>
                		   <%
                	   }
                   }
                   %>
					

