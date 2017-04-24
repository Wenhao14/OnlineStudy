package com.ols.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ols.Bean.dataBean;
import com.ols.Bean.nowdataBean;
import com.ols.Bean.paperBean;
import com.ols.Bean.questionBean;
import com.ols.Bean.restoreBean;
import com.ols.Bean.themeBean;
import com.ols.Bean.userBean;
import com.ols.servers.userIndexServer;
import com.ols.servers.userLognServer;

@WebServlet("/usernewsServlet")
public class usernewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    String select =request.getParameter("select");
	    String username=(String) request.getSession().getAttribute("username");
	    if(username==null){
	    	request.getRequestDispatcher("/indexServlet").forward(request, response);
	    }
	    switch(select){
	      case "0":{
	    	  //退出功能
	    	  request.getSession().removeAttribute("username");
	    	  request.getSession().invalidate();
	          request.getRequestDispatcher("indexServlet").forward(request, response);
	    	  break;
	      }
	      case "1":{
	    	  //完善用户信息
	    	  userBean usernews=new userBean();
	    	  usernews.setS_name(request.getParameter("name"));
	    	  usernews.setS_sex(request.getParameter("sex"));
	    	  usernews.setS_section(request.getParameter("dept"));
	    	  usernews.setS_phone(request.getParameter("phone"));
	    	  usernews.setS_mile(request.getParameter("mail"));
	    	  userLognServer userlogn=new userLognServer();
	    	  if(userlogn.upuserNews(usernews, username)){
	  	      	 out.print("<script>alert('保存成功');history.back(-1);</script>"); 
	    	  }else{
	  	      	 out.print("<script>alert('保存失败');history.back(-1);</script>"); 
	    	  }
	    	  break;
	      }
          case "2":{
        	  //修改密码
	    	  String oldpwd=request.getParameter("oldpwd");
	    	  String newpwd=request.getParameter("newpwd");
	    	  userLognServer userlogn=new userLognServer();
	          int result=userlogn.userTest(username, oldpwd, "user");
	          if(result==1){
	        	  if(userlogn.updataPwd(username, newpwd, "user")){
	  	      	    out.print("<script>alert('密码修改成功');history.back(-1);</script>"); 
	        	  }else{
	  	      	    out.print("<script>alert('密码修改失败');history.back(-1);</script>"); 
	        	  }
	          }else{
	      	    out.print("<script>alert('原密码错误');history.back(-1);</script>"); 
	          }
	    	  break;
	      }
          case "3-1":{
        	  //未学习视频学习
        	 String id=request.getParameter("id");
        	 userIndexServer util=new userIndexServer();
        	 dataBean data=util.getDatanews(id);
        	 request.setAttribute("data", data);
        	 request.setAttribute("se","1");
        	 request.getRequestDispatcher("/WEB-INF/frontPage/fuction.jsp?select=1&s=0.00").forward(request, response);
	         break;
          }
          case "3-2":{
        	  //正在学习视频
        	  String id=request.getParameter("id");
        	  userIndexServer util=new userIndexServer();
         	  nowdataBean nowdata=util.getnowDatanews(id,username);
         	  request.setAttribute("nowdata", nowdata); 
         	  request.setAttribute("se", "2");
        	  request.getRequestDispatcher("/WEB-INF/frontPage/fuction.jsp?select=1&s="+nowdata.getN_s()).forward(request, response);
        	  break;
          }
          case "4":{
        	  //写心得
        	 request.setAttribute("id", request.getParameter("id"));
 	         request.getRequestDispatcher("/WEB-INF/frontPage/fuction.jsp?select=2").forward(request, response);
	         break;
          }
          case "5-1":{
        	  //小测试
        	 String id=request.getParameter("id");
       	     userIndexServer util=new userIndexServer();
        	 ArrayList<?> al=util.getPaper(id);
        	 paperBean paper=util.getPapernews(id);
             request.setAttribute("question", al);
             request.setAttribute("paper", paper);
             request.setAttribute("se", "1");
 	         request.getRequestDispatcher("/WEB-INF/frontPage/fuction.jsp?select=3").forward(request, response);
             break;
          }
          case "5-2":{
        	  //小测试答案
        	  String id=request.getParameter("id");
        	  userIndexServer util=new userIndexServer();
         	  ArrayList<questionBean> al=util.getPaper(id);
         	  paperBean paper=util.getPapernews(id);
              request.setAttribute("question", al);
              request.setAttribute("paper", paper);
              request.setAttribute("se","2");
  	          request.getRequestDispatcher("/WEB-INF/frontPage/fuction.jsp?select=3").forward(request, response);
        	  break;
          }
          case "6":{
        	  //提交心得
        	  String id=request.getParameter("id");
        	  String text=request.getParameter("knowtext");
        	  userIndexServer util=new userIndexServer();
              if(util.setKnow(id, username, text)){
            	  request.getRequestDispatcher("userFunctionServlet?select=u5&kselect=k2").forward(request, response);
	  	      	   // out.print("<script>alert('提交成功');history.back(-1);</script>"); 
              }else{
	  	      	    out.print("<script>alert('提交失败');history.back(-1);</script>"); 
              }
          }
          case "7":{
        	  //提交试卷
        	  String id=request.getParameter("id");
        	  userIndexServer util=new userIndexServer();
         	  ArrayList<questionBean> al=util.getPaper(id);
         	  float add=100/al.size();
         	  float score=0;
        	  for(int i=0;i<al.size();i++){
        		  questionBean question=al.get(i);
        		  String result=request.getParameter(Integer.toString(i));
        		  if(question.getQ_result().equalsIgnoreCase(result)){
        			  score+=add;
        		  }
        	  }
        	  if(util.setMark(id, username, (int)score)){
        		 request.getRequestDispatcher("userFunctionServlet?select=u6&tselect=t2").forward(request, response);
        	  }else{
	  	      	    out.print("<script>alert('提交失败');history.back(-1);</script>"); 

        	  }
          }
          case "8":{
        	  //发表主题
        	  String theme=request.getParameter("theme");
        	  if(!theme.equals("")){
        		  userIndexServer util=new userIndexServer();
        		  themeBean th=new themeBean();
        		  th.setT_theme(theme);
        		  th.setS_user(username);
        		  Date date=new Date();
        		  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        		  String time=format.format(date);
        		  if(util.addTheme(th,time)){
        			  request.getRequestDispatcher("userFunctionServlet?select=u7").forward(request, response);
        		  }else{
        			  out.print("<script>alert('发表失败');history.back(-1);</script>"); 
        		  }
        	  }else{
        		  out.print("<script>alert('发表内容不能为空');history.back(-1);</script>"); 
        	  }
        	  break;
          }
          case "9":{
        	  //主题回复
        	  String restore=request.getParameter("restore");
        	  if(!restore.equals("")){
        		  userIndexServer util=new userIndexServer();
        		  String t_id=request.getParameter("t_id");
        		  restoreBean re=new restoreBean();
        		  re.setR_key(restore);
        		  re.setS_user(username);
        		  re.setT_id(t_id);
        		  Date date=new Date();
        		  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        		  String time=format.format(date);
        		  String page=request.getParameter("page");
        		  if(util.addRestore(re,time)){
        			  request.getRequestDispatcher("userFunctionServlet?select=u7&t_id="+t_id+"&page="+page).forward(request, response);
        		  }else{
        			  out.print("<script>alert('回复失败');history.back(-1);</script>"); 
        		  }
        	  }else{
        		  out.print("<script>alert('回复内容不能为空');history.back(-1);</script>"); 
        	  }
        	  break;
          }
          case "10":{
        	  String Tnow=request.getParameter("now");
        	  String Tsum=request.getParameter("sum");
        	  if(Tnow!=null&&Tsum!=null&&!Tsum.equals("NaN")){
        		 float now= Float.parseFloat(Tnow);
             	 float sum=Float.parseFloat(Tsum);
             	 float jindu1=(now/sum)*100;
             	 BigDecimal b=new BigDecimal(jindu1);
             	 float jindu=b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
             	 userIndexServer util=new userIndexServer();
        		     if(sum>180){
        		    	String id= request.getParameter("id");
        		    	if(now==sum){
        		    		Date date=new Date();
	               		    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	               		    String time=format.format(date);
	               		    String se=request.getParameter("se");
	               		    util.sethasData(username,id,time,se);
                	    }else{
                	    	Date date=new Date();
	               		    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	               		    String time=format.format(date);
                		    if(request.getParameter("se").equals("1")){
                		    	nowdataBean nowdata=new nowdataBean();
                		    	nowdata.setD_id(Integer.parseInt(id));
                		    	nowdata.setG_user(username);
                		    	nowdata.setN_s(Float.toString(now));
                		    	nowdata.setN_time(Float.toString(jindu));
                			    util.setnowData(username, nowdata,time);
                		     }else{
                		    	nowdataBean nowdata=new nowdataBean();
                		    	nowdata.setD_id(Integer.parseInt(id));
                		    	nowdata.setG_user(username);
                		    	nowdata.setN_s(Float.toString(now));
                		    	nowdata.setN_time(Float.toString(jindu));
                		    	util.upnowData(username, nowdata,time);
                		     }
                	    }
        		     }
        	  }
        	 out.print("<script>history.go(-2);</script>"); 
        	 break;
          }
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
