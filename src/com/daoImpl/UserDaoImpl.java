package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;
import com.dao.UserDao;
import com.tools.DBHelper;

public class UserDaoImpl implements UserDao {

	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	private DBHelper mDB;
	private int rInt;

	public UserDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
		rSet = null;
	}

	// SQLException第二个非运行时异常
	@Override
	public User getUserByUserAccount(String userAccount) throws SQLException {
		// ?表示占位符
		String sql = "select * from dvd_user where user_Account = ?";
		// 通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);

		// 通过PreparedStatement对象给占位符做赋值操作
		mStatement.setString(1, userAccount);

		// 通过Statement对象调用方法执行SQL查询语句,并获取结果集对象
		// executeQuery-查询专用,返回resultSet
		rSet = mStatement.executeQuery();
		/*
		 * 如果查得到,结果集中有数据,否则结果集为null
		 */
		if (rSet == null) {
			return null;
		}
		User u = null;
		while (rSet.next()) {
			u = new User();
			u.setUserId(rSet.getInt("USER_ID"));
			u.setUserAccount(rSet.getString("USER_ACCOUNT"));
			u.setUserName(rSet.getString("USER_NAME"));
			u.setUserPwd(rSet.getString("USER_PWD"));
			u.setUserPwdTips(rSet.getString("USER_PWDTIPS"));
			u.setUserStatus(rSet.getInt("USER_STATUS"));
			System.out.println(u);
		}

		return u;
	}

	@Override
	public User registUser(String inputAccount, String inputPwd1, String inputPwdTips) throws SQLException {
		// String sql = "insert into dvd_user values (default,'" + inputAccount +
		// "',default,'" + inputPwd1 + "','"
		// + inputPwdTips + "',default) tablespace dvdManager";
		String sql = "insert into dvd_user values (default,?,default,?,?,default)";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, inputAccount);
		mStatement.setString(2, inputPwd1);
		mStatement.setString(3, inputPwdTips);
		rInt = mStatement.executeUpdate();
		if (rInt > 0) {
			return getUserByUserAccount(inputAccount);
		}
		return null;
	}

}
