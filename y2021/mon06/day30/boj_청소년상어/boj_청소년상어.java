package y2021.mon06.day30.boj_청소년상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_청소년상어 {
	
	static int N = 4, fishCnt = 16;
	static int max = 0;
	static int[][] originMap;
	static Fish[] originFishes; // 1번 ~ 16번 물고기

	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1}; // 반시계방향 
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	static class Fish{
		int x;
		int y;
		int dir;
		boolean die;
		
		public Fish(int x, int y, int dir, boolean die) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.die = die;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", dir=" + dir + ", die=" + die + "]";
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		originMap = new int[N][N];
		originFishes = new Fish[fishCnt+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				originMap[i][j] = num;
				originFishes[num] = new Fish(i, j, dir, false);
			}
		}		
		simulation(originMap, originFishes, 0, 0, 0);
		System.out.println(max);
	}
	
	// (sx, sy) : 상어가 물고기를 먹으러 이동할 위치
	// sum : 상어가 먹은 물고기의 번호 합
	private static void simulation(int[][] copyMap, Fish[] copyFishes, int sx, int sy, int sum) {
		int[][] tempMap = new int[N][N];
		Fish[]  tempFishes = new Fish[fishCnt+1];
		
		// 복사
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tempMap[i][j] = copyMap[i][j];
			}
		}
		for(int i = 1; i <= fishCnt; i++) {
			tempFishes[i] = new Fish(copyFishes[i].x, copyFishes[i].y, copyFishes[i].dir, copyFishes[i].die);
		}

		// 상어가 물고기를 잡아 먹음
		int targetNum = tempMap[sx][sy];
		tempFishes[targetNum].die = true;
		tempMap[sx][sy] = -1;
		max = Math.max(max, sum+targetNum); 

		//print(tempMap);
		//printFish(tempFishes);
	
		// 물고기 이동
		moveFishes(tempMap, tempFishes);
		
		// 상어 이동
		tempMap[sx][sy] = 0; // 기존에 있던 자리는 배워줌
		int d = tempFishes[targetNum].dir;
		for(int i = 0; i < 3; i++) {
			sx += dx[d];
			sy += dy[d];

			if(isRange(sx, sy) && tempMap[sx][sy] > 0) 
				simulation(tempMap, tempFishes, sx, sy, sum+targetNum);
		}
	}
	
	private static void moveFishes(int[][] map, Fish[] fishes) {
		for(int num = 1; num <= fishCnt; num++) {
			if(fishes[num].die) continue;
			
			Fish fish = fishes[num]; // 물고기 번호에 따른 물고기 정보
			int dir = fish.dir;
			int x = fish.x;
			int y = fish.y;
			
			for (int j = 0; j < 8; j++) { // 현재 방향을 기준으로 반시계방향으로 탐색
				int d = (dir+j) % 9 == 0 ? 1 : (dir+j) % 9;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(!isRange(nx, ny) || map[nx][ny] == -1) continue;
				
				if(map[nx][ny] == 0) { // 빈칸이라면
					map[x][y] = 0;
				}
				else {
					Fish swapFish = fishes[map[nx][ny]]; // 자리를 바꿀 물고기의 정보
					swapFish.x = x; // 물고기의 위치 변경
					swapFish.y = y;
					map[x][y] = map[nx][ny];
				}
				fish.dir = d;
				fish.x = nx;
				fish.y = ny;
				map[nx][ny] = num;
				break;
			}
		}
	}
	
	private static boolean isRange(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}
	
	private static void print(int[][] map) {
		for(int i =0 ; i< N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void printFish(Fish[] fishes) {
		for(int i =1 ; i <= fishCnt; i++) {
			System.out.println(i + "번 " + fishes[i]);
		}
	}	
}
