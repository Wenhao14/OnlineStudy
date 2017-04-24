package com.ols.servers;

import java.util.ArrayList;

import com.ols.sqlUtils.SqlVehicel;
//分页功能的工具类
public class PartPageUtil {
     private int pageSize=6;//每页显示多少条
     private int rowCount=0;//共多少条记录
     private int pageCount=0;//共多少页
     //获取每页显示多少条
     public int getPagesize(){
    	 return pageSize;
     }
     //查询共有多少条记录
     public int getRowcount(String sql,String [] paras){
		ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
		Object[] object=al.get(0);
        rowCount=Integer.parseInt(object[0].toString());
        return rowCount;
     }
     //查询共有多少页
     public int getPagecount(String sql,String [] paras){
       ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   Object[] object=al.get(0);
	   rowCount=Integer.parseInt(object[0].toString());
    	 if(rowCount%pageSize==0){
    		 pageCount=rowCount/pageSize;
    	 }else{
    		 pageCount=rowCount/pageSize+1;
    	 }
    	 return pageCount;
     }
     

}
