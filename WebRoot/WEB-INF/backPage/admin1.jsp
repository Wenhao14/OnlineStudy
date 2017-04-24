<%@ page language="java"  import="java.util.*,com.ols.servers.adminIndex"  pageEncoding="utf-8"%>

  <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li id="li1"><a href="/OnLineStudy/adminFunction?Smenu=1">用户管理</a></li>
			<li><a href="/OnLineStudy/adminFunction?Smenu=2">密码管理</a></li>
			<li><a href="/OnLineStudy/adminFunction?Smenu=3">查看学习情况</a></li>
		</ul>
	  <!--end menu--></div>
        <div class="main_left">
		<ul>
		<%
		   adminIndex a=new adminIndex();
		   if(a.SelAdminID((String)request.getSession().getAttribute("username"))){
			   %>
			   <li><a href="/OnLineStudy/adminFunction?Smenu=1&s1=1">管理员</a></li>
			   <%
		   }
		%>
			<li><a href="/OnLineStudy/adminFunction?Smenu=1&s1=2">班级管理员</a></li>
			<li><a href="/OnLineStudy/adminFunction?Smenu=1&s1=3">资料采集员</a></li>
		</ul>
	  <!--end main_left--></div>
	  <div class="main_right">
      <%
          String s1=(String)request.getAttribute("s1");
          String s2=(String)request.getAttribute("s2");
          if(s1!=null&&s2!=null){
        	  if(s1.equals("1")){
            	        %>
            	         <div class="right_head">
    						<ul class="navil2">
    							<li id="li1"><a href="/OnLineStudy/adminFunction?Smenu=1&s1=1&s2=1">增加管理员</a></li>
    							<li><a href="/OnLineStudy/adminFunction?Smenu=1&s1=1&s2=2">删除管理员</a></li>
    						</ul>
    					 <!--end right_head--></div>
    					<%
    					    if(s2.equals("1")){
    					    	 %>
    									<div class="right_main">
    										<form action="/OnLineStudy/adminFunction?Smenu=f3" method="post">
    											<p><span class="span1">用户名：</span><input type="text" name="userN" class="input1"/>
    											    <input type="hidden" name="type" value="admin"/>
    											</p>
    											<p>
    												<input type="submit" value="确定" />
    												<input type="reset" value="取消" />
    											</p>
    										</form>
    									<!--end right_main--></div>
    			                <%
    					    }else{
    					    	ArrayList<String[]> al=(ArrayList<String[]>)request.getAttribute("al");
    					    	
    					    		%>
	    								<div class="right_main">
	    									<table>
	    										<tr>
	    											<td>用户名</td>
	    											<td>操作</td>
	    										</tr>
	    										<%
	    										for(int i=0;i<al.size();i++){
	    		    					    		String[] news=al.get(i);
	    										   %>
	    										      <tr>
		    											<td><%=news[0] %></td>
		    											<td><a href="/OnLineStudy/adminFunction?Smenu=f4&u=<%=news[0]%>&t=admin">删除</a></td>
		    										  </tr>
	    										   <%
	    										}
	    										%>
	    										
	    									</table>
	    									
	    							 	<!--end right_main--></div>
    		                       <%	
    					    }
    					%>
            	  <% 
              }else if(s1.equals("2")){
            	  %>
     	             <div class="right_head">
    					<ul class="navil2">
    						<li id="li1"><a href="/OnLineStudy/adminFunction?Smenu=1&s1=2&s2=1">增加班级管理员</a></li>
    						<li><a href="/OnLineStudy/adminFunction?Smenu=1&s1=2&s2=2">删除班级管理员</a></li>
    					</ul>
    				 <!--end right_head--></div>
    				  <%
    					    if(s2.equals("1")){
    					      %>
    								<div class="right_main">
    									<form action="/OnLineStudy/adminFunction?Smenu=f3" method="post">
    										<p><span class="span1">用户名：</span><input type="text" name="userN" class="input1"/></p>
    										<p><span class="span1">姓名：</span><input type="text" name="name" class="input1"/></p>
    										<p><span class="span1">部门：</span><input type="text" name="dept" class="input1"/></p>
    										<input type="hidden" name="type" value="principal"/>
    										<p>
    											<input type="submit" value="确定" />
    											<input type="reset" value="取消" />
    										</p>
    									</form>
    								<!--end right_main--></div>
    				
    			             
    			             <%
    					    }else{
    					    	ArrayList<String[]> al=(ArrayList<String[]>)request.getAttribute("al");
    					    	int[] p=(int[])request.getAttribute("page");
    					    	
	    					    	%>
	    								<div class="right_main">
	    									<table>
	    										<tr>
	    											<td>用户名</td>
	    											<td>姓名</td>
	    											<td>部门</td>
	    											<td>操作</td>
	    										</tr>
	    										<%
		    										for(int i=0;i<al.size();i++){	    										
		    		    					    		String[] news=al.get(i);
		    		    					    		%>
		    		    					    		  <tr>
			    											<td><%=news[0] %></td>
			    											<td><%=news[1] %> </td>
			    											<td><%=news[2] %></td>
			    											<td><a href="/OnLineStudy/adminFunction?Smenu=f4&u=<%=news[0]%>&t=principal">删除</a></td>
			    										 </tr>
		    		    					    		<%
		    										}
	    										%>
	    										
	    									</table>
			    							<span class="span3">
			    							<%
			    							   if(p[0]>1){
			    								   %>
			    								      <a href="/OnLineStudy/adminFunction?Smenu=1&s1=2&s2=2&p=<%=p[0]-1 %>"><img src="img/last.jpg"></a>
			    								   <%
			    							   }
			    							%>
			    							    <font>第<%=p[0] %>页</font>
			    							<% 
			    							   if(p[0]<p[1]){
			    								   %>
			    								      <a href="/OnLineStudy/adminFunction?Smenu=1&s1=2&s2=2&p=<%=p[0]+1 %>"><img src="img/next.jpg"></a>
			    								   <%
			    							   }
			    							%>	
											</span>
	    								<!--end right_main--></div>
	    		                  <%
    					    }
    				  %>
     	          <% 
              }else{
            	  %>
     	              <div class="right_head">
    					<ul class="navil2">
    						<li id="li1"><a href="/OnLineStudy/adminFunction?Smenu=1&s1=3&s2=1">增加采购员</a></li>
    						<li><a href="/OnLineStudy/adminFunction?Smenu=1&s1=3&s2=2">删除采购员</a></li>
    					</ul>
    				  <!--end right_head--></div>
    				  <%
    					    if(s2.equals("1")){
    					    	%>
    			        	
    								<div class="right_main">
    									<form action="/OnLineStudy/adminFunction?Smenu=f3" method="post">
    										<p><span class="span1">用户名：</span><input type="text" name="userN" class="input1"/></p>
    										<p><span class="span1">姓名：</span><input type="text" name="name" class="input1"/></p>
    										<p><span class="span1">部门：</span><input type="text" name="dept" class="input1"/></p>
    										<p>
    										<input type="hidden" name="type" value="gether"/>
    											<input type="submit" value="确定" />
    											<input type="reset" value="取消" />
    										</p>
    									</form>
    								<!--end right_main--></div>
    					
    							
    			             
    			             <%
    					    }else{
    					    	ArrayList<String[]> al=(ArrayList<String[]>)request.getAttribute("al");		    	
	    					    	%>
	    								<div class="right_main">
	    									<table>
	    										<tr>
	    											<td>用户名</td>
	    											<td>姓名</td>
	    											<td>部门</td>
	    											<td>操作</td>
	    										</tr>
	    										<%
		    										for(int i=0;i<al.size();i++){
		    		    					    		String[] news=al.get(i);
		    		    					    		%>
		    		    					    		   <tr>
				    											<td><%=news[0] %></td>
				    											<td><%=news[1] %> </td>
				    											<td><%=news[2] %></td>
				    											<td><a href="/OnLineStudy/adminFunction?Smenu=f4&u=<%=news[0]%>&t=gether">删除</a></td>
				    										</tr>
		    		    					    	    <% 	
		    										}
	    										%>
	    										
	    									</table>
	    								
	    								<!--end right_main--></div>
	    			              <%
    					    	
    					 }
              }
          }
        %>
     <!--end main_right--></div>
	  
  <!--end main--></div>
