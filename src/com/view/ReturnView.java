package com.view;

import java.util.Scanner;

import com.bean.User;
import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class ReturnView extends View {

	private User nowUser = null;
	private UserBiz ub = null;

	public ReturnView(User u) {
		this.nowUser = u;
		ub = new UserBizImpl();
	}

	@Override
	public View showView() {
		System.out.println("������黹DVD��ID:");
		Scanner scan = new Scanner(System.in);
		int returnDVDId = scan.nextInt();
		if (ub.returnDVD(returnDVDId)) {
			System.out.println("�黹�ɹ�");
		} else {
			System.out.println("�黹ʧ��");
		}
		return null;
	}

}
