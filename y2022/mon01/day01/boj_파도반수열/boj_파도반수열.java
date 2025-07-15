package y2022.mon01.day01.boj_파도반수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_파도반수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for(int i = 6; i <= 100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}

// 1, 1, 1, 2, 2, 3, 4  ...

// 3부터 규칙이 시작함
// 1 + (1, 1, 2) + 2 = 3
// (1) 1 + (1, 2, 2) + 3 = 4

// dp[i] = dp[i-1] + dp[i-5]
