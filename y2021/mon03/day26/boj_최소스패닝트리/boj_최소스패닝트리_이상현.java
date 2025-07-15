package y2021.mon03.day26.boj_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_최소스패닝트리_이상현 {

	static int V, E, result = 0;
	static boolean[] visited; // 해당 정점을 간적이 있는지 확인
	static ArrayList<Edge>[] edgeList;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> {
		return o1.weight - o2.weight; // 가중치 오름차순
	});
	
	static class Edge{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		makePrimMST();
		System.out.println(result);
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new boolean[V+1];
		edgeList = new ArrayList[V+1];
	
		for(int i = 1; i <= V; i++) {
			edgeList[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 양방향 그래프
			edgeList[start].add(new Edge(start, end, weight));
			edgeList[end].add(new Edge(end, start, weight)); 
		}
	}
	
	private static void makePrimMST() {
		Queue<Integer> q = new LinkedList<Integer>(); // 시작 노드를 담을 큐
		q.add(1);

		while(!q.isEmpty()) {
			int current = q.poll(); // 시작점 노드
			visited[current] = true;
			
			for(Edge edge : edgeList[current]) { // 현재 노드와 연결된 간선들 확인
				if(!visited[edge.end]) // 도착지가 가본적 없는 곳이면
					pq.add(edge);
			}
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll(); // 가장 가중치가 작은 간선 선택
				if(visited[edge.end]) continue;
				
				q.add(edge.end); // 다음에 방문할 정점으로 선택
				visited[edge.end] = true;
				result += edge.weight;
				break;
			}
		}
	}
}

// Prim 알고리즘 -> 각 노드의 최소 가중치를 나타내는 minEdge[]배열을 만든다
// 정점의 개수가 만개, 간선의 개수가 10만개 까지 -> 인접리스트 사용!!

//1. 시작정점 지정 (아무거나)
//2. 선택한 정점에 연결된 간선들을 우선순위 큐에 넣기 (큐에 인접한 정점들을 담았다가)
//3. 우선순위 큐를 통해 가장 가중치가 적은 아이 뽑기 (그 간선의 도착지가 다음 방문할 정점)
//4. 총 가중치에 합산하기
