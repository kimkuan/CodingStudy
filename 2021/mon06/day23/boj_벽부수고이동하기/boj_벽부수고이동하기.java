package mon06.day23.boj_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_벽부수고이동하기 {

	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0}; 
	
	static class Point {
		int x;
		int y;
		int step;
		int isCrushed;
		
		public Point(int x, int y, int step, int isCrushed) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.isCrushed = isCrushed;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[2][N][M]; // 벽을 부순 경우 + 벽을 부수지 않은 경우
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(BFS());
	}

	private static int BFS() {
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		q.add(new Point(0, 0, 1, 0)); // 시작점부터 시작 (1)
		visited[0][0][0] = true;
	
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == M-1)  // 도착!
				return p.step;

			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || (map[nx][ny] == '1' && p.isCrushed == 1)) continue;
			
				int isCrushed = p.isCrushed;
				
				if(map[nx][ny] == '1' && p.isCrushed == 0) // 다음칸이 벽이지만, 아직 부술수 있다면
					isCrushed = 1;
				if(visited[isCrushed][nx][ny]) continue;
				
				q.add(new Point(nx, ny, p.step+1, isCrushed));
				visited[isCrushed][nx][ny] = true;
			}
		}
		return -1;
	}
}
