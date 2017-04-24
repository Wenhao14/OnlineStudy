package com.ols.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menuServlet")
public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    //接收点击链接的名称
	    String select=request.getParameter("select");
	    switch(select){
	     case "m1":{ request.getRequestDispatcher("indexServlet").forward(request, response);
	                 break;
	               }
	     case "m2":{ request.getRequestDispatcher("WEB-INF/publicPage/body.jsp?select=m2").forward(request, response);
			         break;
			       }
	     case "m3":{ request.getRequestDispatcher("WEB-INF/publicPage/body.jsp?select=m3").forward(request, response);
			         break;
			       }
	     case "m4":{ request.getRequestDispatcher("WEB-INF/publicPage/body.jsp?select=m4").forward(request, response);
			         break;
			       }
	     case "m5":{ request.getRequestDispatcher("WEB-INF/publicPage/body.jsp?select=m5").forward(request, response);
			         break;
			       }
	     case "m6":{ request.getRequestDispatcher("WEB-INF/publicPage/body.jsp?select=m6").forward(request, response);
			         break;
			       }
	     default:{ request.getRequestDispatcher("indexServlet").forward(request, response);
		           break;
		         }
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
