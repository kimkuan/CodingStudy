package mon03.day12.boj_연구실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_연구실_이상현 {
	
	static int N, M, safe=0, max=0;
	static int[][] lab;
	static int[][] temp;
	static int[] dx = {0, 1, 0, -1}; // 오 아 왼 위
	static int[] dy = {1, 0, -1, 0};
	
	static ArrayList<int[]> virus = new ArrayList<int[]>();
	static ArrayDeque<int[]> q = new ArrayDeque<int[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		temp = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 0) safe++;
				else if(lab[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		
//		if(virus.size() + safe == N*M) { // 벽이 없다는 뜻이므로
//			System.out.println(3); // 최대 크기는 3
//			return;
//		}	
		makeWall(0, 0, 0);
		System.out.println(max);
	}
	
	public static void safeSpace() {

		int cnt = 0;

		for(int i = 0; i < N; i++)
			System.arraycopy(lab[i], 0, temp[i], 0, M); // temp에 초기 lab 상태 저장
		
		for(int i = 0; i < virus.size(); i++) 
			q.push(virus.get(i));
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || temp[nx][ny] != 0) continue;
				temp[nx][ny] = 2; // 바이러스 증식
				cnt++; 
				q.add(new int[] {nx, ny});
			}
		}
		max = Math.max(safe-cnt-3, max);
	}
	
	public static void makeWall(int x, int y, int cnt) { // 벽 세우기
		if(cnt == 3) {
			safeSpace();
			return;
		}
		
		for(int i = x; i < N; i++) {
			for(int j = y; j < M; j++) {
				if(lab[i][j] == 0) {
					lab[i][j] = 1; // 벽 세움
					makeWall(x, y, cnt+1);
					lab[i][j] = 0;
				}
			}
			y = 0;
		}
	}
}
