package com.ols.servers;

import java.util.ArrayList;
import java.util.Date;

import com.ols.Bean.classBean;
import com.ols.sqlUtils.SqlVehicel;

//实现班级管理员相关功能
public class principalIndex {
    //为班级添加资料
	public boolean classAddData(String d_id,String c_id){
		String sql="insert into classdata(d_id,c_id) values(?,?)";
		String[] paras={d_id,c_id};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}			
	}
	//增加班级
	public boolean addClass(String[] paras){
		String sql="insert into class(c_name,c_date,p_id,c_notice) values(?,?,(select p_id from principal where p_user=?),?)";
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}	
	}
	//删除班级
	public boolean delClass(String id){
		String sql="delete from class where c_id=?";
		String[] paras={id};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}	
	}
	//增加学生
	public boolean addStudent(String username,String classID){
		String sql="insert into user(s_user,s_pwd,c_id) values(?,?,?)";
		String[] paras={username,"123456",classID};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}
	//发布公告
	public boolean updataNotice(String classId,String text){
		String sql="update class set c_notice=? where c_id=?";
		String []paras={text,classId};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}
	//查看班级
	public ArrayList<classBean> selClass(String PuserName){
		ArrayList<classBean> newal=new ArrayList<classBean>();
		String sql="select c_id,c_name,c_date from class where p_id=(select p_id from principal where p_user=? ) ORDER BY c_id DESC";
		String [] paras={PuserName};
		ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		  Object[] object=al.get(i);
	    		  classBean cl=new classBean();
	    		  cl.setC_id(Integer.parseInt(object[0].toString()));
	    		  cl.setC_name(object[1].toString());
	    		  cl.setC_date((Date)object[2]);
	    		  newal.add(cl);
	    	  }
	      }
	      return newal;
	}
	//查询未评阅心得的页数
	public int selKnowPage(String username){
		int pageCount;
		int pageSize=8;
		String sql="SELECT COUNT(*) FROM know,USER, DATA ,class WHERE know.s_id=user.s_id AND k_id=d_id AND "
             + "user.c_id IN( SELECT class.c_id FROM class WHERE class.p_id=(SELECT p_id FROM principal WHERE p_user=? ) ) AND k_assess IS NULL";
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
	//查询未评阅心得
	public ArrayList<String[]> selKnow(String username,int pageNow){
		ArrayList<String[]> newal=new ArrayList<String[]>();
		String sql="SELECT k_id,know.s_id,s_user,s_name,d_key FROM know,USER, DATA ,class WHERE know.s_id=user.s_id AND k_id=d_id AND "
         + " user.c_id=class.c_id and user.c_id IN( SELECT class.c_id FROM class WHERE class.p_id=(SELECT p_id FROM principal WHERE p_user=? ) ) "
         + "AND k_assess IS NULL LIMIT "+(pageNow-1)*8+","+8;
		String[] paras={username};
		ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		  Object[] object=al.get(i);
	    		  if(object[3]==null){
	    			  object[3]="--";
	    		  }
	    		  String[] know={object[0].toString(),object[1].toString(),object[2].toString(),
	    				  object[3].toString(),object[4].toString()};
	    		  newal.add(know);
	    	  }
	      }
	      return newal;
	}
	//查询将删除学员的信息
	public String[] selStudent(String ID){
	 	String sql="SELECT s_user,s_name,c_name,s_id FROM USER,class WHERE s_user=? OR s_name=? ";
	    String[] paras={ID,ID};
	    ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()==1){
    		  Object[] object=al.get(0);
    		  String name="";
    		  if(object[1]==null){
    			  name="-";
    		  }else{
    			  name=object[1].toString();
    		  }
    		  String[] std={object[0].toString(),name,object[2].toString(),object[3].toString()};
	    	  return std;
	    	  }
	      return null;
	      }
	//删除学生
	public boolean delStu(String id){
		String sql="delete from user where s_id=?";
		String[] paras={id};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}
	//查看未添加的资料有多少页
	public int seldataPage(String classID){
		int pageCount;
		int pageSize=8;
		String sql="SELECT count(*) FROM DATA WHERE data.d_id  NOT IN (SELECT d_id FROM classdata WHERE c_id=?)";
		String[] paras={classID};
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
	//查看还未添加的资料
	public ArrayList<String[]> selData(String classID,int pageNow){
		ArrayList<String[]> newal=new ArrayList<String[]>();
		String sql="SELECT d_id,d_key FROM DATA WHERE data.d_id  NOT IN (SELECT d_id FROM classdata WHERE c_id=?) LIMIT "+(pageNow-1)*8+","+8;
	    String [] paras={classID};
	    ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    	  for(int i=0;i<al.size();i++){
	    		  Object[] object=al.get(i);
	    		  String[] know={object[0].toString(),object[1].toString()};
	    		  newal.add(know);
	    	  }
	      }
	      return newal;
	}
	//查询待评价心得
	public String[] LookKnow(String d_id,String s_id){
		String sql="select k_id,s_id,k_text,d_key from know ,data where k_id=? and s_id=? and k_id=d_id" ;
        String [] paras={d_id,s_id};
        ArrayList<Object[]>al=new SqlVehicel().SqlSelect(sql, paras);
	      if(al.size()>0){
	    		  Object[] object=al.get(0);
	    		  String[] know={object[0].toString(),object[1].toString(),object[2].toString(),object[3].toString()};
	    		  return know;
	      }
	      return null;
	}
	//存入评价结果
	public boolean SaveAssess(String d_id,String s_id,String assess){
		String sql="update know set k_assess=? where k_id=? and s_id=? ";
		String[] paras={assess,d_id,s_id};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}
}
