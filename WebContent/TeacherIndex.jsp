<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html style="height: 100%;">
  <head>
   <link rel="stylesheet" href="css/main.css">
  <!--  <meta name="viewport" content="width=device-width, initial-scale=1" /> -->
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

  </style>
    <title>教师主页</title>
    　
  </head>
  
 <body style="height: 100%;">
  <!-- <div id="formbackground" style="position:absolute; width:100%; height:100%; z-index:-1">  
  	<img src="imge/image1.jpg" height="100%" width="100%"/>  
  </div>  -->

  	<div style="text-align:center;height: 33%;">
  	  <a href="TeacherInfo.action" >个人信息</a>
    </div>
    <div style="text-align:center;height: 33%;">
  	  <a href="viewStudents.action" >申请管理</a>
    </div>
	<div style="text-align:center;height: 33%;">
     <a href="<%=request.getContextPath()%>/teacherViewArrangement.action">本周日程安排</a>
    </div> 
  </body>
</html>

