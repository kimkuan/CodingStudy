package mon03.day12.boj_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_평범한배낭_이상현 {
	
	static int[][] dp;
	static int[][] item;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
			
		dp = new int[K+1][N+1]; // default : 0
		item = new int[N+1][2]; // [][0] : 무게, [][1] : 가치
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(item, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1]; // 가치가 큰 것 부터
			}
		});	
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
				if(i < item[j][0]) continue;
				dp[i][j] = Math.max(item[j][1], dp[i][j]); // 담을 수 있으면 담아
				
				dp[i][j] = Math.max(dp[i-item[j][0]][j] + dp[item[j][0]][j], dp[i][j]);
				
			}
		}

		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[K][N]);
	}
}
