package com.ols.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.servers.userLognServer;
@WebServlet("/adminLogn")
public class adminLogn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		//接收logn页面表单验证数据
		  String username=request.getParameter("username");
	      String userpwd =request.getParameter("userpwd");
	      String usertype=request.getParameter("radio");
	      String rand=(String)request.getSession().getAttribute("rand");
	      String textrand=request.getParameter("textrand");
	      if(rand.equals(textrand)){
	    	  userLognServer test=new userLognServer();
              int flag=test.userTest(username, userpwd, usertype);
	    	  if(flag==1){
		    	  //验证成功
	    		  request.getSession().setAttribute("username", username);
	    		  if(usertype.equals("admin")){
	    			  //跳转管理员界面
	    			  request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp").forward(request, response);
	    		  }else if(usertype.equals("gether")){
	    			  //跳转资料采集员界面
	    			  request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp").forward(request, response);
	    		  }else{
	    			  //跳转班级管理员界面
	    			  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp").forward(request, response);

	    		  }
		      }else if(flag==-1){
		    	  //密码错误
		    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=密码错误").forward(request, response);
		      }else if(flag==0){
		    	  //用户名不存在
		    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=用户名不存在").forward(request, response);
		      }else{
		    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=请选择用户类型").forward(request, response);
		      }
	      }else{
	    	  //验证码错误
	    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=验证码错误").forward(request, response);
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
