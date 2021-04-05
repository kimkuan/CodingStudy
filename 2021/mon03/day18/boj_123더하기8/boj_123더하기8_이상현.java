package mon03.day18.boj_123더하기8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_123더하기8_이상현 {

	static long[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		dp = new long[100001][2]; // 홀수, 짝수 갯수
		dp[1][0] = 1; dp[1][1] = 0;
		dp[2][0] = 1; dp[2][1] = 1;
		dp[3][0] = 2; dp[3][1] = 2;
		
		for(int i = 4; i <= 100000; i++) {// 더할 때 int범위를 넘게 되므로 long으로 계산!!
			dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % 1000000009; 
			dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % 1000000009;
		}
		
		while(tc++ < T) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
		}
		System.out.print(sb);
	}
}
