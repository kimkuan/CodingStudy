package y2022.mon01.day22.boj_주사위굴리기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_주사위굴리기2 {
	
	static int N, M, K;
	static int[][] map;
	static int[][] score;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] dice = {0, 1, 2, 3, 4, 5, 6}; // 1번이 윗면 위치, 6번이 아랫면 위치

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		score = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 아직 점수가 계산되지 않은 칸
				if(score[i][j] == 0)
					calculateScore(i, j);
			}
		}
		
		int totalScore = 0;
		int x = 0, y = 0, d = 0;
		
		// K번 주사위를 이동시키기
		while(K-- > 0) {
			
			// 1. 주사위 한 칸 이동
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!isRange(nx, ny)) {
				d = d+2 > 3 ? d-2 : d+2; // 반대방향으로 변경
				nx = x + dx[d];
				ny = y + dy[d];
			}

			updateDice(d);
			
			// 2. 도착한 칸에 대한 점수를 획득
			totalScore += score[nx][ny];
			
			// 3. 이동방향 결정
			int A = dice[6]; // 주사위의 아랫면
			int B = map[nx][ny]; // 이동한 칸에 있는 정수
			
			d = updateDirection(A, B, d);
			x = nx;
			y = ny;
		}
		System.out.println(totalScore);
	}

	// 조건에 따른 이동방향 전환
	private static int updateDirection(int a, int b, int d) {
		if(a > b)
			d = d == 3 ? 0 : d+1;
		else if(a < b)
			d = d == 0 ? 3 : d-1;
		return d;
	}

	// 연속된 칸의 점수 계산
	private static void calculateScore(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		ArrayList<int[]> same = new ArrayList<int[]>();
		
		boolean[][] visited = new boolean[N][M];
		int count = 1;
		
		q.add(new int[] {i, j});
		same.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				
				if(!isRange(nx, ny) || visited[nx][ny])
					continue;
				
				// 연속된 칸!
				if(map[i][j] == map[nx][ny]) {
					q.add(new int[] {nx, ny});
					same.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					count++;
				}
			}
		}
		
		for(int[] node : same) {
			score[node[0]][node[1]] = count*map[i][j];
		}
	}
	
	// 주사위 굴리기 -> 아랫면 변경
	private static void updateDice(int d) {
		int[] temp = new int[dice.length];	
		System.arraycopy(dice, 0, temp, 0, dice.length);
		
		switch (d) {
		// 동쪽으로 이동
		case 0:
			dice[1] = temp[4]; // 맨 윗면
			dice[4] = temp[6];
			dice[3] = temp[1];
			dice[6] = temp[3];
			break;
		// 남쪽으로 이동
		case 1:
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[6] = temp[5];
			dice[5] = temp[1];
			break;
		// 서쪽으로 이동
		case 2:
			dice[1] = temp[3];
			dice[4] = temp[1];
			dice[3] = temp[6];
			dice[6] = temp[4];
			break;
		// 북쪽으로 이동
		case 3:
			dice[1] = temp[5];
			dice[5] = temp[6];
			dice[2] = temp[1];
			dice[6] = temp[2];
			break;
		}
	}
	
	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static boolean isRange(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= M)
			return false;
		return true;
	}

}
