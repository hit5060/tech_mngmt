package com.T_S_Management.Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;

public class TeachersAction {
	private Connection conn = null;
	private ArrayList<Teachers> appliedTeachers = new ArrayList<Teachers>();
	private ArrayList<Teachers> acceptedTeachers = new ArrayList<Teachers>();
	private ArrayList<Teachers> rejectedTeachers = new ArrayList<Teachers>();
	
	private ArrayList<Teachers> allTeachers = new ArrayList<Teachers>();
	private Teachers myself = new Teachers();
	//注：查看详情还未实现，Findid和addRelation未实现
	private String id;
	
	private String name;
	private String title;
	private String office;
	private String tel;
	private String introduce;
	private String mail;
	private String college;
	
	private String apllied;
	private String accepted;
	private String rejected;
	private static String userId;
	
	
	
	private String acceptedStudent;
	private String rejectedStudent;
	private String appliedStudent;
	
	static String URL = "jdbc:mysql://localhost:3306/tsm";
	static String username = "root";
	static String password = "960927";
	
	public int[] ids = new int[10];
	private static String relatedStudent;
	private static String relatedTeacher;
	
	static String passID;
	public String searchTeacher;
	/*********************mySql函数**************************/
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

	/**********************************功能函数*************************************/
	public String modifyTeacher(){
				int result = 0;
		try {
			Statement stmt = conn.createStatement();
		
			//插入改成更新！！！！
		    //
			//
			String sql = "update teachers set name = '"+name+"',office  = '"+office+"',title = '"+title+"',tel = '"+tel+"',mail = '"+mail+"', introduce = '"+introduce+"', college = '"+college+"' where userid = "+userId;
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return "SUCCESS";
	}
	
				//System.out.println("nuserId="+nuserId+"npassword="+npassword);
			sql = "update teachers set "+rlt+"='"+relation+"'"+"where id="+tID;
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
	}
	
	public ArrayList<Teachers> queryInfo(String teacherId, int i){	
		
		connect();
		ArrayList<Teachers> teachers = new ArrayList<Teachers>();
		System.out.println("queryInfo");
		
		for(int j = 1; j <= i; j++){
			String sql = "select * from teachers where id ="+ids[j];//warning type error
			System.out.println(sql);
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					teachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		return teachers;
	}
	
	public void search(String sql){
		connect();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				allTeachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
   
	public void queryApply(){
		System.out.println("queryApply");
		//Arrays.fill(ids,0);
		int i = formIds("applied");
		appliedTeachers = queryInfo("applied",i);
		//return "SUCCESS";
	}
	public void queryAccept(){
		//Arrays.fill(ids,0);
		int i = formIds("accepted");
		acceptedTeachers = queryInfo("accepted",i);
		//return "SUCCESS";
	}
	public void queryReject(){
		//Arrays.fill(ids,0);
		int i = formIds("rejected");
		rejectedTeachers = queryInfo("rejected",i);
		//return "SUCCESS";
	}
	
	 /************************************************************************************/
	public String addApply(){
		String rlt = "applied";
		//addRelation(rlt, appliedStudent);
		return "SUCCESS";
	}
	
	public String addAccept(){
		String rlt = "accepted";
		connect();
		relatedTeacher = UsersAction.ID;
		System.out.println(relatedTeacher);
		
		String sql = "select id from teachers where userid ="+relatedTeacher;
		System.out.println(sql);

		String a = "";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){//或者while(rs.next()) 
				   a = rs.getString(1);
				   if(a == null){
				        a = "";
				   }
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		disconnect();
		
		System.out.println("sId = "+relatedStudent+"tId = "+a);
		passID = relatedStudent;
		StudentsAction SA = new StudentsAction(); 
		SA.addAccept();
		addRelation(a,rlt,relatedStudent);
		return "SUCCESS";
	}
	
	public String addReject(){
		String rlt = "rejected";
		//addRelation(rlt, rejectedStudent);
		return "SUCCESS";
	}
	
	
	
	public String queryAll(){
		connect();
		String sql = "select * from teachers";//warning type error
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				allTeachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "SUCCESS";
	}
	
	public String searchAll(){
		String sql1 = "select * from teachers where name="+searchTeacher;
		search(sql1);
		String sql2 = "select * from teachers where introduce like '%"+searchTeacher+"%'";
		search(sql2);
		return "SUCCESS";
		
	}
	
	public String StudentApplication(){
		System.out.println("StudentApplication");
		queryApply();
		queryAccept();
		queryReject();
		return "SUCCESS";
	}
	/*******************************************************************************/
	public String searchMyself(){
		userId = UsersAction.ID;
		String sql = "select * from teachers where userid="+userId;
		connect();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				myself = new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "SUCCESS";
	}
	
	public String nullTeacher(){
		userId = UsersAction.ID;
		ActionContext.getContext().put("teacherID", userId);
		return "SUCCESS";
	}
	
	public String null2Teacher(){
		ActionContext.getContext().put("teacherID", userId);
		return "SUCCESS";
	}
	
	public String searchTeacher(){
		ActionContext.getContext().put("searchTeacher", searchTeacher);
		return "SUCCESS";
	}
	
	
	/**********************************************************/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getApllied() {
		return apllied;
	}
	public void setApllied(String apllied) {
		this.apllied = apllied;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	public String getRejected() {
		return rejected;
	}
	public void setRejected(String rejected) {
		this.rejected = rejected;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	public String getRelatedStudent() {
		return relatedStudent;
	}
	public void setRelatedStudent(String relatedStudent) {
		this.relatedStudent = relatedStudent;
	}

	public ArrayList<Teachers> getAppliedTeachers() {
		return appliedTeachers;
	}

	public void setAppliedTeachers(ArrayList<Teachers> appliedTeachers) {
		this.appliedTeachers = appliedTeachers;
	}

	public ArrayList<Teachers> getAcceptedTeachers() {
		return acceptedTeachers;
	}

	public void setAcceptedTeachers(ArrayList<Teachers> acceptedTeachers) {
		this.acceptedTeachers = acceptedTeachers;
	}

	public ArrayList<Teachers> getRejectedTeachers() {
		return rejectedTeachers;
	}

	public void setRejectedTeachers(ArrayList<Teachers> rejectedTeachers) {
		this.rejectedTeachers = rejectedTeachers;
	}

	public String getAcceptedStudent() {
		return acceptedStudent;
	}

	public void setAcceptedStudent(String acceptedStudent) {
		this.acceptedStudent = acceptedStudent;
	}

	public String getRejectedStudent() {
		return rejectedStudent;
	}

	public void setRejectedStudent(String rejectedStudent) {
		this.rejectedStudent = rejectedStudent;
	}

	public String getAppliedStudent() {
		return appliedStudent;
	}

	public void setAppliedStudent(String appliedStudent) {
		this.appliedStudent = appliedStudent;
	}

	public ArrayList<Teachers> getAllTeachers() {
		return allTeachers;
	}

	public void setAllTeachers(ArrayList<Teachers> allTeachers) {
		this.allTeachers = allTeachers;
	}

	public Teachers getMyself() {
		return myself;
	}

	public void setMyself(Teachers myself) {
		this.myself = myself;
	}

	public String getRelatedTeacher() {
		return relatedTeacher;
	}

	public void setRelatedTeacher(String relatedTeacher) {
		this.relatedTeacher = relatedTeacher;
	}

}
