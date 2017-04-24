package com.ols.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.Bean.classBean;
import com.ols.Bean.userBean;
import com.ols.servers.adminIndex;
import com.ols.servers.userLognServer;

@WebServlet("/adminFunction")
public class adminFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������������
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    String username=(String) request.getSession().getAttribute("username");
	    String select=request.getParameter("Smenu");
	    String Smenu;
		adminIndex admin=new adminIndex();
	    if(select!=null){
	    	switch(select){
	    	      case"0":{
	    	    	  request.getSession().removeAttribute("username");
	    	    	  request.getSession().invalidate();
	    	      	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp").forward(request, response);
	    	    	  break;
	    	      }
		    	  case "2":{
           		      Smenu="2";
           		      String s1=request.getParameter("s1");
           		      if(s1!=null){
           		    	  if(s1.equals("1")){
           		    		  request.setAttribute("s1", "1");
           		    	  }else{
           		    		  
           		    		  request.setAttribute("s1", "2");
           		    	  }
           		      }else{
           		    	  request.setAttribute("s1", "1");
           		      }
           	  	      request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp?Smenu="+Smenu).forward(request, response);
		    		  break;
		    	  }
		    	  case "3":{
		    		  Smenu="3";
		    		  ArrayList<classBean> al=admin.selAllClass();
		    		  request.setAttribute("al", al);
		    	  	  request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp?Smenu="+Smenu).forward(request, response);
		    		  break;
		    	  }
		    	  case "f1":{
		    		  //�޸�����
		    		     String oldpwd= request.getParameter("oldpwd");
			    		 String newpwd=request.getParameter("newpwd"); 
			    		 String newpwd1=request.getParameter("newpwd1");
			    		 if(newpwd.equals(newpwd1)){
			    			 if(newpwd.equals("")){
						      	out.print("<script>alert('������������');history.back(-1);</script>");  
			    			 }else{
			    				 userLognServer userlogn=new userLognServer();
						          int result=userlogn.userTest(username, oldpwd, "admin");
						          if(result==1){
						        	  if(userlogn.updataPwd(username, newpwd, "admin")){
						  	      	    out.print("<script>alert('�����޸ĳɹ�');history.back(-1);</script>"); 
						        	  }else{
						  	      	    out.print("<script>alert('�����޸�ʧ��');history.back(-1);</script>"); 
						        	  }
						          }else{
						      	    out.print("<script>alert('ԭ�������');history.back(-1);</script>"); 
						          }
			    			 }
			    		 }else{
					      	    out.print("<script>alert('�������벻��ͬ');history.back(-1);</script>"); 
			    		 }
		    		 break;
		    	  }
		    	  case "f2":{
		    		  //��������
		    		  String user=request.getParameter("user");
		    		  String usertype=request.getParameter("usertype");
		    		  if(user.equals("")){
			    		  adminIndex reset=new adminIndex();
			    		  if(reset.resetPwd(user, usertype)){
				  	      	    out.print("<script>alert('����������Ϊ123456');history.back(-1);</script>"); 
				        	  }else{
				  	      	    out.print("<script>alert('����ʧ��');history.back(-1);</script>"); 
				        	  }
		    		  }else{
			  	      	    out.print("<script>alert('�������û���');history.back(-1);</script>"); 
		    		  }
		    		  break;
		    	  }
		    	  case "f3":{
		    		  //���ӹ���Ա���ɼ�Ա�Ͱ༶����Ա
		    		  String type=request.getParameter("type");
		    		  if(type.equals("admin")){
		    			 String userN=request.getParameter("userN");
		    			 if(!userN.equals("")){
		    				 if(admin.checkUser(userN, type)){
		    					 if(admin.addAdmin(userN)){
						  	      	    out.print("<script>alert('���ӳɹ�  ��ʼ����Ϊ123456');history.back(-1);</script>"); 
						        	  }else{
						  	      	    out.print("<script>alert('����ʧ��');history.back(-1);</script>"); 
						        	  }
		    				 }else{
		    					 out.print("<script>alert('�û����Ѵ���');history.back(-1);</script>"); 
		    				 }
				    		  
			    		  }else{
				  	      	    out.print("<script>alert('�������û���');history.back(-1);</script>"); 
			    		  }
		    		  }else{
		    			  //�ɼ�Ա���༶����Ա
		    			  String userN=request.getParameter("userN");
		    			  String name=request.getParameter("name");
		    			  String dept=request.getParameter("dept");
		    			  if(!userN.equals("")&&!name.equals("")&&!dept.equals("")){
				    		  if(admin.checkUser(userN, type)){
				    			  if(admin.addGP(userN, name, dept, type)){
						  	      	    out.print("<script>alert('���ӳɹ�  ��ʼ����Ϊ123456');history.back(-1);</script>"); 
						        	  }else{
						  	      	    out.print("<script>alert('����ʧ��');history.back(-1);</script>"); 
						        	  }
				    		  }else{
				    			  out.print("<script>alert('�û����Ѵ���');history.back(-1);</script>"); 
				    		  }		   				  
			    		  }else{
				  	      	    out.print("<script>alert('������������Ϣ');history.back(-1);</script>"); 
			    		  }
		    		  }
		    		  break;
		    	  }
		    	  case "f4":{
		    		  //ɾ������Ա���ɼ�Ա���༶����Ա
		    		  String type=request.getParameter("t");
		    		  String user=request.getParameter("u");
		    		  if(type.equals("admin")){
		    			  int result=admin.delAdmin(user);
		    			  if(result==1){
		    				  ArrayList<String[]> al=admin.selAG("admin");
	    				      request.setAttribute("al", al);
	    				      request.setAttribute("s1", "1");
	    				      request.setAttribute("s2", "2");
	    				      request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp?Smenu=1").forward(request, response);
				          }else if(result==0){
				  	      	 out.print("<script>alert('�Լ�����ɾ���Լ�');history.back(-1);</script>"); 
				          }else{
					  	     out.print("<script>alert('ɾ��ʧ��');history.back(-1);</script>");   
				          }
		    		  }else{
		    			  if(admin.delUser(user, type)){
				  	      	 if(type.equals("gether")){
				  	      		ArrayList<String[]> al=admin.selAG("gether");
	    				    	request.setAttribute("al", al);
				  	      		request.setAttribute("s1", "3");
				  	      	 }else{
				  	      		 int pageNow=1;
	    				    	 int pageCount=admin.selPrinPage();
	    				    	 ArrayList<String[]> al=admin.selPrin(pageNow);
	    				    	 int page[]={pageNow,pageCount};
	    				    	 request.setAttribute("page", page);
	    				    	 request.setAttribute("al", al);
				  	      		 request.setAttribute("s1", "2");
				  	      	 }
	    				    request.setAttribute("s2", "2");
	    				    request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp?Smenu=1").forward(request, response);
				          }else{
				  	      	  out.print("<script>alert('ɾ��ʧ��');history.back(-1);</script>"); 
				          }
		    		  }
		    		  break;
		    	  }
		    	  case "f5":{
	                   //�鿴ѧϰ���
		    		  String s_id =request.getParameter("s_id");
		    		  adminIndex f=new adminIndex();
		    		  if(s_id==null){
		    			  String s_user=request.getParameter("s_user");
		    			  if(s_user==null){
		    				  String c_id=request.getParameter("c_id");
			    			  int pageNow=1;
			    			  if(request.getParameter("p")!=null){
			    				  pageNow=Integer.parseInt(request.getParameter("p"));
			    			  }
			    			  int pageCount=f.selAllSPage(c_id);
				    		  ArrayList<userBean> al=f.selAllstudent(c_id, pageNow);
				    		  int[] p={pageNow,pageCount};
		    				  request.setAttribute("p", p);
		    				  request.setAttribute("c_id",c_id);
				    		  request.setAttribute("al", al);
				    		  request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp?Smenu=3").forward(request, response);
		    			  }else{
		    				  String [] al=f.selSNews(s_user);
		    				  if(al!=null){
		    					  request.setAttribute("al", al);
				    			  request.getRequestDispatcher("/WEB-INF/backPage/studentnews.jsp").forward(request, response);
		    				  }else{
		    					  out.print("<script>alert('���޴�ѧԱ');history.back(-1);</script>"); 
		    				  }
		    			  }
		    			  
		    		  }else{
		    			  String [] al=f.selUStudyNews(s_id);
		    			  request.setAttribute("al", al);
		    			  request.getRequestDispatcher("/WEB-INF/backPage/studentnews.jsp").forward(request, response);
		    		  }
		    		  break;
		    	  }
		    	  default:{
		    		  Smenu="1";
		    		  String s1=request.getParameter("s1");
		    		  String s2=request.getParameter("s2");
		    		  if(s1!=null){
		    			  if(s1.equals("1")){
			    			  request.setAttribute("s1", "1");
			    			  
			    		  }else if(s1.equals("2")){
			    			  request.setAttribute("s1", "2");

			    		  }else{
			    			  request.setAttribute("s1", "3");

			    		  }
		    		  }else{
		    			  if(admin.SelAdminID(username)){
		    				  request.setAttribute("s1", "1");
		    			  }else{
		    				  request.setAttribute("s1", "2");
		    			  }
		    			  
		    		  }
		    		  if(s2!=null){
		    			  if(s2.equals("1")){
		    				  request.setAttribute("s2", "1");
		    			  }else{
		    				  switch(s1){
		    				     case "1":{
		    				    	ArrayList<String[]> al=admin.selAG("admin");
		    				    	request.setAttribute("al", al); 
		    				    	break;
		    				     }
		    				     case  "2":{
		    				    	 int pageNow=1;
		    				    	 int pageCount=admin.selPrinPage();
		    				    	 if(request.getParameter("p")!=null){
		    				    		 pageNow=Integer.parseInt(request.getParameter("p"));
		    				    	 }
		    				    	 ArrayList<String[]> al=admin.selPrin(pageNow);
		    				    	 int page[]={pageNow,pageCount};
		    				    	 request.setAttribute("page", page);
		    				    	 request.setAttribute("al", al);
		    				    	 break;
		    				     }
		    				     case "3":{
		    				    	 ArrayList<String[]> al=admin.selAG("gether");
		    				    	 request.setAttribute("al", al);
		    				    	 break;
		    				     }
		    				  }	
		    				
		    				  request.setAttribute("s2", "2");
		    			  }
		    		  }else{
		    			  request.setAttribute("s2", "1");
		    		  }	  
		    	  	  request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp?Smenu="+Smenu).forward(request, response);
	    	  }
	    	}
	    }else{
		   Smenu="1";
	  	   request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp?Smenu="+Smenu).forward(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
