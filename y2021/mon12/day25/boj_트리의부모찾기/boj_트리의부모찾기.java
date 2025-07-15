package y2021.mon12.day25.boj_트리의부모찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 풀이 시간 : 25분
 * 시간복잡도 : O(N)
 * IDE 사용 : O
*/

public class boj_트리의부모찾기 {
	
	static int N;
	static int[] parents;
	static ArrayList<Integer>[] edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N+1];
		parents = new int[N+1];

		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			edges[node1].add(node2);
			edges[node2].add(node1);
		}
		
		findParent();
		
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]+"\n");
		}
		
		System.out.print(sb.toString());
	}

	private static void findParent() {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		
		// 루트를 시작점으로 두고, 전체 트리탐색
		q.add(1);
		parents[1] = -1;	// 루트의 부모는 없으므로 -1로 설정
		
		while(!q.isEmpty()) {
			int node = q.poll();
						
			for(int next : edges[node]) {
				if(parents[next] != 0)
					continue;
				
				q.add(next);
				parents[next] = node;
			}
		}
	}
}
