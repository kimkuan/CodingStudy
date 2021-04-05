package mon02.day08.boj_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1로만들기_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1]; // 1 ~ n 
		
		if(n <= 2) {
			System.out.println(n-1);
			return;
		}
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + 1;

			if(i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}
		System.out.print(dp[n]);
	}
}

/*
 * 점화식
 * 
 * dp[1] = 0;
 * dp[2] = 1;
 * dp[3] = 1) 3으로 나눌 경우 dp[3/3] + 1 = dp[1] + 1 = 1
 *         2) 1을 뺄 경우 dp[2] + 1  = 2;
 * 
 */

