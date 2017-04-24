package com.ols.servers;

import java.util.ArrayList;

import com.ols.Bean.dataBean;
import com.ols.Bean.questionBean;
import com.ols.sqlUtils.SqlVehicel;

//实现采集员相关功能
public class getherIndex {
   //更新新闻
	public boolean addNews(String title,String conn){
	   String sql="insert into news(news_title,news_conn) values(?,?)";
	   String[] paras={title,conn};
	   int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
	    }
	}
	//上传学习资料
	  public boolean addData(dataBean data){ 
		  String sql="insert into data(d_key,d_type,d_address,g_user) values(?,?,?,?)";
		  String[] paras={data.getD_key(),data.getD_type(),data.getD_address(),data.getG_user()};
		  int result=new SqlVehicel().updataSql(sql, paras);
			if(result==1){
				return true;
			}else{
				return false;
		    }
	  }
	  //查看资料的页数
	  public int LookDataPage(){
		   String sql="select count(*) from data where 1=?";
		   String [] paras={"1"};
		   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
		   Object[] object=al.get(0);
		   int rowCount=Integer.parseInt(object[0].toString());
		   int pageSize=10;
		   int pageCount=0;
	    	 if(rowCount%pageSize==0){
	    		 pageCount=rowCount/pageSize;
	    	 }else{
	    		 pageCount=rowCount/pageSize+1;
	    	 }
	    	 return pageCount;   
	   }
	 //查看资料
	  public ArrayList<dataBean> LookData(int pageNow){
		  ArrayList<dataBean> newal=new ArrayList<dataBean>();
		  String sql="select d_id,d_key,d_type,g_user from data where 1=? LIMIT "+ (pageNow-1)*10+","+10;
		  String [] paras={"1"};
		  ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
		  if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){ 
	    		  Object[] object=al.get(i);
	    		  dataBean data=new dataBean();
	    		  data.setD_id(Integer.parseInt(object[0].toString()));
	    		  data.setD_key(object[1].toString());
	    		  data.setD_type(object[2].toString());
	    		  data.setG_user(object[3].toString());
	    		  newal.add(data);
	    	  }
	      }
		  return newal;
	  }
	//删除学习资料
	  public boolean delData(String id){
		  String sql="delete from data where d_id=?";
		  String[] paras={id};
		  int result=new SqlVehicel().updataSql(sql, paras);
			if(result==1){
				return true;
			}else{
				return false;
		    }
	  }
	 //上传测试题
	  public int addPaper(String p_key){
		  String sql="insert into paper(p_key) values(?)";
		  String [] paras={p_key};
		  int result=new SqlVehicel().updataSql(sql, paras);
			if(result==1){
				String sql1="select max(p_no) from paper where 1=?";
				String [] paras1={"1"};
				ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql1, paras1);
				   Object[] object=al.get(0);
				   int p_id=Integer.parseInt(object[0].toString());
				   return p_id;
			}else{
				return -1;
		    }
	  }
	  //上传试题
	  public boolean addQuestion(questionBean question,String q_id){
		  String sql="insert into question(q_no,q_question,q_a,q_b,q_c,q_d,q_result) values(?,?,?,?,?,?,?)";
		  String [] paras={q_id,question.getQ_question(),question.getQ_a(),question.getQ_b(),question.getQ_c(),question.getQ_d(),question.getQ_result()};
		  int result=new SqlVehicel().updataSql(sql, paras);
			if(result==1){
				return true;
			}else{
				return false;
		    }
	  }
	  //判断试卷是否存在
	  public boolean checkPname(String p_key){
		  String sql="select count(*) from paper where p_key=?";
		  String [] paras={p_key};
		  ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
		   Object[] object=al.get(0);
		   int sum=Integer.parseInt(object[0].toString());
		   if(sum>0){
			   return false;
		   }else{
			   return true;
		   }
	  }
}
