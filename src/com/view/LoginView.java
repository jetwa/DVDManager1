package com.view;

import java.util.Scanner;

import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class LoginView extends View{

	@Override
	public View showView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("«Î ‰»Î’Àªß:");
		String userAccount = scan.next();
		System.out.println("«Î ‰»Î√‹¬Î:");
		String userPwd = scan.next();
		
		UserBiz ub = new UserBizImpl();
		if (ub.userLogin(userAccount, userPwd)) {
			System.out.println("µ«¬Ω≥…π¶");
		} else {
			System.out.println("µ«¬Ω ß∞‹");
		}
		
		scan.close();
		return null;
	}

	
}
