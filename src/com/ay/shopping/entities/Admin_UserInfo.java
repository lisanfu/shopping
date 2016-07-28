package com.ay.shopping.entities;

public class Admin_UserInfo {
	private int admin_userID;
	private String admin_username;
	private String admin_userpwd;
	public int getAdmin_userID() {
		return admin_userID;
	}
	public void setAdmin_userID(int admin_userID) {
		this.admin_userID = admin_userID;
	}
	@Override
	public String toString() {
		return "Admin_UserInfo [admin_userID=" + admin_userID
				+ ", admin_username=" + admin_username + ", admin_userpwd="
				+ admin_userpwd + "]";
	}
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public String getAdmin_userpwd() {
		return admin_userpwd;
	}
	public void setAdmin_userpwd(String admin_userpwd) {
		this.admin_userpwd = admin_userpwd;
	}
	

}
