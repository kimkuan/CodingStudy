package mon03.day16.boj_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_아기상어_이상현 {

	static int N, time = 0;;
	static int[][] fish;
	static boolean[][] visited;
	static int[] count;
	
	static int sx, sy;
	static int fishCount = 0, sharkSize = 2, eat = 0, eatTime=0;
	static int[] dx = {-1, 0, 1, 0}; // 1) 거리순, 2) 위부터 2) 왼쪽 부터
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		fish = new int[N][N];
		visited = new boolean[N][N];
		count = new int[1001]; // 상어가 될 수 있는 크기
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				fish[i][j] = Integer.parseInt(st.nextToken());
				if(fish[i][j] == 9) {
					sx = i; sy = j; // 아기 상어 위치
					fish[i][j] = 0;
				}
				else if(fish[i][j] > 0) {
					count[fish[i][j]]++;
					fishCount++;
				}
			}
		}
		
		while(true) {
			init();
			if(!bfs())
				break;
		}
		System.out.println(eatTime);
	}
	
	private static boolean bfs() {
		// Queue<int[]> q = new LinkedList<int[]>();
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {sx, sy});
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int gx=N, gy=N;
			int size = q.size();
			boolean flag = false;
			time++;

			while(size-- > 0) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
					if(fish[nx][ny] > sharkSize) continue; // 자신보다 큰 물고기는 지나갈 수 없다
					
					q.add(new int[] {nx, ny}); // 작거나 같으면 이동가능
					visited[nx][ny] = true;
					
					if(fish[nx][ny] != 0 && fish[nx][ny] < sharkSize) { // 작을 때는 먹을 수 있음
						if(gx > nx) { // 가장 위쪽
							gx = nx; 
							gy = ny;
						}
						else if(gx == nx)  // 같으면 왼쪽
							gy = Math.min(gy, ny);

						flag = true; // 물고기를 먹을 수 있음
					}
				}
			}
			// 물고기를 먹는 과정
			if(flag) { 
				count[fish[gx][gy]]--;
				eat++;
				fish[gx][gy] = 0;
				eatTime = time;
				
				if(eat == sharkSize) { // 상어 크기만큼 물고기를 먹으면 크기 중가
					sharkSize++;
					eat = 0;
				}
				
				int total = 0; // 상어가 먹을 수 있는 물고기가 존재하는 지
				for(int i = 1; i < sharkSize; i++) {
					total += count[i];
				}
				if(total == 0) 
					return false;
			
				sx = gx; sy = gy; // 상어 위치 조정
				return true;
			}
		}
		return false;
	}
	
	private static void init() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
