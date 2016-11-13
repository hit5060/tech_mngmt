<span style="font-size: 12px;"><span style="font-size: 14px;">
		<%@ page language="java" import="java.sql.*,java.io.*,java.util.*, com.T_S_Management.Action.StudentsAction,com.opensymphony.xwork2.ActionContext"%>
		<%@ page contentType="text/html;charset=utf-8"%>
		<%@ taglib prefix="s" uri="/struts-tags"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>


<head>
 <link rel="stylesheet" href="css/main.css">
<title>申请管理</title>
<style type="text/css">
table {
	text-align:center;
	border:none;
	width: 80%;
	font-size:1.5em;
}
th{
	border-right:1px solid #ccc;
	width:6em;
	}

td{
	height: 2em;
	border:none;
	text-align: center;
}

body {
	font-family: "微软雅黑";
	font-size: 1.5em;
}
h2{
	text-align:center;
	font-size:5em;
	margin:0;
}
div{
	text-align:center;
	margin:1em;
}
a{
	display:block;
	padding:1em;
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
        String tableName = "studenets";  
        //联结字符串   
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="  + userName + "&password=" + userPasswd;  
        Class.forName("com.mysql.jdbc.Driver").newInstance();  
        Connection connection = DriverManager.getConnection(url);  
        Statement statement = connection.createStatement();  
       	StudentsAction a = new StudentsAction();
        String temp;
		temp = ActionContext.getContext().get("studentID").toString();
		System.out.println(temp);
		String sql = "SELECT * FROM students where userid="+ temp;
        ResultSet rs = statement.executeQuery(sql);  
    %> 
		<h2>详细信息</h2>
 <div>
	<center>
	<table>
		<%  
            while (rs.next()) {  
        %>
		<tr>
			<th>
				<%  
                    out.print("姓名");  
                %>
			</th>
			<td>
				<%  
					out.print(rs.getString(2));
                %>
			</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("学号");  
                %>
			</th>
			<td>
				<%  
					out.print(rs.getString(4));
                %>
			</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("专业");  
                %>
			</th>
			<td>
				<%  
					out.print(rs.getString(3));
                %>
			</td>
		</tr>
		
		
		<tr>
			<th>
				<%  
                    out.print("电话号码");  
                %>
			</th>
			<td>
				<%  
				 	out.print(rs.getString(5));
                %>
			</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("个人简介");  
                %>
			</th>
			<td>
				<%  
					out.print(rs.getString(7));
                %>
			</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("邮箱");  
                %>
			</th>
			<td>
				<%  
					out.print(rs.getString(8));
                %>
			</td>
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
	</center>
	
	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %>
    
    	<a href="javascript:;" onclick="location='StudentInfoChange.jsp'"><input
			type=button value="修改" /></a>
		<a href="javascript:;" onclick="location='StudentIndex.jsp'"><input
			type=button value="返回主页" /></a>
	</div>
</body>
</html>