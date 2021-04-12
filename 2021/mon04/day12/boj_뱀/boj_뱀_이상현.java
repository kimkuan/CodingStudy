package mon04.day12.boj_뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_뱀_이상현 {
	
	static int N, appleCnt,dirCnt;
	static int time = 0;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래. 왼쪽. 위쪽 
	static int[] dy = {1, 0, -1, 0};
	
	static ArrayDeque<int[]> snake = new ArrayDeque<>(); // 뱀의 몸이 현재 차지한 위치 (삽입한 순서대로)
	static ArrayDeque<Direction> q = new ArrayDeque<>(); // 방향 값

	static class Direction{
		int cnt;
		char dir;
		public Direction(int cnt, char dir){
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 뱀은 (1, 1)에서 시작함
		input();
		go(1, 1);
		System.out.println(time);
	}
	
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		appleCnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < appleCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1; // 사과의 위치
		}
		
		dirCnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < dirCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			q.add(new Direction(cnt, dir)); 
		}
	}
	
	public static void go(int x, int y) {
		int dir = 0; // 처음에는 오른쪽으로 
		snake.addLast(new int[] {x, y}); // 뱀이 지나온 자리 (1, 1)에서 시작
		arr[x][y] = 2; // 뱀은 2
		
		while(true) {
			time++; // 시간 째깍
			x = x + dx[dir]; // 다음칸 이동
			y = y + dy[dir];

			if(x <= 0 || x > N || y <= 0 || y > N) {   // 범위 넘어가면 게임 끝
				break;
			}
			if(arr[x][y] == 2) { // 이미 뱀의 몸이 있는 위치라면 종료
				break;
			}else if(arr[x][y] == 0){ // 사과가 없다면 꼬리가 위치한 칸을 비워주기
				int sx = snake.peek()[0]; // 꼬리가 위치한 칸을 비워주기
				int sy = snake.peek()[1];
				snake.pollFirst(); 
				arr[sx][sy] = 0;
			}
		
			// 시간이 끝난 후에 체크
			if(!q.isEmpty() && time == q.peek().cnt) {
				char change = q.poll().dir;
				
				if(change == 'D') { // 시계방향
					if(++dir == 4) dir = 0;
				}
				else if(change == 'L') { // 반시계방향
					if(--dir == -1) dir = 3;
				}
			}
			
			arr[x][y] = 2; // 현재 위치에 뱀을 위치시킴
			snake.addLast(new int[] {x, y}); 
		}
	}
//	
//	public static void print(){
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j <= N; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
