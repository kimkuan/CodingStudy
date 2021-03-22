package mon03.day22.boj_그대그머가되어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_그대그머가되어_이상현 {

	static final int INF = Integer.MAX_VALUE;
	static int start, end, N, M;
	static int[][] matrix;
	static int[] distance; 
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		input();
		findReplace();
		System.out.println(distance[end] == INF ? -1 : distance[end]);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 치환가능한 문자쌍의 개수 (간선의 개수)
		matrix = new int[N+1][N+1]; // 정점 번호가 1부터 시작
		distance = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(distance, INF); // 무한대로 초기화
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}	
	}
	
	private static void findReplace() {
		int min = 0, current = 0; // 최소 가중치와 그 정점 번호
		distance[start] = 0;
		
		for(int i = 1; i <= N; i++) {
			min = INF;
          	for(int j = 1; j <= N; j++) {
 				if(!visited[j] && distance[j] < min) {
 					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true; // 최소 가중치를 갖는 정점 방문
			if(current == end) {
				return;
			}
			
			for(int j = 1; j <= N; j++) { // 현재 경유하는 current 노드를 기준으로 최소 비용 노드 선택
				if(!visited[j] && matrix[current][j] == 1 && 
						distance[j] > min + matrix[current][j]) {
					distance[j] = min + matrix[current][j];
				}
			}
		}
	}
}
