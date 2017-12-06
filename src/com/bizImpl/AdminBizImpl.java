package com.bizImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.DVD;
import com.biz.AdminBiz;
import com.dao.AdminDao;
import com.daoImpl.AdminDaoImpl;

public class AdminBizImpl implements AdminBiz {

	private AdminDao ad = null;

	public AdminBizImpl() {
		ad = new AdminDaoImpl();
	}

	@Override
	public boolean checkAccount(String inputAccount) {
		if ("admin".equals(inputAccount)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkPwd(String inputPwd) {
		if ("admin".equals(inputPwd)) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<DVD> scanDVD() {
		try {
			return ad.scanDVD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DVD addDVD(String newDVDName) {
		if (newDVDName == null) {
			return null;
		}

		try {
			return ad.addDVD(newDVDName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteDVD(int deleteDVDId) {
		if (deleteDVDId <= 0) {
			return false;
		}
		try {
			return ad.deleteDVD(deleteDVDId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
