package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.DVD;

public interface AdminDao {

	public ArrayList<DVD> scanDVD() throws SQLException;

	public DVD addDVD(String newDVDName) throws SQLException;

	public boolean deleteDVD(int deleteDVDId) throws SQLException;

}
