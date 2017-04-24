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
//��servelt����վ��ڣ�����Ϊ���Ű��׼������
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������������
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    //׼������
	    ArrayList<newsBean> al=new newsServer().newsAfford();
	    request.setAttribute("news", al);
	    //��ת����¼ҳ��
	    String message=request.getParameter("message");
		request.getRequestDispatcher("/WEB-INF/frontPage/userlogn.jsp?message"+message).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
