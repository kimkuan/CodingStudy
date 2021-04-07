package mon03.day29.boj_미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_미로탈출_이상현 {

	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M;
	static int Hx, Hy, Ex, Ey;
	static int answer = Integer.MAX_VALUE;
	
	static class State{
		int x;
		int y;
		int cnt;
		int magic; // 마법의 지팡이를 사용하기 전이면 0, 사용한 후이면 1
		public State(int x, int y, int cnt, int magic) {
			this.x = x; this.y = y;
			this.cnt = cnt; this.magic = magic;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		escape();
		System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken());
		Hy = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken());
		Ey = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1]; // 인덱스는 (1, 1)부터 시작
		visited = new boolean[N+1][M+1][2]; // 지팡이를 쓰고 갈 경우, 아닌 경우
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void escape() {
		ArrayDeque<State> q = new ArrayDeque<State>();
		q.add(new State(Hx, Hy, 0, 0));
		visited[Hx][Hy][0] = true;
		
		while(!q.isEmpty()) {
			State state = q.poll();
			int x = state.x;
			int y = state.y;
			int cnt = state.cnt;
			int magic = state.magic;
			
			if(x == Ex && y == Ey) {
				answer = Math.min(answer, cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <= 0 || nx > N || ny <= 0 || ny > M ) continue;
			
				if(magic == 0 && map[nx][ny] == 1 && !visited[nx][ny][1]) { // 지팡이를 아직 쓰지 않았고 앞에 벽이 있다면
					q.add(new State(nx, ny, cnt+1, 1));
					visited[nx][ny][1] = true;
				}
				else if(map[nx][ny] == 0 && !visited[nx][ny][magic]){ // 길이면 그냥 지나갈 수 있음
					q.add(new State(nx, ny, cnt+1, magic));
					visited[nx][ny][magic] = true;
				}
			}
		}
	}
}
