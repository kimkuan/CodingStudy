package mon03.day10.boj_불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_불_이상현 {
	
	static int[][] map = new int[1001][1001];
	static boolean[][] visited = new boolean[1001][1001];
	static ArrayDeque<int[]> fire = new ArrayDeque<int[]>();
	static ArrayDeque<int[]> sang = new ArrayDeque<int[]>();
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int W, H, step = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken()); // y
			H = Integer.parseInt(st.nextToken()); // x
			
			char c;
			for(int i = 0; i < H; i++) {
				String str = br.readLine();
				for(int j = 0; j < W; j++) {
					c = str.charAt(j);
					
					map[i][j] = 0; // 일단 초기화
					visited[i][j] = false;
					
					if(c == '*') {
						map[i][j] = 1;
						fire.addLast(new int[]{i, j});
					}
					else if(c == '@') sang.addLast(new int[] {i, j});
					else if(c == '#') map[i][j] = -1;
				}
			}
			
			boolean result;
			while(true) {
				result = escape();
				if(result) {
					sb.append(step).append("\n");
					break;
				}
				else{ // 탈출 못하고 나온 것
					sb.append("IMPOSSIBLE").append("\n");
					break;
				}
			}
			// 초기화
			step = 0;
			fire.clear();
			sang.clear();
		}
		System.out.print(sb);
	}

	private static boolean escape() {
		
		while(sang.size() > 0) {
			step++;
			
			// 불 먼저 번짐
			int size = fire.size();
			int x, y;
			for(int i = 0; i < size; i++) {
				x = fire.peekFirst()[0];
				y = fire.peekFirst()[1];
				fire.pollFirst();
				
				if(map[x][y] > 1) continue; // 이미 지나간 위치의 불이면 2이상임
				map[x][y]++; // 불 붙임
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					else if(map[nx][ny] == 0) {
						map[nx][ny]++;
						fire.addLast(new int[] {nx, ny});
					}
				}
			}
			
			// 상근이 움직임 먼저 번짐
			size = sang.size();
			for(int i = 0; i < size; i++) {
				x = sang.peekFirst()[0];
				y = sang.peekFirst()[1];
				sang.pollFirst();
				
				if(visited[x][y]) continue;
				visited[x][y] = true;
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if(nx < 0 || nx >= H || ny < 0 || ny >= W){ // 탈출!
						return true;
					}
					else if(map[nx][ny] == 0 && !visited[nx][ny]) {
						sang.addLast(new int[] {nx, ny});
					}
				}
			}
		}
		return false; // 상근이는 탈출 못하고 끝남
	}
}
