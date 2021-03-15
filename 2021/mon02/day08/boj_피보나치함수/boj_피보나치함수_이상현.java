package mon02.day08.boj_피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_피보나치함수_이상현 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		int[][] dp = new int[41][2];
		dp[0][0] = 1; dp[0][1] = 0;
		dp[1][0] = 0; dp[1][1] = 1;
		
		while(tc++ < T) {
			int n = Integer.parseInt(br.readLine());
			for(int i = 2; i <= n; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-2][0];
				dp[i][1] = dp[i-1][1] + dp[i-2][1];
			} 
			sb.append(dp[n][0] + " " + dp[n][1] + "\n");
		}
		System.out.print(sb);
	}
}
