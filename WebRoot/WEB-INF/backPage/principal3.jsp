<%@ page language="java"  import="java.util.*,com.ols.Bean.classBean"  pageEncoding="utf-8"%>
 <div class="main">

	  <div class="menu">
		<ul class="navil1">
			<li><a href="/OnLineStudy/principalFunction?Smenu=1">班级管理</a></li>
			<li><a href="/OnLineStudy/principalFunction?Smenu=2">密码管理</a></li>
			<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=3">选择学习资料</a></li>
		</ul>
	  <!--end menu--></div>
	  <div class="bottom">
		  <%
		     String cl=(String)request.getAttribute("classID");
		     if(cl==null){
		    	 %>
		    	 <form action="/OnLineStudy/principalFunction?Smenu=3" method="post" >
		    	    <p>
						<span >请选择班级:</span>
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
		    	 ArrayList<String[]> data=(ArrayList<String[]>)request.getAttribute("data");
		    	 int[] p=(int[])request.getAttribute("p");
		    	 %>
		    	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnLineStudy/principalFunction?Smenu=3">返回选择班级</a>
		    	  <%
		    	      if(data.size()>0){
		    	    	  %>
		    	    	     <p><span>请选择资料：</span></p>
		    	    	     <form action="/OnLineStudy/principalFunction?Smenu=f8" method="post">
									<table>
										<tr>
											<td>资料名</td>
											<td>选择</td>
										</tr>
										<%
										   for(int i=0;i<data.size();i++){
											   String[] al=data.get(i);
											   %>
											      <tr>
													<td><%=al[1] %></td>
													<td><input type="checkbox" name="datas" value="<%=al[0] %>"></td>
												</tr>
											   <%
										   }
										%>	
									</table>
									<input type="hidden" name="classID" value=<%=cl %>>
									<p style="text-align:center;margin-top:60px;">
										<input type="submit" value="确定" />
										<input type="reset" value="取消" />
									</p>
								</form>
							<span class="span3">
									<%
		   							   if(p[0]>1){
		   								   %>
		   								      <a href="/OnLineStudy/getherFunction?Smenu=3&p=<%=p[0]-1 %>"><img src="img/last.jpg"></a>
		   								   <%
		   							   }
		   							%>
		   							    <font>第<%=p[0] %>页</font>
		   							<% 
		   							   if(p[0]<p[1]){
		   								   %>
		   								      <a href="/OnLineStudy/getherFunction?Smenu=3&p=<%=p[0]+1 %>"><img src="img/next.jpg"></a>
		   								   <%
		   							   }
		   							%>	
						    </span>
		    	    	  <%
		    	      }else{
		    	    	  %>
		    	    	     <h3>暂无新的学习资料</h3>
		    	    	  <%
		    	      }
		    	  %> 
				  <!--end bottom--></div>
		    	 <%
		     }
		  %>
  <!--end main--></div>