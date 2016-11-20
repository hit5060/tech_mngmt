package com.T_S_Management.Action;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

 

import org.apache.commons.io.FileUtils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.sun.jmx.snmp.Timestamp;

public class UploadFileAction extends ActionSupport {
	
	private Connection conn = null;

	private static final long serialVersionUID = 1L;

	private File uploadFile;// 得到上传的文件

       private String uploadFileContentType;// 得到文件的类型

       private String uploadFileName;// 得到文件的名称

       static String URL = "jdbc:mysql://localhost:3306/TSM";
   	static String username = "root";
   	static String password = "960927";
   	
       public File getUploadFile() {

              return uploadFile;

       }

 

       public void setUploadFile(File uploadFile) {

              this.uploadFile = uploadFile;

       }

 

       public String getUploadFileContentType() {

              return uploadFileContentType;

       }

 

       public void setUploadFileContentType(String uploadFileContentType) {

              this.uploadFileContentType = uploadFileContentType;

       }

 

       public String getUploadFileName() {

              return uploadFileName;

       }

 

       public void setUploadFileName(String uploadFileName) {

              this.uploadFileName = uploadFileName;

       }

 

       //上传文件

       public String upload() throws Exception {

    	   	System.out.println("here!0");
              String realpath = ServletActionContext.getServletContext().getRealPath(

                            "/images");
              System.out.println("1111realpath:"+realpath);

              File dir = new File(realpath);

              if (!dir.exists()) {

                     dir.mkdir();

              }

             

              if(uploadFileContentType.equals("image/jpeg")){
            	  System.out.println("here1!");
                     uploadFileContentType=".jpg";                 

              }else if(  uploadFileContentType.equals("image/png")){
            	  System.out.println("here2!");
                     uploadFileContentType=".png";                

              } else if(uploadFileContentType.equals("image/gif")){
            	  System.out.println("here3!");
                     uploadFileContentType=".gif";                  

              }            
              System.out.println("here4!");
              uploadFileName="image"+new Timestamp().getDateTime()+uploadFileContentType;           
              FileUtils.copyFile(uploadFile, new File(dir, uploadFileName));
              saveImage("teachers",realpath);
              saveImage("students",realpath);
              return SUCCESS;

       }
       
       /***********************项目功能函数************************/
       private void connect() {
   		try {
   			
   			Class.forName("com.mysql.jdbc.Driver");
   			conn = DriverManager.getConnection(URL, username, password);
   			System.out.println("connected!");
   		} catch (Exception e) {
   			System.out.println(e.getMessage());
   		}
   	}
   	
   	private void disconnect() {
   		if (conn != null) {
   			try {
   				conn.close();
   			} catch (Exception e) {
   			}
   		}
   	}
   	
   	private void saveImage(String user,String photo){
   		connect();
   		System.out.println("存储照片路径");
   		String userId = UsersAction.ID;
   		//String userId = "1001";
		ActionContext.getContext().put("teacherID", userId);
		System.out.println("上传者："+userId);
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
		
			String sql = "update "+user+" set photo = '" +photo+"' where userId = '"+userId+"'";
			System.out.println("更新照片路径语句："+sql);
			//System.out.println(sql);
			result = stmt.executeUpdate(sql);
			System.out.println("result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
   		
   		disconnect();
   	}
   	/***************************************************/
}