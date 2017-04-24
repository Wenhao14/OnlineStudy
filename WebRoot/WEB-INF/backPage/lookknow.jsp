<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html>
 <head>
     <link rel=stylesheet href="css/fuction.css" type="text/css">
 </head>
 <body>
   <div class="view">
      <p ><input type=button value=返回上一页  onclick="window.history.go(-1)"> </p>
      <%
          String[] al=(String[])request.getAttribute("al");
           %>
              
           <%
      %>
		    <p style={font-size:20px;}>
		                         标题:<%=al[3] %>
		    </p>
		   <p>
		    <textarea rows="15" cols="100%" readonly="readonly"><%=al[2] %></textarea>
		   </p>
		   <form action="/OnLineStudy/principalFunction?Smenu=f9&t=1" method="post">
			   <p>
			        <input type="hidden" name="d_id" value="<%=al[0] %>">
			        <input type="hidden" name="s_id" value="<%=al[1] %>">
			       <table align="center" width="60%">
			          <tr>
			                <td><input type="radio" name="pj" value="优"/>优</td>
			                <td><input type="radio" name="pj" value="良"/>良</td>
			                <td><input type="radio" name="pj" value="中"/>中</td>
			                <td><input type="radio" name="pj" value="差"/>差</td>
			                <td> <input type="submit" value="评价"> </td>
			          </tr>
			       </table>     
			   </p>
		   </form>
		   
   </div>
    <div class="mod" >
	    <img alt="宣传图片" src="img/m1.jpg">
	    <p>
	     <img alt="宣传图片" src="img/m2.jpg">
	    </p>
	    <P>
	    <img alt="宣传图片" src="img/m3.jpg">
	    </P>
    </div>
 </body>
</html>