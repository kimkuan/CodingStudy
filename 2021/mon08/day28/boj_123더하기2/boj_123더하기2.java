package mon08.day28.boj_123더하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_123더하기2 {

	static int n, k, count = 0;
	static int[] select;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		select = new int[n+1];
		dp = new int[11];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= 10; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		// K번째 오는 식이 없는 경우에는 -1 출력
		if(dp[n] < k) {
			System.out.println(-1);
			return;
		}
		combination(0, 0);
	}
	
	
	private static void combination(int sum, int depth) {
		
		if(n < sum)
			return;
		
		if(n == sum) {
			count++;
			if(count == k) {
				for(int i = 0; i <= n; i++) {
					if(select[i] == 0) break;
					else sb.append(select[i]+"+");
				}
				sb.setLength(sb.length()-1);
				System.out.println(sb);
			}
			return ;
		}
		
		for(int i = 1; i <= 3; i++) {
			select[depth] = i;
			combination(sum+i, depth+1);
			select[depth] = 0;
		}
	}

}

// n : 1~10까지의 자연수
// k : 2^31-1 보다 작거나 같은 자연수

// n을 1,2,3의 합으로 나타내는 방법에서 k번째로 오는 식을 구해라