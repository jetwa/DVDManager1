package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Jet
 *
 */
public class DBHelper {

	// ��4�������ƶ��������ļ���
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	public static String USER = "c##TC25";
	public static String PWD = "123456";

	Connection mConnection;

	/**
	 * ���غ����ݿ�����Ӷ���
	 * 
	 * @return
	 */
	public Connection getConnection() {
		if (mConnection == null) {
			try {
				// �°汾���Բ�д,Ŀ���Ǽ�������
				Class.forName(DRIVER);
				mConnection = DriverManager.getConnection(URL, USER, PWD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return mConnection;
	}

}
