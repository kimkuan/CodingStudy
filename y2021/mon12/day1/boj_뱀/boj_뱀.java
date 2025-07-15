package mon12.day1.boj_뱀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_뱀 {

	static int N, K, L;
	static int sx, sy, sd;
	static int[][] map;
	static HashMap<Integer, Character> direction = new HashMap<Integer, Character>();
	static ArrayDeque<Place> move = new ArrayDeque<Place>();
	
	static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
	static int[] dy = {1, 0, -1, 0};
	
	static class Place {
		int x;
		int y;
		
		public Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 보드의 크기
		K = Integer.parseInt(br.readLine()); // 사과의 개수
		sx = 1; sy = 1; sd = 0;				 // 뱀의 초기 위치와 방향
		
		map = new int[N+1][N+1];	

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1; // 사과가 있다면 1로 표시
		}
		
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			
			direction.put(time, dir);
		}
		
		map[sx][sy] = 2;
		move.add(new Place(sx, sy));
				
		int totalTime = 0;
		while(true) {
			
			totalTime++;
			
			// 다음 위치로 이동
			sx += dx[sd];
			sy += dy[sd];
			
			// 벽 또는 자기자신과 몸이 부딪히면 게임 끝
			if((sx <= 0 || sx > N || sy <= 0 || sy > N) || map[sx][sy] == 2) {
				break;
			}
			// 이동한 칸에 사과가 없다면
			else if(!move.isEmpty() && map[sx][sy] != 1) {
				Place tail = move.poll();
				map[tail.x][tail.y] = 0; // 빈칸으로 변경
			}
	
			map[sx][sy] = 2;
			move.add(new Place(sx, sy));
			
			// 현재 시간에 회전명령이 있는지
			if(direction.containsKey(totalTime)) {
				rotate(direction.get(totalTime));
			}
		}
		
		System.out.println(totalTime);
	}

	// 뱀의 방향을 회전하는 메소드
	static void rotate(char dir) {
		if(dir == 'D')
			sd = sd == 3 ? 0 : sd+1;
		else if(dir == 'L')
			sd = sd == 0 ? 3 : sd-1;
	}
}
