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
<title>教师申请管理</title>
<s:head />
</head>
<body>

<div style="text-align:center;">
申请学生
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
		 		<td><a
					href="<%=request.getContextPath()%>/StudentInfo.action?userId=<s:property value="userId" />&qrauthorid=电话">
						<s:property value="name" />
				</a></td>
				<td><s:property value="#var.major" /></td>
				<td><s:property value="#var.number" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				<td><a
					href="<%=request.getContextPath()%>/teacherAccept.action?relatedStudent=<s:property value="#var.id" />">
						<input type=button value="接受" style="width: 60px;">
					
				</a>
				<a
					href="<%=request.getContextPath()%>/teacherReject.action?relatedStudent=<s:property value="#var.id" />">
						<input type=button value="拒绝" style="width: 60px;">
					
				</a>
				</td>
			</tr>
		</s:iterator>
	</table>
已接受学生
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
		<s:iterator value="acceptedStudents" var = "var">
			<tr>
		 		<td><a
					href="<%=request.getContextPath()%>/StudentInfo.action?userId=<s:property value="userId" />&qrauthorid=电话">
						<s:property value="name" />
				</a></td>
				<td><s:property value="#var.major" /></td>
				<td><s:property value="#var.number" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				<td><a
					href="<%=request.getContextPath()%>/accept.action?id=<s:property value="#var.id" />">
						<input type=button value="接受" style="width: 60px;">
					
				</a>
				<a
					href="<%=request.getContextPath()%>/reject.action?id=<s:property value="#var.id" />">
						<input type=button value="拒绝" style="width: 60px;">
					
				</a>
				</td>
			</tr>
		</s:iterator>
	</table>
已拒绝学生
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
		<s:iterator value="rejectedStudents" var = "var">
			<tr>
		 		<td><a
					href="<%=request.getContextPath()%>/StudentInfo.action?userId=<s:property value="userId" />&qrauthorid=电话">
						<s:property value="name" />
				</a></td>
				<td><s:property value="#var.major" /></td>
				<td><s:property value="#var.number" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				<td><a
					href="<%=request.getContextPath()%>/apply.action?id=<s:property value="#var.id" />">
						<input type=button value="接受" style="width: 60px;">
					
				</a>
				<a
					href="<%=request.getContextPath()%>/apply.action?id=<s:property value="#var.id" />">
						<input type=button value="拒绝" style="width: 60px;">
					
				</a>
				</td>
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