<%@ page language="java"  import="java.util.*,com.ols.Bean.classBean"  pageEncoding="utf-8"%>
  <%
     String s2=(String)request.getAttribute("s2");
      if(s2!=null){
    	  if(s2.equals("1")){
    		  %>
    		     <div class="right_head">
					<ul class="navil2">
						<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=1&s1=1&s2=1">创建班级</a></li>
						<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=1&s2=2">删除班级</a></li>
					</ul>
				<!--end right_head--></div>
				<div class="right_main">
					<form action="/OnLineStudy/principalFunction?Smenu=f4" method="post">
						<p><span class="span1">班级名：</span><input type="text" name="clName" class="input1"/></p>
						<p>
							<input type="submit" value="创建" />
							<input type="reset" value="取消" />
						</p>
					</form>
	             <!--end right_main--></div>
    		  <% 
    	  }else{
    		  %>
    		      <div class="right_head">
					<ul class="navil2">
						<li><a href="/OnLineStudy/principalFunction?Smenu=1&s1=1&s2=1">创建班级</a></li>
						<li id="li1"><a href="/OnLineStudy/principalFunction?Smenu=1&s1=1&s2=2">删除班级</a></li>
					</ul>
				<!--end right_head--></div>
				<div class="right_main">
					<table>
						<tr>
							<td>班级名</td>
							<td>创建时间</td>
							<td>操作</td>
						</tr>
						<%
						   ArrayList<classBean> al=(ArrayList<classBean>)request.getAttribute("al");
						   for(int i=0;i<al.size();i++){
							   classBean cl=al.get(i);
							   %>
							      <tr>
									<td><%=cl.getC_name() %></td>
									<td><%=cl.getC_date() %> </td>
									<td><a href="/OnLineStudy/principalFunction?Smenu=f5&id=<%=cl.getC_id() %>">删除</a></td>
								 </tr>
							   <%
						   }
						%>
					</table>
				<!--end right_main--></div>
    		  <% 
    	  }
      }
  %>
          
