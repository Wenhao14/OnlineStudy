package com.ols.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.servers.userIndexServer;
import com.ols.servers.userLognServer;

@WebServlet("/userlognServlet")
//本servlet提供用户登录验证
public class userlognServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //接收登录表单数据
        String username=request.getParameter("username");
        String userpwd =request.getParameter("userpwd");
        String usertype=request.getParameter("usertype");
        //返回验证失败结果
        String message="";
        userLognServer userlogn=new userLognServer();
        int result=userlogn.userTest(username, userpwd, usertype);
        if(result==1){
        	//验证成功
        	//将用户名放入Session 中保存
        	request.getSession().setAttribute("username", username);
        	//声明功能类的对象
        	userIndexServer userdata=new userIndexServer();
        	//提取班级公告
        	String notice=userdata.noticeDate(username);
        	//发送班级公告
  		    request.setAttribute("notice", notice);
            request.getRequestDispatcher("/WEB-INF/frontPage/mainpage.jsp").forward(request, response);
        }else if(result==-1){
        	//密码错误
        	message="密码错误";
        	request.getRequestDispatcher("indexServlet?message="+message).forward(request, response);
        }else if(result==0){
        	//用户名不存在
            message="用户名不存在";
        	request.getRequestDispatcher("indexServlet?message="+message).forward(request, response);
        }else if(result==-2){
        	//验证出错
        	message="验证出错";
        	request.getRequestDispatcher("indexServlet?message="+message).forward(request, response);
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
