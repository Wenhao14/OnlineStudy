package com.ols.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.Bean.dataBean;
import com.ols.Bean.questionBean;
import com.ols.servers.getherIndex;
import com.ols.servers.userLognServer;

@WebServlet("/getherFunction")
public class getherFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    String username=(String) request.getSession().getAttribute("username");
	    String select=request.getParameter("Smenu");
	    String Smenu;
	    if(select!=null){
	    	switch(select){
		    	  case "2":{
           		      Smenu="2";
           	  	      request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp?Smenu="+Smenu).forward(request, response);
		    		  break;
		    	  }
		    	  case "3":{
		    		  Smenu="3";
		    	  	  request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp?Smenu="+Smenu).forward(request, response);
		    		  break;
		    	  }
		    	  case "4":{
		    		  Smenu="4";
		    	  	  request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp?Smenu="+Smenu).forward(request, response);
		    		  break;
		    	  }
		    	  case "f1":{
		    		  //修改密码
		    		 String oldpwd= request.getParameter("oldpwd");
		    		 String newpwd=request.getParameter("newpwd"); 
		    		 String newpwd1=request.getParameter("newpwd1");
		    		 System.out.println(username +"  "+oldpwd);
		    		 if(newpwd.equals(newpwd1)){
		    			 if(newpwd.equals("")){
					      	out.print("<script>alert('请输入新密码');history.back(-1);</script>");  
		    			 }else{
		    				 userLognServer userlogn=new userLognServer();
					          int result=userlogn.userTest(username, oldpwd, "gether");
					          if(result==1){
					        	  if(userlogn.updataPwd(username, newpwd, "gether")){
					  	      	    out.print("<script>alert('密码修改成功');history.back(-1);</script>"); 
					        	  }else{
					  	      	    out.print("<script>alert('密码修改失败');history.back(-1);</script>"); 
					        	  }
					          }else{
					      	    out.print("<script>alert('原密码错误');history.back(-1);</script>"); 
					          }
		    			 }
		    		 }else{
				      	    out.print("<script>alert('两次密码不相同');history.back(-1);</script>"); 
		    		 }
		    		  break;
		    	  }
		    	  case "f2":{
		    		  //更新新闻
		    		  String title=request.getParameter("title");
		    		  String conn=request.getParameter("conn");
		    		  if(!title.equals("")&&!conn.equals("")){
		    			  getherIndex gether=new getherIndex();
		    			  if(gether.addNews(title, conn)){
					      	 out.print("<script>alert('添加成功，继续添加');history.back(-1);</script>"); 
		    			  }else{
					      	 out.print("<script>alert('添加失败');history.back(-1);</script>"); 
		    			  }
		    		  }else{
				      	 out.print("<script>alert('请输入合适内容');history.back(-1);</script>"); 
		    		  }
		    		  break;
		    	  }
		    	  case "f3":{
		    		  //删除资料
	    			  getherIndex gether=new getherIndex();
	    			  String id=request.getParameter("id");
                      if(gether.delData(id)){
	                    	 int pageNow=1;
	 				    	 int pageCount=gether.LookDataPage();
	 				    	 ArrayList<dataBean> al=gether.LookData(pageNow);
	 				    	 int page[]={pageNow,pageCount};
	 				    	 request.setAttribute("page", page);
	 				    	 request.setAttribute("al", al);
				    		 request.setAttribute("s1", "2");
				    		 request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp?Smenu=1").forward(request, response);
		    			  }else{
					      	 out.print("<script>alert('删除失败');history.back(-1);</script>"); 
		    			  }
		    		  break;
		    	  }
		    	  case "f4":{
		    		  //上传小测试题
		    		  String id=request.getParameter("id");
		    		  getherIndex gether=new getherIndex();
		    			  if(id==null){
		    				  String p_key=request.getParameter("p_key");
		    				  if(gether.checkPname(p_key)){
		    					  int p_id=gether.addPaper(p_key);
			    				  if(p_id==-1){
			    					  out.print("<script>alert('添加失败');history.back(-1);</script>"); 
			    				  }else{
			    				     request.setAttribute("p_id", String.valueOf(p_id));
						    		 request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp?Smenu=4").forward(request, response);
			    				  }
		    				  }else{
		    					  out.print("<script>alert('该试卷名已存在');history.back(-1);</script>"); 
		    				  }
		    				  
		    			  }else{
		    				  questionBean q=new questionBean();
		    				  q.setQ_question(request.getParameter("q"));
		    				  q.setQ_a(request.getParameter("a"));
		    				  q.setQ_b(request.getParameter("b"));
		    				  q.setQ_c(request.getParameter("c"));
		    				  q.setQ_d(request.getParameter("d"));
		    				  q.setQ_result(request.getParameter("r"));
		    				  if(gether.addQuestion(q,id)){
		    					  out.print("<script>alert('添加成功，请继续');history.back(-1);</script>"); 
		    				  }else{
		    					  out.print("<script>alert('试题添加失败');history.back(-1);</script>"); 
		    				  }
		    				  
		    			  }
		    		  break;
		    	  }
		    	  default:{
		    		  Smenu="1";
		    		  String s1=request.getParameter("s1");
		    		  if(s1!=null){
		    			  if(s1.equals("1")){
			    			  request.setAttribute("s1", "1");
			    			  
			    		  }else{
			    			 getherIndex gether=new getherIndex();
			    			 int pageNow=1;
    				    	 int pageCount=gether.LookDataPage();
    				    	 if(request.getParameter("p")!=null){
    				    		 pageNow=Integer.parseInt(request.getParameter("p"));
    				    	 }
    				    	 ArrayList<dataBean> al=gether.LookData(pageNow);
    				    	 int page[]={pageNow,pageCount};
    				    	 request.setAttribute("page", page);
    				    	 request.setAttribute("al", al);
			    			 request.setAttribute("s1", "2");

			    		  }
		    		  }else{
		    			  request.setAttribute("s1", "1");
		    		  }
		    	  	 request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp?Smenu="+Smenu).forward(request, response);
	    	  }
	    	}
	    }else{
		   Smenu="1";
		   request.setAttribute("s1", "1");
	  	   request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp?Smenu="+Smenu).forward(request, response);
	    }
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
