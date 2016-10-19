package com.T_S_Management.Action;

public class Users {
	private String userId;
	private String password;
	private String property;
	
	Users(){}
	Users(String userId, String password, String property){
		this.userId = userId;
		this.password = password;
		this.property = property;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
}
