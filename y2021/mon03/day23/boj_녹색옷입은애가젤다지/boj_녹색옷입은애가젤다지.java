package y2021.mon03.day23.boj_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_녹색옷입은애가젤다지 {
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Node implements Comparable<Node>{
		int x, y; // 위치
		int dis;  // 해당 경로를 통해 간 비용
		public Node(int x, int y, int dis) {
			this.x = x; this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis; // 내림차순
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 0;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) // 종료
				break;
			
			map = new int[N][N];
			dp = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(dp[i], INF);
			}
			dijkstra();
			sb.append("Problem " + ++tc + ": ").append(dp[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // 거리가 가장 짧은 경우부터 나옴
			int x = now.x;
			int y = now.y;
			int dis = now.dis;
			
			if(dis < dp[x][y]) {
				dp[x][y] = dis;
			}
			
			if(x == N-1 && y == N-1) // 최단경로 탐색 종료 
				return;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				
				if(dp[nx][ny] > dp[x][y] + map[nx][ny]) {
					dp[nx][ny] = dp[x][y] + map[nx][ny];
					pq.add(new Node(nx, ny, dp[nx][ny]));
				}
			}
		}
	}
}
