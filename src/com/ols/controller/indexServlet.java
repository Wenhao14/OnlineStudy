package com.ols.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.Bean.newsBean;
import com.ols.servers.newsServer;

@WebServlet("/indexServlet")
//本servelt是网站入口，并且为新闻版块准备数据
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    //准备新闻
	    ArrayList<newsBean> al=new newsServer().newsAfford();
	    request.setAttribute("news", al);
	    //跳转到登录页面
	    String message=request.getParameter("message");
		request.getRequestDispatcher("/WEB-INF/frontPage/userlogn.jsp?message"+message).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
