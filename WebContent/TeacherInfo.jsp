<span style="font-size: 12px;"><span style="font-size: 14px;">
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
<title>教师个人信息</title>
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
		temp = ActionContext.getContext().get("teacherID").toString();
		System.out.println(temp);
		String sql = "SELECT * FROM teachers where userid="+ temp;
        ResultSet rs = statement.executeQuery(sql);  
    %> 
    
	<div style="text-align: center;">
		<h2>
			<font size=9em>详细信息</font>
		</h2>
	</div>
	<br>
	<br>
	<table align="center">
		<%  
            while (rs.next()) {  
        %>
		<tr>
			<th>
				<%  
                    out.print("姓名");  
                %>
			</th>
			<th>
				<%  
					out.print(rs.getString(2));
                %>
			</th>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("所在学院");  
                %>
			</th>
			<th>
				<%  
					out.print(rs.getString(13));
                %>
			</th>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("职称");  
                %>
			</th>
			<th>
				<%  
					out.print(rs.getString(3));
                %>
			</th>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("办公地点");  
                %>
			</th>
			<th>
				<%  
					out.print(rs.getString(4));
                %>
			</th>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("电话号码");  
                %>
			</th>
			<th>
				<%  
				 	out.print(rs.getString(5));
                %>
			</th>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("个人简介");  
                %>
			</th>
			<th>
				<%  
					out.print(rs.getString(7));
                %>
			</th>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("邮箱");  
                %>
			</th>
			<th>
				<%  
					out.print(rs.getString(8));
                %>
			</th>
		</tr>
		
		<%  
            }
        %>
		
		
		
		
		
		
		<%-- 	<th>
				
			</th>
			<th>
				<%  
                    out.print("出版社");  
                %>
			</th>
			<th>
				<%  
                    out.print("出版时间");  
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
                    out.print(rs.getString(1));  
                %>
			</td>
			<td>
				<%  
                    out.print(rs.getString(2));  
                %>
			</td>
			<td>  
                <%  
                    out.print(rs.getString(3));  
                %>  
            </td>  
			<td>
				<%  
                
                    out.print(rs.getString(6));  
                %>
			</td>
			<td>
				<%  
                    out.print(rs.getString(4));  
                %>
			</td>
			<td>
				<%  
                    out.print(rs.getString(5));  
                %>
			</td>
			<td><a
				href="<%=request.getContextPath()%>/passISBN.action?ISBN=<%=rs.getString(1)%>&AuthorID=<%=rs.getString(3)%>">修改信息</a>
				<a
				href="<%=request.getContextPath()%>/deleBook.action?ISBN=<%=rs.getString(1)%>">删除</a>
				<a
				href="<%=request.getContextPath()%>/passAuthorID.action?AuthorID=<%=rs.getString(3)%>">查看作者信息</a>
			</td>
		</tr>
		<%  
            }  
        %> --%>
	</table>
	
	
	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %>
    
    <a href="javascript:;" onclick="location='TeacherInfoChange.jsp'"><input
			type=button value="修改" /></a>
	<br>
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location='TeacherIndex.jsp'"><input
			type=button value="返回主页" /></a>
	</div>
</body>
</html>