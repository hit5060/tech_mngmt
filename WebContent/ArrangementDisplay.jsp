	<%@ page language="java" import="java.sql.*,java.io.*,java.util.*, com.T_S_Management.Action.TeachersAction,com.opensymphony.xwork2.ActionContext"%>
		<%@ page contentType="text/html;charset=utf-8"%>
		<%@ taglib prefix="s" uri="/struts-tags"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>日程展示</title>
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
		<h2>本周日程安排</h2>
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
			<th>
				<%  
                    out.print("周日");  
                %>
			</th>
			
		</tr>


		<tr>
			<th>
				<%  
                    out.print("一二节课");  
                %>
			</th>
			<td>${s1}</td>
			<td>${s2}</td>
			<td>${s3}</td>
			<td>${s4}</td>
			<td>${s5}</td>
			<td>${s6}</td>
			<td>${s7}</td>
		</tr>
		
			<tr>
			<th>
				<%  
                    out.print("三四节课");  
                %>
			</th>
			<td>${s8}</td>
			<td>${s9}</td>
			<td>${s10}</td>
			<td>${s11}</td>
			<td>${s12}</td>
			<td>${s13}</td>
			<td>${s14}</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("五六节课");  
                %>
			</th>
			<td>${s15}</td>
			<td>${s16}</td>
			<td>${s17}</td>
			<td>${s18}</td>
			<td>${s19}</td>
			<td>${s20}</td>
			<td>${s21}</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("七八节课");  
                %>
			</th>
			<td>${s22}</td>
			<td>${s23}</td>
			<td>${s24}</td>
			<td>${s25}</td>
			<td>${s26}</td>
			<td>${s27}</td>
			<td>${s28}</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("晚课");  
                %>
			</th>
			<td>${s29}</td>
			<td>${s30}</td>
			<td>${s31}</td>
			<td>${s32}</td>
			<td>${s33}</td>
			<td>${s34}</td>
			<td>${s35}</td>
		</tr>	
	</table>
	</center>
	
<%-- 	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %> --%>
    
    
    <a href="Apply.jsp"><input type=button value="修改" /></a>
    
    <a href="javascript:;" onclick="location='TeacherIndex.jsp'"><input
			type=button value="返回主页" /></a>
</div>
</body>
</html>