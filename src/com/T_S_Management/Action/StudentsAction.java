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
	//����ѧ���Ľ�ʦ����
	static private ArrayList<Teachers> appliedTeachers = new ArrayList<Teachers>();
	private ArrayList<Teachers> acceptedTeachers = new ArrayList<Teachers>();
	private ArrayList<Teachers> rejectedTeachers = new ArrayList<Teachers>();


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
	private String appliedTeacher; //ѧ��Ҫ����Ľ�ʦ��Id
	private String viewTeacher; //ѧ��Ҫ�鿴�Ľ�ʦId
	
	static String URL = "jdbc:mysql://localhost:3306/TSM";
	static String username = "root";
	static String password = "960927";
	
	public int[] ids = new int[10];
	private String relatedTeacher;
	private String relatedStudent;
	
	private String nname = new String();
	
	private String time;
	private String t1 = "����һһ����";
	
	/*********************mySql����**************************/
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

	/**********************************���ܺ���*************************************/
	
	//ע��
	public String modifyStudent(){
		connect();
		userId = UsersAction.ID;
		ActionContext.getContext().put("studentID", userId);
		System.out.println(userId);
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			//System.out.println("nuserId="+nuserId+"npassword="+npassword);
			String sql = "update students set name = '"+name+"',major  = '"+major+"',number = '"+number+"',tel = '"+tel+"',mail = '"+mail+"', introduce = '"+introduce+"' where userid = '"+userId +"'";
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		return "SUCCESS";
	}
	
	public String viewTeachers(){
		connect(); //�������ݿ�
		
		userId = UsersAction.ID;
		ActionContext.getContext().put("studentID", userId);
		System.out.println(userId);
		
		String application = new String(); //�����ݿ��еĹ�ϵ��临�Ƶ���String
		String sql1 = "select application from students where userId = '" +userId +"'"; //��ѯ��ǰѧ����userId
		//���Ƚ���ϵ����ڵ�ǰѧ�������ݿ�����ȡ����
		try{
			System.out.println("ѡȡ��ǰѧ���������ϵ�����"+sql1);
			PreparedStatement ps = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				application =  rs.getString(1);
				System.out.println("��ǰѧ���������ϵΪ��" + application);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//����ǰ��ϵ���
		String[] sub = application.split(";");
		String A = "A";
		String B = "B";
		String C = "C";
		String teacherId = "";
		for(int i = 0, len =sub.length; i < len; i ++){ //�Եõ���ÿһλ��ʦ�ֱ���
			System.out.println("��ʦId�����ϵ��"+ sub[i]);
			int len2 = sub[i].length();
			if(sub[i].contains(":A")) { //��ѯ����Ľ�ʦ
				teacherId = sub[i].substring(0, len2 - 8);//����Ľ�ʦ��Id
				System.out.println("����Ľ�ʦ��Id��" + teacherId);
				
				String sql2 = "select * from teachers where userId = '" + teacherId + "'";
				try{
					System.out.println("��ѯ�����ʦ�����"+sql2);
					PreparedStatement ps = conn.prepareStatement(sql2);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						System.out.println("��ѯ��һ����ʦ����������������ʦ��������");
						appliedTeachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
						nname = rs.getString(2);
					}
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
			}else if(sub[i].contains(":B")){ //��ѯ���ܵĽ�ʦ
				teacherId = sub[i].substring(0, len2 - 8);
				System.out.println("���ܵĽ�ʦ��Id��" + teacherId);
				
				String sql2 = "select * from teachers where userId = '" + teacherId + "'";
				try{
					System.out.println("��ѯ���ܽ�ʦ�����"+sql2);
					PreparedStatement ps = conn.prepareStatement(sql2);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						System.out.println("��ѯ��һ����ʦ��������ӽ��ܵ���ʦ��������");
						acceptedTeachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));

					}
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
			}else if(sub[i].contains(":C")){ //��ѯ�ܾ��Ľ�ʦ
				teacherId = sub[i].substring(0, len2 - 8);
				System.out.println("�ܾ��Ľ�ʦ��Id��" + teacherId);
				
				String sql2 = "select * from teachers where userId = '" + teacherId + "'";
				try{
					System.out.println("��ѯ�ܾ���ʦ�����"+sql2);
					PreparedStatement ps = conn.prepareStatement(sql2);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						System.out.println("��ѯ��һ����ʦ��������Ӿܾ�����ʦ��������");
						rejectedTeachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));

					}
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		
		disconnect();
		for (Teachers t : appliedTeachers){
			System.out.println(t.getName()+t.getCollege()+t.getTitle()+t.getOffice()+t.getTel()+t.getMail()+t.getIntroduce());

		}
		return "SUCCESS";
	}
	
	public String apply(){
		connect(); //�������ݿ�
		
		userId = UsersAction.ID;
		ActionContext.getContext().put("studentID", userId);
		System.out.println("��ǰѧ����Id��"+userId);
		System.out.println("����ʱ�䣺"+time);
		
		System.out.println("����ʱ��2��"+getTime());
		
		System.out.println("��ʦ��"+getAppliedTeacher());
		
		int result = 0;
		
		String application = new String(); //�����ݿ��еĹ�ϵ��临�Ƶ���String
		String sql1 = "select application from students where userId = '" +userId +"'"; //��ѯ��ǰѧ����userId
		//���Ƚ���ϵ����ڵ�ǰѧ�������ݿ�����ȡ����
		try{
			System.out.println("ѡȡ��ǰѧ���������ϵ�����"+sql1);
			PreparedStatement ps = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				application =  rs.getString(1);
				System.out.println("��ǰѧ���������ϵΪ��" + application);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		application = application + appliedTeacher + ":A"+ time + ";";//�γ��µ������ϵ
		System.out.println("�޸ĺ�ѧ���������ϵΪ��" + application);
		
		String sql2 = "update students set application = '"+application+"' where userid = '" + userId +"'";
		
		try {
			Statement stmt = conn.createStatement();
			System.out.println("����ѧ����������ݿ������䣺"+sql2);
			result = stmt.executeUpdate(sql2);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		
		viewTeachers();
		
		return "SUCCESS";
	}
	
	
	
	
	
	
	/***********************************���ƺ���*******************************************/
	
	
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

	public String getViewTeacher() {
		return viewTeacher;
	}

	public void setViewTeacher(String viewTeacher) {
		this.viewTeacher = viewTeacher;
	}
	public ArrayList<Teachers> getAppliededTeachers() {
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

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

}
