package com.view;

import java.util.Scanner;

import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class LoginView extends View{

	@Override
	public View showView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������˻�:");
		String userAccount = scan.next();
		System.out.println("����������:");
		String userPwd = scan.next();
		
		UserBiz ub = new UserBizImpl();
		if (ub.userLogin(userAccount, userPwd)) {
			System.out.println("��½�ɹ�");
		} else {
			System.out.println("��½ʧ��");
		}
		
		scan.close();
		return null;
	}

	
}
