	<%@ page language="java" import="java.sql.*,java.io.*,java.util.*, com.T_S_Management.Action.TeachersAction,com.opensymphony.xwork2.ActionContext"%>
		<%@ page contentType="text/html;charset=utf-8"%>
		<%@ taglib prefix="s" uri="/struts-tags"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>所有老师</title>
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
table {
	text-align:center;
	border:none;
	width: 80%;
	margin-top:2em;
	font-size:1.5em;
}

td{
	border:none;
}

body {
	background-image: url(img/3.jpg);
	background-attachment:fixed;
	font-family: "微软雅黑";
	font-size: 1.5em;
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
	
	 <%  
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
    %> 
		<h2>所有教师</h2>
		<div>
	<center>
	<table>
		<tr>
			<th>
				<%  
                    out.print("姓名");  
                %>
			</th>
			<th>
				<%  
                    out.print("学院");  
                %>
			</th>
	
			<th>
				<%  
                    out.print("操作");  
                %>
			</th>
		</tr>

		<%  
            while (rs.next()) {  
        %>
		<tr>
			<td>
				<%  
                    out.print(rs.getString(2));  
                %>
			</td>
			<td>
				<%  
                    out.print(rs.getString(13));  
                %>
			</td>
			
			<td>
				<a
				href="<%=request.getContextPath()%>/DetailTeacherInfo.action?userId=<%=rs.getString(12)%>">查看详细信息</a>
				<br>
				
				<!-- 发出申请需要加传参  -->
				<a
				href="<%=request.getContextPath()%>/StudentApply.action?userid=<%=rs.getString(12)%>">发出申请</a>
			</td>
		</tr>
		<%  
            }  
        %>
	</table>
	</center>
	
	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %>
    
    <a href="javascript:;" onclick="location='StudentSearch.jsp'"><input
			type=button value="教师查询" /></a>
    
    <a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><input
			type=button value="返回" /></a>
</div>
</body>
</html>