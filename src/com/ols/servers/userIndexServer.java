package com.ols.servers;
import java.util.*;
import com.ols.Bean.*;
import com.ols.sqlUtils.SqlVehicel;

//�ṩ��ͨ�û�����ģ����������
public class userIndexServer extends PartPageUtil  {
	int pageSize=getPagesize();
	//�ṩ�༶������������
   public String noticeDate(String username){
	   String sql="select c_notice from class,user where s_user=? and user.c_id=class.c_id ";
	   String []paras={username};
	   String notice=null;
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   if(al.size()==1){
	      Object[] object=al.get(0);
	       notice=object[0].toString();
	   }
	   
	   return notice;
   }
   //��ѯ��ѧϰ����
   public int getDataSum(String username,String type){
	   String sql="";
	   if(type.equals("video")){
		   sql="select count(*) from classdata ,user,data where s_user=? and user.c_id=classdata.c_id and classdata.d_id=data.d_id and d_type='1'";
	   }else if(type.equals("text")){
		   sql="select count(*) from classdata ,user,data where s_user=? and user.c_id=classdata.c_id and classdata.d_id=data.d_id and d_type='2'";
	   }
	   String [] paras={username};
	   int result=getRowcount(sql, paras);
	   return result;
   }
   //��ѯ���ѧϰ����
   public int gethasDataSum(String username,String type){
	   String sql="";
	   if(type.equals("video")){
		   sql="select count(*) from hasdata ,user,data where s_user=? and user.s_id=hasdata.s_id and hasdata.h_id=data.d_id and d_type='1'";
	   }else if(type.equals("text")){
		   sql="select count(*) from hasdata ,user,data where s_user=? and user.s_id=hasdata.s_id and hasdata.h_id=data.d_id and d_type='2'";
	   }
	   String [] paras={username};
	   int result=getRowcount(sql, paras);
	   return result;
   }
   //�ṩδѧ�γ�����
   //��ѯ���ж���ҳ
   public int getnoDataPage(String username,String type){
	   String sql1="";
	   String []paras={username,username,username};
	   if(type.equals("video")){
		   sql1="SELECT COUNT(*) from user ,classvideo where `user`.s_user=? AND  user.c_id=classvideo.c_id "+
				"and d_id not in (SELECT n_id FROM nowdata ,user where `user`.s_user=? AND nowdata.s_id=`user`.s_id ) AND d_id "+
				" not in (SELECT h_id FROM hasdata ,user where `user`.s_user=? AND hasdata.s_id=`user`.s_id )";
		    
	   }else if(type.equals("text")){
		   sql1="SELECT COUNT(*) from user ,classtext where `user`.s_user=? AND  user.c_id=classtext.c_id "+
				   "and d_id not in (SELECT n_id FROM nowdata ,user where `user`.s_user=? AND nowdata.s_id=`user`.s_id ) AND d_id "+
				  " not in (SELECT h_id FROM hasdata ,user where `user`.s_user=? AND hasdata.s_id=`user`.s_id )";
	  }
	   //��ѯ���ж���ҳ
	   int result=getPagecount(sql1, paras);
	   return result;
   }
   //��ҳ��ѯ
   public ArrayList<dataBean> getnoData(String username ,String type,int pagenow){
	   ArrayList<dataBean> newal=new ArrayList<dataBean>();
	   String sql="";
	   if(type.equals("video")){
		    sql="SELECT  d_key,d_id from user ,classvideo where user.s_user=? AND  user.c_id=classvideo.c_id "+ 
	            "and d_id not in (SELECT n_id FROM nowdata ,user where user.s_user=? AND nowdata.s_id=user.s_id ) AND d_id "+
                "not in (SELECT h_id FROM hasdata ,user where user.s_user=? AND hasdata.s_id=user.s_id ) LIMIT "+ (pagenow-1)*pageSize+","+pageSize;
	   }else if(type.equals("text")){
		    sql="SELECT d_key,d_id from user ,classtext where `user`.s_user=? AND  user.c_id=classtext.c_id "+
			    "and d_id not in (SELECT n_id FROM nowdata ,user where `user`.s_user=? AND nowdata.s_id=`user`.s_id ) AND d_id "+
			    " not in (SELECT h_id FROM hasdata ,user where `user`.s_user=? AND hasdata.s_id=`user`.s_id ) LIMIT "+(pagenow-1)*pageSize+","+pageSize;
	   }
	   
	   String []paras={username,username,username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object=al.get(i);
		   dataBean data=new dataBean();
		   data.setD_key(object[0].toString());
		   data.setD_id(Integer.parseInt(object[1].toString()));
		   newal.add(data);
	   }
       return newal;
   }
   //�ṩ����ѧϰ����
   public int getnowDataPage(String username,String type){
	   String sql1="";
	   String []paras={username};
	   if(type.equals("video")){
		   sql1="select COUNT(*) FROM user,nowdata,data WHERE `user`.s_user=? "
			   		+"and nowdata.s_id=`user`.s_id AND nowdata.n_id=`data`.d_id AND `data`.d_type='1'";
	   }else if(type.equals("text")){
		   sql1=" select COUNT(*) FROM user,nowdata,data WHERE `user`.s_user=? "+
			          "and nowdata.s_id=`user`.s_id AND nowdata.n_id=`data`.d_id AND `data`.d_type='2'";
	  }
	   //��ѯ���ж���ҳ
	  int result= getPagecount(sql1, paras);
	   return result;
   }
   public ArrayList<nowdataBean> getnowDate(String username ,String type,int pagenow){
	   ArrayList<nowdataBean> newal= new ArrayList<nowdataBean>();
	   String sql="";
	   if(type.equals("video")){
		  sql="select d_key,d_id,n_time,last_time FROM user,nowdata,data WHERE `user`.s_user=? "
		   		+"and nowdata.s_id=`user`.s_id AND nowdata.n_id=`data`.d_id AND `data`.d_type='1' LIMIT "+(pagenow-1)*pageSize+","+pageSize;
	   }else if(type.equals("text")){
		  sql=" select d_key,d_id,n_time,last_time FROM user,nowdata,data WHERE `user`.s_user=? "+
	          "and nowdata.s_id=`user`.s_id AND nowdata.n_id=`data`.d_id AND `data`.d_type='2' LIMIT "+(pagenow-1)*pageSize+","+pageSize;
	   }
	   String[] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object =al.get(i);
		   nowdataBean nowdata=new nowdataBean();
		   nowdata.setD_key(object[0].toString());
		   nowdata.setD_id(Integer.parseInt(object[1].toString()));
		   nowdata.setN_time(object[2].toString());
		   nowdata.setLast_time((Date)object[3]);
		   newal.add(nowdata);
	   }
	   return newal;
   }
   //��ѯ��ѧϰ����
   public int gethasDataPage(String username,String type){
	   String sql1="";
	   String []paras={username};
	   if(type.equals("video")){
		   sql1="SELECT count(*) from user, hasdata ,data WHERE `user`.s_user=? and `user`.s_id=hasdata.s_id AND hasdata.h_id=`data`.d_id AND `data`.d_type='1' ";
	   }else if(type.equals("text")){
		   sql1=" SELECT count(*) from user, hasdata ,data WHERE `user`.s_user=? and `user`.s_id=hasdata.s_id AND hasdata.h_id=`data`.d_id AND `data`.d_type='2'";
	   }
	   //��ѯ���ж���ҳ
	   int result=getPagecount(sql1, paras);
	   return result;
   }
   public ArrayList<hasdataBean> gethasData(String username ,String type,int pagenow){
	   ArrayList<hasdataBean> newal=new ArrayList<hasdataBean>();
	   String sql="";
	   if(type.equals("video")){
		   sql="SELECT d_key,h_time,if_know from user, hasdata ,data WHERE `user`.s_user=? and `user`.s_id=hasdata.s_id AND hasdata.h_id=`data`.d_id AND `data`.d_type='1' LIMIT "+(pagenow-1)*pageSize+","+pageSize;
	   }else if(type.equals("text")){
		   sql=" SELECT d_key,h_time,if_know from user, hasdata ,data WHERE `user`.s_user=? and `user`.s_id=hasdata.s_id AND hasdata.h_id=`data`.d_id AND `data`.d_type='2' LIMIT "+(pagenow-1)*pageSize+","+pageSize;
	   }
	   String [] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object =al.get(i);
		   hasdataBean hasdata=new hasdataBean();
		   hasdata.setD_key(object[0].toString());
		   hasdata.setH_time((Date)object[1]);
		   hasdata.setIf_know(object[2].toString());
		   newal.add(hasdata);
	   }
	   return newal;
   }
   //��ѯ�轻�ĵ���
   public int getknowSum(String username){
	    String sql="select count(*) from user,hasdata where s_user=? and user.s_id=hasdata.s_id";
	   String [] paras={username};
	   int result=getRowcount(sql, paras);
	   return result;
   }
   //��ѯ�ѽ��ĵ���
   public int gethasKnowSum(String username){
	   String sql="select count(*) from user,hasdata where s_user=? and user.s_id=hasdata.s_id and if_know='��' ";
	   String []paras={username};
	   //��ѯ���ж�����
	   int result=getRowcount(sql, paras);
	   return result;
   }
   //��ѯδ���ĵ�ҳ��
   public int getnoKownPage(String username){
	   String sql="select COUNT(*) FROM user,hasdata where s_user=? and user.s_id=hasdata.s_id and if_know='��' ";
	   String []paras={username};
	   //��ѯ���ж���ҳ
	   int result=getPagecount(sql, paras);
	   return result;
   }
   //��ѯδ���ĵ�
   public ArrayList<dataBean> getnoKown(String username ,int pagenow){
	   ArrayList<dataBean> newal=new ArrayList<dataBean>();
	   String sql="select d_id,d_key FROM user, hasdata,data where s_user=? and user.s_id=hasdata.s_id and if_know='��' and hasdata.h_id=data.d_id LIMIT "+(pagenow-1)*pageSize+","+pageSize;
	   String [] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object =al.get(i);
		   dataBean noknow=new dataBean();
		   noknow.setD_id(Integer.parseInt(object[0].toString()));
		   noknow.setD_key(object[1].toString());
		   newal.add(noknow);
	   }
	   return newal;
   }
   
   //��ѯ�ѽ��ĵ�ҳ��
   public int gethasKownPage(String username){
	   String sql="select count(*) from user,hasdata where s_user=? and user.s_id=hasdata.s_id and if_know='��' ";
	   String []paras={username};
	   //��ѯ���ж���ҳ
	   int result=getPagecount(sql, paras);
	   return result;
   }
   //��ѯ�ѽ��ĵ�
   public ArrayList<kownBean> gethasKown(String username ,int pagenow){
	   ArrayList<kownBean> newal=new ArrayList<kownBean>();
	   String sql="select d_key ,k_assess FROM user, hasdata,data ,know where s_user=? and user.s_id=hasdata.s_id and if_know='��' and hasdata.h_id=data.d_id  and `user`.s_id= know.s_id AND hasdata.h_id=know.k_id Limit "+(pagenow-1)*pageSize+","+pageSize;
	   String [] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object =al.get(i);
		   kownBean hasknow=new kownBean();
		   hasknow.setD_key(object[0].toString());
		   if(object[1]!=null){
		   hasknow.setK_assess(object[1].toString());
		   }else{
			   hasknow.setK_assess("-");
		   }
		   newal.add(hasknow);
	   }
	   return newal;
   }
   //��ѯ�ܵ�����
   public int getPaperSum(){
	   String sql="select count(*) from paper where 1=?";
	   String []paras={"1"};
	   int result=getRowcount(sql, paras);
	   return result;
   }
   //��ѯ���������
   public int gethasPaperSum(String username){
	   String sql="select count(*) from mark,user where s_user=? and user.s_id=mark.s_id";
	   String []paras={username};
	   int result=getRowcount(sql, paras);
	   return result;
   }
   //��ѯδ��ɵ�ҳ��
   public int  getnoPaperPage(String username){
	   String sql="select count(*) from paper  where p_no not in(select m_no from mark,user where s_user=? and user.s_id=mark.s_id ) ";
	   String []paras={username};
	   //��ѯ���ж���ҳ
	   int result=getPagecount(sql, paras);
	   return result;
   }
   //��ҳ��ѯδ�������
   public ArrayList<paperBean> getnoPaper(String username,int pagenow){
	   ArrayList<paperBean> newal=new ArrayList<paperBean>();
	   String sql="SELECT p_no,p_key FROM USER,paper WHERE  p_no NOT IN(SELECT m_no FROM mark,USER WHERE s_user=? AND user.s_id=mark.s_id ) LIMIT "+(pagenow-1)*pageSize+","+pageSize;
	   String [] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object =al.get(i);
		   paperBean nopaper=new paperBean();
		   nopaper.setP_no(Integer.parseInt(object[0].toString()));
		   nopaper.setP_key(object[1].toString());
		   newal.add(nopaper);
	   }
	   return newal;
   }
   //��ѯ�����ҳ��
   public int gethasPaperPage(String username){
	   String sql="select count(*) from mark,user where s_user=? and user.s_id=mark.s_id ";
	   String []paras={username};
	   //��ѯ���ж���ҳ
	  int result=getPagecount(sql, paras);
	  return result;
	  
   }
   //��ѯ���������
   public ArrayList<markBean> gethasPaper(String username,int pagenow){
	   ArrayList<markBean> newal=new ArrayList<markBean>();
	   String sql="select m_no,p_key,score from mark,user,paper where s_user=? and user.s_id=mark.s_id and m_no=p_no Limit "+(pagenow-1)*pageSize+","+pageSize;
	   String [] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object =al.get(i);
		   markBean haspaper=new markBean();
		   haspaper.setM_no(Integer.parseInt(object[0].toString()));
		   haspaper.setP_key(object[1].toString());
		   haspaper.setScore(Integer.parseInt(object[2].toString()));
		   newal.add(haspaper);
	   }
	   return newal;
   }
   //��ѯ��Ƶ��ϸ��Ϣ
   public dataBean getDatanews(String id){
	   dataBean data=new dataBean();
	   String sql="select d_address,d_key from data where d_id=?";
	   String[] paras={id};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   if(al.size()==1){
		   Object[] object=al.get(0);
		   data.setD_id(Integer.parseInt(id));
		   data.setD_address(object[0].toString());
		   data.setD_key(object[1].toString());
	   }
	   return data;
   }
   //��ѯ����ѧϰ��Ƶ��ϸ��Ϣ
   public nowdataBean getnowDatanews(String id,String username){
	   nowdataBean nowdata=new nowdataBean();
	   String sql="select d_address,d_key,n_s from data,user,nowdata where s_user=? and user.s_id=nowdata.s_id and nowdata.n_id=? and d_id=?";
       String[] paras={username,id,id};
       ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
       if(al.size()==1){
    	   Object[] object=al.get(0);
    	   nowdata.setD_address(object[0].toString());
    	   nowdata.setD_key(object[1].toString());
    	   nowdata.setN_s(object[2].toString());
    	   nowdata.setD_id(Integer.parseInt(id));
       }
       return nowdata;
   }
   //�ύ�ĵ�
   public boolean setKnow(String id,String username,String text){
	   String sql="INSERT INTO know(k_id,s_id,k_text) VALUES(?,(SELECT s_id FROM USER WHERE s_user=?) , ? )";
	   String sql1="update hasdata set if_know=? where s_id=(SELECT s_id FROM USER WHERE s_user=?) and h_id=?";
       String[] paras={id,username,text};
       String[] paras1={"��",username,id};
       int result=new SqlVehicel().updataSql(sql, paras);
       int result1=new SqlVehicel().updataSql(sql1, paras1);
       if(result==1&&result1==1){
    	   return true;
       }else{
    	   return false;
       }
   }
   //��ȡ�Ծ���Ϣ
   public paperBean getPapernews(String id){
	   paperBean paper=new paperBean();
	   String sql="select p_key from paper where p_no=?";
	   String [] paras={id};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
       if(al.size()==1){
    	   Object[] object=al.get(0);
    	   paper.setP_key(object[0].toString());
    	   paper.setP_no(Integer.parseInt(id));
       }
	   return paper;
   }
   //��ȡ��������
   public ArrayList<questionBean> getPaper(String id){
	   ArrayList<questionBean> newal=new ArrayList<questionBean>();
	   String sql="select q_question,q_a,q_b,q_c,q_d,q_result from question where q_no=? ";
	   String [] paras={id};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	   for(int i=0;i<al.size();i++){
		   Object[] object=al.get(i);
		   questionBean paper=new questionBean();
		   paper.setQ_question(object[0].toString());
		   paper.setQ_a(object[1].toString());
		   paper.setQ_b(object[2].toString());
		   paper.setQ_c(object[3].toString());
		   paper.setQ_d(object[4].toString());
		   paper.setQ_result(object[5].toString());
		   newal.add(paper);
	   }
	   return newal;
   }
   //¼��ɼ�
   public boolean  setMark(String id,String username,int score){
	   String sql="insert into mark values(?,(SELECT s_id FROM USER WHERE s_user=?),?) ";
	   String[] paras={id,username,Integer.toString(score)};
       int result=new SqlVehicel().updataSql(sql, paras);
       if(result==1){
    	   return true;
       }else{
    	   return false;
       }
    }
   //�������ѧϰ�γ�
   public boolean setnowData(String username,nowdataBean nowdata,String time){
	   String sql="insert into nowdata values(?,(SELECT s_id FROM USER WHERE s_user=?),?,?,?)";
	   String[] paras={Integer.toString(nowdata.getD_id()),username,nowdata.getN_s(),nowdata.getN_time(),time};
	   int result=new SqlVehicel().updataSql(sql, paras);
	   if(result==1){
		   return true;
	   }else{
		   return false;
	   } 
   }
   //����ѧϰʱ��
   public boolean upnowData(String username,nowdataBean nowdata,String time){
	   String sql="update  nowdata set n_s=?,n_time=?,last_time=? where s_id=(SELECT s_id FROM USER WHERE s_user=?) and n_id=?";
	   String[] paras={nowdata.getN_s(),nowdata.getN_time(),time,username,Integer.toString(nowdata.getD_id())};
	   int result=new SqlVehicel().updataSql(sql, paras);
	   if(result==1){
		   return true;
	   }else{
		   return false;
	   } 
   }
   //�����ѧ��γ�
   public boolean sethasData(String username,String id,String time,String se){
	   String sql="DELETE FROM nowdata WHERE n_id=? AND s_id=(SELECT s_id FROM USER WHERE s_user=?) ";
	   String [] paras={id,username};
	   String sql1="INSERT INTO hasdata(h_id,s_id,h_time) VALUES(?,(SELECT s_id FROM USER WHERE s_user=?),?)";
       String [] paras1={id,username,time};
       if(se.equals("1")){
    	   if(new SqlVehicel().updataSql(sql1, paras1)==1){
    		   return true;
    	   }else{
    		   return false;
    	   }
       }else{
    	   if(new SqlVehicel().updataSql(sql, paras)==1&&new SqlVehicel().updataSql(sql1, paras1)==1){
        	   return true;
           }else{
        	   return false;
           }
       }   
   }
  
   //��ѯ��̳���⹲�ж���ҳ
 	public int selThemePage(String username){
 		int pageCount;
 		int pageSize=15;
 		String sql="SELECT COUNT(*) FROM  USER,theme WHERE user.s_id=theme.s_id AND user.c_id=(SELECT c_id FROM USER WHERE s_user=? ) ";
 		String[] paras={username};
 		ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
 		   Object[] object=al.get(0);
 		   int rowCount=Integer.parseInt(object[0].toString());
 	    	 if(rowCount%pageSize==0){
 	    		 pageCount=rowCount/pageSize;
 	    	 }else{
 	    		 pageCount=rowCount/pageSize+1;
 	    	 }
 		return pageCount;
 	}
 	//�鿴��̳����
 	 public ArrayList<themeBean> getTheme(String username,int pageNow){
 		   ArrayList<themeBean> newal=new ArrayList<themeBean>();
 		   String sql="SELECT t_id,s_user,s_name,t_theme,t_time FROM  USER,theme WHERE user.s_id=theme.s_id AND user.c_id=(SELECT c_id FROM USER WHERE s_user=? ) ORDER BY t_id DESC Limit "+(pageNow-1)*15+","+15;
 		   String [] paras={username};
 		   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
 		   for(int i=0;i<al.size();i++){
 			   Object[] object=al.get(i);
 			   themeBean theme=new themeBean();
 			   theme.setT_id(object[0].toString());
 			   if(object[2]==null){
 				   theme.setS_name(object[1].toString());
 			   }else{
 				   theme.setS_name(object[2].toString());
 			   }
 			   theme.setT_theme(object[3].toString());
 			   theme.setT_time((Date)object[4]);
 			   newal.add(theme);
 		   }
 		   return newal;
 	   }
 	 //�鿴ĳһ��������
 	 public String[] LookTheme(String t_id){
 		 String sql="select  t_theme from theme where t_id=?";
 		 String [] paras={t_id};
		 ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
         if(al.size()==1){
        	 Object[] object=al.get(0);
        	 String[] newal={t_id,object[0].toString()};
        	 return newal;
         }else{
        	 return null;
         }
 	 }
 	 //��ѯĳһ����Ļظ���ҳ��
 	public int selRestorePage(String id){
 		int pageCount;
 		int pageSize=10;
 		String sql="SELECT COUNT(*) FROM USER,RESTORE WHERE user.s_id=restore.s_id AND t_id=? ";
 		String[] paras={id};
 		ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
 		   Object[] object=al.get(0);
 		   int rowCount=Integer.parseInt(object[0].toString());
 	    	 if(rowCount%pageSize==0){
 	    		 pageCount=rowCount/pageSize;
 	    	 }else{
 	    		 pageCount=rowCount/pageSize+1;
 	    	 }
 		return pageCount;
 	}
 	//�鿴ĳһ��¼�Ļظ�
 	 public ArrayList<restoreBean> getRestore(String id,int pageNow){
		   ArrayList<restoreBean> newal=new ArrayList<restoreBean>();
		   String sql="SELECT s_user,s_name,r_key,r_time FROM USER,RESTORE WHERE user.s_id=restore.s_id AND t_id=? ORDER BY r_id DESC Limit "+(pageNow-1)*10+","+10;
		   String [] paras={id};
		   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
		   for(int i=0;i<al.size();i++){
			   Object[] object=al.get(i);
			   restoreBean restore =new restoreBean();
			   if(object[1]==null){
				   restore.setS_name(object[0].toString());
			   }else{
				   restore.setS_name(object[1].toString());
			   }
			   restore.setR_key(object[2].toString());
			   restore.setR_time((Date)object[3]);
			   newal.add(restore);
		   }
		   return newal;
	   }
 	 //��������
 	 public boolean addTheme(themeBean theme,String time){
 		 String sql="insert into theme(s_id,t_theme,t_time) values((select s_id from user where s_user=?),?,?)";
 	     String [] paras={theme.getS_user(),theme.getT_theme(),time};
 	     String sql1="update user set s_integral=s_integral+2 where s_user=?";
 	     String[] paras1={theme.getS_user()};
 	     int result=new SqlVehicel().updataSql(sql, paras);
 	     if(result==1){
 	    	new SqlVehicel().updataSql(sql1, paras1);
 		    return true;
 	     }else{
 		    return false;
 	     } 	 
 	 }
 	 //����ظ�
 	public boolean addRestore(restoreBean restore,String time){
		 String sql="insert into restore(t_id,s_id,r_key,r_time) values(?,(select s_id from user where s_user=?),?,?)";
	     String [] paras={restore.getT_id(),restore.getS_user(),restore.getR_key(),time};
	     String sql1="update user set s_integral=s_integral+1 where s_user=?";
 	     String[] paras1={restore.getS_user()};
	     int result=new SqlVehicel().updataSql(sql, paras);
	     if(result==1){
	    	new SqlVehicel().updataSql(sql1, paras1);
		    return true;
	     }else{
		    return false;
	     } 	 
	 }
}
