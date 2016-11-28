package com.T_S_Management.Action;

import java.io.File;

 

import javax.servlet.http.HttpServletResponse;

 

import org.apache.commons.io.FileUtils;

import org.apache.struts2.ServletActionContext;

 

import com.opensymphony.xwork2.ActionSupport;

import com.sun.jmx.snmp.Timestamp;

public class UploadFileAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private File uploadFile;// �õ��ϴ����ļ�

       private String uploadFileContentType;// �õ��ļ�������

       private String uploadFileName;// �õ��ļ�������

 

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

 

       //�ϴ��ļ�

       public String upload() throws Exception {

    	   System.out.println("here!");
              String realpath = ServletActionContext.getServletContext().getRealPath(

                            "/images");
              System.out.println("realpath:"+realpath);

              File dir = new File(realpath);

              if (!dir.exists()) {

                     dir.mkdir();

              }

             

              if(uploadFileContentType.equals("image/jpeg")){
            	  System.out.println("here!");

                     uploadFileContentType=".jpg";                 

              }else if(  uploadFileContentType.equals("image/png")){

                     uploadFileContentType=".png";                

              } else if(uploadFileContentType.equals("image/gif")){

                     uploadFileContentType=".gif";                  

              }            

              uploadFileName="image"+new Timestamp().getDateTime()+uploadFileContentType;           
              FileUtils.copyFile(uploadFile, new File(dir, uploadFileName));

              return SUCCESS;

       }

}