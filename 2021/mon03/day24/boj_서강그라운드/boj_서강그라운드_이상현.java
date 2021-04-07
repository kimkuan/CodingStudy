package mon03.day24.boj_서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_서강그라운드_이상현 {

	static final int INF = 100000000;
	static int N, M, R; // 지역의 개수, 수색범위, 길의 개수
	static int[] item;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		item = new int[N+1]; // 각 지역에서 얻을 수 있는 아이템 수
		distance = new int[N+1][N+1]; // i번 노드에서 j번 노드로 가는데 필요한 최소 비용
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(distance[i], INF); // 무한대로 초기화
			distance[i][i] = 0; // 자기자신에 대한 비용은 0으로 초기화
		}
	
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			distance[start][end] = weight;
			distance[end][start] = weight;
		}
		
		for(int k = 1; k <= N; k++) { // 경유하는 점 (첫번째 for문에 나와야함. 그래야 제대로 갱신이 된다)
			for(int i = 1; i <= N; i++) { // 시작점 
				for(int j = 1; j <= N; j++) { // 끝점
					if(distance[i][j] > distance[i][k] + distance[k][j]) { // 경유하는 경로가 더 작으면
						distance[i][j] = distance[i][k] + distance[k][j]; 
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			int itemCount = 0;
			for(int j = 1; j <= N; j++) {
				if(distance[i][j] <= M) { // i에서 j로 가는 최소 비용이 M보다 작거나 같다면 
					itemCount += item[j]; // 아이템 획득 가능! 
				}
			}
			answer = Math.max(answer, itemCount);
		}
		System.out.print(answer);
	}
}
