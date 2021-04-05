package mon02.day08.boj_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_RGB거리_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 계단의 수
		int[][] arr = new int[n][3]; // n개의 집이 각각 집을 RGB 색상으로 칠하는데 필요한 비용 
		int[][] dp = new int[n][3];  // 1~n번재의 집을 칠하는데 필요한 최소비용
		int minCost = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // R
			arr[i][1] = Integer.parseInt(st.nextToken()); // G
			arr[i][2] = Integer.parseInt(st.nextToken()); // B
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}

		for(int x : dp[n-1]) {
			minCost = minCost > x ? x : minCost;
		}
		System.out.println(minCost);
	}
}
