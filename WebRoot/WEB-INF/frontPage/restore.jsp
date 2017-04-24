<%@ page language="java"  import="java.util.*,com.ols.Bean.restoreBean"  pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <link rel=stylesheet href="css/reply.css" type="text/css">
 </head>
 <body>
          
          <%
              ArrayList<restoreBean> al=(ArrayList<restoreBean>)request.getAttribute("al");
              String[] theme=(String[])request.getAttribute("theme");
              int[] p=(int[])request.getAttribute("p");
              String pN=(String)request.getAttribute("page");
              %>
              <div class="xh">
             <center> <a href="/OnLineStudy/userFunctionServlet?select=u7&p=<%=pN %>"><font size="5">返&nbsp;&nbsp;&nbsp;&nbsp;回</font></a></center><br>
                 <font class="font1">主题：</font>
					<div class="text">
						<%=theme[1] %>
					</div>
					<hr color="red"/>
					<table>
                        <% if(al.size()>0){
                            for(int i=0;i<al.size();i++){
                            	restoreBean restore=al.get(i);
                            	%>
                            	    <tr class="tr1">
									<td class="td1"><font color="green"><%=restore.getS_name() %></font></td>
									<td class="td1"><font color="green"><%=restore.getR_time() %></font></td>
									<td class="td1"><font color="green">说:</font></td>
								</tr>
								<tr >
									<td colspan="3">
											<%=restore.getR_key() %>
									</td>
								</tr> 
                            	<%
                            }
                        }else{
                        	%>
                        	  <font  color="blue">还没有人回复</font>
                        	<%
                        }
                        %>
						
					</table>

					<div class="page">
						 <%
							  if(p[0]>1){
							     %>
							       <a class="a2" href="/OnLineStudy/userFunctionServlet?select=u7&page=<%=pN %>&t_id=<%=theme[0] %>&p=<%=p[0]-1 %>">上一页</a>
							     <%
							  }
						  %>
						       第<font><%=p[0] %></font>页
		                  <%
			                  if(p[0]<p[1]){
							     %>
							        <a class="a2" href="/OnLineStudy/userFunctionServlet?select=u7&page=<%=pN %>&t_id=<%=theme[0]  %>&p=<%=p[0]+1 %>">下一页</a>
							     <%
			                  }
						  %>
					</div>
				</div>
				<div class="right_bottom">
					<form action="/OnLineStudy/usernewsServlet?select=9&t_id=<%=theme[0] %>&page=<%=pN %>" method="post">
						<input class="input1" name="restore" type="text"/>
						<input type="submit" value="回复"/>
					</form>
                  
                  
				<!--end bottom--></div>
				
              <%
          %>
					
				
			

 </body>
</html>
