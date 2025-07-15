package mon10.day09.boj_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_인구이동 {

	static class Country{
		int x;
		int y;
		
		public Country(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Union {
		int totalCount; // 총 국가수
		int totalPerson; // 총 인구수
		
		public Union(int totalCount , int totalPerson) {
			this.totalCount = totalCount;
			this.totalPerson = totalPerson;
		}

		@Override
		public String toString() {
			return "Union [totalCount=" + totalCount + ", totalPerson=" + totalPerson + "]";
		}
		
	}
	
	static int N, L, R;
	static int[][] map; // 인구 수
	static int[] parent; // 연합의 번호 (r,c) -> r*N + c
	static boolean[][] visited;
	static HashMap<Integer, Union> sumOfUnion = new HashMap<Integer, Union>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		parent = new int[N*N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				parent[i*N+j] = i*N + j; // 연합의 번호
			}
		}
		
		// 1. BFS를 돌면서 연합을 찾는다.
		// 2. 각 연합의 인구평균을 구하기 = 인구이동
		int day = 0;
		boolean exit = true;
		while(exit) {
			exit = bfs();
			
			if(!exit) // 연합이 만들어지지 않았으면 BREAK
				break;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					parent[i*N+j] = find(i*N+j); // 1번 더 갱신
					
					if(sumOfUnion.containsKey(parent[i*N+j])) {
						Union union = sumOfUnion.get(parent[i*N+j]); // 기존의 연합에서
						sumOfUnion.put(parent[i*N+j], new Union(union.totalCount+1, union.totalPerson+map[i][j]));
					}
					else
						sumOfUnion.put(parent[i*N+j], new Union(1, map[i][j]));
				}
			}
			
			move();	
			day += 1;
			sumOfUnion.clear();
		}
		System.out.println(day);
	}
	
	private static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Union union = sumOfUnion.get(parent[i*N+j]);
				map[i][j] = union.totalPerson / union.totalCount;
				
				parent[i*N+j] = i*N+j; // 연합번호 초기화
			}
		}
	}


	private static boolean bfs() {
		ArrayDeque<Country> q = new ArrayDeque<>();
		boolean moved = false; // 국경선이 열리는지, 열리지 않는지
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				
				q.add(new Country(i, j));
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					Country con = q.poll();
					
					for (int d = 0; d < 4; d++) {
						int nx = con.x + dx[d];
						int ny = con.y + dy[d];
						
						if(nx < 0 || nx >= N | ny < 0 || ny >= N || visited[nx][ny]) continue;

						int gap = Math.abs(map[nx][ny] - map[con.x][con.y]); // 인접한 두 나라간의 인구 차
						if(gap < L || gap > R) continue; // 국경선이 열리지 않는다.
						
						int num1 = con.x*N + con.y; // 현재 국가번호
						int num2 = nx*N + ny; // 인접국 국가번호
						
						findUnion(num1, num2);
						q.add(new Country(nx, ny));
						visited[nx][ny] = true;
						moved = true;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) 
			 Arrays.fill(visited[i], false);
				
		return moved;
	}
	
	private static void findUnion(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	private static int find(int x) {
		if(x == parent[x])
			return x;
		return x = find(parent[x]);
	}

}

// 두 나라의 인구차이가 L명 이상, R명 이하일 때 국경선이 열린다
// 조건에 의해 국경선이 모두 열리면 인구이동 시작

// 인접한 칸을 통해 이동가능하면 그 국가들은 하루동안 연합을 맺는다.
// 연합을 이루고 있는 각 칸의 인구수 = (연합의 인구수) / (연합을 이루는 칸의 개수  -> 소수점은 버린다
// 연합을 해체하고 모든 국경선을 닫는다.
