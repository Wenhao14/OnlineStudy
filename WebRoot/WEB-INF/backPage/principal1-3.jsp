<%@ page language="java"  import="java.util.*,com.ols.Bean.classBean,com.ols.Bean.userBean"  pageEncoding="utf-8"%>
<%
   String s2=(String)request.getAttribute("s2");
   if(s2!=null){
	   if(s2.equals("1")){
		   String cl=(String)request.getAttribute("classID");
		   if(cl==null){
		    %>
			      <div class="right_head">
					<ul class="navil2">
						<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=1&s1=3&s2=1">学习情况查询</a></li>
						<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=3&s2=2">学员心得评价</a></li>
					</ul>
				  <!--end right_head--></div>
				  <div class="right_main">
			    	 <form action="/OnLineStudy/principalFunction?Smenu=f10" method="post" >
			    	    <p>
							<span >请选择要查看班级:</span>
								<select name="classID">
								<%
								     ArrayList<classBean> al=(ArrayList<classBean>)request.getAttribute("al");
								     for(int i=0;i<al.size();i++){
								    	 classBean ID=al.get(i);
								    	 %>
								    	    <option value="<%=ID.getC_id() %>"><%=ID.getC_name() %></option>
								    	 <%										    	 
								     }
							     %>
							</select>
						</p>
							<p style="text-align:center;margin-top:60px;">
									<input type="submit" value="确定" />
									<input type="reset" value="取消" />
						    </p>
					    </form>
			    	 <%
				     }else{
				    	 ArrayList<userBean> al=(ArrayList<userBean>)request.getAttribute("al");
				    	 int[] p=(int[])request.getAttribute("p");
				    	 %>
				    	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnLineStudy/principalFunction?Smenu=1&s1=3">返回选择班级</a>
				    	  <%
				    	      if(al.size()>0){
				    	    	  %>
				    	    	     <div class="right_main">
											<table>
												<tr>
													<td>学员名</td>
													<td>查看学习情况</td>
												</tr>
												<%
												   for(int i=0;i<al.size();i++){
													   userBean data=al.get(i);
													   %>
													      <tr>
															<td><%=data.getS_name() %></td>
															<td><a href="/OnLineStudy/principalFunction?Smenu=f10&s_id=<%=data.getS_id() %>">查看</a></td>
														</tr>
													   <%
												   }
												%>	
											</table>
									    </div>
									<span class="span3">
											<%
				   							   if(p[0]>1){
				   								   %>
				   								      <a href="/OnLineStudy/principalFunction?Smenu=f10&classID=<%=cl %>&p=<%=p[0]-1 %>"><img src="img/last.jpg"></a>
				   								   <%
				   							   }
				   							%>
				   							    <font>第<%=p[0] %>页</font>
				   							<% 
				   							   if(p[0]<p[1]){
				   								   %>
				   								      <a href="/OnLineStudy/principalFunction?Smenu=f10&classID=<%=cl %>&p=<%=p[0]+1 %>"><img src="img/next.jpg"></a>
				   								   <%
				   							   }
				   							%>	
								    </span>
				    	    	  <%
				    	      }else{
				    	    	  %>
				    	    	     <h3>本班暂无学员</h3>
				    	    	  <%
				    	      }
				     }
			   %>
			<!--end right_main--></div>
	    <%
	   }else{
		   ArrayList<String[]> al=(ArrayList<String[]>)request.getAttribute("al");
		   int[] p=(int[])request.getAttribute("p");
		   %>
		      <div class="right_head">
				<ul class="navil2">
					<li ><a href="/OnLineStudy/principalFunction?Smenu=1&s1=3&s2=1">学习情况查询</a></li>
					<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=1&s1=3&s2=2">学员心得评价</a></li>
				</ul>
			  <!--end right_head--></div>
			  <div class="right_main">
			  <% 
			     if(al.size()>0){
			    	 %>
					     <table>
							<tr>
								<td>用户名</td>
								<td>姓名</td>
								<td>标题</td>
								<td>操作</td>
							</tr>
							<%
							   for(int i=0;i<al.size();i++){
								   String [] know=al.get(i);
								   %>
								      <tr>
										<td><%=know[2] %></td>
										<td><%=know[3] %></td>
										<td><%=know[4] %></td>
										<td><a href="/OnLineStudy/principalFunction?Smenu=f9&s_id=<%=know[1] %>&d_id=<%=know[0] %>">评阅</a></td>
									</tr>
								   <%
							   }
							%>
							
						</table>
						<span class="span3">
							<%
							   if(p[0]>1){
								   %>
								      <a href="/OnLineStudy/principalFunction?Smenu=1&s1=3&s2=2&p=<%=p[0]-1 %>"><img src="img/last.jpg"></a>
								   <%
							   }
							%>
							   <font>第<%=p[0] %>页</font>
							<% 
							   if(p[0]<p[1]){
								   %>
								      <a href="/OnLineStudy/principalFunction?Smenu=1&s1=3&s2=2&p=<%=p[0]+1 %>"><img src="img/next.jpg"></a>
								   <%
							   }
							%>	
						</span>
			    	 <%
			     }else{
			    	%>
			    	   <H3>暂无记录</H3>
			    	<%
			    	 
			     }
			  %>	
			 <!--end right_main--></div>
		   <%
	   }
   }
%>
