<%@ page language="java"  import="java.util.*,com.ols.Bean.*"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
 <head>
 </head>
 <body >
     <div >
      <p ><input type=button value=返回上一页  onclick="window.history.go(-1)"></p>
	 <%
	     String se=(String)request.getAttribute("se"); 
	     ArrayList al=(ArrayList)request.getAttribute("question");
	     paperBean  paper=(paperBean)request.getAttribute("paper");
		 if(se!=null){
			 if(se.equals("1")){
		    	 %>
		    	    <center><p><b><h3><%=paper.getP_key() %></h3></b></p></center>
				      <form action="/OnLineStudy/usernewsServlet?select=7&id=<%=paper.getP_no() %>" method="post" onsubmit="getEIementByid('sub').disabled=true;return true">
				       <%
				            for(int i=0;i<al.size();i++){
				            	questionBean ques=(questionBean)al.get(i);
				            	%>
				            	  <p>
						            <b><%=i+1%>.<%=ques.getQ_question() %>></b>
						          </p>
						          <table>
							          <tr>
							            <td><input TYPE="radio" name="<%=i %>"  value="A" >A.<%=ques.getQ_a() %></td>
							          </tr>
							          <tr>
							             <td><input TYPE="radio" name="<%=i %>"  value="B" >B.<%=ques.getQ_b() %></td>
							          </tr>
							           <tr>
							             <td><input TYPE="radio" name="<%=i %>"  value="C" >C.<%=ques.getQ_c() %></td>
							          </tr>
							           <tr>
							             <td> <input TYPE="radio" name="<%=i %>"  value="D" >D.<%=ques.getQ_d() %></td>
							          </tr>
						          </table>
				            	<%
				            }
				        %>
				         <p><center><input type="submit" id="sub" name="test" value="提交"/></center></p>
				      </form>
		    	 <% 
		     }else{
		    	%>
			    	 <center><p><b><h3><%=paper.getP_key() %>答案</h3></b></p></center>
				       <%
				            for(int i=0;i<al.size();i++){
				            	questionBean ques=(questionBean)al.get(i);
				            	%>
				            	  <p>
						            <b><%=i+1%>.<%=ques.getQ_question() %></b>
						          </p>
						          <%
						            if(ques.getQ_result().equalsIgnoreCase("A")){
						            	%>
						            	   <table>
									          <tr>
									            <td><input TYPE="radio" name="<%=i %>"  value="A" checked >A.<%=ques.getQ_a() %></td>
									          </tr>
									          <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="B" >B.<%=ques.getQ_b() %></td>
									          </tr>
									           <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="C" >C.<%=ques.getQ_c() %></td>
									          </tr>
									           <tr>
									             <td> <input TYPE="radio" name="<%=i %>"  value="D" >D.<%=ques.getQ_d() %></td>
									          </tr>
								          </table>
						            	<% 
						            	
						            }else if(ques.getQ_result().equalsIgnoreCase("B")){
						            	%>
						            	   <table>
									          <tr>
									            <td><input TYPE="radio" name="<%=i %>"  value="A" >A.<%=ques.getQ_a() %></td>
									          </tr>
									          <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="B" checked >B.<%=ques.getQ_b() %></td>
									          </tr>
									           <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="C" >C.<%=ques.getQ_c() %></td>
									          </tr>
									           <tr>
									             <td> <input TYPE="radio" name="<%=i %>"  value="D" >D.<%=ques.getQ_d() %></td>
									          </tr>
								          </table>
						            	<% 
						            }else if(ques.getQ_result().equalsIgnoreCase("C")){
						            	%>
						            	   <table>
									          <tr>
									            <td><input TYPE="radio" name="<%=i %>"  value="A" >A.<%=ques.getQ_a() %></td>
									          </tr>
									          <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="B" >B.<%=ques.getQ_b() %></td>
									          </tr>
									           <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="C" checked >C.<%=ques.getQ_c() %></td>
									          </tr>
									           <tr>
									             <td> <input TYPE="radio" name="<%=i %>"  value="D" >D.<%=ques.getQ_d() %></td>
									          </tr>
								          </table>
						            	<% 
						            }else{
						            	%>
						            	   <table>
									          <tr>
									            <td><input TYPE="radio" name="<%=i %>"  value="A" >A.<%=ques.getQ_a() %></td>
									          </tr>
									          <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="B" >B.<%=ques.getQ_b() %></td>
									          </tr>
									           <tr>
									             <td><input TYPE="radio" name="<%=i %>"  value="C" >C.<%=ques.getQ_c() %></td>
									          </tr>
									           <tr>
									             <td> <input TYPE="radio" name="<%=i %>"  value="D" checked >D.<%=ques.getQ_d() %></td>
									          </tr>
								          </table>
						            	<% 
						            }
						          %>
						          
				            	<%
				            }
				        %>
			    <%
		     }
		 }
	     
	 %>
      
      </div>
 </body>
</html>