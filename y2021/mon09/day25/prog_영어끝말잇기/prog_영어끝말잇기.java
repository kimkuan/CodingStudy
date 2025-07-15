package com.mon09.day25.prog_영어끝말잇기;

import java.util.HashSet;

public class prog_영어끝말잇기 {

	static int n = 2;
	static String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
	
	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<>();
		char lastChar;
		int[] answer = new int[2]; // (틀린 사람의 번호, 몇 번째 차례에서 틀렸는지)
		
		set.add(words[0]); // 첫번째 단어
		lastChar = words[0].charAt(words[0].length()-1); // 첫번째 단어의 마지막 문자
		
		// 두번째 단어부터 체크
		for (int i = 1; i < words.length; i++) {
			
			// 1. 이전 사람이 말한 단어의 마지막 문자와 현재 단어의 첫번째 문자를 비교
			// 2. 이전 사람이 말한 단어인지 확인
			if(lastChar != words[i].charAt(0) || set.contains(words[i])) {
				// gameout
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}
			else {
				set.add(words[i]);
				lastChar = words[i].charAt(words[i].length()-1);
			}
		}
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

}
