package com.biz;

import java.util.ArrayList;

import com.bean.DVD;

public interface AdminBiz {

	boolean checkAccount(String inputAccount);

	boolean checkPwd(String inputPwd);

	ArrayList<DVD> scanDVD();

	DVD addDVD(String newDVDName);

	boolean deleteDVD(int deleteDVDId);

}
