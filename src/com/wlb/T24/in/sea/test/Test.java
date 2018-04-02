package com.wlb.T24.in.sea.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public String test(String T){
		
		return T;
	}
	public static void main(String[] args){
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
		System.out.println(simpleDateFormat.format(date));
	}
}
