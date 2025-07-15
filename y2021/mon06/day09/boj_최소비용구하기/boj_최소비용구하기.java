package y2021.mon06.day09.boj_최소비용구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_최소비용구하기 {
	
	static class Node implements Comparable<Node>{
		int v; // 도착지
		int w; // 도착지까지의 비용
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w); // 오름차순
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Node>[] matrix = new ArrayList[N+1];
		int[] minEdge = new int[N+1];
		boolean[] visited = new boolean[N+1]; // 이미 방문한 정점은 다시 갈 필요가 없음.
											  // 먼저 방문했다는 것 자체가 더 최소 비용이라는 뜻 (왜냐면 모든 비용은 양수이기때문에 늦게가면 더 비용이 증가)
		for(int i = 1; i <= N; i++) {
			matrix[i] = new ArrayList<Node>();
			minEdge[i] = Integer.MAX_VALUE; // 무한대값으로 초기화
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			matrix[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 출발지
		int dest = Integer.parseInt(st.nextToken()); // 도착지
		
		// 다익스트라
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		minEdge[start] = 0;
		q.add(new Node(start, minEdge[start]));
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(visited[current.v]) continue;
			visited[current.v] = true;
			
			// 현재 정점과 이어진 정점들까지 갈 수 있는 최소비용 갱신
			for(Node node : matrix[current.v]) {
				if(!visited[node.v] &&
						minEdge[node.v] > minEdge[current.v] + node.w) {
					minEdge[node.v] = minEdge[current.v] + node.w;
					q.add(new Node(node.v, minEdge[node.v]));
				}
			}
		}
		System.out.println(minEdge[dest]);
	}
}
