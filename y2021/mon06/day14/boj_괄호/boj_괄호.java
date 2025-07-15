package y2021.mon06.day14.boj_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_괄호 {

	static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		dp = new long[5001]; // 홀수는 무조건 0으로 초기화
		dp[0] = 1;
		dp[2] = 1;
		for(int i = 4; i <= 5000; i++) {
			// j : 처음 열린 괄호를 닫는 괄호의 인덱스
			// j-2 : 처음 열린 괄호 안에있는 괄호의 개수
			// i-j : 처음열린 괄호 외의 괄호의 개수
			if(i % 2 == 1) continue;
			for(int j = 2; j <= i; j++) {
				dp[i] += (dp[j-2] * dp[i-j]);
				dp[i] %= 1000000007;
			}
		}
		
		for(int t = 0; t < T; t++) {
			int L = Integer.parseInt(br.readLine());	
			sb.append(dp[L] + "\n");
		}
		System.out.print(sb);
	}
}
