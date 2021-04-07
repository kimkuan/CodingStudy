package mon03.day22.boj_특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_특정거리의도시찾기_이상현 {

	static final int INF = 300001; // Integer.MAX_VALUE를 쓰면 오버플로우가 날 가능성이 크다!
	static int N, M, K, X; // N : 도시의 개수, M : 도로의 개수, K : 거리정보 , X: 출발도시의 번호
	static ArrayList<Node>[] matrix; // 인접 리스트
	static int[] distance; // 시작점에서부터 각 노드까지의 최소 비용
	static boolean[] visited; // 방문여부
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v ,int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w; // 최소 가중치를 기준으로 정렬되어야 한다
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		input();
		findRoad();

		for(int i = 1; i <= N; i++) {
			if(distance[i] == K) 
				sb.append(i).append("\n");
		}
		System.out.println(sb.length() == 0 ? -1 : sb);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		matrix = new ArrayList[N+1]; // 노드는 1부터 시작
		distance = new int[N+1];
		visited = new boolean[N+1]; 
		
		Arrays.fill(distance, INF); // 최소 가중치 무한대로 초기화
	
		for(int i = 1; i <= N; i++) {
			matrix[i] = new ArrayList<Node>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from].add(new Node(to, 1));
		}
	}
	
	private static void findRoad() {
		PriorityQueue<Node> q = new PriorityQueue<Node>(); // 최소 가중치를 우선순위로 두는 pq
		distance[X] = 0; // 출발지의 가중치를 0으로 초기화
		q.offer(new Node(X, distance[X]));
		
		Node current = null; // 최소 가중치를 갖는 노드
		while(!q.isEmpty()) {
			// 방문하지 않은 정점중 최소 가중치를 갖는 노드 선택
			current = q.poll();
			
			if(visited[current.v]) continue; // 이미 방문했다면 pass
			visited[current.v] = true;
			
			for(Node j : matrix[current.v]) {
				if(!visited[j.v] && j.w != 0 // 방문하지 않았고, 인접해있는 노드이고,
						&& distance[j.v] > current.w + j.w) { //  최소 가중치보다 현재 current노드를 경유했을 때가 더 적다면
					distance[j.v] = current.w + j.w;
					q.offer(new Node(j.v, distance[j.v]));
				}
			}	
		}
	}
}
