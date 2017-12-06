package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.DVD;
import com.dao.AdminDao;
import com.tools.DBHelper;

public class AdminDaoImpl implements AdminDao {

	private Connection mConnection = null;
	private PreparedStatement mStatement = null;
	private ResultSet rSet = null;
	private DBHelper mDB = null;
	private int rInt = 0;

	public AdminDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}

	@Override
	public ArrayList<DVD> scanDVD() throws SQLException {
		ArrayList<DVD> list = new ArrayList<>();
		String sql = "select * from dvd_dvd where dvd_status!=2";
		mStatement = mConnection.prepareStatement(sql);
		rSet = mStatement.executeQuery();
		if (rSet == null) {
			return null;
		}
		DVD dvd = null;
		while (rSet.next()) {
			dvd = new DVD();
			dvd.setDvdId(rSet.getInt("DVD_ID"));
			dvd.setDvdName(rSet.getString("DVD_NAME"));
			dvd.setDvdDate(String.valueOf(rSet.getDate("DVD_DATE")));
			dvd.setLendCount(rSet.getInt("DVD_LENDCOUNT"));
			dvd.setDvdStatus(rSet.getInt("DVD_STATUS"));
			list.add(dvd);
		}
		return list;
	}

	@Override
	public DVD addDVD(String newDVDName) throws SQLException {
		String sql = "insert into dvd_dvd (dvd_name) values (?)";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, newDVDName);
		rInt = mStatement.executeUpdate();
		if (rInt > 0) {
			return getNewDVD(newDVDName);
		}
		return null;
	}

	private DVD getNewDVD(String newDVDName) throws SQLException {
		DVD dvd = null;
		String sql = "select * from (select * from dvd_dvd where dvd_name=? order by dvd_id) where rownum<2";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, newDVDName);
		rSet = mStatement.executeQuery();
		if (rSet == null) {
			return null;
		}
		while (rSet.next()) {
			dvd = new DVD();
			dvd.setDvdId(rSet.getInt("DVD_ID"));
			dvd.setDvdName(rSet.getString("DVD_NAME"));
			dvd.setDvdDate(String.valueOf(rSet.getDate("DVD_DATE")));
			dvd.setLendCount(rSet.getInt("DVD_LENDCOUNT"));
			dvd.setDvdStatus(rSet.getInt("DVD_STATUS"));
		}
		return dvd;
	}

	@Override
	public boolean deleteDVD(int deleteDVDId) throws SQLException {
		String sql = "update dvd_dvd set dvd_status=2 where dvd_id=?";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setInt(1, deleteDVDId);
		rInt = mStatement.executeUpdate();
		if (rInt > 0) {
			return true;
		}
		return false;
	}

}
