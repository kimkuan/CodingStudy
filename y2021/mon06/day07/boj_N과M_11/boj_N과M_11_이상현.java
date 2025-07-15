package y2021.mon06.day07.boj_N과M_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj_N과M_11_이상현 {

	static int N, R;
	static int[] input;
	static int[] result;
	static HashSet<Integer> set = new HashSet<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		// 중복제거한 개수만큼 크기의 iput과 selected 배열 만들기
		N = set.size();
		input = new int[N];
		result = new int[R];
		
		int index = 0;
		for(Integer item : set) {
			input[index++] = item;
		}
		Arrays.sort(input);
		combination(0);
		System.out.print(sb.toString());
	}

	private static void combination(int cnt) {
		if(cnt == R) {
			for(int i = 0; i < R; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return ;
		}
		for(int i = 0; i < N; i++) {
			result[cnt] = input[i];
			combination(cnt+1);
		}
	}
}
