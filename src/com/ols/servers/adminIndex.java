package com.ols.servers;

import java.util.ArrayList;
import com.ols.Bean.classBean;
import com.ols.Bean.userBean;
import com.ols.sqlUtils.SqlVehicel;
//ʵ�ֹ���Ա��ع���
public class adminIndex {
	//�����û����Ƿ����
	public boolean checkUser(String userN,String type){
		String sql="";
		if(type.equals("admin")){
			sql="select count(*) from admin where a_user=? ";
		}else if(type.equals("gether")){
			sql="select count(*) from gether where g_user=? ";
		}else if(type.equals("principal")){
			sql="select count(*) from principal where p_user=? ";
		}else{
			sql="select count(*) from user where s_user=? ";
		}		 
		String [] paras={userN};
		ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
	     Object[] object=al.get(0);
	     int Count=Integer.parseInt(object[0].toString());
	     if(Count>0){
	    	 return false;
	     }else{
	    	 return true;
	     }
	}
    //��������
   public boolean resetPwd(String username,String usertype){
	   String sql="";
		if(usertype.equals("gether")){
			sql="update gether set g_pwd=123456 where g_user=?";
		}else if(usertype.equals("principal")){
			sql="update principal set p_pwd=123456 where p_user=?";
		}else if(usertype.equals("user")){
			sql="update user set s_pwd=123456 where s_user=?";
		}
		String[] paras={username};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
   }
   //���ӹ���Ա
   public boolean addAdmin(String username){
	   String sql="INSERT INTO admin(a_user,a_pwd) VALUES(?,'123456')";
	   String[] paras={username};
	   int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
   }
   //�鿴����Ա�����ǲ���1
   public boolean SelAdminID(String username){
	   String sql1="select a_id from admin where a_user=?";
	   String[] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql1, paras);
		 if(al.size()==1){
			 Object[] object=al.get(0);
			 if(Integer.parseInt(object[0].toString())==1){
			   return true;
			 }else{
				 return false;
			 }
		 }else{
			 return false;
		 }
   }
   //ɾ������Ա
   public int delAdmin(String username){
	   String sql1="select a_id from admin where a_user=?";
	   String sql="DELETE FROM admin WHERE a_user=?";
	   String[] paras={username};
	   ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql1, paras);
		 if(al.size()==1){
			 Object[] object=al.get(0);
			 if(Integer.parseInt(object[0].toString())!=1){
				 int result=new SqlVehicel().updataSql(sql, paras);
					if(result==1){
						//ɾ���ɹ�
						return 1;
					}else{
						//ɾ��ʧ��
						return -1;
					}
			 }else{
				//���Ϊ1 ����ɾ�� 
				 return 0;
			 }
		 }else{
			 //ʧ��
			 return -2;
		 }
	   
   }
   //ɾ���û����ɼ�Ա���༶����Ա
   public boolean delUser(String username,String usertype){
	   String sql="";
	    if(usertype.equals("gether")){
		   sql="DELETE FROM gether WHERE g_user=?";
	   }else{
		   sql="DELETE FROM principal WHERE p_user=?";
	   }
	   String[] paras={username};
	   int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
   }
   //���Ӳɼ�Ա���༶����Ա
   public boolean addGP(String username,String name,String dept,String type){
	   String sql="";
	   if(type.equals("gether")){
		   sql="INSERT INTO gether(g_user,g_pwd,g_name,g_dept) VALUES(?,'123456',?,?)";
	   }else{
		   sql="INSERT INTO principal(p_user,p_pwd,p_name,p_dept) VALUES(?,'123456',?,?)";
	   }
	   String[] paras={username,name,dept};
	   int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
   }
   //�鿴����Ա���ɼ�Ա
   public ArrayList<String[]> selAG(String type){
	   ArrayList<String[]> newal=new ArrayList<String[]>();
	   String sql="";
	  if(type.equals("gether")){
		  sql="select g_user,g_name,g_dept from gether where 1=?";
		  String[] paras={"1"};
		  ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		  Object[] object=al.get(i);
	    		  String[] str={object[0].toString(),object[1].toString(),object[2].toString() };
	    		  newal.add(str);
	    	  }
	      }
	  }else{
		  sql="select a_user from admin where 1=?";
		  String[] paras={"1"};
		  ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		  Object[] object=al.get(i);
	    		  String[] str={object[0].toString()};
	    		  newal.add(str);
	    	  }
	      }
	  }
	  return newal;
   }
   //�鿴�༶����Ա�ж���ҳ
   public int selPrinPage(){
	   String sql="select count(*) from principal where 1=?";
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
   //�鿴�༶����Ա
   public ArrayList<String[]> selPrin(int pageNow){
	   ArrayList<String[]> newal=new ArrayList<String[]>();
		  String sql="select p_user,p_name,p_dept from principal where 1=? Limit "+ (pageNow-1)*10+","+10;
		  String[] paras={"1"};
		  ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		  Object[] object=al.get(i);
	    		  String[] str={object[0].toString(),object[1].toString(),object[2].toString() };
	    		  newal.add(str);
	    	  }
	      }
	      return newal;
   }
   //�鿴ĳ��ѧ������
   public int selAllSPage(String c_id){
	   String sql="SELECT count(*)  FROM USER,class WHERE class.c_id=? AND user.c_id=class.c_id ";
	   String [] paras={c_id};
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
   //�鿴ĳ�༶��ȫ��ѧ��
   public ArrayList<userBean> selAllstudent(String c_id,int pageNow){
	   ArrayList<userBean> newal=new ArrayList<userBean>();
		  String sql="SELECT s_id ,s_user,s_name  FROM USER,class WHERE class.c_id=? AND user.c_id=class.c_id Limit "+ (pageNow-1)*10+","+10;
		  String[] paras={c_id};
		  ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		 Object[] object=al.get(i);
	    		 userBean user=new userBean();
	    		 user.setS_id(Integer.parseInt(object[0].toString()));
	    		 if(object[2]==null){
	    			 user.setS_name(object[1].toString());
	    		 }else{
	    			 user.setS_name(object[2].toString());
	    		 }
	    		 newal.add(user);
	    	  }
	      }
	      return newal;
   }
   //id�鿴ĳһѧ�������
   public String[] selUStudyNews(String s_id){
	   String sql1="SELECT s_name,s_sex,s_section,s_phone,c_name,s_integral,p_name,p_dept"
	       +" FROM USER,class,principal WHERE user.s_id=? AND user.c_id=class.c_id AND principal.p_id=class.p_id ";
	   String sql2="SELECT COUNT(hasdata.h_id) FROM hasdata WHERE hasdata.s_id=? ";
	   String sql3="SELECT COUNT(know.k_id) FROM know  WHERE know.s_id=? ";
	   String sql4="SELECT COUNT(paper.p_no) FROM paper WHERE 1=?";
	   String sql5="SELECT COUNT(mark.m_no) FROM mark WHERE mark.s_id=?";
	   String sql6="SELECT COUNT(classdata.d_id) FROM classdata,USER WHERE user.s_id=? AND classdata.c_id=user.c_id";
       String[] paras1={s_id};
       String[] paras2={"1"};
		try {
			ArrayList<Object[]> al1=new SqlVehicel().SqlSelect(sql1, paras1);
		    ArrayList<Object[]> al2=new SqlVehicel().SqlSelect(sql2, paras1);
		    ArrayList<Object[]> al3=new SqlVehicel().SqlSelect(sql3, paras1);
		    ArrayList<Object[]> al4=new SqlVehicel().SqlSelect(sql4, paras2);
		    ArrayList<Object[]> al5=new SqlVehicel().SqlSelect(sql5, paras1);
		    ArrayList<Object[]> al6=new SqlVehicel().SqlSelect(sql6, paras1);
			Object[] object1= al1.get(0);
		     for(int i=0;i<object1.length;i++ ){
		    	 if(object1[i]==null){
		    		 object1[i]="-";
		    	 }
		     }
			Object[] object2= al2.get(0);
			Object[] object3= al3.get(0);
			Object[] object4= al4.get(0);
			Object[] object5= al5.get(0);
			Object[] object6= al6.get(0);
			System.out.println(object6[0].toString());
			String[] newal={object1[0].toString(),object1[1].toString(),object1[2].toString(),object1[3].toString(),
					        object1[4].toString(),object1[5].toString(),object1[6].toString(),object1[7].toString(),
					        object6[0].toString(),object2[0].toString(),object3[0].toString(),object4[0].toString(),
					        object5[0].toString()};
			 return newal;
		} catch (Exception e) {
			return null;
		}
   }
 //�û����鿴ĳһѧ�������
   public String[] selSNews(String s_user){
	   String al[]=null;
	   String sql="select s_id from user where s_user=?";
	   String []paras={s_user};
	   ArrayList<Object[]> ID=new SqlVehicel().SqlSelect(sql, paras);
	   if(ID.size()>0){
		   try{
			   Object[] Id=ID.get(0);
			   al=selUStudyNews(Id[0].toString());
			   
		   }catch(Exception e){
		   }
	   }
	   return al;
   }
   //�鿴���еİ༶
   public ArrayList<classBean> selAllClass(){
		ArrayList<classBean> newal=new ArrayList<classBean>();
		String sql="select c_id,c_name from class where 1=? ORDER BY c_id DESC";
		String [] paras={"1"};
		ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		  Object[] object=al.get(i);
	    		  classBean cl=new classBean();
	    		  cl.setC_id(Integer.parseInt(object[0].toString()));
	    		  cl.setC_name(object[1].toString());
	    		  newal.add(cl);
	    	  }
	      }
	      return newal;
	}
}
