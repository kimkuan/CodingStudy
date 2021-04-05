package mon03.day16.boj_보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_보물섬_이상현 {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int max = 0;
	static Queue<int[]> q = new LinkedList<int[]>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 map = new char[N][M];
		 visited = new boolean[N][M];
		 
		 for(int i = 0; i < N; i++) {
			 map[i] = br.readLine().toCharArray();
		 }
		 
		 for(int i = 0; i < N; i++) {
			 for(int j = 0; j < M; j++) {
				 if(map[i][j] == 'L') {
					 init();
					 bfs(i, j);
				 }
			 }
		 }
		 System.out.print(max);
	}
	private static void init() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
	private static void bfs(int sx, int sy) {
		q.add(new int[] {sx, sy, 0});
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			q.poll();
			
			max = Math.max(max, cnt);
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 'W') continue;
				q.add(new int[] {nx, ny, cnt+1});
				visited[nx][ny] = true;
			}
		}
	}
}
