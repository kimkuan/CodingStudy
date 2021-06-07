package mon05.day05.boj_끝나지않는파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_끝나지않는파티 {

	static int N, M;
	static int[][] minCost; // 다른 파티장으로 가는데 필요한 최소비용
	static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) throws IOException {
		solve();
		System.out.print(sb);
	}
	
	public static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minCost = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				minCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 플로이드 워샬
		for(int k = 1; k <= N; k++) { // 경유지 
			for(int i = 1; i <= N; i++) { // 출발지
				for(int j = 1; j <= N; j++) { // 도착지
					if(minCost[i][j] > minCost[i][k] + minCost[k][j])
						minCost[i][j] = minCost[i][k] + minCost[k][j];
				}
			}
		}	
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			if(minCost[from][to] <= time)
				sb.append("Enjoy other party\n");
			else
				sb.append("Stay here\n");
		}
	}
}
