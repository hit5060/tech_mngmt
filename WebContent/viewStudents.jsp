<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="css/main.css">
<title>教师申请管理</title>
<s:head />
<style type="text/css">
table {
	border: 0px #CCCCCC solid;
	width: 80%;
}

td, th {
	height: 30px;
	text-align: center;
}

body {
	background-image: url(img/3.jpg);
	background-attachment:fixed;
	font-family: 微软雅黑, 宋体;
	font-size: 1.5em;
	color: black;
}
h3{
	font-size:2.5em;
	font-family:"微软雅黑";
	margin-bottom:1em;
}
</style>
</head>
<body>

<div style="text-align:center;">
<h3>申请学生</h3>
<center>
<table align="center">
		<tr>
			<th>学生姓名  </th>
			<th>专业           </th>
			<th>学号           </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>
			<th>操作            </th>
		</tr>
		<s:iterator value="appliedStudents" var = "var">
			<tr>
		 		<td><s:property value="name" /></td>
				<td><s:property value="#var.major" /></td>
				<td><s:property value="#var.number" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				<td>
				<a
					href="<%=request.getContextPath()%>/accept.action?acceptedStudent=<s:property value="#var.userId" />">接受</a>
					
				</a>
				<a 
					href="<%=request.getContextPath()%>/reject.action?rejectedStudent=<s:property value="#var.userId" />">拒绝</a>
					
				</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	</center>
<h3>已接受学生</h3>
<center>
	<table align="center">
		<tr>
			<th>学生姓名  </th>
			<th>专业           </th>
			<th>学号           </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>
		</tr>
		<s:iterator value="acceptedStudents" var = "var">
			<tr>
		 		<td><s:property value="name" /></td>
				<td><s:property value="#var.major" /></td>
				<td><s:property value="#var.number" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
			</tr>
		</s:iterator>
	</table>
	</center>
<h3>已拒绝学生</h3>
<center>
	<table align="center">
		<tr>
			<th>学生姓名  </th>
			<th>专业           </th>
			<th>学号           </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>
		</tr>
		<s:iterator value="rejectedStudents" var = "var">
			<tr>
		 		<td><s:property value="name" /></td>
				<td><s:property value="#var.major" /></td>
				<td><s:property value="#var.number" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
			</tr>
		</s:iterator>
	</table>
	</center>
	
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><input
			type=button value="返回" /></a>
	</div>
	</div>
</body>
</html>