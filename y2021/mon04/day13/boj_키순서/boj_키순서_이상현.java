package y2021.mon04.day13.boj_키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_키순서_이상현 {

	static int N, M; // N : 학생들의 수, M : 두 학생의 키를 비교한 횟수
	static int INF = 987654321;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException {
		input();
		
		// 플로이드 워샬
		for(int k = 0; k < N; k++) { // 경유지
			for(int i = 0; i < N; i++) { // 출발지
				for(int j = 0; j < N; j++) { // 도착지
					if(matrix[i][j] > matrix[i][k] + matrix[k][j]) // 1-4는 INF였지만 1-4-5가 가능해짐
						matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < N; i++) { // i번째 학생의 순서 체크
			boolean know = true;
			for(int j = 0; j < N; j++) { // i번째 학생과 j번째 학생의 키 순서 비교
				if(i == j) continue;
				if(matrix[i][j] == INF && matrix[j][i] == INF) // 다른 학생와의 키 순서를 모르면 자신의 순서를 알 수 없음
					know = false; 
			}
			if(know) answer++;
		}
		System.out.print(answer);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][N]; // N명의 학생들의 키 비교 -> (a < b)이면  matrix[a][b] = 1;
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(matrix[i], INF);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int stdA = Integer.parseInt(st.nextToken()); // stdA < stdB 
			int stdB = Integer.parseInt(st.nextToken());
			matrix[stdA-1][stdB-1] = 1; 
		}
	}
}

// 자신보다 빨리 나가는 사람들 + 자신보다 늦게 나가는 사람들 => N-1명이 되어야한다!
// 그래야 자신의 순서를 확실하게 알 수 있음

// 방법1. 해당 노드로 들어오는 간선의 개수 + 해당 노드에서 나가는 간선의 개수 = N-1임을 이용
// 방법2. 전체 노드의 경로를 계산하고 해당 노드에서 다른 노드로 갈 수없는 경우를 제외 -> 플로이드 워샬 or 다익스트라 이용
