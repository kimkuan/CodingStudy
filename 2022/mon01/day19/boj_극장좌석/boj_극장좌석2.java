package mon01.day19.boj_극장좌석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj_극장좌석2 {

	static int N, M;
	static int[] dp;
	static HashSet<Integer> vips = new HashSet<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			vips.add(num);
		}
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			// 현재 좌석이 VIP이거나, 이전 좌석이 VIP이면 이동 불가능
			if(vips.contains(i) || vips.contains(i-1))
				dp[i] = dp[i-1];
			else
				dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}
}
// dp[i] => i번 사람까지 앉히는 경우의 수

// 원래 자리에 앉히는 경우      |    옆(왼쪽) 자리에 앉히는 경우       
// dp[i] = dp[i-1] + dp[i-2]

// dp[1] = 1

// dp[2] = {1} 2       |    2, 1


// dp[3] = {1, 2} 3    |    {1} 3, 2
//         {2, 1}


// dp[4] = {1, 2, 3} 4 |    {1, 2} 4, 3
//         {2, 1   }
//            ...
