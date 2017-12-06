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
		System.out.println("请输入归还DVD的ID:");
		Scanner scan = new Scanner(System.in);
		int returnDVDId = scan.nextInt();
		if (ub.returnDVD(returnDVDId)) {
			System.out.println("归还成功");
		} else {
			System.out.println("归还失败");
		}
		return null;
	}

}
