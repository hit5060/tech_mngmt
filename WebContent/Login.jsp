<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<!-- <link rel="stylesheet" href="https://necolas.github.io/normalize.css/5.0.0/normalize.css">
 -->
 <link rel="stylesheet" href="css/main.css">
<!-- <link rel="stylesheet" href="css/main.css"> -->
<style type="text/css">
table {
	border: 0px #CCCCCC solid;
	width: 50%;
}

td, th {
	height: 30px;
	border: #CCCCCC 0px solid;
	text-align: center;
}

body {
	font-family: 微软雅黑;
	font-size: 1.5em；
}
h2{
	font-size:5em;
	font-family:"微软雅黑";
	margin:0;
}
</style>
</head>
<body>
   <div style="text-align: center">
   <h2>登陆</h2>
   <center>
   <table>
     <s:form action="login" >
           <s:textfield name="nuserId" label="用户名"/>
           <s:textfield name="npassword" label="密   码" />
           <s:submit value="登 陆"/>     
     </s:form>
     </table>
  </center>
     <a href="javascript:;" onclick="location='StudentRegist.jsp'"><input
			type=button value="学生注册" /></a>
	 <a href="javascript:;" onclick="location='TeacherRegist.jsp'"><input
			type=button value="教师注册" /></a>
	</div>
</body>
</html>