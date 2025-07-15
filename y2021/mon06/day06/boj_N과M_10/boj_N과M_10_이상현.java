package y2021.mon06.day06.boj_N과M_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj_N과M_10_이상현 {

	static int N, R;
	static int[] input;
	static boolean[] selected;
	static LinkedHashSet<String> set = new LinkedHashSet<String>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		input = new int[N];
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		combination(0, 0);
		
		for(String str : set) {
			System.out.println(str);
		}
	}

	private static void combination(int start, int cnt) {
		if(cnt == R) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				if(selected[i]) sb.append(input[i] + " ");
			}
			set.add(sb.toString());
			return ;
		}
		if(start == N) {
			return ;
		}
		
		selected[start] = true;
		combination(start+1, cnt+1); // 선택
		selected[start] = false;
		combination(start+1, cnt); // 미선택
	}
}
