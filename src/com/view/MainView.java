package com.view;

import java.util.Scanner;

public class MainView extends View {

	@Override
	public View showView() {
		boolean isContinue = true;
		Scanner scan = new Scanner(System.in);
		int choose = 0;

		System.out.println("=====================");
		System.out.println("   ��ӭʹ��DVD����ϵͳ");
		System.out.println("=====================");

		while (isContinue) {
			System.out.println("1.�û���¼");
			System.out.println("2.�û�ע��");
			System.out.println("3.����Ա��¼");
			System.out.println("0.�˳�");
			System.out.println("������ѡ��:");
			choose = scan.nextInt();
			switch (choose) {
			case 0:
				//�˳�
				System.out.println("��л��ʹ��DVD����ϵͳ,�ټ�!");
				isContinue = false;
				break;
			case 1:
				//�û���¼
				View lv = new LoginView();
				lv.showView();
				break;
			case 2:
				//�û�ע��
				View rv = new RegistView();
				rv.showView();
				break;
			case 3:
				//����Ա��¼
				View alv = new AdminLoginView();
				alv.showView();
				break;
			default:
				break;
			}
		}
		return null;
	}

}
