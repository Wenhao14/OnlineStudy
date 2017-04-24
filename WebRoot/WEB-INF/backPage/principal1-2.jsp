<%@ page language="java"  import="java.util.*,com.ols.Bean.classBean"  pageEncoding="utf-8"%>
  <%
     String s2=(String)request.getAttribute("s2");
     if(s2!=null){
    	 if(s2.equals("1")){
    		 %>
    		    <div class="right_head">
					<ul class="navil2">
						<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=1&s1=2&s2=1">增加学员</a></li>
						<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=2&s2=2">删除学员</a></li>
					</ul>
				<!--end right_head--></div>
				<div class="right_main">
					   <%
					      String classID=(String)request.getAttribute("classID");
					       if(classID==null){
					    	   %>
						    	   <form action="/OnLineStudy/principalFunction?Smenu=1&s1=2&s2=1" method="post">
						    	      <p>
										<span >请选择班级:</span>
										<select name="classID">
										  <%
										     ArrayList<classBean> al=(ArrayList<classBean>)request.getAttribute("al");
										     for(int i=0;i<al.size();i++){
										    	 classBean cl=al.get(i);
										    	 %>
										    	    <option value="<%=cl.getC_id() %>"><%=cl.getC_name() %></option>
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
					    	   %>
					    	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/OnLineStudy/principalFunction?Smenu=1&s1=2&s2=1">返回选择班级</a>
					    	    <form action="/OnLineStudy/principalFunction?Smenu=f7" method="post">
						    	     <p><span class="span1">用户名：</span><input type="text" name="Suser" class="input1"/></p>
						    	     <input type="hidden" name="classID" value="<%=classID %>">
									 <p>
										<input type="submit" value="确定" />
										<input type="reset" value="取消" />
									 </p>
								 </form>
					    	   <%
					       }
					   %>						
					
				<!--end right_main--></div>
    		    
    		 <%
    	 }else{
    		  
    		 %>
    		     <div class="right_head">
					<ul class="navil2">
						<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=2&s2=1">增加学员</a></li>
						<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=1&s1=2&s2=2">删除学员</a></li>
					</ul>
				<!--end right_head--></div>
				<div class="right_main">
				  <% 
				      String[] student=(String[])request.getAttribute("student");
				      if(student==null){
				    	  String message=(String)request.getAttribute("message");
				    	  if(message!=null){
				    		  %>
				    		  <br><br>
				    		    <font color="red">*<%=message %></font> 
				    		  <%
				    	  }else{
				    		  %>
				    		   <br/><br><br>
				    		  <%
				    	  }
				          %>
				    	      <form action="/OnLineStudy/principalFunction?Smenu=1&s1=2&s2=2" method="post">
					    	      <p><span>请输入用户名或姓名：</span><input type="text" name="delstu" class="input1"/></p>
					    	      <p>
									<input type="submit" value="确定" />
									<input type="reset" value="取消" />
								  </p>
							   </form>
				    	  <%
				      }else{
				    	  %>
				    	    <table>
								<tr>
									<td>用户名</td>
									<td>姓名</td>
									<td>班级</td>
									<td>操作</td>
								</tr>
								<tr>
									<td><%=student[0] %></td>
									<td><%=student[1] %> </td>
									<td><%=student[2] %></td>
									<td><a href="/OnLineStudy/principalFunction?Smenu=f6&id=<%=student[3]%>">删除</a></td>
								</tr>
							</table>
				    	  <%
				      }
				  %>
				<!--end right_main--></div>
    		 <%
    	 }
     }
  %>