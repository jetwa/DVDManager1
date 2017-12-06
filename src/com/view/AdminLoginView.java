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
				System.out.println("����<-�ϼ��˵�");
				isContinue = false;
				break;
			case 1:
				System.out.println("->���������Ա�˺�:");
				String inputAccount = Scan.getScanner().next();
				if ("0".equals(inputAccount)) {
					choose = 0;
					break;
				}
				if (ab.checkAccount(inputAccount)) {
					choose = 2;
				} else {
					System.out.println("����<-�˺�,����������");
				}
				break;
			case 2:
				System.out.println("->���������Ա����:");
				String inputPwd = Scan.getScanner().next();
				if (ab.checkPwd(inputPwd)) {
					System.out.println("�ɹ�<-��¼");
					View amv = new AdminMainView();
					amv.showView();
					choose = 0;
				} else {
					System.out.println("����<-����,����������");
				}
				break;
			default:
				break;
			}
		}
		return null;
	}

}
