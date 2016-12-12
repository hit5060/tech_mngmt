<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<link rel="stylesheet" href="css/main.css">
<title>学生申请管理</title>
<s:head />
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
	background-image: url(img/3.jpg);
	background-attachment:fixed;
	font-family: 微软雅黑, 宋体;
	font-size: 1em;
	color: black;
}
h3{
	font-size:3em;
	font-family:"微软雅黑";
	margin-bottom:1em;
}
</style>
</head>
<body>
<div style="text-align:center;">
<h3>申请教师</h3>
<center>
<table align="center">
		<tr>
			<th>教师姓名  </th>
			<th>学院           </th>
			<th>职称           </th>
			<th>办公室       </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>
			
		</tr>
		<s:iterator value="appliedTeachers" var = "var">
			<tr>
				<td><s:property value="#var.name" /></td>
		 		<td><s:property value="college" /></td>
				<td><s:property value="#var.title" /></td>
				<td><s:property value="#var.office" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				
			</tr>
		</s:iterator>
	</table>
<h3>接受教师</h3>
	<table align="center">
		<tr>
			<th>教师姓名  </th>
			<th>学院           </th>
			<th>职称           </th>
			<th>办公室       </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>
			
		</tr>
		<s:iterator value="acceptedTeachers" var = "var">
			<tr>
				<td><s:property value="#var.name" /></td>
		 		<td><s:property value="college" /></td>
				<td><s:property value="#var.title" /></td>
				<td><s:property value="#var.office" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				
			</tr>
		</s:iterator>
	</table>
	<h3>拒绝教师</h3>
	<table align="center">
		<tr>
			<th>教师姓名  </th>
			<th>学院           </th>
			<th>职称           </th>
			<th>办公室       </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>

		</tr>
		<s:iterator value="rejectedTeachers" var = "var">
			<tr>
				<td><s:property value="#var.name" /></td>
		 		<td><s:property value="college" /></td>
				<td><s:property value="#var.title" /></td>
				<td><s:property value="#var.office" /></td>
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