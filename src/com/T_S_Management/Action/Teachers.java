package com.T_S_Management.Action;

public class Teachers {
	
	private String id;
	private String name;
	private String title;
	private String office;
	private String tel;
	private String introduce;
	private String mail;
	private String apllied;
	private String accepted;
	private String rejected;
	private String userId;
	private String college;
	Teachers(){}
	Teachers(String id, String name, String title, String office, String tel, String introduce, String mail, String applied, String accepted, String rejected, String userId, String college){
		this.setId(id);
		this.setName(name);
		this.setTitle(title);
		this.setOffice(office);
		this.setTel(tel);
		this.setMail(mail);
		this.setIntroduce(introduce);
		this.setApllied(applied);
		this.setAccepted(accepted);
		this.setRejected(rejected);
		this.setUserId(userId);
		this.setCollege(college);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getApllied() {
		return apllied;
	}
	public void setApllied(String apllied) {
		this.apllied = apllied;
	}
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	public String getRejected() {
		return rejected;
	}
	public void setRejected(String rejected) {
		this.rejected = rejected;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}

}

