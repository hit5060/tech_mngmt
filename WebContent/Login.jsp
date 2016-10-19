<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<br>

<br>
   <div style="text-align: center;">
   <h2>
			<font size=7em>登陆</font>
		</h2>
		<br>
   <center>
     <s:form action="login">
           <s:textfield name="nuserId" label="用户名"/>
           <s:textfield name="npassword" label="密   码" />
           <s:submit value="登陆"/>     
     </s:form>
  </center>
   
     
     <a href="javascript:;" onclick="location='StudentRegist.jsp'"><input
			type=button value="学生注册" /></a>
	 <a href="javascript:;" onclick="location='TeacherRegist.jsp'"><input
			type=button value="教师注册" /></a>
	</div>
</body>
</html>