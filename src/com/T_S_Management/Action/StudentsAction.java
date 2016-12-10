package com.T_S_Management.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsAction {
	private Connection conn = null;
	private ArrayList<Students> appliedStudents = new ArrayList<Students>();
	private ArrayList<Students> acceptedStudents = new ArrayList<Students>();
	private ArrayList<Students> rejectedStudents = new ArrayList<Students>();

	private String id;
	private String name;
	//private String sex;
	private String number;
	private String major;
	private String tel;
	private String introduce;
	private String mail;
	
	private String apllied;
	private String accepted;
	private String rejected;
	private String userId;
	//private String npassword;
	
	private String acceptedTeacher;
	private String rejectedTeacher;
	private String appliedTeacher;
	
	static String URL = "jdbc:mysql://localhost:3306/tch_mngmt";
	static String username = "root";
	static String password = "7892341911";
	
	public int[] ids = new int[10];
	private String relatedTeacher;
	private String relatedStudent;
	
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
	
	//注册
	public String modifyStudent(){
		connect();
		userId = UsersAction.ID;
		ActionContext.getContext().put("studentID", userId);
		System.out.println(userId);
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			//System.out.println("nuserId="+nuserId+"npassword="+npassword);
			String sql = "update students set name = '"+name+"',major  = '"+major+"',number = '"+number+"',tel = '"+tel+"',mail = '"+mail+"', introduce = '"+introduce+"' where userid = "+userId;
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return "SUCCESS";
	}
	
	
	public int formIds(String rlt){
		System.out.println("formIds");
		
		connect();
		relatedTeacher = UsersAction.ID;
		System.out.println(relatedTeacher);
		
		String sql = "select "+rlt+" from teachers where userid ="+relatedTeacher;
		System.out.println(sql);

		String ori = "";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){//或者while(rs.next()) 
				   ori = rs.getString(1);
				   if(ori == null){
				        ori = "";
				   }
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		disconnect();
		
		String regex = "[0-9]+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(ori);
        int i = 1;
        while (mat.find())
        {
            System.out.println(mat.group());
            String val = mat.group();
            int value = Integer.parseInt(val);
            ids[i] = value;
            i ++;
        }
		return i;
	}
	
	public void addRelation(String tID, String rlt, String sID){
		connect();
		int result = 0;
		String sql = "select "+rlt+" from students where id ="+sID;
		System.out.println(sql);
		String relation = "";
		
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){//或者while(rs.next()) 
				relation = rs.getString(1);
				   if(relation == null){
					   relation = "";
				   }
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		relation = relation + ',' +tID;
		try {
			Statement stmt = conn.createStatement();
			//System.out.println("nuserId="+nuserId+"npassword="+npassword);
			sql = "update students set "+rlt+"='"+relation+"'"+"where id="+sID;
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
	}
	
	public ArrayList<Students> queryInfo(String studentId, int i){
		
		connect();
		ArrayList<Students> students = new ArrayList<Students>();
		
		for(int j = 1; j <= i; j++){
			String sql = "select * from students where id ="+ids[j];//warning type error
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					students.add(new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		return students;
	}
	
	public void queryApply(){
		Arrays.fill(ids,0);
		int i = formIds("applied");
		appliedStudents = queryInfo("applied",i);
		//return "SUCCESS";
	}
	public void queryAccept(){
		Arrays.fill(ids,0);
		int i = formIds("accepted");
		acceptedStudents = queryInfo("accepted",i);
		//return "SUCCESS";
	}
	public void queryReject(){
		Arrays.fill(ids,0);
		int i = formIds("rejected");
		rejectedStudents = queryInfo("rejected",i);
		//return "SUCCESS";
	}
	
	/***********************************控制函数*******************************************/
	//请求项
	public String addApply(){
		String rlt = "applied";
		//addRelation(rlt, appliedTeacher);
		return "SUCCESS";
	}
	
	//老师接受后学生申请里添加
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
		relatedStudent = TeachersAction.passID;
		System.out.println("sId = "+relatedStudent+"tId = "+a);
		addRelation(a,rlt,relatedStudent);
		return "SUCCESS";
	}
	
	//老师拒绝
	public String addReject(){
		String rlt = "rejected";
		//addRelation(rlt, rejectedTeacher);
		return "SUCCESS";
	}
	
	
	public String TeacherApplication(){
		System.out.println("TeacherApplication");
		queryApply();
		queryAccept();
		queryReject();
		return "SUCCESS";
	}
	/*****************************************************************/
	
	public String nullStudent(){
		userId = UsersAction.ID;
		ActionContext.getContext().put("studentID", userId);
		System.out.println(userId);
		return "SUCCESS";
	}
	/**************************************************************************/  
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getApllied() {
		return apllied;
	}
	public void setApllied(String apllied) {
		this.apllied = apllied;
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

	public String getAcceptedTeacher() {
		return acceptedTeacher;
	}

	public void setAcceptedTeacher(String acceptedTeacher) {
		this.acceptedTeacher = acceptedTeacher;
	}

	public String getRejectedTeacher() {
		return rejectedTeacher;
	}

	public void setRejectedTeacher(String rejectedTeacher) {
		this.rejectedTeacher = rejectedTeacher;
	}

	public String getAppliedTeacher() {
		return appliedTeacher;
	}

	public void setAppliedTeacher(String appliedTeacher) {
		this.appliedTeacher = appliedTeacher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	/****************************************************************/
	public ArrayList<Students> getAppliedStudents() {
		return appliedStudents;
	}

	public void setAppliedStudents(ArrayList<Students> appliedStudents) {
		this.appliedStudents = appliedStudents;
	}

	public ArrayList<Students> getAcceptedStudents() {
		return acceptedStudents;
	}

	public void setAcceptedStudents(ArrayList<Students> acceptedStudents) {
		this.acceptedStudents = acceptedStudents;
	}

	public ArrayList<Students> getRejectedStudents() {
		return rejectedStudents;
	}

	public void setRejectedStudents(ArrayList<Students> rejectedStudents) {
		this.rejectedStudents = rejectedStudents;
	}

	public String getRelatedTeacher() {
		return relatedTeacher;
	}

	public void setRelatedTeacher(String relatedTeacher) {
		this.relatedTeacher = relatedTeacher;
	}

	public String getRelatedStudent() {
		return relatedStudent;
	}

	public void setRelatedStudent(String relatedStudent) {
		this.relatedStudent = relatedStudent;
	}
}
