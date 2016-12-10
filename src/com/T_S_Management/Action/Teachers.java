package com.T_S_Management.Action;

public class Teachers {
	
	private String id;
	private String name;
	private String title;
	private String office;
	private String tel;
	private String photo;
	private String introduce;
	private String mail;
	private String userId;
	private String college;
	private String arrangement;
	Teachers(){}
	Teachers(String id, String name, String title, String office, String tel, String photo, String introduce, String mail, String userId, String college, String arrangement){
		this.setId(id);
		this.setName(name);
		this.setTitle(title);
		this.setOffice(office);
		this.setTel(tel);
		this.setPhoto(photo);
		this.setMail(mail);
		this.setIntroduce(introduce);
		this.setUserId(userId);
		this.setCollege(college);
		this.setArrangement(arrangement);
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getArrangement() {
		return arrangement;
	}
	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}

}

