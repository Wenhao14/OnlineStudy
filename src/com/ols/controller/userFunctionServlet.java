package com.ols.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.Bean.restoreBean;
import com.ols.Bean.themeBean;
import com.ols.Bean.userBean;
import com.ols.servers.userIndexServer;
import com.ols.servers.userLognServer;

@WebServlet("/userFunctionServlet")
public class userFunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    String username=(String) request.getSession().getAttribute("username");
	    if(username==null){
	    	request.getRequestDispatcher("/indexServlet").forward(request, response);
	    }
	    int []a={0,0,0,0,0};
	    
	    //默认当前页数为1
	    int pageNow=1;
	    //默认总页数为1
	    int pageCount=1;
	    //定义用户功能的服务类的对象
	    userIndexServer userdata=new userIndexServer();
	    //每页显示多少条记录
	    int pageSize=userdata.getPagesize();
	    //接收用户所选择的功能
	    String select=request.getParameter("select");
	    if(select!=null){
	    	switch(select){
	    	   case "u2":{
	    		   select="u2";
	    		   String mselect=request.getParameter("mselect");
	    		   if(mselect!=null){
		    	    	if(mselect.equals("m2")){
		    	    		mselect="m2";
		    	    	}else{
		    	    		mselect="m1";
		    	    		userLognServer usernews=new userLognServer();
		    	    		userBean news=usernews.userNews(username);
		    	    		request.setAttribute("news", news);
		    	    	}
		    	     }else{
		    	    	mselect="m1";
		    	    	userLognServer usernews=new userLognServer();
	    	    		userBean news=usernews.userNews(username);
	    	    		request.setAttribute("news", news);
		    	     }
		    	     request.setAttribute("mselect",mselect);
	    		   break;
	    	   }
	    	   case "u3":{
		    		select="u3";
		    		String type="video";
		    		String vselect=request.getParameter("vselect");
		    		String pagenow=request.getParameter("pageNow");
    	    		if(pagenow!=null){
    	    			pageNow=Integer.parseInt(pagenow);
    	    		}
    	    		ArrayList<?> al=new ArrayList<Object>();
		    		if(vselect!=null){
		    	    	if(vselect.equals("v2")){
		    	    		vselect="v2";
		    	    		pageCount=userdata.getnowDataPage(username, type);
			    	        al=userdata.getnowDate(username, type, pageNow);
		    	    	}else if(vselect.equals("v3")){
		    	    		vselect="v3";
		    	    		pageCount=userdata.gethasDataPage(username, type);
			    	    	al=userdata.gethasData(username, type, pageNow);
		    	    	}else{
		    	    		vselect="v1";
		    	    		pageCount=userdata.getnoDataPage(username, type);
			    	        al=userdata.getnoData(username,type,pageNow);
		    	    	}
		    	     }else{
		    	    	 vselect="v1";
		    	    	 pageCount=userdata.getnoDataPage(username, type);
			    	     al=userdata.getnoData(username,type,pageNow);
		    	     }
		    		 a[0]=userdata.getDataSum(username, type);
		    		 a[1]=userdata.gethasDataSum(username, type);
	    	    	 a[2]=pageSize;
	    	    	 a[3]=pageCount;
	    	    	 a[4]=pageNow;
		    		 request.setAttribute("sum", a);
		    		 request.setAttribute("al", al);
		    	     request.setAttribute("vselect",vselect); 
		    		 break; 
		       }
	    	   case "u5":{
	    		   select="u5";
	    		   String pagenow=request.getParameter("pageNow");
	    		   if(pagenow!=null){
   	    			pageNow=Integer.parseInt(pagenow);
   	    		   }
   	    		    ArrayList<?> al=new ArrayList<Object>();
	    		   String kselect=request.getParameter("kselect");
	    		   if(kselect!=null){
		    	    	if(kselect.equals("k2")){
		    	    		kselect="k2";
		    	    		pageCount=userdata.gethasKownPage(username);
		    	    		al=userdata.gethasKown(username, pageNow);
		    	    	}else{
		    	    		kselect="k1";
		    	    		pageCount=userdata.getnoKownPage(username);
			    	        al=userdata.getnoKown(username, pageNow);
		    	    	}
		    	     }else{
		    	    	 kselect="k1";
	    	    		 pageCount=userdata.getnoKownPage(username);
		    	         al=userdata.getnoKown(username, pageNow);
		    	     }
	    		     a[0]=userdata.getknowSum(username);
		    		 a[1]=userdata.gethasKnowSum(username);
	    	    	 a[2]=pageSize;
	    	    	 a[3]=pageCount;
	    	    	 a[4]=pageNow;
		    		 request.setAttribute("sum", a);
		    		 request.setAttribute("al", al);
		    	     request.setAttribute("kselect",kselect); 
	    		   break;
	    	   }
	    	   case "u6":{
	    		   select="u6";
	    		   String pagenow=request.getParameter("pageNow");
	    		   if(pagenow!=null){
   	    			pageNow=Integer.parseInt(pagenow);
   	    		   }
   	    		    ArrayList<?> al=new ArrayList<Object>();
	    		   String tselect=request.getParameter("tselect");
	    		   if(tselect!=null){
		    	    	if(tselect.equals("t2")){
		    	    		tselect="t2";
		    	    		pageCount=userdata.gethasPaperPage(username);
			    	        al=userdata.gethasPaper(username, pageNow);
		    	    	}else{
		    	    		tselect="t1";
		    	    		pageCount=userdata.getnoPaperPage(username);
			    	        al=userdata.getnoPaper(username, pageNow);
		    	    	}
		    	     }else{
		    	    	 tselect="t1";
	    	    		 pageCount=userdata.getnoPaperPage(username);
		    	         al=userdata.getnoPaper(username, pageNow);
		    	     }
	    		     a[0]=userdata.getPaperSum();
		    		 a[1]=userdata.gethasPaperSum(username);
	    	    	 a[2]=pageSize;
	    	    	 a[3]=pageCount;
	    	    	 a[4]=pageNow;
		    		 request.setAttribute("sum", a);
		    		 request.setAttribute("al", al);
		    	     request.setAttribute("tselect",tselect);
	    		   break;
	    	   }
	    	   case "u7":{
	    		   //论坛
	    		   select="u7";
	    		   String t_id=request.getParameter("t_id");
	    		   if(t_id==null){
	    			   String pagenow=request.getParameter("p");
    	    		   if(pagenow!=null){
    	    			   pageNow=Integer.parseInt(pagenow);
    	    		   }
   	    			   pageCount= userdata.selThemePage(username);
   	    			   int[] p={pageNow,pageCount};
   	    			   ArrayList<themeBean> al=userdata.getTheme(username, pageNow);
	    			   request.setAttribute("al", al);
	    			   request.setAttribute("p", p);
	    		   }else{
	    			   String pagenow=request.getParameter("p");
    	    		   if(pagenow!=null){
    	    			   pageNow=Integer.parseInt(pagenow);
    	    		   }
	    			   pageCount= userdata.selRestorePage(t_id);
	    			   int[] p={pageNow,pageCount};
	    			   ArrayList<restoreBean> al=userdata.getRestore(t_id, pageNow);
	    			   String[] theme=userdata.LookTheme(t_id);
	    			   request.setAttribute("theme", theme);
	    			   request.setAttribute("page", request.getParameter("page"));
	    			   request.setAttribute("al", al);
	    			   request.setAttribute("flag","true");
	    			   request.setAttribute("p", p);
	    		   }
	    		   break;
	    	   }
	    	   default:{
	    		   String notice=userdata.noticeDate(username);
	    		   request.setAttribute("notice", notice);
	    		   select="u1";
	    	   }
	    	}
	    }else{
	        String notice=userdata.noticeDate(username);
  		    request.setAttribute("notice", notice);
	    	select="u1";
	    }
	    request.getRequestDispatcher("/WEB-INF/frontPage/mainpage.jsp?select="+select).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
