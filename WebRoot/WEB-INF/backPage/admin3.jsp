<%@ page language="java"  import="java.util.*,com.ols.Bean.classBean,com.ols.Bean.userBean"  pageEncoding="utf-8"%>

  <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li><a href="/OnLineStudy/adminFunction?Smenu=1">用户管理</a></li>
			<li><a href="/OnLineStudy/adminFunction?Smenu=2">密码管理</a></li>
			<li id="li1"><a href="/OnLineStudy/adminFunction?Smenu=3">查看学习情况</a></li>
		</ul>
	  <!--end menu--></div>

	  <div class="main_left">
		<div class="search">
			<form action="/OnLineStudy/adminFunction?Smenu=f5" method="post">
				<p><label>用户名：</label><input type="text" name="s_user" placeholder="请输入要查找的用户名"/></p>
				<p>
					<input type="submit" value="查找" />
				</p>
			</form>
		</div>
	  <!--end main_left--></div>

		<div class="main_right">
             <%
                String c_id=(String)request.getAttribute("c_id");
                if(c_id==null){
                	%>
                	  <div class="right_main">
	                	   <form action="/OnLineStudy/adminFunction?Smenu=f5" method="post" >
					    	    <p>
									<span >请选择要查看班级:</span>
										<select name="c_id">
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
						 </div>
                	<%
                	
                }else{
                	 ArrayList<userBean> al=(ArrayList<userBean>)request.getAttribute("al");
			    	 int[] p=(int[])request.getAttribute("p");
               	      if(al.size()>0){
		    	    	  %>
		    	    	     <div class="right_main">
			    	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnLineStudy/adminFunction?Smenu=3">返回选择班级</a>
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
													<td><a href="/OnLineStudy/adminFunction?Smenu=f5&s_id=<%=data.getS_id() %>">查看</a></td>
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
		   								      <a href="/OnLineStudy/adminFunction?Smenu=f5&c_id=<%=c_id %>&p=<%=p[0]-1 %>"><img src="img/last.jpg"></a>
		   								   <%
		   							   }
		   							%>
		   							    <font>第<%=p[0] %>页</font>
		   							<% 
		   							   if(p[0]<p[1]){
		   								   %>
		   								      <a href="/OnLineStudy/adminFunction?Smenu=f5&c_id=<%=c_id %>&p=<%=p[0]+1 %>"><img src="img/next.jpg"></a>
		   								   <%
		   							   }
		   							%>	
						      </span>
						    <!--end right_main--></div>
		    	    <%
		    	  }else{
	    	    	  %>
    	    	    	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnLineStudy/adminFunction?Smenu=3">返回选择班级</a>    	    	  
	    	    	     <h3>本班暂无学员</h3>
	    	    	  <%
	    	      }
			  }   
		  %>
  <!--end main--></div>
