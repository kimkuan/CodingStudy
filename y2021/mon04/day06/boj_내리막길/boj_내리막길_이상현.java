package y2021.mon04.day06.boj_내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_내리막길_이상현 {

	static int N, M; // 세로 N 가로 M
	static int[][] arr;
	static int[][] dp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		input();
		find(0, 0);
		System.out.print(dp[0][0]);
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
		
		for(int i = 0; i < N; i++) 
			Arrays.fill(dp[i], -1);
	}
	
	private static int find(int x, int y) {
		
		if(x == N-1 && y == M-1) // 도착지일 때는 1반환 해야함 
			return 1;
		
		if(dp[x][y] != -1)  // 이미 왔던 길이면 dp값 반환
			return dp[x][y];
		
		dp[x][y] = 0; // 방문처리 (경로가 없으면 0, 방문한적이 없으면 -1)
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[x][y] <= arr[nx][ny]) continue;
			dp[x][y] += find(nx, ny);
		}
		return dp[x][y];
	}
	
	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) 
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}
}
