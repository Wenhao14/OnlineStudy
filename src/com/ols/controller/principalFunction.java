package com.ols.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.Bean.classBean;
import com.ols.Bean.userBean;
import com.ols.servers.adminIndex;
import com.ols.servers.principalIndex;
import com.ols.servers.userLognServer;

@WebServlet("/principalFunction")
public class principalFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
           		  	  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu="+Smenu).forward(request, response);
		    		  break;
		    	  }
		    	  case "3":{
		    		  //为班级选择学习资料
		    		  Smenu="3";
		    		  String classID=request.getParameter("classID");
					  if(classID==null){
						  principalIndex prin=new principalIndex();
						  ArrayList<classBean> al=prin.selClass(username);
						  request.setAttribute("al", al);
					  }else{
						  principalIndex prin=new principalIndex();
						  int pageNow=1;
						  if(request.getParameter("p")!=null){
    						  pageNow=Integer.parseInt(request.getParameter("p"));
    					  }
						  int pageCount=prin.seldataPage(classID);
						  int[] p={pageNow,pageCount};
						  ArrayList<String[]> data=prin.selData(classID,pageNow);
						  request.setAttribute("p", p);
						  request.setAttribute("data", data);
						  request.setAttribute("classID", classID);
					  }
		    		  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu="+Smenu).forward(request, response);
		    		  break;
		    	  }
		    	  case "f1":{
		    		 //修改密码
		    		     String oldpwd= request.getParameter("oldpwd");
			    		 String newpwd=request.getParameter("newpwd"); 
			    		 String newpwd1=request.getParameter("newpwd1");
			    		 if(newpwd.equals(newpwd1)){
			    			 if(newpwd.equals("")){
						      	out.print("<script>alert('请输入新密码');history.back(-1);</script>");  
			    			 }else{
			    				 userLognServer userlogn=new userLognServer();
						          int result=userlogn.userTest(username, oldpwd, "principal");
						          if(result==1){
						        	  if(userlogn.updataPwd(username, newpwd, "principal")){
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
		    		  //重置学生密码
		    		  adminIndex f=new adminIndex();
		    		  String user=request.getParameter("user");
		    		  if(!user.equals("")){
		    			  if(f.resetPwd(user, "user")){
					      	 out.print("<script>alert('重置密码为 123456');history.back(-1);</script>"); 
		    			  }else{
					      	 out.print("<script>alert('重置失败');history.back(-1);</script>"); 
		    			  }
		    		  }else{
				      	 out.print("<script>alert('请输入用户名');history.back(-1);</script>"); 
		    		  }
		    		  break;
		    	  }
		    	  case "f3":{
		    		  //发布公告
		    		  String selClass=request.getParameter("selClass");
		    		  String text=request.getParameter("text");
		    		  if(!selClass.equals("")&&!text.equals("")){
		    			  principalIndex prin=new principalIndex();
		    			  if(prin.updataNotice(selClass,text)){
		    				  out.print("<script>alert('发布成功');history.back(-1);</script>");
		    			  }else{
		    				  out.print("<script>alert('发布失败');history.back(-1);</script>");
		    			  }
		    		  }else{
		    			  out.print("<script>alert('未选择班级或公告为空');history.back(-1);</script>");
		    		  }
		    		  break;
		    	  }
		    	  case "f4":{
		    		  //创建班级
		    		  String clName=request.getParameter("clName");
		    		  if(!clName.equals("")){
		    			  String notice="请各学员尽快完善自己的个人信息";
		    			  Date date=new Date();
		    			  DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		    			  String nowdate=format.format(date);
		    			  String[] paras={clName,nowdate,username,notice};
		    			  principalIndex prin=new principalIndex();
		    			  if(prin.addClass(paras)){
		    				  out.print("<script>alert('班级创建成功，请添加学员');history.back(-1);</script>");
		    			  }else{
		    				  out.print("<script>alert('班级创建失败');history.back(-1);</script>");
		    			  }
		    		  }else{
		    			  out.print("<script>alert('请输入要创建的班级名');history.back(-1);</script>");
		    		  }
		    		  break;
		    	  }
		    	  case "f5":{
		    		  //删除班级
		    		  String id=request.getParameter("id");
		    		  principalIndex prin=new principalIndex();
		    		  if(prin.delClass(id)){
		    			  ArrayList<classBean> al=prin.selClass(username);
	    				  request.setAttribute("al", al);
	    				  request.setAttribute("s1", "1");
	    				  request.setAttribute("s2", "2");
	    				  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu=1").forward(request, response);
		    		  }else{
		    			  out.print("<script>alert('班级删除失败');history.back(-1);</script>");
		    		  }
		    		  break;
		    	  }
		    	  case "f6":{
		    		  //删除学生
		    		  String id=request.getParameter("id");
		    		  principalIndex prin=new principalIndex();
		    		  if(prin.delStu(id)){
		    			  out.print("<script>alert('该学生已删除');history.go(-2);</script>");
		    		  }else{
		    			  out.print("<script>alert('删除失败');history.back(-1);</script>");
		    		  }
		    		  break;
		    	  }
		    	  case "f7":{
		    		  //添加学员
		    		  String classID=request.getParameter("classID");
		    		  String Suser=request.getParameter("Suser");
		    		  if(!Suser.equals("")){
		    			      adminIndex check=new adminIndex();
		    				 if(check.checkUser(Suser, "user")){
		    					 principalIndex prin=new principalIndex();
		                         if(prin.addStudent(Suser,classID)){
		                       	  out.print("<script>alert('学员添加成功 初始密码为123456');history.back(-1);</script>");
		                         }else{
		                       	  out.print("<script>alert('学员添加失败');history.back(-1);</script>");
		                         }
		    				 }else{
		    					 out.print("<script>alert('用户名已存在');history.back(-1);</script>"); 
		    				 }
				    		  
			    		  }else{
				  	      	    out.print("<script>alert('请输入用户名');history.back(-1);</script>"); 
			    		  }
		    		  break;
		    	  }
		    	  case "f8":{
		    		  //添加资料
		    		  String classID=request.getParameter("classID");
		    		  String[] dataID=request.getParameterValues("datas");
		    		  principalIndex prin=new principalIndex();
		    		  try {
							for(int i=0;i<dataID.length;i++){
								  prin.classAddData(dataID[i],classID);
							  }
							  int pageNow=1;
							  int pageCount=prin.seldataPage(classID);
							  int[] p={pageNow,pageCount};
							  ArrayList<String[]> data=prin.selData(classID,pageNow);
							  request.setAttribute("p", p);
							  request.setAttribute("data", data);
							  request.setAttribute("classID", classID);
			    		      request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu=3").forward(request, response);
					    }catch (Exception e) {
						// TODO Auto-generated catch block
						   out.print("<script>alert('添加失败');history.back(-1);</script>");
					    }
                    break;
		    	  }
		    	  case "f9":{
                      //评阅学员心得
		    		  String t=request.getParameter("t");
		    		  principalIndex prin=new principalIndex();
		    		  if(t==null){
		    			  String s_id=request.getParameter("s_id");
			    		  String d_id=request.getParameter("d_id");
			    		  String[] al=prin.LookKnow(d_id, s_id);
			    		  request.setAttribute("al", al);
			    		  request.getRequestDispatcher("/WEB-INF/backPage/lookknow.jsp").forward(request, response);
		    		  }else{
		    			  String s_id=request.getParameter("s_id");
			    		  String d_id=request.getParameter("d_id");
			    		  String assess=request.getParameter("pj");
			    		  if(prin.SaveAssess(d_id, s_id, assess)){
			    			  int pageNow=1;
	    					  int pageCount=prin.selKnowPage(username);
		    				  ArrayList<String[]> al=prin.selKnow(username, pageNow);
		    				  int[] p={pageNow,pageCount};
		    				  request.setAttribute("p", p);
		    				  request.setAttribute("al", al);
		    				  request.setAttribute("s1", "3");
		    				  request.setAttribute("s2", "2");
		    				  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu=1").forward(request, response);
			    		  }else{
			    			  out.print("<script>alert('评价失败');history.back(-1);</script>");
			    		  }
		    		  }
		    		 
		    	  }
		    	  case "f10":{
		    		  //查看学生学习情况
		    		  String s_id =request.getParameter("s_id");
		    		  if(s_id==null){
		    			  adminIndex f=new adminIndex();
		    			  String c_id=request.getParameter("classID");
		    			  int pageNow=1;
		    			  if(request.getParameter("p")!=null){
		    				  pageNow=Integer.parseInt(request.getParameter("p"));
		    			  }
		    			  int pageCount=f.selAllSPage(c_id);
			    		  ArrayList<userBean> al=f.selAllstudent(c_id, pageNow);
			    		  int[] p={pageNow,pageCount};
	    				  request.setAttribute("p", p);
	    				  request.setAttribute("classID",c_id);
			    		  request.setAttribute("al", al);
			    		  request.setAttribute("s1", "3");
	    				  request.setAttribute("s2", "1");
			    		  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu=1").forward(request, response);
		    		  }else{
		    			  adminIndex f=new adminIndex();
		    			  String[] al=f.selUStudyNews(s_id);
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
		    			  }else if(s1.equals("3")){
		    				//传递管理的班级有哪些
				    		 principalIndex prin=new principalIndex();
		    				 ArrayList<classBean> al=prin.selClass(username);
		    				 request.setAttribute("al", al);
		    				 request.setAttribute("s1", "3");
		    			  }else{
		    				 //传递管理的班级有哪些
				    		 principalIndex prin=new principalIndex();
		    				 ArrayList<classBean> al=prin.selClass(username);
		    				 request.setAttribute("al", al);
				    		 request.setAttribute("s1", "4");
		    			  }
		    		  }else{
			    	     request.setAttribute("s1", "1");
		    		  }
		    		  if(s2!=null){
		    			  if(s2.equals("1")){
		    				  if(s1.equals("2")){
		    					  //接收班级
		    					  String classID=request.getParameter("classID");
		    					  if(classID==null){
		    						  principalIndex prin=new principalIndex();
		    						  ArrayList<classBean> al=prin.selClass(username);
		    						  request.setAttribute("al", al);
		    					  }else{
		    						  request.setAttribute("classID", classID);
		    					  }
		    				  }
		    				  request.setAttribute("s2", "1");
		    			  }else{
		    				  if(s1.equals("1")){
		    					  //提出该班级管理员管理的所有的班级
		    					  principalIndex prin=new principalIndex();
			    				  ArrayList<classBean> al=prin.selClass(username);
			    				  request.setAttribute("al", al);
		    				  }
		    				  if(s1.equals("3")){
		    					  //提出未评阅的心得
		    					  int pageNow=1;
		    					  if(request.getParameter("p")!=null){
		    						  pageNow=Integer.parseInt(request.getParameter("p"));
		    					  }
		    					  principalIndex prin=new principalIndex();
		    					  int pageCount=prin.selKnowPage(username);
			    				  ArrayList<String[]> al=prin.selKnow(username, pageNow);
			    				  int[] p={pageNow,pageCount};
			    				  request.setAttribute("p", p);
			    				  request.setAttribute("al", al);
		    				  }
		    				  if(s1.equals("2")){
		    					  //删除学员
		    					  String delstu=request.getParameter("delstu");
		    					  if(delstu!=null){
		    						  principalIndex prin=new principalIndex();
		    						  String[] al=prin.selStudent(delstu);
		    						  if(al==null){
		    							  request.setAttribute("message","未找到该学员");
		    						  }else{
		    							  request.setAttribute("student", al);
		    						  }
		    					  }
		    				  }
		    				  request.setAttribute("s2", "2");
		    			  }
		    		  }else{
		    			  if(s1!=null){
			    			  if(s1.equals("2")){
		    					  //接收班级
		    					  String classID=request.getParameter("classID");
		    					  if(classID==null){
		    						  principalIndex prin=new principalIndex();
		    						  ArrayList<classBean> al=prin.selClass(username);
		    						  request.setAttribute("al", al);
		    					  }else{
		    						  request.setAttribute("classID", classID);
		    					  }
		    				  }
		    			  }
		    			  request.setAttribute("s2", "1");
		    		  }
		    		  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu="+Smenu).forward(request, response);  
	    	      }
	    	}
	    }else{
		   Smenu="1";
		   request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp?Smenu="+Smenu).forward(request, response);

		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
