package com.view;

import java.util.Scanner;

import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class RegistView extends View {

	@Override
	public View showView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入账户:");
		String inputAccount = scan.next();
		System.out.println("请输入密码:");
		String inputPwd1 = scan.next();
		System.out.println("请确认密码:");
		String inputPwd2 = scan.next();
		System.out.println("请输入密码提示:");
		String inputPwdTips = scan.next();

		if (!inputPwd1.equals(inputPwd2)) {
			System.out.println("两次输入的密码不一致,请重新注册.");
			return null;
		}

		UserBiz ub = new UserBizImpl();
		if (null != ub.check(inputAccount, inputPwd1, inputPwdTips)) {
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败");
		}

		scan.close();
		return null;
	}

}
