package mon01.day05.boj_사과나무;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_사과나무 {

	static int maxValue = Integer.MIN_VALUE; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());

		int[][] gain = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		
		// 입력 받아서 배열에 저장
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				gain[i][j] = Integer.parseInt(st.nextToken());	
				maxValue = Math.max(gain[i][j], maxValue); // 크키가 1인 정사각형일 때의 최대 이익
			}
		}
		
		// 사각형의 누적합을 구해서 배열에 저장
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + gain[i][j];
			}
		}
		
		// 크기가 2인 정사각형 부터 이익의 최댓값을 구하기
		for(int i = 2; i <= N; i++) {
			findMaxValue(dp, i);
		}
		System.out.println(maxValue);
		
	}

	private static void findMaxValue(int[][] dp, int k) {
		int N = dp.length;

		for (int i = 1; i <= N-k; i++) {
			for (int j = 1; j <= N-k; j++) {
				int sum = dp[i+k-1][j+k-1] - dp[i-1][j+k-1]
							- dp[i+k-1][j-1] + dp[i-1][j-1];
				
				maxValue = Math.max(sum, maxValue);
			}
		}
	}

}
