package mon04.day06.boj_내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_내리막길_이상현2 {

	static int N, M; // 세로 N 가로 M
	static int[][] arr;
	static int[][] dp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		input();
		find();
		print();
		System.out.print(dp[N-1][M-1]);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void find() {
		ArrayDeque <int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {0, 0});

		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			dp[x][y]++;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
						
				// 오르막이면 안됨
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[x][y] <= arr[nx][ny]) continue;		
				
				if(dp[nx][ny] == 0) // 가본적 없으면 큐에 넣고 
					q.add(new int[] {nx, ny});
			}
			
		}
	}
	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) 
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}
}
