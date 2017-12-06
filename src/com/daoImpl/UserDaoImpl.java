package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.DVD;
import com.bean.User;
import com.dao.UserDao;
import com.tools.DBHelper;

public class UserDaoImpl implements UserDao {

	private Connection mConnection = null;
	private PreparedStatement mStatement = null;
	private ResultSet rSet = null;
	private DBHelper mDB = null;
	private int rInt = 0;
	private User u = null;

	public UserDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
		rSet = null;
		u = null;
	}

	public UserDaoImpl(User u) {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
		rSet = null;
		this.u = u;
	}

	// SQLException�ڶ���������ʱ�쳣
	@Override
	public User getUserByUserAccount(String userAccount) throws SQLException {
		// ?��ʾռλ��
		String sql = "select * from dvd_user where user_Account = ?";
		// ͨ�����ӻ�ȡPreparedStatement����
		mStatement = mConnection.prepareStatement(sql);
		// ͨ��PreparedStatement�����ռλ������ֵ����
		mStatement.setString(1, userAccount);
		// ͨ��Statement������÷���ִ��SQL��ѯ���,����ȡ���������
		// executeQuery-��ѯר��,����resultSet
		// executeUpdate-��ɾ��ʹ��,����int
		rSet = mStatement.executeQuery();
		/*
		 * �����õ�,�������������,��������Ϊnull
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

	@Override
	public ArrayList<DVD> scanDVD() throws SQLException {
		ArrayList<DVD> list = new ArrayList<>();
		String sql = "select * from dvd_dvd";
		mStatement = mConnection.prepareStatement(sql);
		rSet = mStatement.executeQuery();
		while (rSet.next()) {
			DVD dvd = new DVD();
			dvd.setDvdId(rSet.getInt("DVD_ID"));
			dvd.setDvdName(rSet.getString("DVD_NAME"));
			dvd.setDvdDate(rSet.getDate("DVD_DATE").toString());
			dvd.setLendCount(rSet.getInt("DVD_LENDCOUNT"));
			dvd.setDvdStatus(rSet.getInt("DVD_STATUS"));
			list.add(dvd);
		}
		return list;
	}

	@Override
	public boolean lendDVD(int lendDVDId, User nowUser) throws SQLException {
		// 0��ʾ�ڿ�,1��ʾ���,-1��ʾɾ��
		String sql = "update dvd_dvd set dvd_status=1 ,dvd_lendcount=dvd_lendcount+1 where(dvd_id=? and dvd_status=0)";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setInt(1, lendDVDId);
		rInt = mStatement.executeUpdate();
		if (rInt > 0) {
			sql = "insert into dvd_lr values(default,default,?,?,?,(select dvd_name from dvd_dvd where dvd_id=?),default,default,0)";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, nowUser.getUserId());
			mStatement.setString(2, nowUser.getUserAccount());
			mStatement.setInt(3, lendDVDId);
			mStatement.setInt(4, lendDVDId);
			rInt = mStatement.executeUpdate();
			if (rInt > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean returnDVD(int returnDVDId) throws SQLException {
		String sql = "update dvd_lr set lr_status=1 where (dvd_id=? and user_id=? and lr_status=0)";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setInt(1, returnDVDId);
		mStatement.setInt(2, u.getUserId());
		rInt = mStatement.executeUpdate();
		if (rInt > 0) {
			if (rInt > 0) {
				sql = "update dvd_dvd set dvd_status=0 where (dvd_id=? and dvd_status=1)";
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setInt(1, returnDVDId);
				rInt = mStatement.executeUpdate();
				return true;
			}
		}
		return false;
	}

}
