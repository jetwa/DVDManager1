package com.view;

import java.util.Scanner;

import com.bean.User;
import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class LoginView extends View {

	@Override
	public View showView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("«Î ‰»Î’Àªß:");
		String userAccount = scan.next();
		System.out.println("«Î ‰»Î√‹¬Î:");
		String userPwd = scan.next();

		UserBiz ub = new UserBizImpl();
		User u = ub.userLogin(userAccount, userPwd);
		if (null != u) {
			System.out.println("µ«¬Ω≥…π¶");
			View umv = new UserMainView(u);
			umv.showView();
		} else {
			System.out.println("µ«¬Ω ß∞‹");
		}
		return null;
	}

}
