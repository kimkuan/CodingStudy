package y2021.mon01.day28.boj_세친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_세친구_이상현 {

	static int[] alpha = new int[26]; // (default : 0)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String S = ""; int cnt = 0; // 가능한  S의 경우
		
		if(n % 2 == 0) { // 무조건 홀수여야 함
			System.out.println("NOT POSSIBLE");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			alpha[str.charAt(i) - 'A']++; // 추가한 문자 외에는 무조건 짝수 
		}
		
		for(int i = 0; i < 26; i++) {
			if(alpha[i] % 2 != 0) {
				int idx = str.indexOf(i+'A');	
				
				while(idx > -1 && idx < str.length()) {
						S = str.substring(0, idx) + str.substring(idx+1, str.length());
						
						if(S.substring(0, S.length()/2).equals(S.substring(S.length()/2, S.length())))
							cnt++;
						if(cnt > 1){
							System.out.println("NOT UNIQUE");
							return;
						}
						idx = str.indexOf(i+'A', idx+1);
				}
			}
		}
		System.out.println(S.substring(0, S.length()/2));
	}
}
