package com.test;

import com.view.MainView;
import com.view.View;

public class Test {
	/*
	 * View����Biz
	 * Biz����Dao
	 * Dao����Bean
	 */
	public static void main(String[] args) {
		View mv = new MainView();
		mv.showView();
	}
	
	
}
