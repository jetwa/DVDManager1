package com.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author Jet
 *
 */
public class DBHelper {

	// 将4个常量移动到配置文件中
	// public static final String DRIVER = "oracle.jdbc.OracleDriver";
	// public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	// public static String USER = "c##TC25";
	// public static String PWD = "123456";
	public static String DRIVER = "";
	public static String URL = "";
	public static String USER = "";
	public static String PWD = "";
	Properties p = new Properties();

	Connection mConnection;

	
	{

		try {
			p.load(new FileInputStream(new File("config.properties")));
			String driver = p.getProperty("DRIVER");
			String url = p.getProperty("URL");
			String user = p.getProperty("USER");
			String pwd = p.getProperty("PWD");
			DRIVER = driver;
			URL = url;
			USER = user;
			PWD = pwd;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 返回和数据库的连接对象
	 * 
	 * @return
	 */
	public Connection getConnection() {		
		if (mConnection == null) {
			try {
				// 新版本可以不写,目的是加载驱动
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
