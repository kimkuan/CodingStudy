package mon01.day28.boj_크로아티아알파벳;

import java.util.Scanner;

public class boj_크로아티아알파벳_이상현 {
	
	// 'dz=' 가 'z='보다 먼저 검색되어야 한다! (예제2번 참고)
	static String[] alpha = {"c=", "c-", "dz=", "z=", "d-", "lj", "nj", "s="};
	
	public static void main(String[] args) throws Exception {
		printResult(getLengthOfKroatiaWord(makeInput()));
	}
	
	private static int getLengthOfKroatiaWord(String word) {
		
		for(int i = 0; i < 8; i++) {
			word = word.replace(alpha[i], "*"); // 찾은 문자열을 하나의 문자로 변경
		}
		return word.length(); 
	}
	
	private static String makeInput() { return new Scanner(System.in).next();}
	private static void printResult(int lengthOfKroatiaWord) { System.out.println(lengthOfKroatiaWord); }
}