package com.mon08.day01.prog_숫자문자열과영단어;

public class prog_숫자문자열과영단어 {

	static String[] englishNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static String s = "one4seveneight";
	public static void main(String[] args) {
		
		for(int i = 0; i <= 9; i++) {
			s = s.replace(englishNumber[i], String.valueOf(i));
		}
		int answer = Integer.parseInt(s);
		System.out.println(answer);
	}
}
