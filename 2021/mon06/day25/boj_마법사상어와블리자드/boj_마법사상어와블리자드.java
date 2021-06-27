package mon06.day25.boj_마법사상어와블리자드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_마법사상어와블리자드 {

	static int N, M;
	static int sx, sy; // 상어의 위치
	static int[][] map; // 구슬이 없는 칸 : 0
	static int[] explodeCnt = new int[4];
	static int[] dx = {0, -1, 1, 0, 0}; // 위 - 아래 - 왼 - 오른
	static int[] dy = {0, 0, 0, -1, 1};
	static int[] rotate = {2, 4, 1, 3}; // 구슬을 큐에 넣을 순서 (아래, 오른, 위, 왼)
	static ArrayDeque<Integer> q = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		sx = (N+1)/2;
		sy = (N+1)/2;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); 
			
			useSkill(d, s);
			move();
			q.clear();
		}
		System.out.println(explodeCnt[1] + explodeCnt[2]*2 + explodeCnt[3]*3);
	}

	public static void useSkill(int d, int s) {
		int x = sx; // 처음 시작 위치
		int y = sy;
		
		for(int i = 1; i <= s; i++) {
			x += dx[d];
			y += dy[d];
			if(!isRange(x, y)) break; // 범위를 벗어나게 되면 break
			map[x][y] = 0; // 빈칸으로 변경
		}
	}
	
	public static void move() {
		int n = 1; // 현재 이동시켜야 하는 칸 개수
		int x = sx, y = sy-1; // 상어의 왼쪽 칸 부터
		int dir = 0; // rotate상에서의 인덱스 -> 
		int cnt = 0; 

		if(map[x][y] != 0) { // 처음 상어 왼쪽칸을 큐에 넣어주기
			q.add(map[x][y]);
			map[x][y] = 0;
		}
		
		while(true) {
			int count = (n == 1) ? 1 : (n == N-1) ? 3 : 2; // n칸의 이동이 반복되는 횟수
			// n칸만큼 확인하는 과정이 처음에는 1번 (아래), 마지막에는 3번(아래, 오른, 위), 나머지는 2번 반복된다
			for(int j = 0; j < n; j++) {
				x = x + dx[rotate[dir]];
				y = y + dy[rotate[dir]];
				
				if(map[x][y] == 0) continue;
				q.add(map[x][y]);
				map[x][y] = 0;
			}
			dir = (dir+1)%4; // dir방향으로 n개 만큼 넣었으면 방향은 변경되고
			cnt++; 
			
			if(cnt == count) { // 그 방향으로 진행할 갯수는 n마다 다름(count)
				cnt = 0;
				n++;
			}
			if(n == N)
				break;
		}
		
		explode(); // 폭발할건 폭발하고
		groupExpand(); // 구슬 그룹도 만들어짐
		
		// 이후에는 큐에 담긴 구슬을 맵에 다시 뿌려주기
		n = 1;
		x = sx; y = sy-1;
		dir = 0; 
		cnt = 0;
		
		if(!q.isEmpty())
			map[x][y] = q.poll();
		
		while(!q.isEmpty()) {
			int count = (n == 1) ? 1 : (n == N-1) ? 3 : 2; // n칸의 이동이 반복되는 횟수
			for(int j = 0; j < n; j++) {
				x = x + dx[rotate[dir]];
				y = y + dy[rotate[dir]];
				
				if(!q.isEmpty()){
					map[x][y] = q.poll();
				}
			}
			dir = (dir+1)%4; // 방향은 변경되고
			cnt++;
			
			if(cnt == count) { // 그 방향으로 진행할 갯수는 n마다 다름(count)
				cnt = 0;
				n++;
			}
			if(n == N)
				break;
		}
	}
	
	public static void explode() {
		while(true) {
			boolean exploded = false;
			int cnt = 0;
			int size = q.size();
			int color = 0;
			int colorCnt = 0;
			
			while(cnt++ < size) {
				if(color != 0 && color != q.peekFirst()) {
					if(colorCnt >= 4) {
						exploded = true;
						explodeCnt[color] += colorCnt;
						for(int i = 0; i < colorCnt; i++)
							q.pollLast();
					}
					colorCnt = 1;
				}
				else
					colorCnt++;
				
				color = q.peekFirst();
				q.addLast(q.pollFirst());
			}
			
			if(!exploded)
				break;
		}
	}
	
	public static void groupExpand() {
		int size = q.size();
		int cnt = 0;
		int color = 0;
		int colorCnt = 0;
		
		while(cnt++ < size) {
			if(color != 0 && color != q.peekFirst()) {
				q.addLast(colorCnt); // 구슬의 개수 
				q.addLast(color); // 구슬의 색깔
				colorCnt = 1;
			}
			else
				colorCnt++;
			
			color = q.pollFirst();
		}
		// 큐의 맨 마지막에 있던 구슬은 따로 넣어줘야 한다
		q.addLast(colorCnt);
		q.addLast(color);
		
	}
	
	public static boolean isRange(int x, int y) {
		if(x <= 0 || x > N || y <= 0 || y > N) return false;
		return true;
	}
}
