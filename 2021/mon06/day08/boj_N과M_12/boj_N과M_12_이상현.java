package mon06.day08.boj_N과M_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_N과M_12_이상현 {

	static int N, M;
	static int[] input;
	static int[] result;
	static HashSet<Integer> set = new HashSet<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		N = set.size();
		input = new int[N];
		result = new int[M];
		
		int index = 0;
		for(Integer item : set) 
			input[index++] = item;
		
		Arrays.sort(input);
		combination(0, 0);
		
		System.out.print(sb);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return ;
		}

		for(int i = start; i < N; i++) {
			result[cnt] = input[i];
			combination(cnt+1, i);
		}
	}
}
