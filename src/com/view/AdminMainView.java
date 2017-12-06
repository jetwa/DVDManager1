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
			System.out.println("1.�鿴DVD");
			System.out.println("2.����DVD");
			System.out.println("3.�޸�DVD����");
			System.out.println("4.ɾ��DVD");
			System.out.println("5.�鿴User");
			System.out.println("6.�޸�User״̬");
			System.out.println("7.�鿴�����¼");
			System.out.println("8.�鿴����DVD");
			System.out.println("0.�����ϼ��˵�");
			choose = Scan.getScanner().nextInt();
			switch (choose) {
			case 0:
				System.out.println("����<-�ϼ��˵�");
				break;
			case 1:
				// �鿴DVD
				for (DVD dvd : ab.scanDVD()) {
					System.out.println(dvd);
				}
				break;
			case 2:
				// ����DVD
				while (true) {
					System.out.println("->��������DVD����(����0�����ϼ��˵�):");
					String newDVDName = Scan.getScanner().next();
					if ("0".equals(newDVDName)) {
						System.out.println("����<-�ϼ��˵�");
						break;
					}
					DVD dvd = ab.addDVD(newDVDName);
					if (dvd != null) {
						System.out.println("�ɹ�<-���DVD" + dvd);
					} else {
						System.out.println("ʧ��<-���DVD");
					}
				}
				break;
			case 3:
				// �޸�DVD����
				break;
			case 4:
				// ɾ��DVD
				while (true) {
					System.out.println("->������ɾ��DVD��ID(����0�����ϼ��˵�):");
					int deleteDVDId = Scan.getScanner().nextInt();
					if (deleteDVDId == 0) {
						System.out.println("�����ϼ��˵�");
						break;
					}

					if (ab.deleteDVD(deleteDVDId)) {
						System.out.println("�ɹ�<-ɾ��");
					} else {
						System.out.println("ʧ��<-ɾ��");
					}
				}
				break;
			case 5:
				// �鿴User
				break;
			case 6:
				// �޸�User״̬
				break;
			case 7:
				// �鿴�����¼
				break;
			case 8:
				// �鿴����DVD
				break;
			default:
				System.out.println("����<-��������,����������");
				break;
			}
		}
		return null;
	}

}
