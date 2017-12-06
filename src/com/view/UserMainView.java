package com.view;

import java.util.Scanner;

import com.bean.DVD;
import com.bean.User;
import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class UserMainView extends View {

	private User u = null;
	private UserBiz ub = null;

	public UserMainView(User u) {
		this.u = u;
		ub = new UserBizImpl(u);
	}

	@Override
	public View showView() {
		boolean isContinue = true;
		Scanner scan = new Scanner(System.in);
		int choose = 0;
		System.out.println("��ӭ" + u.getUserName() + "����wo�Ĺ���ϵͳ...");
		while (isContinue) {
			System.out.println("�û����˵�:");
			System.out.println("1.�鿴DVD");
			System.out.println("2.���DVD");
			System.out.println("3.�黹DVD");
			System.out.println("0.�����ϼ��˵�");

			choose = scan.nextInt();

			switch (choose) {
			case 0:
				isContinue = false;
				System.out.println("<-�����ϼ��˵�");
				break;
			case 1:
				for (DVD d : ub.scanDVD()) {
					System.out.println(d);
				}
				break;
			case 2:
				View lv = new LendView(u);
				lv.showView();
				break;
			case 3:
				View rv = new ReturnView(u);
				rv.showView();
				break;
			}

		}
		return null;
	}

}
