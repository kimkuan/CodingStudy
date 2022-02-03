package mon02.day03.boj_공통부분문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_공통부분문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		int answer = 0;
		
		int[][] dp = new int[len1][len2]; // 앞에서 일치했던 문자열의 개수
		
		
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {	
				
				if(str1.charAt(i) == str2.charAt(j)) {
					if(i == 0 || j == 0)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i-1][j-1] + 1;
				}
				
				answer = Math.max(dp[i][j], answer);
			}
		}
		
		
		System.out.println(answer);
	}

}
