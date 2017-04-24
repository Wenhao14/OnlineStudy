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
//��servlet�ṩ�û���¼��֤
public class userlognServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //���������������
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //���յ�¼������
        String username=request.getParameter("username");
        String userpwd =request.getParameter("userpwd");
        String usertype=request.getParameter("usertype");
        //������֤ʧ�ܽ��
        String message="";
        userLognServer userlogn=new userLognServer();
        int result=userlogn.userTest(username, userpwd, usertype);
        if(result==1){
        	//��֤�ɹ�
        	//���û�������Session �б���
        	request.getSession().setAttribute("username", username);
        	//����������Ķ���
        	userIndexServer userdata=new userIndexServer();
        	//��ȡ�༶����
        	String notice=userdata.noticeDate(username);
        	//���Ͱ༶����
  		    request.setAttribute("notice", notice);
            request.getRequestDispatcher("/WEB-INF/frontPage/mainpage.jsp").forward(request, response);
        }else if(result==-1){
        	//�������
        	message="�������";
        	request.getRequestDispatcher("indexServlet?message="+message).forward(request, response);
        }else if(result==0){
        	//�û���������
            message="�û���������";
        	request.getRequestDispatcher("indexServlet?message="+message).forward(request, response);
        }else if(result==-2){
        	//��֤����
        	message="��֤����";
        	request.getRequestDispatcher("indexServlet?message="+message).forward(request, response);
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
