package com.mon08.day22.prog_가장먼노드;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class prog_가장먼노드 {

	static int n = 6;
	static int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
	static ArrayList<Integer>[] matrix = new ArrayList[n+1];
	static int[] minEdge;
	static boolean[] visited;
	
	public static void main(String[] args) {
		minEdge = new int[n+1];
		visited = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}

		for(int i = 1; i <= n; i++) {
			matrix[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < vertex.length; i++) {
			int from = vertex[i][0];
			int to = vertex[i][1];
			matrix[from].add(to); // 양방향 그래프
			matrix[to].add(from);
		}
		
		// 다익스트라 시작
		PriorityQueue<Integer> q = new PriorityQueue<>();
		minEdge[1] = 0; // 1번노드를 출발지로 정함
		q.add(1);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			if(visited[current]) // 이미 방문한 노드이면 다시 뽑기
				continue;
			
			visited[1] = true;
		
			// 현재 노드를 경유해서 가는게 더 빠른지 vs 원래대로 가는게 더 빠른지
			for(int i = 0; i < matrix[current].size(); i++) {
				int next = matrix[current].get(i);
				
				if(minEdge[next] > minEdge[current] + 1) {
					minEdge[next] = minEdge[current] + 1;
					q.add(next);
				}
			}
		}
		
		int max = 0; // 가장 멀리 떨어진 거리
		int maxCount = 0; // 가장 멀리 떨어진 거리의 노드 개수
		for (int i = 1; i <= n; i++) {
			if(max < minEdge[i]) {
				max = minEdge[i];
				maxCount = 1;
			}
			else if(max == minEdge[i]) {
				maxCount++;
			}
		}
		System.out.println(maxCount);
	}
}
