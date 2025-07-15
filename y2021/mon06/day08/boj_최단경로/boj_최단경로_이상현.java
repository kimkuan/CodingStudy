package y2021.mon06.day08.boj_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_최단경로_이상현 {
	static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w); // 오름차순
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine())-1;
		
		ArrayList<Node>[] matrix = new ArrayList[V];
		int[] minEdge = new int[V]; // 시작점에서 다른 정점으로 가는 최소 비용
		boolean[] selected = new boolean[V]; // 선택한 정점인지 확인하기 위한 배열
		
		for(int i = 0; i < V; i++) {
			matrix[i] = new ArrayList<Node>();
			minEdge[i] = Integer.MAX_VALUE; // 무한값으로 초기화
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			matrix[from].add(new Node(to, cost));
		}
		
		// 다익스트라 알고리즘
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		minEdge[start] = 0; // 자기자신으로 가는 비용은 0
		q.add(new Node(start, minEdge[start]));
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(selected[current.v]) continue;// 이미 선택한 정점이 뽑히면 다시
			selected[current.v] = true;
	
			for(Node node : matrix[current.v]) {
				// 현재 선택한 정점을 거쳐서 갈 수 있는, 아직 선택되지 않은 정점 중에, 경유했을 때가 더 최소비용을 갖는다면
				if(!selected[node.v]
						&& minEdge[node.v] > minEdge[current.v] + node.w) {
					minEdge[node.v] = minEdge[current.v] + node.w; // 최소 비용으로 갱신해주기
					q.add(new Node(node.v, minEdge[node.v]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < V; i++) {
			sb.append(minEdge[i] == Integer.MAX_VALUE ? "INF" : minEdge[i]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
