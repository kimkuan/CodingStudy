package mon10.day02.boj_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_아기상어 {
	
	static int answer = 0;
	static int sx, sy, ssize, seat; // 상어의 정보 (위치, 현재 크기, 현재 크기로 먹은 물고기의 수)
	static int fishCount = 0;
	static Node fish; // 거리가 가장 가까운 물고기의 정보
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static class Node {
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		// 상어의 정보
		ssize = 2;
		seat = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			for (int j = 0; j < N; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
				// 상어의 위치 정보
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				} else if(map[i][j] > 0) {
					fishCount++;
				}
			}
		}
		
		while(true) {
			init();
			if(checkAvailable())
				break;
			
			System.out.println("물고기의 정보");
			System.out.println(fish.toString());
			
			eat();
		}
		
		System.out.println(answer);
	}
	
	
	private static void init() {
		fish = new Node(21, 21, 10000001); // 초기화
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}


	private static boolean checkAvailable() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		boolean available = false;
		
		if(fishCount == 0)
			return false;
		
		q.add(new Node(sx, sy, 0));
		visited[sx][sy] = true;
		
		while(!q.isEmpty()){
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = current.x + dx[i];
				int y = current.y + dy[i];
				
				if(x < 0 || x >= N || y < 0 || y >= N || visited[x][y]) 
					continue;
				if(map[x][y] > ssize) // 자신의 크기보다 작거나 같을 때만 이동 가능
					continue;

				q.add(new Node(x, y, current.cnt+1));
				visited[x][y] = true;
				
				// 먹을 수 있는 물고기가 있는 지 체크
				if(map[x][y] != 0 && map[x][y] < ssize) {
					if(changeFish(current)) { // 더 거리가 가까우면 
						fish.x = current.x;
						fish.y = current.y;
						fish.cnt = current.cnt+1;
					}
					available = true;
				}
			}
		}
		if(available)  
			eat();
		
		return available;
	}
	
	// 어떤 물고기를 먹을 지
	private static boolean changeFish(Node current) {
		boolean change = false;
		
		if(current.cnt < fish.cnt) { // 더 거리가 가까우면 
			change = true;
		} else if(current.cnt == fish.cnt) {
			if(current.x < fish.x) 
				change = true;
			else if(current.x == fish.x && current.y < fish.y) 
				change = true;
		}
		return change;
	}
	
	private static void eat() {
		seat++; // 먹은 물고기의 수 증가
		fishCount--;
		
		if(seat == ssize) {
			ssize += 1;
			seat = 0;
		}
		sx = fish.x;
		sy = fish.y;
		map[fish.x][fish.y] = 0;
		
		answer += fish.cnt;
	}
}

// 물고기의 위치를 Queue에 저장

// 1. 이번 턴에 먹을 물고기를 정하기 (거리 순, 자신보다 작은 물고기, 도달할 수 있는지)
// -> 먹을 수 있다면 물고기까지의 최단 거리 함께 구하기
// 3. 물고기 냠냠
// 4. 상어의 크기 증가 여부