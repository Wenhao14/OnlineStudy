<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
 <head>
 <link href="css/news.css" type="text/css" rel="stylesheet"/>
 </head>
 <body>
 <div class="main">
 
 <%
     String [] al=(String[])request.getAttribute("al");
     %>
       <p ><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=button value=返回查看  onclick="window.history.go(-1)"></p>
         <table class="tab1">
	       <caption  class="text">学员基本信息</caption>
	       <tr>
	          <td>姓名</td><td><%=al[0] %></td>
	          <td>性别</td><td><%=al[1] %></td>
	       </tr>
	       <tr>
	          <td>部门</td><td><%=al[2] %></td>
	          <td>班级</td><td><%=al[4] %></td>
	       </tr>
	       <tr>
	          <td>手机号</td><td><%=al[3] %></td>
	          <td>论坛积分</td><td><%=al[5] %></td>
	       </tr>
	       <tr>
	          <td>负责人</td><td><%=al[6] %></td>
	          <td>负责人部门</td><td><%=al[7] %></td>
	       </tr>
	   </table>
	   <hr color="blue">
	   <table class="tab2">
	       <caption class="text">学习情况</caption>
	       <tr>
	          <td>学习要求</td><td><%=al[8] %></td>
	          <td>已经完成</td><td><%=al[9] %></td>
	       </tr>
	       <tr>
	          <td>作业要求</td><td><%=al[9] %></td>
	          <td>已经完成</td><td><%=al[10] %></td>
	       </tr>
	       <tr>
	          <td>测试试题</td><td><%=al[11] %></td>
	          <td>已经完成</td><td><%=al[12] %></td>
	       </tr>
	   </table>
     <%
 %>
  </div>
 </body>
</html>