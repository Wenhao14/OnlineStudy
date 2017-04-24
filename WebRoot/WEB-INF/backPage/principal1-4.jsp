<%@ page language="java"  import="java.util.*,com.ols.Bean.classBean"  pageEncoding="utf-8"%>
       <div class="right_main1">
		<form action="/OnLineStudy/principalFunction?Smenu=f3"  method="post">
			<p>
			   <span class="span2">请选择班级：</span> 
			    <select name="selClass">
			    <option value=""></option>
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
			<p><span style="margin-right:360px;">公告：</span></p>
			<p><textarea name="text" cols="50" rows="12"/></textarea></p>
			<p>
				<input type="submit" value="确定" />
				<input type="reset" value="取消" />
			</p>
		</form>
        <!--end right_main--></div>