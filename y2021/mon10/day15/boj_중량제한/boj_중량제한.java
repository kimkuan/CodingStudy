package mon10.day15.boj_중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_중량제한 {

	static int N, M, startNode, endNode;
	static int result = 0;
	static ArrayList<Node>[] matrix;
	static boolean[] visited;
	
	static class Node {
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new ArrayList[N+1];
		visited = new boolean[N+1]; // 정점의 방분여부 체크
		
		for (int i = 0; i <= N; i++) {
			matrix[i] = new ArrayList<Node>();
		}
		
		int high = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			matrix[start].add(new Node(end, weight));
			matrix[end].add(new Node(start, weight));
			high = Math.max(high, weight); // 이분탐색에 쓰일 high 값 
		}
		
		st = new StringTokenizer(br.readLine());
		startNode = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		binarySearch(1, high);

		System.out.println(result);
	}
	
	private static void binarySearch(int start, int end) {

		while(start <= end) {
			int mid = (start+end)/2;
			
			if(bfs(mid)) { // 도착점에 도착할 수 있으면 증량 ++
				result = Math.max(result, mid); // 가능한 최대증량 찾기
				start = mid+1;
			}else { // 도착점에 도착할 수 없으면 증량 --
				end = mid-1;
			}
		}
	}

	private static boolean bfs(int mid) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		Arrays.fill(visited, false); // 방문 여부 초기화

		q.add(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			if(current == endNode) { // 도착지에 도착!
				return true;
			}
		
			for(int i = 0; i < matrix[current].size(); i++) {
				Node next = matrix[current].get(i);
				
				if(!visited[next.end] && next.weight >= mid) { // 현재 무게중량으로 건널 수 있는 다리인지
					q.add(next.end);
					visited[next.end] = true;
				}
			}
		}
		
		return false;
	}
}

// 중량제한은 10억까지 가능하다 -> for문으로 10억번 돌리면 시간초과

