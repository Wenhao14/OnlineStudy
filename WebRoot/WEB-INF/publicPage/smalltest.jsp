<%@ page language="java"  import="java.util.* ,com.ols.Bean.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <link rel=stylesheet href="css/part1.css" type="text/css">
 <div class="right_head">
	<img src="img/part5.jpg"/>
<!--end right head--></div>
                   <%
                        String tselect=(String) request.getAttribute("tselect");
                        int[] a=(int[])request.getAttribute("sum");
                       if(tselect!=null){
                    	    if(tselect.equals("t1")){
                    	    	%>
					<div class="main_head">
						<ul class="navil">
							<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t1">未完成</a></li>
							<li><a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t2">已完成</a></li>
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
								<td class="td1">测试科目</td>
								<td class="td3">测试</td>
							</tr>
							<%
							 ArrayList<paperBean> al=(ArrayList<paperBean>)request.getAttribute("al");
							    for(int i=0;i<al.size();i++){
							    	paperBean nopaper=al.get(i);
							   %>
							    <tr class="">
									<td class=""><%=nopaper.getP_key() %></td>
									<td class="td4"><a href="/OnLineStudy/usernewsServlet?select=5-1&id=<%=nopaper.getP_no() %>"><img src="img/pen.jpg"/></a></td>
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
						    	  <a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t1&pageNow=<%=a[4]-1%>"><img src="img/last.jpg"></a>
						          <% 
						       }
						    %>
							
							<font>第<%=a[4] %>页</font>
							<%
						       if(a[4]<a[3]){
						    	  
						    	  %> 
							       <a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t1&pageNow=<%=a[4]+1%>"><img src="img/next.jpg"></a>
						          <% 
						       }
						    %>
						</span>
					<!--end main_button--></div>
                    	    	<%
                    	    }else if(tselect.equals("t2")){
                    	       %>
      
					<div class="main_head">
						<ul class="navil">
							<li><a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t1">未完成</a></li>
							<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t2">已完成</a></li>
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
								<td class="td1">测试科目</td>
								<td class="td3">成绩</td>
								<td class="td3">查看答案</td>
							</tr>
							<%
							 ArrayList<markBean> al=(ArrayList<markBean>)request.getAttribute("al");
							    for(int i=0;i<al.size();i++){
							    	markBean haspaper=al.get(i);
								  %>
								     <tr class="">
										<td class=""><%=haspaper.getP_key() %></td>
										<td class="td3"><font><%=haspaper.getScore() %></font></td>
										<td class="td3"><a href="/OnLineStudy/usernewsServlet?select=5-2&id=<%=haspaper.getM_no()%>">查看</a></td>
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
						    	  <a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t2&pageNow=<%=a[4]-1%>"><img src="img/last.jpg"></a>
						          <% 
						       }
						    %>
							
							<font>第<%=a[4] %>页</font>
							<%
						       if(a[4]<a[3]){
						    	  
						    	  %> 
							       <a href="/OnLineStudy/userFunctionServlet?select=u6&tselect=t2&pageNow=<%=a[4]+1%>"><img src="img/next.jpg"></a>
						          <% 
						       }
						    %>
						</span>
					<!--end main_button--></div>
                    	       <% 
                    	    }
                       }
                   %>
					