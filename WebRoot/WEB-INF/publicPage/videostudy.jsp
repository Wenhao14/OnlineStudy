<%@ page language="java" import="java.util.*,com.ols.Bean.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel=stylesheet href="css/part1.css" type="text/css">
<div class="main_page">
     <div class="right_head">
		<img src="img/part2.jpg"/>
	<!--end right head--></div>
        <%
            String vselect=(String)request.getAttribute("vselect");
            int[] a=(int[])request.getAttribute("sum");
          if(vselect!=null){
             if(vselect.equals("v1")){
            	
        		  %>
					<div class="main_head">
						<ul class="navil">
							<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v1">未学课程</a></li>
							<li><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v2">未学完的课程</a></li>
							<li><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v3">已学完的课程</a></li>
						</ul>
					<!--end main_head--></div>
			
					<div class="main_middle">
						<ul class="navil">
							<li>要求：<%=a[0] %>  个</li>
							<li>已学：<%=a[1] %>  个</li>
						</ul>
					<!--end main_middle--></div>

					<div class="main_main">
						<table>
							<tr class="tr1">
								<td class="td1">课程标题</td>
								<td class="td2">操作</td>
							</tr>
							<%
							    ArrayList<dataBean> al=(ArrayList)request.getAttribute("al");
							    for(int i=0;i<al.size();i++){
							    	dataBean nodata=al.get(i);
							   %>
							     <tr class="">
								 <td class=""><%=nodata.getD_key() %></td>
								 <td class="btn"><a href="/OnLineStudy/usernewsServlet?select=3-1&id=<%=nodata.getD_id()%>"><img src="img/btn_learn.gif"></a></td>
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
						    	  <a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v1&pageNow=<%=a[4]-1%>"><img src="img/last.jpg"></a>
						          <% 
						       }
						    %>
							
							<font>第<%=a[4] %>页</font>
							<%
						       if(a[4]<a[3]){
						    	  
						    	  %> 
							       <a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v1&pageNow=<%=a[4]+1%>"><img src="img/next.jpg"></a>
						          <% 
						       }
						    %>
						</span>
					<!--end main_button--></div>
	
        		  
        		  <% 
        	  }else if(vselect.equals("v2")){
        		  %>
       
					<div class="main_head">
						<ul class="navil">
							<li><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v1">未学课程</a></li>
							<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v2">未学完的课程</a></li>
							<li><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v3">已学完的课程</a></li>
						</ul>
					<!--end main_head--></div>
                       
					<div class="main_middle">
						<ul class="navil">
							<li>要求：<%=a[0]%>  个</li>
							<li>已学：<%=a[1]%>  个</li>
						</ul>
					<!--end main_middle--></div>

					<div class="main_main">
						<table>
							<tr class="tr1">
								<td class="td1">课程标题</td>
								<td class="td3">最后学习时间</td>
								<td class="td3">学习进度
								<td class="td3">操作</td>
							</tr>
							<%
							  ArrayList<nowdataBean> al=(ArrayList<nowdataBean>)request.getAttribute("al");
							  for(int i=0;i<al.size();i++){
								  nowdataBean nowdata=al.get(i);
							  %>
							    <tr class="">
									<td class=""><%=nowdata.getD_key()%> </td>
									<td class="td3"><%=nowdata.getLast_time() %></td>
									<td class="td3"><font><%=nowdata.getN_time()%>%</font></td>
									<td class="btn"><a href="/OnLineStudy/usernewsServlet?select=3-2&id=<%=nowdata.getD_id() %>"><img src="img/btn_learn.gif"></a></td>
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
							<font><%=a[3]%></font>
							页
						</span>

						<span class="span3">
						    <%
						       if(a[4]>1){
						    	   
						    	  %> 
						    	  <a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v2&pageNow=<%=a[4]-1%>"><img src="img/last.jpg"></a>
						          <% 
						       }
						    %>
							
							<font>第<%=a[4]%>页</font>
							<%
						       if(a[4]<a[3]){
						    	  
						    	  %> 
							       <a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v2&pageNow=<%=a[4]+1%>"><img src="img/next.jpg"></a>
						          <% 
						       }
						    %>
						</span>
					<!--end main_button--></div>
	
        		  <% 
        	  }else if(vselect.equals("v3")){
        		  %>
				
					<div class="main_head">
						<ul class="navil">
							<li><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v1">未学课程</a></li>
							<li><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v2">未学完的课程</a></li>
							<li id="li1"><a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v3">已学完的课程</a></li>
						</ul>
					<!--end main_head--></div>
					
					<div class="main_middle">
						<ul class="navil">
							<li>要求：<%=a[0]%>  个</li>
							<li>已学：<%=a[1]%>  个</li>
						</ul>
					<!--end main_middle--></div>

					<div class="main_main">
						<table>
							<tr class="tr1">
								<td class="td1">课程标题</td>
								<td class="td3">完成学习时间</td>
								<td class="td3">是否提交心得</td>
							</tr>
							<%
							  ArrayList<hasdataBean> al=(ArrayList<hasdataBean>)request.getAttribute("al");
							   for(int i=0;i<al.size();i++){
								   hasdataBean hasdata=al.get(i);
							   %>
							    <tr class="">
									<td class=""><%=hasdata.getD_key() %></td>
									<td class="td3"><%=hasdata.getH_time() %></td>
									<td class="td3"><font><%=hasdata.getIf_know()%></font></td>
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
							<font><%=a[3]%></font>
							页
						</span>

						<span class="span3">
						    <%
						       if(a[4]>1){
						    	   
						    	  %> 
						    	  <a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v3&pageNow=<%=a[4]-1%>"><img src="img/last.jpg"></a>
						          <% 
						       }
						    %>
							
							<font>第<%=a[4]%>页</font>
							<%
						       if(a[4]<a[3]){
						    	  
						    	  %> 
							       <a href="/OnLineStudy/userFunctionServlet?select=u3&vselect=v3&pageNow=<%=a[4]+1%>"><img src="img/next.jpg"></a>
						          <% 
						       }
						    %>
						</span>
					<!--end main_button--></div>
	            
        		  
        		  <% 
        	  }
          }
        %>
         <!--end main_page--></div> 