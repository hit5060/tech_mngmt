package com.T_S_Management.Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersAction {
	private Connection conn = null;
	
	private String nuserId;
	private String npassword;
	private String nproperty;
	 static String ID; 
	/****************************************************/
	static String URL = "jdbc:mysql://localhost:3306/TSM";
	static String username = "root";
	static String password = "960927";
	//System.getenv("MYSQL_HOST_S"); Îª´Ó¿â£¬Ö»¶Á
	//static String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
	/***************************************************/
	private void connect() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, username, password);
			System.out.println("connected!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void disconnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public String createTeacher(){
		connect();
		int result1 = 0;
		int result2 = 0;
		try {
			Statement stmt = conn.createStatement();
			System.out.println("nuserId="+nuserId+"npassword="+npassword);
			String sql1 = "insert into accounts values('"+nuserId+"','"+npassword+"',1)";
			String sql2 = "insert into teachers(userid,arrangement) values('"+nuserId+"' , '0000000000000000000000000000000000000000')";
			result1 = stmt.executeUpdate(sql1);
			result2 = stmt.executeUpdate(sql2);
			System.out.println("result1 = "+result1);
			System.out.println("result2 = "+result2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		if(result1 == 1){
			return "SUCCESS";
		}else{
			return "ERROR";
		}
	}
	
	public String createStudent(){
		connect();
		int result1 = 0;
		int result2 = 0;
		try {
			Statement stmt = conn.createStatement();
			System.out.println("nuserId="+nuserId+"npassword="+npassword);
			String sql1 = "insert into accounts values('"+nuserId+"','"+npassword+"',2)";
			String sql2 = "insert into students(userid,application) values('"+nuserId+"','')";
			result1 = stmt.executeUpdate(sql1);
			result2 = stmt.executeUpdate(sql2);
			System.out.println("result="+result1);
			System.out.println("result="+result2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		if(result1 == 1){
			return "SUCCESS";
		}else{
			return "ERROR";
		}
	}
	
	public String login(){
		connect();
		ID = nuserId;
		int pro = 0;
		String rtn = null;
		String realpass;
		String sql = "select * from accounts where userId = '"+ nuserId +"'";
		System.out.println("sql ="+sql);
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				realpass = rs.getString(2);
				if(realpass.equals(npassword)) {
					pro = rs.getInt(3);
					System.out.println("pro ="+pro);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(pro == 1){
			rtn = "teacher";
		}
		if(pro == 2){
			rtn = "student";
		}
		if(pro == 0){
			rtn = "fail";
		}
		return rtn;
	}
	/*******************************************************/
	public String getNuserId() {
		return nuserId;
	}

	public void setNuserId(String nuserId) {
		this.nuserId = nuserId;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	public String getNproperty() {
		return nproperty;
	}

	public void setNproperty(String nproperty) {
		this.nproperty = nproperty;
	}
}
