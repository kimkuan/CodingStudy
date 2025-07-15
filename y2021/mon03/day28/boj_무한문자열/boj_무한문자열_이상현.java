package y2021.mon03.day28.boj_무한문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_무한문자열_이상현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int len = lcm(s.length(), t.length()); // 두 길이의 최소 공배수
		
		System.out.println(check(s, t, len));
	}
	private static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b; // 6 3
			a = b; // 3
			b = r; // 2
		}
		return a;
	}
	// 최소공배수 => a*b / gcd
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	private static int check(String s, String t, int len) {
		int sIdx = 0;
		int tIdx = 0;
		
		for(int i = 0; i < len; i++) {
			if(sIdx == s.length()) sIdx = 0;
			if(tIdx == t.length()) tIdx = 0;
			
			if(s.charAt(sIdx++) != t.charAt(tIdx++)) // 최대공배수 만큼 길이를 비교
				return 0;
		}
		return 1;
	}
}
// 같은 문자열abc abcabc  
// abc bca
