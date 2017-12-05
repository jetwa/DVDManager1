package com.view;

import java.util.Scanner;

import com.bean.User;
import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class LoginView extends View {

	@Override
	public View showView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������˻�:");
		String userAccount = scan.next();
		System.out.println("����������:");
		String userPwd = scan.next();

		UserBiz ub = new UserBizImpl();
		User u = ub.userLogin(userAccount, userPwd);
		if (null != u) {
			System.out.println("��½�ɹ�");
			View umv = new UserMainView(u);
			umv.showView();
		} else {
			System.out.println("��½ʧ��");
		}
		return null;
	}

}
