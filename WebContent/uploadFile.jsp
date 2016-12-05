<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title>My JSP 'uploadFile.jsp' starting page</title>

<script Language="JavaScript" Type="text/javascript">

       function validateForm(frmUpload) {

                //检查是否提交了上传文件否弹出提示不需要这一功能的删除即可   

              if (document.all.uploadFile.value == "")

              {

                     alert("没有选择上传的文件！");

                     frmUpload.uploadFile.focus();

                     return false;

              }     

                //截取提交上传文件的扩展名  

              var ext = frmUpload.uploadFile.value.match(/^(.*)(\.)(.{1,8})$/)[3];

              ext = ext.toLowerCase(); //设置允许上传文件的扩展名           

              if (ext ==  "jpg" || ext == "gif" || ext=="png") {

                     return true;

              } else {

                     alert("只允许上传 .jpg或gif 或png文件，请重新选择需要上传的文件！");

                     return false;

              }

       }

</script>

</head>

 

<body>
<h2>上传图片文件</h2>

       <hr>

       <form name="frmUpload" enctype="multipart/form-data"

              action="uploadfile" method="post" onsubmit="return validateForm(this)">

              <input type="file" name="uploadFile">  

              <input type="hidden" value=ext name="uploadFileContentType">           

               <input type="submit"    value="上传">            

       </form>

</body>

</html>