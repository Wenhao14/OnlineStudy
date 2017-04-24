package com.ols.servers;

import java.util.ArrayList;

import com.ols.Bean.userBean;
import com.ols.sqlUtils.SqlVehicel;

//用户身份验证
public class userLognServer {
    public int userTest(String username,String userpwd,String usertype){
    	if(username!=null&&userpwd!=null&&usertype!=null){
    		//查询sql语句 
    		String sql="";
    		if(usertype.equals("admin")){
    			sql="select a_pwd from admin where a_user=?";
    		}else if(usertype.equals("gether")){
    			sql="select g_pwd from gether where g_user=?";
    		}else if(usertype.equals("principal")){
    			sql="select p_pwd from principal where p_user=?";
    		}else if(usertype.equals("user")){
    			sql="select s_pwd from user where s_user=?";
    		}
    		String[] paras={username};
    		 ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
    		 if(al.size()==1){
    			 Object[] object=al.get(0);
    			 if(userpwd.equals((String)object[0])){
    				 //验证成功
    				 return 1;
    			 }else{
    				 //密码错误
    				 return -1;
    			 }
    		 }else{
    			 //用户不存在
    			 return 0;
    		 }
    	}else{
    		//身份验证失败
    		return -2;
    	}
    }
    //用户修改密码
    public boolean updataPwd(String username,String newpwd,String usertype){
    	String sql="";
		if(usertype.equals("admin")){
			sql="update admin set a_pwd=? where a_user=?";
		}else if(usertype.equals("gether")){
			sql="update gether set g_pwd=? where g_user=?";
		}else if(usertype.equals("principal")){
			sql="update principal set p_pwd=? where p_user=?";
		}else if(usertype.equals("user")){
			sql="update user set s_pwd=? where s_user=?";
		}
		String[] paras={newpwd,username};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
    	
    }
    //用户完善信息
    public boolean upuserNews(userBean usernews,String username){
    	String sql="update user set s_name=?,s_sex=?,s_section=?,s_phone=?,s_mile=? where s_user=?";
		String[] paras={usernews.getS_name(),usernews.getS_sex(),usernews.getS_section(),usernews.getS_phone(),usernews.getS_mile(),username};
		int result=new SqlVehicel().updataSql(sql, paras);
		if(result==1){
			return true;
		}else{
			return false;
		}
    }
   //提取用户信息
    public userBean userNews(String username){
    	String sql="select s_name,s_sex,s_section,s_phone,s_mile from user where s_user=?";
    	String[] paras={username};
    	userBean news=new userBean();
    	ArrayList<Object[]> al=new SqlVehicel().SqlSelect(sql, paras);
    	if(al.size()==1){
	    	Object[] object=(Object[]) al.get(0);
	    	for(int i=0;i<object.length;i++){
	    		if(object[i]==null){
	    			object[i]=" ";
	    		}
	    	}
	    	news.setS_name(object[0].toString());
	    	news.setS_sex(object[1].toString());
	    	news.setS_section(object[2].toString());
	    	news.setS_phone(object[3].toString());
	    	news.setS_mile(object[4].toString());
    	}
    	return news;
    }
	
}
