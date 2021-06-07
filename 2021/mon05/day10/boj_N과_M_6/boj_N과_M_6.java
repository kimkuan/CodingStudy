package mon05.day10.boj_N과_M_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_N과_M_6 {

	static int N, M;
	static int[] input; // 입력값을 저장할 배열
	static boolean[] selected; // 이미 선택한 값은 선택하지 못하도록 선택 유무를 저장할 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N]; 
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input); // 사전순 정렬
		combination(0, 0);
		System.out.print(sb);
	}

	// 같은 수를 여러번 골라도 된다 (단, 비내림차순 이어야 한다)
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < N; i++) {
				if(selected[i])
					sb.append(input[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			combination(cnt+1, i+1);
			selected[i] = false;
		}
	}
}
