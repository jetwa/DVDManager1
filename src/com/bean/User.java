package com.bean;

public class User {
	private int userId;
	private String userAccount;
	private String userName;
	private String userPwd;
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userName=" + userName + ", userPwd="
				+ userPwd + ", userPwdTips=" + userPwdTips + ", userStatus=" + userStatus + "]";
	}

	private String userPwdTips;
	private int userStatus;

	public User(String userAccount, String userName, String userPwd, String userPwdTips) {
		this(0, userAccount, userName, userPwd, userPwdTips, 1);
	}

	public User(int userId, String userAccount, String userName, String userPwd, String userPwdTips, int userStatus) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userPwdTips = userPwdTips;
		this.userStatus = userStatus;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserPwdTips() {
		return userPwdTips;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserPwdTips(String userPwdTips) {
		this.userPwdTips = userPwdTips;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

}
