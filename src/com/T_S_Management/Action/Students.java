package com.T_S_Management.Action;

public class Students {
	private String id;
	private String name;
	private String major;
	private String number;
	private String tel;
	private String introduce;
	private String mail;
	private String apllied;
	private String accepted;
	private String rejected;
	private String userId;

	Students(){}
	Students(String id, String name, String major, String number, String tel, String introduce, String mail, String applied, String accepted, String rejected, String userId){
		this.id = id;
		this.name = name;
		this.number = number;
		this.major = major;
		this.tel = tel;
		this.mail = mail;
		this.introduce = introduce;
		this.apllied = applied;
		this.accepted = accepted;
		this.rejected = rejected;
		this.userId = userId;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
}
