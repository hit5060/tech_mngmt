<%-- <%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>所有老师</title>
</head>
<body>
</body>
</html><span style="font-size: 12px;"><span style="font-size: 14px;"> --%>
		<%@ page language="java" import="java.sql.*,java.io.*,java.util.*, com.T_S_Management.Action.TeachersAction,com.opensymphony.xwork2.ActionContext"%>
		<%@ page contentType="text/html;charset=utf-8"%>
		<%@ taglib prefix="s" uri="/struts-tags"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

<style type="text/css">
table {
	border: 0px #CCCCCC solid;
	width: 80%;
}

td, th {
	height: 30px;
	border: #CCCCCC 0px solid;
	text-align: center;
}

body {
	font-family: 微软雅黑, 宋体;
	font-size: 1em;
	color: black;
}
</style>
<head>
<title>搜索结果</title>
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
        
        TeachersAction a = new TeachersAction();
        String temp;
		temp = ActionContext.getContext().get("searchTeacher").toString();
		System.out.println(temp);
		
		String sql = "SELECT * FROM teachers where name ="+temp;
        ResultSet rs = statement.executeQuery(sql);  
        
       
    %> 
    
	<div style="text-align: center;">
		<h2>
			<font size=9em>搜索结果</font>
		</h2>
	</div>
	<br>
	<br>
	
	<table align="center">
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
				<%-- <a
				href="<%=request.getContextPath()%>/Apply.action?userid=<%=rs.getString(12)%>">发出申请</a> --%>
			</td>
		</tr>
		<%  
            }  
        %>
        
       
	
	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %>
    </table>

    
    <div style="text-align: center;">
		<a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><input
			type=button value="返回" /></a>
	</div>
</body>
</html>