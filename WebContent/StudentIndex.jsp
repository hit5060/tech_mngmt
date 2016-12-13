<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html style="height: 100%;">
  <head>
   <link rel="stylesheet" href="css/main.css">
  <style type="text/css">
body{
	background-image: url(img/3.jpg);
	background-attachment:fixed;
	margin:0;
	padding:0;
	font-size:5em;
}

a{
	position:relative;
	top:1em;

}

#header{
	font-size:.7em;
	height:2em;
}
#header nav{
	font-size:.7em;
	line-height:1em;
}
#header nav .button{
	font-size:1em;
}
</style>
    <title>学生主页</title>
  </head>

 <body style="height: 100%;">
  <!-- <div id="formbackground" style="position:absolute; width:100%; height:100%; z-index:-1">  
  	<img src="imge/image1.jpg" height="100%" width="100%"/>  
  </div>  -->
  <header id="header" >
	<nav class="left">
		您以<a href="StudentInfo.action"></a>学生的身份登录
	</nav>
	<nav class = "right">
		<a href="Login.jsp" class="button alt">退出</a>
</header>
  
  	<div style="text-align:center;height: 33%;">
  	  <a href="StudentInfo.action" >个人信息</a>
  	</div>
  	<div style="text-align:center;height: 33%;">
      <a href="AllTeacher.jsp" >教师浏览</a>
    </div>
    <div style="text-align:center;height: 33%;">
  	  <a href="viewTeachers.action" >申请管理</a> 
  	</div>
  	<!-- <div style="text-align:center;height: 25%;"> 
  	  <a href="queryAll.action" >查看全部</a>   
  	</div> -->   
  </body>
</html>

