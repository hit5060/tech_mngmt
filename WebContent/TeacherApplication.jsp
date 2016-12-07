<span style="font-size: 12px;"><span style="font-size: 14px;">
		<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>
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
<title>申请管理</title>
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
        String userName = "zhouhaotian_lab2";  
        //密码   
        String userPasswd = "zombiez960927";  
        //数据库名   
        String dbName = "bookdb";  
        //表名   
        String tableName = "Book";  
        //联结字符串   
        String url = "jdbc:mysql://rrpmsushspsg.rds.sae.sina.com.cn:10083/" + dbName + "?user="  + userName + "&password=" + userPasswd;  
        Class.forName("com.mysql.jdbc.Driver").newInstance();  
        Connection connection = DriverManager.getConnection(url);  
        Statement statement = connection.createStatement();  
        String sql = "SELECT * FROM " + tableName;  
        ResultSet rs = statement.executeQuery(sql);  
    %>
	<div style="text-align: center;">
		<h2>
			<font size=9em>书 库</font>
		</h2>
	</div>
	<br>
	<br>
	<table align="center">
		<tr>
			<th>
				<%  
                    out.print("编号");  
                %>
			</th>
			<th>
				<%  
                    out.print("书名");  
                %>
			</th>
			<%--  <th>  
                <%  
                    out.print("作者");  
                %>  
            </th>   --%>
			<th>
				<%  
                    out.print("价格");  
                %>
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
			<%-- <td>  
                <%  
                    out.print(rs.getString(3));  
                %>  
            </td>   --%>
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
        %>
	</table>
	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %>
	<br>
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location='TeacherIndex.jsp'"><input
			type=button value="返回主页" /></a>
	</div>
</body>
</html>