package com.biz;

public interface UserBiz {
	public boolean userLogin(String userAccount,String userPwd);

	public boolean check(String inputAccount, String inputPwd1, String inputPwdTips);
}
