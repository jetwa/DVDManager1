package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.DVD;
import com.bean.User;

public interface UserDao {
	User getUserByUserAccount(String userAccount) throws SQLException;

	User registUser(String inputAccount, String inputPwd1, String inputPwdTips) throws SQLException;

	ArrayList<DVD> scanDVD() throws SQLException;
	
	boolean lendDVD(int lendDVDId, User nowUser) throws SQLException;
}
