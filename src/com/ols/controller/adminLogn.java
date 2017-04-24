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
		//���������������
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		//����lognҳ�����֤����
		  String username=request.getParameter("username");
	      String userpwd =request.getParameter("userpwd");
	      String usertype=request.getParameter("radio");
	      String rand=(String)request.getSession().getAttribute("rand");
	      String textrand=request.getParameter("textrand");
	      if(rand.equals(textrand)){
	    	  userLognServer test=new userLognServer();
              int flag=test.userTest(username, userpwd, usertype);
	    	  if(flag==1){
		    	  //��֤�ɹ�
	    		  request.getSession().setAttribute("username", username);
	    		  if(usertype.equals("admin")){
	    			  //��ת����Ա����
	    			  request.getRequestDispatcher("/WEB-INF/backPage/admin.jsp").forward(request, response);
	    		  }else if(usertype.equals("gether")){
	    			  //��ת���ϲɼ�Ա����
	    			  request.getRequestDispatcher("/WEB-INF/backPage/gether.jsp").forward(request, response);
	    		  }else{
	    			  //��ת�༶����Ա����
	    			  request.getRequestDispatcher("/WEB-INF/backPage/principal.jsp").forward(request, response);

	    		  }
		      }else if(flag==-1){
		    	  //�������
		    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=�������").forward(request, response);
		      }else if(flag==0){
		    	  //�û���������
		    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=�û���������").forward(request, response);
		      }else{
		    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=��ѡ���û�����").forward(request, response);
		      }
	      }else{
	    	  //��֤�����
	    	  request.getRequestDispatcher("/WEB-INF/backPage/logn.jsp?message=��֤�����").forward(request, response);
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
