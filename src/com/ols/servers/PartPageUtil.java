package com.ols.servers;

import java.util.ArrayList;

import com.ols.sqlUtils.SqlVehicel;
//��ҳ���ܵĹ�����
public class PartPageUtil {
     private int pageSize=6;//ÿҳ��ʾ������
     private int rowCount=0;//����������¼
     private int pageCount=0;//������ҳ
     //��ȡÿҳ��ʾ������
     public int getPagesize(){
    	 return pageSize;
     }
     //��ѯ���ж�������¼
     public int getRowcount(String sql,String [] paras){
		ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
		Object[] object=al.get(0);
        rowCount=Integer.parseInt(object[0].toString());
        return rowCount;
     }
     //��ѯ���ж���ҳ
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
