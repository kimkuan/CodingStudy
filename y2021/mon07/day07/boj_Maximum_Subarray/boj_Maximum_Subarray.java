package y2021.mon07.day07.boj_Maximum_Subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_Maximum_Subarray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int [] arr = new int[N];
			int max = Integer.MIN_VALUE; // 최댓값이 음수일 수도 있으므로 min_value로 초기화한다.
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) { // 배열값 입력
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = i; j < N; j++) {
					sum += arr[j];
					max = Math.max(sum, max);
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb.toString());
	}
}
