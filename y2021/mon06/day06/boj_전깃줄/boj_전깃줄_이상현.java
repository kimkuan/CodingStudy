package y2021.mon06.day06.boj_전깃줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_전깃줄_이상현 {

	static int N, answer = 0;
	static int[] dp; // 현재까지 살릴 수 있는 최대 전깃줄의 개수 
	static Lope[] lopes;

	static class Lope implements Comparable<Lope>{
		int start;
		int end;

		public Lope(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Lope o) {
			return Integer.compare(this.start, o.start); // 오름차순
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		lopes = new Lope[N];
		dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lopes[i] = new Lope(start, end);
		}
		if(N == 1) {
			System.out.println(0);
			return ;
		}
		
		Arrays.sort(lopes);
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			int max = checkCount(i);
			dp[i] = max == 0 ? 1 : max+1;
			answer = Math.max(dp[i], answer);
		}
		System.out.println(N-answer);
	}
	
	private static int checkCount(int i) {
		Lope lope = lopes[i]; 
		int max = 0;
	
		for(int j = i-1; j >= 0; j--) {
			if(lopes[j].end < lope.end)  // 현재 전봇대보다 end가 작은 애들 중에서 dp값이 가장 큰 값
				max = Math.max(max, dp[j]);
		}
		return max;
	}
}
