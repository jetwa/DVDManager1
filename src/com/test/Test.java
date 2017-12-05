package com.test;

import com.tools.DBHelper;
import com.view.MainView;
import com.view.View;

public class Test {
	/*
	 * View调用Biz
	 * Biz调用Dao
	 * Dao调用Bean
	 */
	public static void main(String[] args) {
		
		DBHelper db = new DBHelper();
		if (db.getConnection() ==null) {
			System.out.println("连接失败");
		} else {
			System.out.println("数据库连接成功");
		}
		
		View mv = new MainView();
		mv.showView();
	}
	
	
}
