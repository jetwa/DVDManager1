package com.test;

import com.tools.DBHelper;
import com.view.MainView;
import com.view.View;

public class Test {
	/*
	 * View����Biz
	 * Biz����Dao
	 * Dao����Bean
	 */
	public static void main(String[] args) {
		
		DBHelper db = new DBHelper();
		if (db.getConnection() ==null) {
			System.out.println("����ʧ��");
		} else {
			System.out.println("���ݿ����ӳɹ�");
		}
		
		View mv = new MainView();
		mv.showView();
	}
	
	
}
