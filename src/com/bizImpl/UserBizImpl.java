package com.bizImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.DVD;
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
	public User userLogin(String userAccount, String userPwd) {

		if (userAccount == null || userPwd == null || userAccount.length() == 0 || userPwd.length() == 0) {
			return null;
		}

		try {
			u = ud.getUserByUserAccount(userAccount);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (u == null) {
			return null;
		}

		// ��֤����
		if (u.getUserPwd().equals(userPwd)) {
			return u;
		}

		return null;
	}

	@Override
	public User check(String inputAccount, String inputPwd1,String inputPwdTips) {
		if (inputAccount == null || inputPwd1 == null || inputAccount.length() == 0 || inputPwd1.length() == 0 || inputPwdTips==null || inputPwdTips.length()==0) {
			return null;
		}
		try {
			u = ud.registUser(inputAccount,inputPwd1,inputPwdTips);
			return u;
		} catch (SQLException e) {
			System.out.println("�������Ϣ������Ҫ��,��鿴�û����������ʽ,�ǳ���Ǹ.");
		}
		return null;
	}

	@Override
	public ArrayList<DVD> scanDVD() {
		ArrayList<DVD> list = new ArrayList<>();
		try {
			list = ud.scanDVD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean lendDVD(int lendDVDId,User nowUser) {
		if (lendDVDId>0) {
			try {
				return ud.lendDVD(lendDVDId,nowUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
