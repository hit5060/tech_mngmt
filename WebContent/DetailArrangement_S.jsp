	<%@ page language="java" import="java.sql.*,java.io.*,java.util.*, com.T_S_Management.Action.TeachersAction,com.opensymphony.xwork2.ActionContext"%>
		<%@ page contentType="text/html;charset=utf-8"%>
		<%@ taglib prefix="s" uri="/struts-tags"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生申请</title>
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
table {
	text-align:center;
	border:none;
	width: 100%;
	margin-top:2em;
	font-size:1.5em;
}

td{
	border:none;
}

body {
	background-image: url(img/3.jpg);
	background-attachment:fixed;
	font-family: 微软雅黑;
	font-size: 1.5em
}

h2{
	text-align:center;
	font-size:3em;
	margin:0;
}
div{
	text-align:center;

}
</style>
</head>

<body>
	<!-- <div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image4.jpg" height="100%" width="100%" />
	</div> -->
	
	<%--  <%  
        //驱动程序名   
        String driverName = "com.mysql.jdbc.Driver";  
        //数据库用户名   
        String userName = "root";  
        //密码   
        String userPasswd = "960927";  
        //数据库名   
        String dbName = "TSM";  
        //表名   
        String tableName = "teachers";  
        //联结字符串   
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="  + userName + "&password=" + userPasswd;  
        Class.forName("com.mysql.jdbc.Driver").newInstance();  
        Connection connection = DriverManager.getConnection(url);  
        Statement statement = connection.createStatement();  
		String sql = "SELECT * FROM teachers ";
        ResultSet rs = statement.executeQuery(sql);  
    %>  --%>
		<h2>教师日程安排</h2>
		<div>
	<center>
	<table>
		<tr>
			<th>
				<%  
                    out.print("");  
                %>
			</th>
			<th>
				<%  
                    out.print("周日");  
                %>
			</th>
			<th>
				<%  
                    out.print("周一");  
                %>
			</th>
			<th>
				<%  
                    out.print("周二");  
                %>
			</th>
			<th>
				<%  
                    out.print("周三");  
                %>
			</th>
			<th>
				<%  
                    out.print("周四");  
                %>
			</th>
			<th>
				<%  
                    out.print("周五");  
                %>
			</th>
			<th>
				<%  
                    out.print("周六");  
                %>
			</th>
			
		</tr>


		<tr>
			<th>
				<%  
                    out.print("一二节课");  
                %>
			</th>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s1}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s2}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s3}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s4}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s5}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s6}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s7}</a></td>
		</tr>
		
			<tr>
			<th>
				<%  
                    out.print("三四节课");  
                %>
			</th>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s8}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s9}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s10}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s11}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s12}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s13}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s14}</a></td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("五六节课");  
                %>
			</th>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s15}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s16}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s17}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s18}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s19}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s20}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s21}</a></td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("七八节课");  
                %>
			</th>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s22}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s23}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s24}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s25}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s26}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s27}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s28}</a></td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("晚课");  
                %>
			</th>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s29}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s30}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s31}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s32}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s33}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s34}</a></td>
			<td><a href="<%=request.getContextPath()%>/apply.action?appliedTeacher=${viewTeacher}">${s35}</a></td>
		</tr>	
	</table>
	</center>
	
<%-- 	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %> --%>
    
    
    <a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><input
			type=button value="返回" /></a>
</div>
</body>
</html>