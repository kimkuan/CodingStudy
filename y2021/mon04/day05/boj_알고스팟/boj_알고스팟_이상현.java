package y2021.mon04.day05.boj_알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_알고스팟_이상현 {

	static int N, M;
	static int INF = 987654321;
	static char[][] map;
	static int[][] dp; 
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class State{
		int x;
		int y;
		public State(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		BFS();
		System.out.println(dp[N-1][M-1]);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		map = new char[N][M];
		dp = new int[N][M]; // 해당 좌표를 방문했을 때, 부슌 벽의 최소 개수
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(dp[i], INF);
		}
	}
	
	private static void BFS() {
		ArrayDeque<State> q = new ArrayDeque<State>();
		q.add(new State(0, 0));
		dp[0][0] = 0;
		
		while(!q.isEmpty()) {
			State s = q.poll();
			int x = s.x;
			int y = s.y;
			
			if(x == N-1 && y == M-1) { 
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				// 갈 수 있다면
				if(map[nx][ny] == '1') {
					if(dp[nx][ny] > dp[x][y] + 1) { // 벽을 부숴도 그 값이 더 작아지면 다음 단계로 넘어감
						dp[nx][ny] = dp[x][y] + 1;
						q.add(new State(nx, ny));
					}
				} 
				else {
					if(dp[nx][ny] > dp[x][y]) { // 벽을 부수지 않고
						dp[nx][ny] = dp[x][y];
						q.add(new State(nx, ny));
					}
				}	
			}
		
		}
	}
//	private static void print() {
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//	}
}
