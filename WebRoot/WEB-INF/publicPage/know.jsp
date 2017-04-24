<%@ page language="java"  import="java.util.*,com.ols.Bean.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <link rel=stylesheet href="css/part1.css" type="text/css">
 <div class="right_head">
	<img src="img/part4.jpg"/>
<!--end right head--></div>
                   <%
                       String kselect=(String) request.getAttribute("kselect");
                       int[] a=(int[])request.getAttribute("sum");
                       if(kselect!=null){
                    	    if(kselect.equals("k1")){
                    	    	%>
					<div class="main_head">
						<ul class="navil">
							<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k1">未提交</a></li>
							<li><a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k2">已提交</a></li>
						</ul>
					<!--end main_head--></div>

					<div class="main_middle">
						<ul class="navil">
							<li>要求完成：<%=a[0] %>  个</li>
							<li>已完成：<%=a[1] %>  个</li>
						</ul>
					<!--end main_middle--></div>

					<div class="main_main">
						<table>
							<tr class="tr1">
								<td class="td1">作业标题</td>
								<td class="td3">操作</td>
							</tr>
							<%
							 ArrayList<dataBean> al=(ArrayList<dataBean>)request.getAttribute("al");
							    for(int i=0;i<al.size();i++){
							    	dataBean noknow=al.get(i);
								   %>
								    <tr class="">
									  <td class=""><%=noknow.getD_key() %></td>
									  <td class="td4"><a href="/OnLineStudy/usernewsServlet?select=4&id=<%=noknow.getD_id()%>"><img src="img/pen.jpg"/></a></td>
								    </tr>   
								   <% 
							    }
							%>
							
							
						</table>
					<!--end main_main--></div>
					<div class="main_button">
						<span class="span1">
							每页显示
							<font><%=a[2]%></font>
							条
						</span>

						<span class="span2">
							共
							<font><%=a[3] %></font>
							页
						</span>

						<span class="span3">
						    <%
						       if(a[4]>1){
						    	 
						    	  %> 
						    	  <a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k1&pageNow=<%=a[4]-1%>"><img src="img/last.jpg"></a>
						          <% 
						       }
						    %>
							
							<font>第<%=a[4] %>页</font>
							<%
						       if(a[4]<a[3]){
						    	   
						    	  %> 
							       <a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k1&pageNow=<%=a[4]+1%>"><img src="img/next.jpg"></a>
						          <% 
						       }
						    %>
						</span>
				<!--end main_button--></div>
                    	    	<%
                    	    }else if(kselect.equals("k2")){
                    	       %>
      
								<div class="main_head">
									<ul class="navil">
										<li><a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k1">未提交</a></li>
										<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k2">已提交</a></li>
									</ul>
								<!--end main_head--></div>
			
								<div class="main_middle">
									<ul class="navil">
										<li>要求完成：<%=a[0] %>  个</li>
										<li>已完成：<%=a[1] %>  个</li>
									</ul>
								<!--end main_middle--></div>
			
								<div class="main_main">
									<table>
										<tr class="tr1">
											<td class="td1">作业标题</td>
											<td class="td3">评价</td>
										</tr>
										<%
										ArrayList<kownBean> al=(ArrayList<kownBean>)request.getAttribute("al");
									    for(int i=0;i<al.size();i++){
									    	kownBean hasknow=al.get(i);
											  %>
											    <tr class="">
												  <td class=""><%=hasknow.getD_key() %></td>
												  <td class="td3"><font><%=hasknow.getK_assess() %></font></td>
											    </tr>
											  <%
									     }
										%>
				
						</table>
					<!--end main_main--></div>
					<div class="main_button">
						<span class="span1">
							每页显示
							<font><%=a[2] %></font>
							条
						</span>

						<span class="span2">
							共
							<font><%=a[3] %></font>
							页
						</span>

						<span class="span3">
						    <%
						       if(a[4]>1){
						    	  
						    	  %> 
						    	  <a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k2&pageNow=<%=a[4]-1%>"><img src="img/last.jpg"></a>
						          <% 
						       }
						    %>
							
							<font>第<%=a[4] %>页</font>
							<%
						       if(a[4]<a[3]){
						 
						    	  %> 
							       <a href="/OnLineStudy/userFunctionServlet?select=u5&kselect=k2&pageNow=<%=a[4]+1%>"><img src="img/next.jpg"></a>
						          <% 
						       }
						    %>
						</span>
					<!--end main_button--></div>
                    	       <% 
                    	    }
                       }
                   %>
					