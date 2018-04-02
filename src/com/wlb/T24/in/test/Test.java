package com.wlb.T24.in.test;

public class Test {
	public static void main(String[] args) {
		String string = "20180207";
		String[] fieldSplit = string.split(":");
		try {
			String string2 = fieldSplit[2];
			String[] fieldDetSplit =string2.split("=",-1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("---");
		}
	}
}
