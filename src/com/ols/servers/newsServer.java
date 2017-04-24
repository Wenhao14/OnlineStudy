package com.ols.servers;

import java.util.ArrayList;

import com.ols.Bean.newsBean;
import com.ols.sqlUtils.SqlVehicel;

//提供新闻
public class newsServer {
   public ArrayList<newsBean> newsAfford(){
	   ArrayList<newsBean> newal=new ArrayList<newsBean>();
	   String sql="SELECT news_title,news_conn FROM news where 1=? ORDER BY news_no DESC LIMIT 9";
	   String [] paras={"1"};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object=al.get(i);
		   newsBean news=new newsBean();
		   news.setNews_title(object[0].toString());
		   news.setNews_conn(object[1].toString());
		   newal.add(news);
	   }
	   return newal;
   }
}
