package com.view;

import java.util.Scanner;

public class MainView extends View {

	@Override
	public View showView() {
		boolean isContinue = true;
		Scanner scan = new Scanner(System.in);
		int choose = 0;

		System.out.println("=====================");
		System.out.println("   欢迎使用DVD管理系统");
		System.out.println("=====================");

		while (isContinue) {
			System.out.println("1.用户登录");
			System.out.println("2.用户注册");
			System.out.println("3.管理员登录");
			System.out.println("0.退出");
			System.out.println("请输入选项:");
			choose = scan.nextInt();
			switch (choose) {
			case 0:
				//退出
				System.out.println("感谢您使用DVD管理系统,再见!");
				isContinue = false;
				break;
			case 1:
				//用户登录
				View lv = new LoginView();
				lv.showView();
				break;
			case 2:
				//用户注册
				View rv = new RegistView();
				rv.showView();
				break;
			case 3:
				//管理员登录
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
