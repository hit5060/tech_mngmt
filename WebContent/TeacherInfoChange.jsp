<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
<link rel="stylesheet" href="css/main.css">
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
	font-size:5em;
	font-family:"微软雅黑";
	margin:0;
}
</style>
<title>教师信息修改</title>
</head>

<body>
	<%-- <s:property value="tips"/> --%>
	<!-- <div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image2.jpg" height="100%" width="100%" />
	</div> -->
	<div style="text-align: center;">
		<h2>教师信息修改</h2>
	<center>
	<table>
		<s:form action="modifyTeacher">
			<s:textfield name="name" label="姓名" />
			<s:textfield name="college" label="学院" />
			<s:textfield name="title" label="职称" />
			<s:textfield name="office" label="办公室" />
			<s:textfield name="tel" label="电话" />
			<s:textfield name="mail" label="邮箱" />
			<s:textarea  name="introduce" label="简介" />
			<s:submit value="修改" />
		</s:form>
		</table>
	</center>
		<a href="javascript:;" onclick="location='TeacherIndex.jsp'"><input
			type=button value="返回主页" /></a>
	</div>
</body>
</html>
