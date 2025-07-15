package mon07.day26.boj_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_평범한배낭 {
	
	static int N, K;
	static int[][] things;
	static int[] dp; // 일차원 배열을 사용하면, 이전에 계산한 값을 그대로 유지 (최대 무게가 k인 가방에서 가장 큰 가치가 남게됨)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		things = new int[N+1][2];
		dp = new int[K+1];
		
		things[0][0] = 0;
		things[0][1] = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken()); // w 무게
			things[i][1] = Integer.parseInt(st.nextToken()); // v 가치
		}

		for (int i = 1; i <= N; i++) {
			for(int j = K; j-things[i][0] >= 0; j--) { // K에서부터 현재 물건을 담을 수 있는 무게까지만 탐색
				dp[j] = Math.max(dp[j], dp[j-things[i][0]] + things[i][1]);
			}
		}
		System.out.println(dp[K]);
	}
}
