package com.tools;

import java.util.Scanner;

public class Scan {
	private static Scanner scan = null;

	public static Scanner getScanner() {
		if (scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}
}
