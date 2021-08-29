package com.mon08.day29.prog_단어변환;

public class prog_단어변환 {

	static String begin = "hit";
	static String target = "cog";
	static String[] words = {"hot", "dot", "dog", "lot", "log"};
	static boolean[] selected;
	static int answer = 0;
	
	public static void main(String[] args) {

		// 1. target이 words안에 있는 지 체크
		// 1-1. 없다면 0를 return 
		// 1-2. 있다면 알파벳을 하나씩 변경해가면서 target으로 변환
		
		// 2. dfs 방식으로 알파벳을 변환 (단어의 길이는 10이하)
		selected = new boolean[words.length];
		
		if(isPossible(target))
			getChangeCount(begin, 0);
		
		System.out.println(answer);
	}
	
	private static boolean isPossible(String target) {
		for (int i = 0; i < words.length; i++) {
			if(target.equals(words[i]))
				return true;
		}	
		return false;
	}
	
	private static void getChangeCount(String now, int changeCount) {
		if(now.equals(target)) {
			answer = changeCount;
			return;
		}
		
		// begin과 target의 첫번째 알파벳부터 변경가능한 단어가 있는지 체크 
		for (int i = 0; i < words.length; i++) {
			if(selected[i] || !compareWord(now, words[i])) continue;
			selected[i] = true;
			getChangeCount(words[i], changeCount+1); // 있으면 그 길로 가보기
			selected[i] = false;
		}
	}
	
	// 두 문자열의 차이가 1개인지 체크
	private static boolean compareWord(String now, String word) {
		int count = 0;
		for (int i = 0; i < now.length(); i++) {
			if(now.charAt(i) != word.charAt(i)) 
				count++;
		}
		return count == 1 ? true : false;
	}
}
