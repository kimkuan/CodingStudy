package mon07.day18.boj_구슬탈출4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_구슬탈출4 {

	static int N, M;
	static char[][] map;
	static int[] dx = {0, 1, 0,-1};
	static int[] dy = {1, 0, -1, 0};
	static int rx, ry, bx, by, gx, gy;
	
	static ArrayDeque<Info> q = new ArrayDeque<Info>(); // 구슬 정보를 담을 큐
	static class Info {
		int rx;
		int ry;
		int bx;
		int by;
		int count;
		
		public Info(int rx, int ry, int bx, int by, int count){
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
				}else if(map[i][j] == 'B') {
					bx = i;
					by = j;
				}else if(map[i][j] == 'O'){
					gx = i;
					gy = j;
				}
			}
		}
		
		startGame();
	}

	private static void startGame() {
		q.add(new Info(rx, ry, bx, by, 0));
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			
			for (int i = 0; i < 4; i++) {
				
			}
		}
	}	
}
