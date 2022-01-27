package mon01.day27.boj_회장뽑기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_회장뽑기 {

	static int N, INF = 99999;
	static int[][] matrix;
	static int[] score;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N+1][N+1];
		score = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j)
					matrix[i][j] = 0;
				else
					matrix[i][j] = INF; // 점수는 50점을 넘지 않는다. 
				
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1)
				break;
			
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		// 플로이드 워샬 
		for (int i = 1; i <= N; i++) { // 경유지
			for (int j = 1; j <= N; j++) { // 출발지 
				for (int k = 1; k <= N; k++) { // 도착지
					if(i == j || i == k || j == k)
						continue;
					
					matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
				}
			}
		}
		
		int present = 9999; // 회장 후보의 점수
		int presentCnt = 0; // 회장 후보의 수
		
		for (int i = 1; i <= N; i++) {
			int maxScore = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j)
					continue;
				
				maxScore = Math.max(maxScore, matrix[i][j]);
			}
			score[i] = maxScore;
			
			// 회장후보의 점수
			if(present > score[i]){
				present = score[i];
				presentCnt = 1;
			}
			else if(present == score[i]) {
				presentCnt++;
			}
		}
		
		sb.append(present + " " + presentCnt);
		sb.append("\n");
		
		for(int i = 1; i <= N; i++) {
			if(score[i] == present)
				sb.append(i + " ");
		}
		
		System.out.print(sb.toString());
	}
}
