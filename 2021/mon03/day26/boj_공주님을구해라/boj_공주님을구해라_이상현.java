package mon03.day26.boj_공주님을구해라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_공주님을구해라_이상현 {

	static class State{
		int x;
		int y;
		int cnt;
		int sword; // 0 : 검X
		
		public State(int x, int y, int cnt, int sword) {
			this.x = x; this.y = y;
			this.cnt = cnt;
			this.sword = sword;
		}
	}
	static int N, M, T, answer = 1000000000;
	static int[][] map;
	static boolean[][][] visited; // 각 좌표에 검을 들고 온 경우와 검을 들지 않고 온 경우
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		input();
		savePrincess();
		System.out.println(answer > T ? "Fail" : answer);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2]; // 검을 안주웠을 때 0  /  검을 주웠을 때  1
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void savePrincess() {
		ArrayDeque<State> q = new ArrayDeque<State>();
		q.add(new State(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			State s = q.poll();
			int x = s.x;
			int y = s.y;
			int cnt = s.cnt;
			int sword = s.sword;
			
			if(x == N-1 && y == M-1) {
				answer = Math.min(answer, cnt);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][sword]) continue;
				if(sword == 1) { // sword를 갖고 있음
					q.add(new State(nx, ny, cnt+1, sword));
					visited[nx][ny][sword] = true;
				}
				else if(sword == 0) { // sword를 갖고 있지 않음
					if(map[nx][ny] == 0) {
						q.add(new State(nx, ny, cnt+1, sword));
						visited[nx][ny][sword] = true;
					}
					else if(map[nx][ny] == 2) { // 검 발견!
						q.add(new State(nx, ny, cnt+1, 1));
						visited[nx][ny][1] = true;
					}
				}
			}
		}
	}
}
