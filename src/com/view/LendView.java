package com.view;

import java.util.Scanner;

import com.bean.User;
import com.biz.UserBiz;
import com.bizImpl.UserBizImpl;

public class LendView extends View {
	private UserBiz ub = null;
	private User u = null;

	public LendView(User u) {
		ub = new UserBizImpl();
		this.u = u;
	}

	@Override
	public View showView() {
		System.out.println("请输入要借出DVD的ID:");
		Scanner scan = new Scanner(System.in);
		int lendDVDId = scan.nextInt();
		if (ub.lendDVD(lendDVDId,u)) {
			System.out.println("借出成功");
		} else {
			System.out.println("借出失败,请检查DVD状态");
		}
		return null;
	}

}
