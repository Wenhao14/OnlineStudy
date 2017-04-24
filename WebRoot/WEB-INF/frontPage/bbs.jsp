<%@ page language="java"  import="java.util.*"  pageEncoding="utf-8"%>
<%
    String flag=(String)request.getAttribute("flag");
    if(flag==null){
    	%>
    	   <%@ include file="theme.jsp" %> 
    	<%
    }else{
    	%>
	 	   <%@ include file="restore.jsp" %> 
	 	<%
    }
%>