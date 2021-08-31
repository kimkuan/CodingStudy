package com.mon08.day31.prog_문자열압축;

import java.util.ArrayList;

public class prog_문자열압축 {

	static String s = "abcabcabcabcdededededede";
	
	public static void main(String[] args) {
		
		int answer = s.length();
		
		// 자르는 개수 (1~문자열의 반)
		for (int i = 1; i <= s.length()/2; i++) {
			System.out.println(i + "개 단위");
			ArrayList<String> list = new ArrayList<>();
			
			// SubString
			for(int j = 0; j < s.length(); j += i) {
				if(j+i < s.length()) {
					list.add(s.substring(j, j+i));
				}else {
					list.add(s.substring(j, s.length()));
				}
			}
			
			// 마지막 문자열까지 처리해주기 위해 마무리 문자열 추가
			list.add("");
			
			// 중복 문자열 카운트
			StringBuilder sb = new StringBuilder();
			String before = "";
			int count = 1;
			for(String str : list) {
				if(str.equals(before))
					count++;
				else {
					sb.append(count > 1 ? count + before : before);
					count = 1;
					before = str;
				}
			}
			
			answer = Math.min(answer, sb.length());
		}
		System.out.println(answer);
	}

}
