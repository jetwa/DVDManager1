package com.test;

import com.view.MainView;
import com.view.View;

public class Test {
	/*
	 * View调用Biz
	 * Biz调用Dao
	 * Dao调用Bean
	 */
	public static void main(String[] args) {
		View mv = new MainView();
		mv.showView();
	}
	
	
}
