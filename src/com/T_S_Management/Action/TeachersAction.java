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
	//教师的集合们
	private ArrayList<Teachers> appliedTeachers = new ArrayList<Teachers>();
	private ArrayList<Teachers> acceptedTeachers = new ArrayList<Teachers>();
	private ArrayList<Teachers> rejectedTeachers = new ArrayList<Teachers>();
	
	private ArrayList<Teachers> allTeachers = new ArrayList<Teachers>();
	private Teachers myself = new Teachers();
	//学生的集合们
	private ArrayList<Students> appliedStudents = new ArrayList<Students>(); //向该老师申请的学生集合
	private ArrayList<Students> acceptedStudents = new ArrayList<Students>(); //该老师已接受的学生集合
	private ArrayList<Students> rejectedStudents = new ArrayList<Students>(); //该老师已拒绝的学生集合
	
	//注：查看详情还未实现，Findid和addRelation未实现
	private String id;
	private String name;
	private String title;
	private String office;
	private String tel;
	private String photo;
	private String introduce;
	private String mail;
	private String college;
	private String arrangement;
	
	private static String userId;
	
	private String viewTeacher; //学生要查看的教师Id
	
	private String acceptedStudent; //接受的学生（教师功能页面传递过来的学生userID）
	private String rejectedStudent; //拒绝的学生（教师功能页面传递过来的学生userID）
	private String appliedStudent;
	
	static String URL = "jdbc:mysql://localhost:3306/TSM";
	static String username = "root";
	static String password = "960927";
	
	public int[] ids = new int[10];
	private static String relatedStudent;
	private static String relatedTeacher;
	
	static String passID;
	public String searchTeacher;
	
	private static String passTeacherUserId;
	
	
	/***************日程管理功能的变量定义*************************/
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String s5;
	private String s6;
	private String s7;
	private String s8;
	private String s9;
	private String s10;
	private String s11;
	private String s12;
	private String s13;
	private String s14;
	private String s15;
	private String s16;
	private String s17;
	private String s18;
	private String s19;
	private String s20;
	private String s21;
	private String s22;
	private String s23;
	private String s24;
	private String s25;
	private String s26;
	private String s27;
	private String s28;
	private String s29;
	private String s30;
	private String s31;
	private String s32;
	private String s33;
	private String s34;
	private String s35;
	private String s36;
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
	public String modifyTeacher(){ //修改教师个人信息。
		connect();
		userId = UsersAction.ID;
		ActionContext.getContext().put("teacherID", userId);
		System.out.println(userId);
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
		
			//插入改成更新！！！！
		    //
			//
			String sql = "update teachers set name = '"+name+"',office  = '"+office+"',title = '"+title+"',tel = '"+tel+"',mail = '"+mail+"', introduce = '"+introduce+"', college = '"+college+"' where userid = '" + userId + "'";
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
		relatedStudent = UsersAction.ID;
		System.out.println(relatedStudent);

		String sql = "select "+rlt+" from students where userid ="+relatedStudent;
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
	
	public String viewStudents(){ //查看申请、接受、拒绝的学生的个人信息，修改三个学生的集合
		
		userId = UsersAction.ID;
		ActionContext.getContext().put("teacherID", userId);
		System.out.println("教师功能-查询学生，教师ID："+userId);
		
		connect(); //连接数据库
		
		String sql1 = "select * from students where application like '%" + userId + ":A%'"; //查询申请学生
		String sql2 = "select * from students where application like '%" + userId + ":B%'"; //查询接受学生
		String sql3 = "select * from students where application like '%" + userId + ":C%'"; //查询拒绝学生
		try{
			System.out.println("查询申请学生的语句"+sql1);
			PreparedStatement ps = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				appliedStudents.add(new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try{
			System.out.println("查询接受学生的语句"+sql2);
			PreparedStatement ps = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				acceptedStudents.add(new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try{
			System.out.println("查询拒绝学生的语句"+sql3);
			PreparedStatement ps = conn.prepareStatement(sql3);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				rejectedStudents.add(new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		disconnect();
		return "SUCCESS";
	}
	
	
	public void search(String sql){
		connect();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				allTeachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		disconnect();
	}
	
	public String accept(){ //教师接受学生申请
		
		userId = UsersAction.ID;
		ActionContext.getContext().put("teacherID", userId);
		System.out.println("教师功能-接受学生申请，教师ID："+userId);
		
		connect(); //连接数据库
		int result = 0;
		String application = new String(); //将数据库中的关系语句复制到该String
		String sql1 = "select application from students where userId = '" +acceptedStudent+"'"; //查询申请学生
		//首先将关系语句在要接受的学生的数据库中提取出来
		try{
			System.out.println("选取接受学生的申请关系的语句"+sql1);
			PreparedStatement ps = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				application =  rs.getString(1);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//生成新的关系语句，将其更新到接受的学生的数据库关系字段中
		String sub = userId + ":A";
		System.out.println("接受学生申请的老师的关系表达式:"+sub);
		String[]subs = new String[10];
		subs = application.split(sub);
		application = subs[0] + userId + ":B" + subs[1];
		String sql2 = "update students set application = '"+application+"' where userid = '"+acceptedStudent +"'";
		
		try {
			Statement stmt = conn.createStatement();
			System.out.println("接受学生申请的数据库更新语句："+sql2);
			result = stmt.executeUpdate(sql2);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		viewStudents();
		return "SUCCESS";
	}
   
	public String reject(){ //教师拒绝学生申请
		
		userId = UsersAction.ID;
		ActionContext.getContext().put("teacherID", userId);
		System.out.println("教师功能-拒绝学生申请，教师ID："+userId);
		
		connect(); //连接数据库
		int result = 0;
		String application = new String(); //将数据库中的关系语句复制到该String
		String sql1 = "select application from students where userId = '" +rejectedStudent +"'"; //查询拒绝学生
		//首先将关系语句在要拒绝的学生的数据库中提取出来
		try{
			System.out.println("选取拒绝学生的申请关系的语句"+sql1);
			PreparedStatement ps = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				application =  rs.getString(1);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//生成新的关系语句，将其更新到拒绝的学生的数据库关系字段中
		String sub = userId + ":A";
		System.out.println("拒绝学生申请的老师的关系表达式:"+sub);
		String[]subs = new String[10];
		subs = application.split(sub);
		application = subs[0] + userId + ":C" + subs[1];
		String sql2 = "update students set application = '"+application+"' where userid = '" + rejectedStudent +"'";
		
		try {
			Statement stmt = conn.createStatement();
			System.out.println("拒绝学生申请的数据库更新语句："+sql2);
			result = stmt.executeUpdate(sql2);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		viewStudents();
		return "SUCCESS";
	}
		
		
	 /************************************************************************************/
	
	
	
	
	public String queryAll(){
		connect();
		String sql = "select * from teachers";//warning type error
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				allTeachers.add(new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
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
	
	public String arrangement(){
		String arrgmt = new String();
		arrgmt = s1 + s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9+ s10+ s11+ s12+ s13+ s14+ s15+ s16+ s17+ s18+ s19+ s20+ s21+ s22+ s23+ s24+ s25+ s26+ s27+ s28+ s29+ s30+ s31+ s32+ s33+ s34+ s35;
		connect();
		userId = UsersAction.ID;
		ActionContext.getContext().put("teacherID", userId);
		System.out.println(userId);
		int result = 0;
		try {
			Statement stmt = conn.createStatement();

			String sql = "update teachers set arrangement = '"+arrgmt+"' where userid = '"+ userId +"'";
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		disconnect();
		
		teacherViewArrangement();
		
		return "SUCCESS";
	}
	
	public String studentViewArrangement(){
		passTeacherUserId = viewTeacher;
		
		System.out.println("学生功能-查看教师日程，教师ID："+viewTeacher);
		
		connect(); //连接数据库
		String sql = "select arrangement from teachers where userId = '" + viewTeacher +"'"; 
		
		int result = 0;
		String arrgmt = "";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				arrgmt = rs.getString(1);
				System.out.println("教师"+viewTeacher+"的日程安排"+arrgmt);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		s1 = arrgmt.substring(0, 1);
		System.out.println(s1);
		if(s1.equals("0")){
			System.out.println("here!");
			s1 = "";
		}
			
		else
			s1 = "√";
		s2 = arrgmt.substring(1, 2);
		if(s2.equals("0"))
			s2 = "";
		else
			s2 = "√";
		s3 = arrgmt.substring(2, 3);
		if(s3.equals("0"))
			s3 = "";
		else
			s3 = "√";
		s4 = arrgmt.substring(3, 4);
		if(s4.equals("0"))
			s4 = "";
		else
			s4 = "√";
		s5 = arrgmt.substring(4, 5);
		if(s5.equals("0"))
			s5 = "";
		else
			s5 = "√";
		s6 = arrgmt.substring(5, 6);
		if(s6.equals("0"))
			s6 = "";
		else
			s6 = "√";
		s7 = arrgmt.substring(6, 7);
		if(s7.equals("0"))
			s7 = "";
		else
			s7 = "√";
		s8 = arrgmt.substring(7, 8);
		if(s8.equals("0"))
			s8 = "";
		else
			s8 = "√";
		s9 = arrgmt.substring(8, 9);
		if(s9.equals("0"))
			s9 = "";
		else
			s9 = "√";
		s10 = arrgmt.substring(9, 10);
		if(s10.equals("0"))
			s10 = "";
		else
			s10 = "√";
		s11 = arrgmt.substring(10, 11);
		if(s11.equals("0"))
			s11 = "";
		else
			s11 = "√";
		s12 = arrgmt.substring(11, 12);
		if(s12.equals("0"))
			s12 = "";
		else
			s12 = "√";
		s13 = arrgmt.substring(12, 13);
		if(s13.equals("0"))
			s13 = "";
		else
			s13 = "√";
		s14 = arrgmt.substring(13, 14);
		if(s14.equals("0"))
			s14 = "";
		else
			s14 = "√";
		s15 = arrgmt.substring(14, 15);
		if(s15.equals("0"))
			s15 = "";
		else
			s15 = "√";
		s16 = arrgmt.substring(15, 16);
		if(s16.equals("0"))
			s16 = "";
		else
			s16 = "√";
		s17 = arrgmt.substring(16, 17);
		if(s17.equals("0"))
			s17 = "";
		else
			s17 = "√";
		s18 = arrgmt.substring(17, 18);
		if(s18.equals("0"))
			s18 = "";
		else
			s18 = "√";
		s19 = arrgmt.substring(18, 19);
		if(s19.equals("0"))
			s19 = "";
		else
			s19 = "√";
		s20 = arrgmt.substring(19, 20);
		if(s20.equals("0"))
			s20 = "";
		else
			s20 = "√";
		s21 = arrgmt.substring(20, 21);
		if(s21.equals("0"))
			s21 = "";
		else
			s21 = "√";
		s22 = arrgmt.substring(21, 22);
		if(s22.equals("0"))
			s22 = "";
		else
			s22 = "√";
		s23 = arrgmt.substring(22, 23);
		if(s23.equals("0"))
			s23 = "";
		else
			s23 = "√";
		s24 = arrgmt.substring(23, 24);
		if(s24.equals("0"))
			s24 = "";
		else
			s24 = "√";
		s25 = arrgmt.substring(24, 25);
		if(s25.equals("0"))
			s25 = "";
		else
			s25 = "√";
		s26 = arrgmt.substring(25, 26);
		if(s26.equals("0"))
			s26 = "";
		else
			s26 = "√";
		s27 = arrgmt.substring(26, 27);
		if(s27.equals("0"))
			s27 = "";
		else
			s27 = "√";
		s28 = arrgmt.substring(27, 28);
		if(s28.equals("0"))
			s28 = "";
		else
			s28 = "√";
		s29 = arrgmt.substring(28, 29);
		if(s29.equals("0"))
			s29 = "";
		else
			s29 = "√";
		s30 = arrgmt.substring(29, 30);
		if(s30.equals("0"))
			s30 = "";
		else
			s30 = "√";
		s31 = arrgmt.substring(30, 31);
		if(s31.equals("0"))
			s31 = "";
		else
			s31 = "√";
		s32 = arrgmt.substring(31, 32);
		if(s32.equals("0"))
			s32 = "";
		else
			s32 = "√";
		s33 = arrgmt.substring(32, 33);
		if(s33.equals("0"))
			s33 = "";
		else
			s33 = "√";
		s34 = arrgmt.substring(33, 34);
		if(s34.equals("0"))
			s34 = "";
		else
			s34 = "√";
		s35 = arrgmt.substring(34, 35);
		if(s35.equals("0"))
			s35 = "";
		else
			s35 = "√";
		
		disconnect();
		return "SUCCESS";
	}
	
	public String teacherViewArrangement(){
		userId = UsersAction.ID;
		ActionContext.getContext().put("teacherID", userId);
		System.out.println("教师功能-拒绝学生申请，教师ID："+userId);
		
		System.out.println("教师功能-查看教师日程，教师ID："+userId);
		
		connect(); //连接数据库
		String sql = "select arrangement from teachers where userId = '" + userId +"'"; 
		
		int result = 0;
		String arrgmt = "";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				arrgmt = rs.getString(1);
				System.out.println("教师"+userId+"的日程安排"+arrgmt);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		s1 = arrgmt.substring(0, 1);
		if(s1.equals("0")){
			System.out.println("here!");
			s1 = "";
		}
			
		else
			s1 = "√";
		s2 = arrgmt.substring(1, 2);
		if(s2.equals("0"))
			s2 = "";
		else
			s2 = "√";
		s3 = arrgmt.substring(2, 3);
		if(s3.equals("0"))
			s3 = "";
		else
			s3 = "√";
		s4 = arrgmt.substring(3, 4);
		if(s4.equals("0"))
			s4 = "";
		else
			s4 = "√";
		s5 = arrgmt.substring(4, 5);
		if(s5.equals("0"))
			s5 = "";
		else
			s5 = "√";
		s6 = arrgmt.substring(5, 6);
		if(s6.equals("0"))
			s6 = "";
		else
			s6 = "√";
		s7 = arrgmt.substring(6, 7);
		if(s7.equals("0"))
			s7 = "";
		else
			s7 = "√";
		s8 = arrgmt.substring(7, 8);
		if(s8.equals("0"))
			s8 = "";
		else
			s8 = "√";
		s9 = arrgmt.substring(8, 9);
		if(s9.equals("0"))
			s9 = "";
		else
			s9 = "√";
		s10 = arrgmt.substring(9, 10);
		if(s10.equals("0"))
			s10 = "";
		else
			s10 = "√";
		s11 = arrgmt.substring(10, 11);
		if(s11.equals("0"))
			s11 = "";
		else
			s11 = "√";
		s12 = arrgmt.substring(11, 12);
		if(s12.equals("0"))
			s12 = "";
		else
			s12 = "√";
		s13 = arrgmt.substring(12, 13);
		if(s13.equals("0"))
			s13 = "";
		else
			s13 = "√";
		s14 = arrgmt.substring(13, 14);
		if(s14.equals("0"))
			s14 = "";
		else
			s14 = "√";
		s15 = arrgmt.substring(14, 15);
		if(s15.equals("0"))
			s15 = "";
		else
			s15 = "√";
		s16 = arrgmt.substring(15, 16);
		if(s16.equals("0"))
			s16 = "";
		else
			s16 = "√";
		s17 = arrgmt.substring(16, 17);
		if(s17.equals("0"))
			s17 = "";
		else
			s17 = "√";
		s18 = arrgmt.substring(17, 18);
		if(s18.equals("0"))
			s18 = "";
		else
			s18 = "√";
		s19 = arrgmt.substring(18, 19);
		if(s19.equals("0"))
			s19 = "";
		else
			s19 = "√";
		s20 = arrgmt.substring(19, 20);
		if(s20.equals("0"))
			s20 = "";
		else
			s20 = "√";
		s21 = arrgmt.substring(20, 21);
		if(s21.equals("0"))
			s21 = "";
		else
			s21 = "√";
		s22 = arrgmt.substring(21, 22);
		if(s22.equals("0"))
			s22 = "";
		else
			s22 = "√";
		s23 = arrgmt.substring(22, 23);
		if(s23.equals("0"))
			s23 = "";
		else
			s23 = "√";
		s24 = arrgmt.substring(23, 24);
		if(s24.equals("0"))
			s24 = "";
		else
			s24 = "√";
		s25 = arrgmt.substring(24, 25);
		if(s25.equals("0"))
			s25 = "";
		else
			s25 = "√";
		s26 = arrgmt.substring(25, 26);
		if(s26.equals("0"))
			s26 = "";
		else
			s26 = "√";
		s27 = arrgmt.substring(26, 27);
		if(s27.equals("0"))
			s27 = "";
		else
			s27 = "√";
		s28 = arrgmt.substring(27, 28);
		if(s28.equals("0"))
			s28 = "";
		else
			s28 = "√";
		s29 = arrgmt.substring(28, 29);
		if(s29.equals("0"))
			s29 = "";
		else
			s29 = "√";
		s30 = arrgmt.substring(29, 30);
		if(s30.equals("0"))
			s30 = "";
		else
			s30 = "√";
		s31 = arrgmt.substring(30, 31);
		if(s31.equals("0"))
			s31 = "";
		else
			s31 = "√";
		s32 = arrgmt.substring(31, 32);
		if(s32.equals("0"))
			s32 = "";
		else
			s32 = "√";
		s33 = arrgmt.substring(32, 33);
		if(s33.equals("0"))
			s33 = "";
		else
			s33 = "√";
		s34 = arrgmt.substring(33, 34);
		if(s34.equals("0"))
			s34 = "";
		else
			s34 = "√";
		s35 = arrgmt.substring(34, 35);
		if(s35.equals("0"))
			s35 = "";
		else
			s35 = "√";
		
		disconnect();
		return "SUCCESS";
	}
	/*******************************************************************************/
	public String searchMyself(){
		userId = UsersAction.ID;
		String sql = "select * from teachers where userid = '"+userId +"'";
		connect();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				myself = new Teachers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
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
	
	
	/***********************Get & Set***********************************/
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
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		TeachersAction.userId = userId;
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
		TeachersAction.relatedStudent = relatedStudent;
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
		TeachersAction.relatedTeacher = relatedTeacher;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS3() {
		return s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
	}

	public String getS4() {
		return s4;
	}

	public void setS4(String s4) {
		this.s4 = s4;
	}

	public String getS5() {
		return s5;
	}

	public void setS5(String s5) {
		this.s5 = s5;
	}

	public String getS6() {
		return s6;
	}

	public void setS6(String s6) {
		this.s6 = s6;
	}

	public String getS7() {
		return s7;
	}

	public void setS7(String s7) {
		this.s7 = s7;
	}

	public String getS8() {
		return s8;
	}

	public void setS8(String s8) {
		this.s8 = s8;
	}

	public String getS9() {
		return s9;
	}

	public void setS9(String s9) {
		this.s9 = s9;
	}

	public String getS10() {
		return s10;
	}

	public void setS10(String s10) {
		this.s10 = s10;
	}

	public String getS11() {
		return s11;
	}

	public void setS11(String s11) {
		this.s11 = s11;
	}

	public String getS12() {
		return s12;
	}

	public void setS12(String s12) {
		this.s12 = s12;
	}

	public String getS13() {
		return s13;
	}

	public void setS13(String s13) {
		this.s13 = s13;
	}

	public String getS14() {
		return s14;
	}

	public void setS14(String s14) {
		this.s14 = s14;
	}

	public String getS15() {
		return s15;
	}

	public void setS15(String s15) {
		this.s15 = s15;
	}

	public String getS16() {
		return s16;
	}

	public void setS16(String s16) {
		this.s16 = s16;
	}

	public String getS17() {
		return s17;
	}

	public void setS17(String s17) {
		this.s17 = s17;
	}

	public String getS18() {
		return s18;
	}

	public void setS18(String s18) {
		this.s18 = s18;
	}

	public String getS19() {
		return s19;
	}

	public void setS19(String s19) {
		this.s19 = s19;
	}

	public String getS20() {
		return s20;
	}

	public void setS20(String s20) {
		this.s20 = s20;
	}

	public String getS21() {
		return s21;
	}

	public void setS21(String s21) {
		this.s21 = s21;
	}

	public String getS22() {
		return s22;
	}

	public void setS22(String s22) {
		this.s22 = s22;
	}

	public String getS23() {
		return s23;
	}

	public void setS23(String s23) {
		this.s23 = s23;
	}

	public String getS24() {
		return s24;
	}

	public void setS24(String s24) {
		this.s24 = s24;
	}

	public String getS25() {
		return s25;
	}

	public void setS25(String s25) {
		this.s25 = s25;
	}

	public String getS26() {
		return s26;
	}

	public void setS26(String s26) {
		this.s26 = s26;
	}

	public String getS27() {
		return s27;
	}

	public void setS27(String s27) {
		this.s27 = s27;
	}

	public String getS28() {
		return s28;
	}

	public void setS28(String s28) {
		this.s28 = s28;
	}

	public String getS29() {
		return s29;
	}

	public void setS29(String s29) {
		this.s29 = s29;
	}

	public String getS30() {
		return s30;
	}

	public void setS30(String s30) {
		this.s30 = s30;
	}

	public String getS31() {
		return s31;
	}

	public void setS31(String s31) {
		this.s31 = s31;
	}

	public String getS32() {
		return s32;
	}

	public void setS32(String s32) {
		this.s32 = s32;
	}

	public String getS33() {
		return s33;
	}

	public void setS33(String s33) {
		this.s33 = s33;
	}

	public String getS34() {
		return s34;
	}

	public void setS34(String s34) {
		this.s34 = s34;
	}

	public String getS35() {
		return s35;
	}

	public void setS35(String s35) {
		this.s35 = s35;
	}

	public String getS36() {
		return s36;
	}

	public void setS36(String s36) {
		this.s36 = s36;
	}

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

	public String getArrangement() {
		return arrangement;
	}

	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getViewTeacher() {
		return viewTeacher;
	}

	public void setViewTeacher(String viewTeacher) {
		this.viewTeacher = viewTeacher;
	}

	public static String getPassTeacherUserId() {
		return passTeacherUserId;
	}

	public static void setPassTeacherUserId(String passTeacherUserId) {
		TeachersAction.passTeacherUserId = passTeacherUserId;
	}

}
