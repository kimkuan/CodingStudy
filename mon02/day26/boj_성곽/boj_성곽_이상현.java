package mon02.day26.boj_성곽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_성곽_이상현 {
	
	static int N, M; // 가로, 세로
	static int rooms = 0, size = 0, sumRoom = 0; // 방의 개수, 방의 사이즈
	static int[][] map, num;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>(); // 방의 크기
	
	static int[] dx = {0, -1, 0, 1}; // 서 북 동 남
	static int[] dy = {-1, 0, 1, 0};
	
	public static void getCount(int sx, int sy) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sx, sy});
		size = 0;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			num[x][y] = rooms; // 0번방 ~ 4번방
			size++;
			
			for(int i = 0; i < 4; i++) {
				if((map[x][y] & (1<<i)) != 0) continue; // 벽이 있다는 뜻

				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny]) continue;
				q.add(new int[] {nx, ny}); // 방으로 이동 가능
			}
		}
	}
	
	public static void maxRoom(int sx, int sy) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sx, sy});
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			// System.out.println("x y num " + x + " " + y + " -> " + num[x][y] );
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny]) continue;
				if(num[x][y] != num[nx][ny]) 
					sumRoom = Math.max(sumRoom, list.get(num[x][y]) + list.get(num[nx][ny]));
				
				q.add(new int[] {nx, ny}); 
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		map = new int[M][N];
		num = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) { // 세로
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) { // 가로
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i = 0; i < M; i++) { // 세로
			for(int j = 0; j < N; j++) { // 가로
				if(!visited[i][j]) { // 안가본 방
					getCount(i, j);
					rooms++;
					
					list.add(size); // 해당 방의 사이즈
					max = Math.max(max, size);
				}
			}
		}
		
		for(boolean[] x : visited) 
			Arrays.fill(x, false);
		
		maxRoom(0, 0);
		
		System.out.println(rooms); // 방의 개수
		System.out.println(max); // 가장 넓은 방의 넓이
		System.out.println(sumRoom); // 만들 수 있는 최대 방의 넓이
	}
}
