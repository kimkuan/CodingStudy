package mon02.day03.boj_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Chu {
	int x;
	int y;
	public Chu(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj_유기농배추_이상현 {
	
	static int M, N;
	static int[][] farm; // default : 0
	static boolean[][] visited; // default : false
	static int[] dx = {0, 1, 0, -1}; // 오른, 아래 ,왼, 위
	static int[] dy = {1, 0, -1, 0};
	
	public static void BFS(int x, int y) {
		Queue<Chu> q = new LinkedList<>();
		q.add(new Chu(x, y));
		
		while(!q.isEmpty()) {
			Chu c = q.poll();
			x = c.x;
			y = c.y;
			
			if(visited[x][y] == true)
				continue;
			
			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(farm[nx][ny] == 1 && visited[nx][ny] == false)
						q.add(new Chu(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			int K = Integer.parseInt(st.nextToken()); // 배추 개수
			int ans = 0;
			
			farm = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < K; i++) {
				 st = new StringTokenizer(br.readLine());
				 int x = Integer.parseInt(st.nextToken());
				 int y = Integer.parseInt(st.nextToken());
				 farm[y][x] = 1;
			}
			
			for(int i = 0; i < N; i++) { // 세로 
				for(int j = 0; j < M; j++) { // 가로					
					if(farm[i][j] == 1 && !visited[i][j]) { // 배추가 있고 방문한적이 없으면
						BFS(i, j);
						ans++;
					}
				}
			}
			for(int i = 0; i < N; i++) { // 초기화
				Arrays.fill(farm[i], 0);
				Arrays.fill(visited[i], false);
			}
			System.out.println(ans);
		}
	}
}
