package mon07.day26.boj_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_평범한배낭 {
	
	static int N, K;
	static int[][] dp;
	static Integer[][] things;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		things = new Integer[N+1][2];
		
		things[0][0] = 0;
		things[0][1] = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken()); // w 무게
			things[i][1] = Integer.parseInt(st.nextToken()); // v 가치
		}

		Arrays.sort(things, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		dp = new int[K+1][N+1];
		for(int k = 1; k <= K; k++) { // 가방에 담을 수 있는 최대 무게가 0일 때 부터 K일 때 까지 
			for(int j = 1; j <= N; j++) {
				// 바로 이전 값을 그대로 쓰거나, 새로 계산한 값(현재의 무게만큼 뺐을 때 최댓값 + 현재 무게에서 최댓값)을 쓰거나
				if(k-things[j][0] >= 0) {
					dp[k][j] = Math.max(dp[k][j-1], dp[k-things[j][0]][j-1] + things[j][1]);
				}else {
					dp[k][j] = dp[k][j-1];
				}
			}		
		}
		System.out.println(dp[K][N]);
	}
}
