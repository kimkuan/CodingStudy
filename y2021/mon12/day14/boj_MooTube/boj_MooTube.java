package y2021.mon12.day14.boj_MooTube;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_MooTube {
	static int N, Q;
	static ArrayList<Edge>[] matrix;
	
	static class Edge {
		int num;
		int usado;
		
		public Edge(int num, int usado) {
			this.num = num;
			this.usado = usado;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		matrix = new ArrayList[N+1];  // 1번부터 N번 동영상 간의 유사도를 저장할 배열 (이차원배열로 접근하면 시간초과!)
		
		for (int i = 1; i <= N; i++) {
			matrix[i] = new ArrayList<Edge>();
		}
		
		for(int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int usado = Integer.parseInt(st.nextToken());
			
			matrix[num1].add(new Edge(num2, usado));
			matrix[num2].add(new Edge(num1, usado));
		}
		
		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			
			sb.append(caculateUsado(K, I));
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	// 모든 비디오 간의 유사도를 계산하는 메소드
	private static int caculateUsado(int k, int start) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N+1]; // 1번 노드 ~ N번노드 까지의 방문 여부
		int count = 0;
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();

			for (Edge e : matrix[node]) {
				if(!visited[e.num] && e.usado >= k) {					
					q.add(e.num);
					visited[e.num] = true;
					count++;
				}
			}
		}
		return count;
	}
}
