package y2021.mon05.day10.boj_N과M_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_N과M_3 {

	static int N, M;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		overlabCombination(0);
		System.out.print(sb);
	}
	
	// 같은 수를 여러번 골라도 된다
	private static void overlabCombination(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			selected[cnt] = i;
			overlabCombination(cnt+1);
		}
	}
}
