	<%@ page language="java" import="java.sql.*,java.io.*,java.util.*, com.T_S_Management.Action.TeachersAction,com.opensymphony.xwork2.ActionContext"%>
		<%@ page contentType="text/html;charset=utf-8"%>
		<%@ taglib prefix="s" uri="/struts-tags"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>申请</title>
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
table {
	text-align:center;
	border:none;
	width: 100%;
	margin-top:2em;
	font-size:1.5em;
}

td{
	border:none;
}

body {
	font-family: "微软雅黑";
	font-size: 1.5em;
}

h2{
	text-align:center;
	font-size:3em;
	margin:0;
}
div{
	text-align:center;

}
</style>
</head>

<body>
	<!-- <div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image4.jpg" height="100%" width="100%" />
	</div> -->
	
	 <%  
        //驱动程序名   
        String driverName = "com.mysql.jdbc.Driver";  
        //数据库用户名   
        String userName = "root";  
        //密码   
        String userPasswd = "960927";  
        //数据库名   
        String dbName = "TSM";  
        //表名   
        String tableName = "teachers";  
        //联结字符串   
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="  + userName + "&password=" + userPasswd;  
        Class.forName("com.mysql.jdbc.Driver").newInstance();  
        Connection connection = DriverManager.getConnection(url);  
        Statement statement = connection.createStatement();  
		String sql = "SELECT * FROM teachers ";
        ResultSet rs = statement.executeQuery(sql);  
    %> 
		<h2>所有教师</h2>
		<div>
	<center>
	<form>
	<table>
		<tr>
			<th>
				<%  
                    out.print("");  
                %>
			</th>
			<th>
				<%  
                    out.print("周日");  
                %>
			</th>
			<th>
				<%  
                    out.print("周一");  
                %>
			</th>
			<th>
				<%  
                    out.print("周二");  
                %>
			</th>
			<th>
				<%  
                    out.print("周三");  
                %>
			</th>
			<th>
				<%  
                    out.print("周四");  
                %>
			</th>
			<th>
				<%  
                    out.print("周五");  
                %>
			</th>
			<th>
				<%  
                    out.print("周六");  
                %>
			</th>
			
		</tr>


		<tr>
			<th>
				<%  
                    out.print("一二节课");  
                %>
			</th>
			<td>
			
		   	<input type="radio" name="s1" value="1" checked>√
		   	<br>
			<input type="radio" name="s1" value="0">×
		
			</td>
			<td>
		   <!-- 塞东西 表单周一 -->
			<input type="radio" name="s2" value="1" checked>√	<br>
			<input type="radio" name="s2" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周二 -->
			<input type="radio" name="s3" value="1" checked>√	<br>
			<input type="radio" name="s3" value="0">×		
			</td>
			<td>
		   <!-- 塞东西 表单周三-->
			<input type="radio" name="s4" value="1" checked>√	<br>
			<input type="radio" name="s4" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周四 -->
			<input type="radio" name="s5" value="1" checked>√	<br>
			<input type="radio" name="s5" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周五-->
			<input type="radio" name="s6" value="1" checked>√	<br>
			<input type="radio" name="s6" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周六 -->
			<input type="radio" name="s7" value="1" checked>√	<br>
			<input type="radio" name="s7" value="0">×
			</td>
		</tr>
			
			<tr>
			<th>
				<%  
                    out.print("三四节课");  
                %>
			</th>
			<td>
		   <!-- 塞东西 表单周日 -->
			<input type="radio" name="s8" value="1" checked>√	<br>
			<input type="radio" name="s8" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周一 -->
			<input type="radio" name="s9" value="1" checked>√	<br>
			<input type="radio" name="s9" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周二 -->
			<input type="radio" name="s10" value="1" checked>√	<br>
			<input type="radio" name="s10" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周三-->
			<input type="radio" name="s11" value="1" checked>√	<br>
			<input type="radio" name="s11" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周四 -->
			<input type="radio" name="s12" value="1" checked>√	<br>
			<input type="radio" name="s12" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周五-->
			<input type="radio" name="s13" value="1" checked>√	<br>
			<input type="radio" name="s13" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周六 -->
			<input type="radio" name="s14" value="1" checked>√	<br>
			<input type="radio" name="s14" value="0">×
			</td>
			
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("五六节课");  
                %>
			</th>
			<td>
		   <!-- 塞东西 表单周日 -->
			<input type="radio" name="s15" value="1" checked>√	<br>
			<input type="radio" name="s15" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周一 -->
			<input type="radio" name="s16" value="1" checked>√	<br>
			<input type="radio" name="s16" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周二 -->
			<input type="radio" name="s17" value="1" checked>√	<br>
			<input type="radio" name="s17" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周三-->
			<input type="radio" name="s18" value="1" checked>√	<br>
			<input type="radio" name="s18" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周四 -->
			<input type="radio" name="s19" value="1" checked>√	<br>
			<input type="radio" name="s19" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周五-->
			<input type="radio" name="s20" value="1" checked>√	<br>
			<input type="radio" name="s20" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周六 -->
			<input type="radio" name="s21" value="1" checked>√	<br>
			<input type="radio" name="s21" value="0">×
			</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("七八节课");  
                %>
			</th>
			<td>
		   <!-- 塞东西 表单周日 -->
			<input type="radio" name="s22" value="1" checked>√	<br>
			<input type="radio" name="s22" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周一 -->
			<input type="radio" name="s23" value="1" checked>√	<br>
			<input type="radio" name="s23" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周二 -->
			<input type="radio" name="s24" value="1" checked>√	<br>
			<input type="radio" name="s24" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周三-->
			<input type="radio" name="s25" value="1" checked>√	<br>
			<input type="radio" name="s25" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周四 -->
			<input type="radio" name="s26" value="1" checked>√	<br>
			<input type="radio" name="s26" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周五-->
			<input type="radio" name="s27" value="1" checked>√	<br>
			<input type="radio" name="s27" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周六 -->
			<input type="radio" name="s28" value="1" checked>√	<br>
			<input type="radio" name="s28" value="0">×
			</td>
		</tr>
		
		<tr>
			<th>
				<%  
                    out.print("晚课");  
                %>
			</th>
			<td>
		   <!-- 塞东西 表单周日 -->
			<input type="radio" name="s29" value="1" checked>√	<br>
			<input type="radio" name="s29" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周一 -->
			<input type="radio" name="s30" value="1" checked>√	<br>
			<input type="radio" name="s30" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周二 -->
			<input type="radio" name="s31" value="1" checked>√	<br>
			<input type="radio" name="s31" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周三-->
			<input type="radio" name="s32" value="1" checked>√	<br>
			<input type="radio" name="s32" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周四 -->
			<input type="radio" name="s33" value="1" checked>√	<br>
			<input type="radio" name="s33 value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周五-->
			<input type="radio" name="s34" value="1" checked>√	<br>
			<input type="radio" name="s34" value="0">×
			</td>
			<td>
		   <!-- 塞东西 表单周六 -->
			<input type="radio" name="s35" value="1" checked>√	<br>
			<input type="radio" name="s35" value="0">×
			</td>
		</tr>	
	</table>
	<input type="submit" value="确定">
	</form>
	</center>
	
	<%  
        rs.close();  
        statement.close();  
        connection.close();  
    %>
    
    
    <a href="javascript:;" onclick="location.href='javascript:history.go(-1);'"><input
			type=button value="返回" /></a>
</div>
</body>
</html>