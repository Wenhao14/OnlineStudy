<%@ page language="java"  import="java.util.*,com.ols.Bean.themeBean"  pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
 <head>
  <link rel=stylesheet href="css/luntan.css" type="text/css">
 </head>
 <body>
   <%
        ArrayList<themeBean> al=(ArrayList<themeBean>)request.getAttribute("al");
        int[] p=(int[])request.getAttribute("p");
        %>
            	<div class="right_head">
					<img src="img/indexxyy.jpg"/>
				<!--end right head--></div>

				<div class="right_main">
					<hr/>
					<table>
						<tr class="tr1">
							<td class="td1"><img src="img/qiqiu.jpg"/>标题</td>
							<td><img src="img/letter.png"/>回复</td>
							<td><img src="img/smile.png"/>发表人</td>
							<td><img src="img/bell.png"/>发表时间</td>
						<tr>
                       <%
                         if(al.size()>0){
                        	 for(int i=0;i<al.size();i++){
                          	   themeBean theme=al.get(i);
                          	   String key=theme.getT_theme();
                          	   if(key.length()>30)
                          		   key=key.substring(0, 29)+"......";
                          	   %>
                          	      <tr>
  									<td><%=key %></td>
  									<td class="td2"><a class="a1" href="/OnLineStudy/userFunctionServlet?select=u7&page=<%=p[0] %>&t_id=<%=theme.getT_id() %>"><font color="green">[回复]</font></a></td>
  									<td class="td2"><%=theme.getS_name() %></td>
  									<td class="td2"><%=theme.getT_time() %></td>
  								 </tr>
                          	   <%
                             }
                         }else{
                        	 %>
                        	     <font  color="blue">还没有人发表主题</font>
                        	 <%
                         }
                          
                       %>
						
					</table>
                
				<!--end right_main--></div>
				<p class="next">
				  <%
					  if(p[0]>1){
					     %>
					       <a class="a2" href="/OnLineStudy/userFunctionServlet?select=u7&p=<%=p[0]-1 %>">上一页</a>
					     <%
					  }
				  %>
				       第<font><%=p[0] %></font>页
                  <%
	                  if(p[0]<p[1]){
					     %>
					        <a class="a2" href="/OnLineStudy/userFunctionServlet?select=u7&p=<%=p[0]+1 %>">下一页</a>
					     <%
	                  }
				  %>
                </p>
                 <br/>
				<div class="right_bottom">
					<form action="/OnLineStudy/usernewsServlet?select=8" method="post">
						<input class="input1" name="theme" type="text"/>
						<input type="submit" value="发表"/>
					</form>
				<!--end bottom--></div>
        <%
   %>

			
 </body>
</html>
