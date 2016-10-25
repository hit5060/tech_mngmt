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
<title>查找教师</title>
</head>

<body>
	<!-- <div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image4.jpg" height="100%" width="100%" />
	</div> -->
	<br>
	<br>
	<div style="text-align: center;">
		<h2>查找教师</h2>
	</div>
	<br>
	<center>
		<s:form action="Search">
			<s:textfield name="searchTeacher" label="关键字" />
			<br>
			<s:submit value="查找" />
		</s:form>
		<br> <br>
	</center>
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location='StudentIndex.jsp'"><input
			type=button value="返回主页" /></a>
	</div>
</body>
</html>
