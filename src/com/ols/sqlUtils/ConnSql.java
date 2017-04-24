package com.ols.sqlUtils;

import java.sql.*;

public class ConnSql {
    private Connection conn;
    final private String driverName="com.mysql.jdbc.Driver";//加载jdbc驱动
	final private String dbUrl="jdbc:mysql://localhost:3306/onlinestudy";//连接的服务器和数据库
	final private String userName="root";//数据库用户名
	final private String userPwd="Root";//密码
    public Connection getConn(){
    	try{
    		Class.forName(driverName);//获取驱动
    	    conn=DriverManager.getConnection(dbUrl, userName, userPwd);//建立连接
    	    
    	}catch(Exception ex){
    		ex.printStackTrace();
    		return null;
    	}
    	return conn;
    }
}
