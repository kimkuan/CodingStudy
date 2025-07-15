package y2021.mon04.day30.boj_레이저통신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_레이저통신_이상현 {
	static int INF = Integer.MAX_VALUE;
	static int W, H, min = INF;

	static int sx, sy; // 시작점
	static char[][] map; // 입력 지도
	static int[][] visited; // 최소한의 꺽임으로 해당 위치에 감
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Point{
		int x, y;
		int cnt;
		int dir;
		public Point(int x, int y, int cnt, int dir) {
			this.x = x; this.y = y;
			this.cnt = cnt; this.dir = dir;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + ", dir=" + dir + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new int[H][W];

		for(int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(visited[i], INF);
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 'C') {
					sx = i; sy = j; // 출발지
				} 
			}
		}
		BFS();
		System.out.println(min);
	}
	
	// (x, y) : 현재 위치
	// cnt : 현재까지 꺽인 횟수 = 거울이 필요한 횟수
	// dir : 이전 방향
	public static void BFS() {
//		PriorityQueue<Point> q = new PriorityQueue<Point>(new Comparator<Point>() {
//			@Override
//			public int compare(Point o1, Point o2) {
//				return Integer.compare(o1.cnt, o2.cnt);
//			}
//		});
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		
		visited[sx][sy] = 0;
		q.add(new Point(sx, sy, -1, -1)); // 4방향으로 넣어줌 (단, 처음에는 -1부터 시작을 해서 0이 되도록)
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			// 도착지에 도착했을 때
			if(map[p.x][p.y] == 'C' && (p.x != sx || p.y != sy)) {
				min = p.cnt;
				return;
			}
			
			// 저번에 왔을 때 보다 꺽인 횟수가 많으면 continue
			if(visited[p.x][p.y] < p.cnt) 
				continue;

			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == '*') continue;
				
				// 방향을 바꾸지 않음 
				if(p.dir == i && visited[nx][ny] >= p.cnt) {
					visited[nx][ny] = p.cnt;
					q.add(new Point(nx, ny, p.cnt, p.dir));
				}
				else if(visited[nx][ny] >= p.cnt+1) {
					visited[nx][ny] = p.cnt+1;
					q.add(new Point(nx, ny, p.cnt+1, i));
				}
			}
		}
	}
}
