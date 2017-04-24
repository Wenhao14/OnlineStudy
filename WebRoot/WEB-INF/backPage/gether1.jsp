<%@ page language="java"  import="java.util.*,com.ols.Bean.dataBean"  pageEncoding="utf-8"%>

<div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li id="li1"><a href="/OnLineStudy/getherFunction?Smenu=1">学习资料管理</a></li>
			<li><a href="/OnLineStudy/getherFunction?Smenu=2">修改密码</a></li>
			<li><a href="/OnLineStudy/getherFunction?Smenu=3">采集新闻</a></li>
			<li id="li1"><a href="/OnLineStudy/getherFunction?Smenu=4">添加小测试题</a></li>
		</ul>
	  <!--end menu--></div>

	  <div class="main_left">
		<ul>
			<li><a href="/OnLineStudy/getherFunction?Smenu=1&s1=1">上传学习资料</a></li>
			<li><a href="/OnLineStudy/getherFunction?Smenu=1&s1=2">删除学习资料</a></li>
		</ul>
	  <!--end main_left--></div>
          
		<%
		   String s1=(String)request.getAttribute("s1");
		  if(s1.equals("1")){
			  %>
			     <div class="main_right">

					<div class="right_main">
		
		
							<form action="/OnLineStudy/UploadHandleServlet" enctype="multipart/form-data" method="post">
							    <table>
							       <tr>
							            <td>标题:<input type="text" name="title" width="150"/></td>
							            <td><input type="file" name="data" accept=".mp4 ,.ogg"/></td>
							       </tr>
							       <tr>
								       <td><input type="submit" value="上传"/></td>
								       <td><input type="reset" value="取消" /></td>  						
							       </tr>
							    </table>
							</form>
						
					<!--end right_main--></div>
		
				<!--end main_right--></div>
			     
			  <%
		  }else{
			  ArrayList<dataBean> al=(ArrayList<dataBean>)request.getAttribute("al");
			  int [] p=(int[])request.getAttribute("page");
				      %>
				       <div class="main_right">
	
						<div class="right_main">
							<table>
								<tr>
									<td>名称</td>
									<td>类型</td>
									<td>上传人</td>
									<td>操作</td>
								</tr>
								<%
									for(int i=0;i<al.size();i++){
							    		dataBean data=al.get(i);
							    		%>
								    		<tr>
												<td><%=data.getD_key() %></td>
												<td>视频 </td>
												<td><%=data.getG_user()%></td>
												<td><a href="/OnLineStudy/getherFunction?Smenu=f3&id=<%=data.getD_id()%>">删除</a></td>
										    </tr>
									    <% 
									}
								%>
							</table>
							<span class="span3">
								<%
	   							   if(p[0]>1){
	   								   %>
	   								      <a href="/OnLineStudy/getherFunction?Smenu=1&s1=2&p=<%=p[0]-1 %>"><img src="img/last.jpg"></a>
	   								   <%
	   							   }
	   							%>
	   							    <font>第<%=p[0] %>页</font>
	   							<% 
	   							   if(p[0]<p[1]){
	   								   %>
	   								      <a href="/OnLineStudy/getherFunction?Smenu=1&s1=2&p=<%=p[0]+1 %>"><img src="img/next.jpg"></a>
	   								   <%
	   							   }
	   							%>	
							</span>
						<!--end right_main--></div>
			
					  <!--end main_right--></div>	
				<%  			  
		  }
	%> 
  <!--end main--></div>