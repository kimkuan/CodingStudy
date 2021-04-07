package mon03.day9_boj.미친아두이노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 맞았습니다! 버전

public class boj_미친아두이노_이상현 {
	
	static int R, C; 
	static int[][] map;
	static char[][] answer;
	static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1}; // 0번 인덱스는 사용 X
	static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	static ArrayDeque<int[]> q = new ArrayDeque<int[]>(); // 미친 아두이노의 좌표
	static int jx, jy; // 종수의 현 위치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C]; 
		answer = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				char robot = s.charAt(j);
				if(robot == 'I') {jx = i; jy = j;} // 종수의 위치 저장
				else if(robot == 'R') {map[i][j] = 1; q.addLast(new int[] {i, j});} // 로봇의 위치
			}
		}
		
		String cmd = br.readLine();
		for(int i = 0; i < cmd.length(); i++) {
			int num = cmd.charAt(i) - '0';
			
			// 종수 위치 이동
			jx = jx + dx[num];
			jy = jy + dy[num];
			
			// 미친 아두이노 이동
			if(!moveCrazy()) {
				System.out.println("kraj " + (i+1)); // 중간에 게임이 끝남
				return;
			}
			// 미친 아두이노가 여러 개있는 곳은 폭발!
			explode();
		}
		
		answer();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	// 값 설정
	private static void answer() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0)
					answer[i][j] = 'R';
				else
					answer[i][j] = '.';
			}
		}
		answer[jx][jy] = 'I';
	}
	
	private static void explode() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 1) // 1개 이상의 로봇이 있으면
					map[i][j] = 0; // 폭발
				else if(map[i][j] == 1) // 폭발하지 않은 로봇을 push
					q.addLast(new int[] {i, j});
			}
		}
	}
		
	private static boolean moveCrazy() {
		
		// 종수와 가장 가까운 방향으로 이동
		while(!q.isEmpty()) {
			int rx = q.peek()[0];
			int ry = q.peek()[1];
			q.pollFirst();
			
			map[rx][ry]--; // 기존에 있던 곳에서 이동
			
			int xgap = jx - rx; // 로봇과 종수 사이의 x위치 차
			int ygap = jy - ry;
			int dir = 0;
			
			if(xgap == 0 && ygap == 0) { // 아예 처음부터 종수랑 같은 자리에서 시작하면 
				return false;
			}
			
			// 종수랑 가까워지는 방향 선택
			if(xgap > 0) 
				dir = (ygap == 0) ? 2 : (ygap > 0 ? 3 : 1);
			else if(xgap == 0) 
				dir = (ygap == 0) ? 5 : (ygap > 0 ? 6 : 4);
			else 
				dir = (ygap == 0) ? 8 : (ygap > 0 ? 9 : 7);
			
			int nx = rx+dx[dir];
			int ny = ry+dy[dir];
		
			// 옮긴 자리에서 종수랑 만났다면
			if(nx == jx && ny == jy) {
				return false; // 게임 끝
			}
			
			map[nx][ny]++; // 새로운 좌표로 이동
		}
		
		return true;
	}

}
