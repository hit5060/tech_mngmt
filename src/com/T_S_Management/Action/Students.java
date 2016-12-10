package com.T_S_Management.Action;

public class Students {
	private String id;
	private String name;
	private String major;
	private String number;
	private String tel;
	private String photo;
	private String introduce;
	private String mail;
	private String userId;
	private String application;
	private String time;

	Students(){}
	Students(String id, String name, String major, String number, String tel, String photo, String introduce, String mail,String userId, String application,String time){
		this.id = id;
		this.name = name;
		this.number = number;
		this.major = major;
		this.tel = tel;
		this.photo = photo;
		this.mail = mail;
		this.introduce = introduce;
		this.userId = userId;
		this.application = application;
		this.time = time;
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
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
