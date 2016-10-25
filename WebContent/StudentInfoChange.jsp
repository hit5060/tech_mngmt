<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
<style type="text/css">
body {
	font-family: 微软雅黑, 宋体;
	font-size: 1.5em;
	color: black;
}
</style>
<title>学生信息修改</title>
</head>

<body>
	<%-- <s:property value="tips"/> --%>
	<!-- <div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image2.jpg" height="100%" width="100%" />
	</div> -->
	<div style="text-align: center;">
		<h2>学生信息修改</h2>
	</div>
	<center>
		<s:form action="modifyStudent">
			<s:textfield name="name" label="姓名" />
			<s:textfield name="number" label="学号" />
			<s:textfield name="major" label="专业" />
			<s:textfield name="tel" label="电话" />
			<s:textfield name="mail" label="邮箱" />
			<s:textfield name="introduce" label="简介" />			
			<div align="center">
				<s:submit value="修改" />
			</div>
		</s:form>
	</center>
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location='Login.jsp'"><input
			type=button value="返回登陆界面" /></a>
	</div>
</body>
</html>
