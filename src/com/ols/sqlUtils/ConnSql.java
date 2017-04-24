package com.ols.sqlUtils;

import java.sql.*;

public class ConnSql {
    private Connection conn;
    final private String driverName="com.mysql.jdbc.Driver";//����jdbc����
	final private String dbUrl="jdbc:mysql://localhost:3306/onlinestudy";//���ӵķ����������ݿ�
	final private String userName="root";//���ݿ��û���
	final private String userPwd="Root";//����
    public Connection getConn(){
    	try{
    		Class.forName(driverName);//��ȡ����
    	    conn=DriverManager.getConnection(dbUrl, userName, userPwd);//��������
    	    
    	}catch(Exception ex){
    		ex.printStackTrace();
    		return null;
    	}
    	return conn;
    }
}
