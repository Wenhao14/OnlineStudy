<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
 <head>
 </head>
 <body>
    <p ><input type=button value=返回上一页  onclick="window.history.go(-1)"> </p>
	 <form action="/OnLineStudy/usernewsServlet?select=6&id=<%=(String)request.getAttribute("id")%>" method="post">
	    <textarea rows="15" cols=80%  name="knowtext"></textarea>
	    <br/>
	    <p>
	    &nbsp;&nbsp;&nbsp;&nbsp;
	   <input type="submit" value="提交" width="80px" height="60px"/>
	   </p>
	 </form>
 </body>
</html>