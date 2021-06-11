package mon06.day10.boj_특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_특정한최단경로 {

	static int N, E, INF = Integer.MAX_VALUE; 
	static int nodeA, nodeB;
	static ArrayList<Node>[] matrix;
	static int[] minEdge;
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		matrix = new ArrayList[N+1];
		minEdge = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1 ; i <= N; i++) {
			matrix[i] = new ArrayList<Node>();
		}
		
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			matrix[from].add(new Node(to, dist));
			matrix[to].add(new Node(from, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		nodeA = Integer.parseInt(st.nextToken());
		nodeB = Integer.parseInt(st.nextToken());
		
		long resultA = 0; // 시작점 -> nodeA -> nodeB -> 도착점
		long resultB = 0; // 시작점 -> nodeB -> nodeA -> 도착점

		getMinDistance(nodeA);
		resultA += minEdge[1];
		resultA += minEdge[nodeB];
		resultB += minEdge[N];
		
		getMinDistance(nodeB);
		resultA += minEdge[N];
		resultB += minEdge[1];
		resultB += minEdge[nodeA];
		
		if(resultA >= INF && resultB >= INF) // 불가능한 경로라면
			System.out.println(-1);
		else	
			System.out.println(Math.min(resultA, resultB));
	}
	
	public static void getMinDistance(int start) {
		Arrays.fill(minEdge, INF); // 무한대로 초기화
		Arrays.fill(visited, false); // 무한대로 초기화

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		minEdge[start] = 0; // 시작점의 minEdge값은 0으로 초기화
		q.add(new Node(start, minEdge[start]));
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(visited[current.v]) continue;
			visited[current.v] = true;
			
			for(Node node : matrix[current.v]) {
				if(!visited[node.v] &&
						minEdge[node.v] > minEdge[current.v] + node.w) {
					minEdge[node.v] = minEdge[current.v] + node.w;
					q.add(new Node(node.v, minEdge[node.v]));
				}
			}
		}
	}
}
