package mon02.day26.boj_PuyoPuyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_PuyoPuyo_이상현 {

	static int N = 12, M = 6; // 세로 가로
	static int ans = 0, cnt = 0;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0, 1, 0, -1}; 
	static int[] dy = {1, 0, -1, 0};
	
	static ArrayList<int[]> start = new ArrayList<>(); // 4개 이상의 시작지점
	
	public static void getCount(int sx, int sy, char c) { // 4개 이상인 애들만 폭파
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sx, sy});
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();	
			cnt++;
						
			if(visited[x][y]) continue; // 이미 방문했으면 
			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] || map[nx][ny] != c) continue;
				
				q.add(new int[] {nx, ny});
				
			}	
		}
	}
	
	public static void game(int sx, int sy, char c) { // 4개 이상인 애들만 폭파
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sx, sy});
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			map[x][y] = '.'; // 폭파!
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] || map[nx][ny] != c) continue;
				
				q.add(new int[] {nx, ny});
			}	
		}
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void getDown() {
		for(int i = 0; i < M; i++) {
			for(int j = N-1; j >= 0; j--) { // 아래에서 위로
				if(map[j][i] != '.') {
					
					if(j+1 >= N) continue; // 배열을 넘으면 안됨
					if(map[j+1][i] != '.') continue; // 밑에 비어있어야지 아래로 옮길 수 있음

					int x = j+1;
					int y = i;
					// 범위를 벗어나지 않고 빈칸이면 계속 아래로 내림
					while(x >= 0 && x < N && y >= 0 && y < M && map[x][y] == '.') x++;
					
					map[x-1][y] = map[j][i];
					map[j][i] = '.';
				}
			}
		}
	}
	
	public static void init() {
		for(int i = 0; i < N; i++) 
			Arrays.fill(visited[i], false);
	}
	
	public static void gameStart() {
		init();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != '.' && !visited[i][j]) { 
					cnt = 0;
					getCount(i, j, map[i][j]);
					
					if(cnt >= 4)
						start.add(new int[] {i, j});
				}
			}
		}
				
		if(start.size() == 0) // 시작점이 없다면 게임 끝
			return;

		for(int[] s : start) {			
			init();
			game(s[0], s[1], map[s[0]][s[1]]);
		}
		getDown();
		ans++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) 
			map[i] = br.readLine().toCharArray();
		
		while(true) {
			gameStart();
			
			if(start.size() == 0) break;
			else start.clear(); // 시작점 비우고 재시작
		}
		
		System.out.print(ans);
	}
}
