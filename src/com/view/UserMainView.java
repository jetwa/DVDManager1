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
		System.out.println("欢迎" + u.getUserName() + "来到wo的管理系统...");
		while (isContinue) {
			System.out.println("用户主菜单:");
			System.out.println("1.查看DVD");
			System.out.println("2.借出DVD");
			System.out.println("3.归还DVD");
			System.out.println("0.返回上级菜单");

			choose = scan.nextInt();

			switch (choose) {
			case 0:
				isContinue = false;
				System.out.println("<-返回上级菜单");
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
