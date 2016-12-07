<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AllTeacher2</title>
<s:head />
</head>
<body>
全部教师
<table border="1">
		<tr>
			<th>教师姓名  </th>
			<th>学院           </th>
			<th>职称           </th>
			<th>办公室       </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>
			<th>操作            </th>
		</tr>
		<s:iterator value="allTeachers" var = "var">
			<tr>
				<td><s:property value="#var.name" /></td>
		 		<td><a
					href="<%=request.getContextPath()%>/teacherInfo.action?userId=<s:property value="userrId" />&qrauthorid=电话">
						<s:property value="college" />
				</a></td>
				<td><s:property value="#var.title" /></td>
				<td><s:property value="#var.office" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				<td><a
					href="<%=request.getContextPath()%>/apply.action?id=<s:property value="#var.id" />">
						<input type=button value="申请" style="width: 60px;">
				</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<table border="2">
		<tr>
			<th>教师姓名  </th>
			<th>学院           </th>
			<th>职称           </th>
			<th>办公室       </th>
			<th>电话           </th>
			<th>邮箱           </th>
			<th>简介           </th>
			<th>操作            </th>
		</tr>
		<s:iterator value="allTeachers" var = "var">
			<tr>
				<td><s:property value="#var.name" /></td>
		 		<td><a
					href="<%=request.getContextPath()%>/teacherInfo.action?userId=<s:property value="userrId" />&qrauthorid=电话">
						<s:property value="college" />
				</a></td>
				<td><s:property value="#var.title" /></td>
				<td><s:property value="#var.office" /></td>
				<td><s:property value="#var.tel" /></td>
				<td><s:property value="#var.mail" /></td>
				<td><s:property value="#var.introduce" /></td>
				<td><a
					href="<%=request.getContextPath()%>/apply.action?id=<s:property value="#var.id" />">
						<input type=button value="申请" style="width: 60px;">
				</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	
</body>
</html>