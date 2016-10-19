<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script>
function display_alert()
  {
  alert("添加成功!");
  }
</script>

<html>
<head>
<style type="text/css">
body {
	font-family: 微软雅黑, 宋体;
	font-size: 1.5em;
	color: black;
}
</style>
<title>教师注册</title>
</head>

<body>
	<%-- <s:property value="tips"/> --%>
	<div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image2.jpg" height="100%" width="100%" />
	</div>
	<div style="text-align: center;">
		<h2>教师注册</h2>
	</div>
	<center>
		<s:form action="TeacherRegist">
			<s:textfield name="nuserId" label="用户名" />
			<s:textfield name="npassword" label="密码" />
			<div align="center">
				<s:submit value="确定" />
			</div>
		</s:form>
	</center>
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location='Login.jsp'"><input
			type=button value="返回登陆界面" /></a>
	</div>
</body>
</html>
