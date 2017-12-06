package com.biz;

import java.util.ArrayList;

import com.bean.DVD;
import com.bean.User;

public interface UserBiz {
	User userLogin(String userAccount,String userPwd);

	User check(String inputAccount, String inputPwd1, String inputPwdTips);

	ArrayList<DVD> scanDVD();


	boolean lendDVD(int lendDVDId, User nowUser);

	boolean returnDVD(int returnDVDId);
}
