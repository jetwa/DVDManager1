package com.view;

import com.bean.DVD;
import com.biz.AdminBiz;
import com.bizImpl.AdminBizImpl;
import com.tools.Scan;

public class AdminMainView extends View {

	private AdminBiz ab = null;

	public AdminMainView() {
		ab = new AdminBizImpl();
	}

	@Override
	public View showView() {
		boolean isContinue = true;
		int choose = 0;
		while (isContinue) {
			System.out.println("1.查看DVD");
			System.out.println("2.增加DVD");
			System.out.println("3.修改DVD名称");
			System.out.println("4.删除DVD");
			System.out.println("5.查看User");
			System.out.println("6.修改User状态");
			System.out.println("7.查看借出记录");
			System.out.println("8.查看所有DVD");
			System.out.println("0.返回上级菜单");
			choose = Scan.getScanner().nextInt();
			switch (choose) {
			case 0:
				System.out.println("返回<-上级菜单");
				break;
			case 1:
				// 查看DVD
				for (DVD dvd : ab.scanDVD()) {
					System.out.println(dvd);
				}
				break;
			case 2:
				// 增加DVD
				while (true) {
					System.out.println("->请输入新DVD名称(输入0返回上级菜单):");
					String newDVDName = Scan.getScanner().next();
					if ("0".equals(newDVDName)) {
						System.out.println("返回<-上级菜单");
						break;
					}
					DVD dvd = ab.addDVD(newDVDName);
					if (dvd != null) {
						System.out.println("成功<-添加DVD" + dvd);
					} else {
						System.out.println("失败<-添加DVD");
					}
				}
				break;
			case 3:
				// 修改DVD名字
				break;
			case 4:
				// 删除DVD
				while (true) {
					System.out.println("->请输入删除DVD的ID(输入0返回上级菜单):");
					int deleteDVDId = Scan.getScanner().nextInt();
					if (deleteDVDId == 0) {
						System.out.println("返回上级菜单");
						break;
					}

					if (ab.deleteDVD(deleteDVDId)) {
						System.out.println("成功<-删除");
					} else {
						System.out.println("失败<-删除");
					}
				}
				break;
			case 5:
				// 查看User
				break;
			case 6:
				// 修改User状态
				break;
			case 7:
				// 查看借出记录
				break;
			case 8:
				// 查看所有DVD
				break;
			default:
				System.out.println("错误<-输入有误,请重新输入");
				break;
			}
		}
		return null;
	}

}
