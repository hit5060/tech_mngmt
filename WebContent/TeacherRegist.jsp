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
 <link rel="stylesheet" href="css/main.css">
<style type="text/css">
table {
	border: 0px #CCCCCC solid;
	width: 50%;
	text-align:center;
}
h2{
	font-size:5em;
	font-family:"微软雅黑";
	margin:0;
}

body {
	background-image: url(img/3.jpg);
	background-attachment:fixed;
	font-family: 微软雅黑;
	font-size: 1.5em
}

</style>
<title>教师注册</title>
</head>

<body>
	<%-- <s:property value="tips"/> --%>
<!-- 	<div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image2.jpg" height="100%" width="100%" />
	</div> -->
	<div style="text-align: center;">
		<h2>教师注册</h2>
	</div>
	<center>
	<table>
		<s:form action="TeacherRegist">
			<s:textfield name="nuserId" label="用户名" />
			<s:textfield name="npassword" label="密码" />
			<s:submit value="确定" />
		</s:form>
	</table>
	</center>
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location='Login.jsp'"><input
			type=button value="返回登陆界面" /></a>
	</div>
</body>
</html>
