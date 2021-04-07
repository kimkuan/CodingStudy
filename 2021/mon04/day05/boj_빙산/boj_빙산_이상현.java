package mon04.day05.boj_빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_빙산_이상현 {

	static int N, M;
	static int[][] sea; // 바다의 상태
	static boolean[][] visited; // 그룹의 수를 세기 위한 방문여부
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayDeque<State> ice = new ArrayDeque<State>(); // 빙산의 정보를 담는 큐
	
	static class State{
		int x;
		int y;
		int h; // 현재 빙산의 높이
		public State(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int time = 0; // 시간

		input();		
		
		while(true) {
			melt();
			oneYearLater();
			time++;

			if(countGroup() >= 2) // 그룹이 2개 이상이면 stop 
				break;
			if(ice.size() == 0) // 그룹이 나뉘기전에 빙산이 모두 녹아버린 경우
				break;
		}
		System.out.print(ice.size() == 0 ? 0 : time);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sea = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if(sea[i][j] > 0) ice.add(new State(i, j, sea[i][j])); // 빙산의 정보를 저장
			}
		}
	}
	
	private static void melt() {
		int size = ice.size();
		
		for(int i = 0; i < size; i++) {
			State s = ice.poll();
			int x = s.x;
			int y = s.y;
			int h = s.h;
			int meetWithSea = 0; // 바다와 만난 면
			
			for(int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(sea[nx][ny] == 0) meetWithSea++;
			}
			// 바다와 만난 면의 수만큼 빙산의 높이를 감소 시킨다
			if(h - meetWithSea <= 0) 
				ice.add(new State(x, y, 0)); // 빙산이 모두 녹은 경우
			else 
				ice.add(new State(x, y, h-meetWithSea)); // 아직 남은 경우
		}
	}
	
	private static void oneYearLater() {
		int size = ice.size();
		for(int i = 0; i < size; i++) {
			State s = ice.poll();
			sea[s.x][s.y] = s.h; // 1년후의 모습으로 갱신
			
			if(s.h > 0) // 아직 빙산이 남아있으면 다시 큐에 삽입
				ice.add(s);
		}
	}
	
	private static int countGroup() {
		int group = 0; // 그룹의 수
		int size = ice.size();
		
		for(int i = 0; i < N; i++) 
			Arrays.fill(visited[i], false);
		
		for(int i = 0; i < size; i++) {
			State s = ice.poll();
			
			if(!visited[s.x][s.y]) { // 아직 방문하지 않은 빙산 = 새로운 그룹의 빙산
				sameGroup(s.x, s.y);
				group++;
			}
			ice.add(s);
		}
		return group;
	}
	
	// 같은 그룹에 속한 빙산들을 방문처리 해주는 함수
	private static void sameGroup(int sx, int sy) {
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {sx, sy});
		visited[sx][sy] = true; 
	
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				if(sea[nx][ny] > 0) {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}
}
