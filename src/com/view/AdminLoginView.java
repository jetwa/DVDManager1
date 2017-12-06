package com.view;

import com.biz.AdminBiz;
import com.bizImpl.AdminBizImpl;
import com.tools.Scan;

public class AdminLoginView extends View {

	AdminBiz ab = null;

	public AdminLoginView() {
		ab = new AdminBizImpl();
	}

	@Override
	public View showView() {
		int choose = 1;
		boolean isContinue = true;
		while (isContinue) {
			switch (choose) {
			case 0:
				System.out.println("返回<-上级菜单");
				isContinue = false;
				break;
			case 1:
				System.out.println("->请输入管理员账号:");
				String inputAccount = Scan.getScanner().next();
				if ("0".equals(inputAccount)) {
					choose = 0;
					break;
				}
				if (ab.checkAccount(inputAccount)) {
					choose = 2;
				} else {
					System.out.println("错误<-账号,请重新输入");
				}
				break;
			case 2:
				System.out.println("->请输入管理员密码:");
				String inputPwd = Scan.getScanner().next();
				if (ab.checkPwd(inputPwd)) {
					System.out.println("成功<-登录");
					View amv = new AdminMainView();
					amv.showView();
					choose = 0;
				} else {
					System.out.println("错误<-密码,请重新输入");
				}
				break;
			default:
				break;
			}
		}
		return null;
	}

}
