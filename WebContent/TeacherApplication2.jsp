<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生申请管理</title>
<s:head />
</head>
<body>
<div style="text-align:center;">
申请教师
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
接受教师
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
	拒绝教师
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
	
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><input
			type=button value="返回" /></a>
	</div>
	
	</div>
</body>
</html>