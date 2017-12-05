package com.view;

import java.util.Scanner;

import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class RegistView extends View {

	@Override
	public View showView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������˻�:");
		String inputAccount = scan.next();
		System.out.println("����������:");
		String inputPwd1 = scan.next();
		System.out.println("��ȷ������:");
		String inputPwd2 = scan.next();
		System.out.println("������������ʾ:");
		String inputPwdTips = scan.next();

		if (!inputPwd1.equals(inputPwd2)) {
			System.out.println("������������벻һ��,������ע��.");
			return null;
		}

		UserBiz ub = new UserBizImpl();
		if (null != ub.check(inputAccount, inputPwd1, inputPwdTips)) {
			System.out.println("ע��ɹ�");
		} else {
			System.out.println("ע��ʧ��");
		}

		scan.close();
		return null;
	}

}
