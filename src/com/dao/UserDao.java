package com.dao;

import java.sql.SQLException;

import com.bean.User;

public interface UserDao {
	User getUserByUserAccount(String userAccount) throws SQLException;

	User registUser(String inputAccount, String inputPwd1, String inputPwdTips) throws SQLException;
}
