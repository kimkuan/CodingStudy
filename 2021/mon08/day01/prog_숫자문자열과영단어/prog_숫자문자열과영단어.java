package com.mon08.day01.prog_���ڹ��ڿ������ܾ�;

public class prog_���ڹ��ڿ������ܾ� {

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
