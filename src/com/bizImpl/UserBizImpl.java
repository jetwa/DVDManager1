package com.bizImpl;

import java.sql.SQLException;

import com.bean.User;
import com.biz.UserBiz;
import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;

public class UserBizImpl implements UserBiz {

	UserDao ud;
	User u;

	public UserBizImpl() {
		ud = new UserDaoImpl();
		u = null;
	}

	@Override
	public boolean userLogin(String userAccount, String userPwd) {

		if (userAccount == null || userPwd == null || userAccount.length() == 0 || userPwd.length() == 0) {
			return false;
		}

		try {
			u = ud.getUserByUserAccount(userAccount);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (u == null) {
			return false;
		}

		// 验证密码
		if (u.getUserPwd().equals(userPwd)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean check(String inputAccount, String inputPwd1,String inputPwdTips) {
		if (inputAccount == null || inputPwd1 == null || inputAccount.length() == 0 || inputPwd1.length() == 0 || inputPwdTips==null || inputPwdTips.length()==0) {
			return false;
		}
		try {
			u = ud.registUser(inputAccount,inputPwd1,inputPwdTips);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("输入的信息不满足要求,请查看用户名及密码格式,非常抱歉.");
		}
		return false;
	}

}
