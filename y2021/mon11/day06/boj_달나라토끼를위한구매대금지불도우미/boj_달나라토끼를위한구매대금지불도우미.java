package y2021.mon11.day06.boj_달나라토끼를위한구매대금지불도우미;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_달나라토끼를위한구매대금지불도우미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cost = Integer.parseInt(br.readLine());
		
		int[] dp = new int[100001];
		
		for (int i = 0; i <= cost; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;
		
		for (int i = 8; i <= cost; i++) {
			if(i >= 7) 
				dp[i] = Math.min(dp[i], dp[i-7]);
			
			if(i >= 5) 
          		dp[i] = Math.min(dp[i], dp[i-5]);
			
      		if(i >= 2) 
				dp[i] = Math.min(dp[i], dp[i-2]);
			
			if(i >= 1) 
				dp[i] = Math.min(dp[i], dp[i-1]);
			
			dp[i] += 1; // 1, 2, 5, 7�� �� �ϳ��� �� ��������Ƿ� +1	
		}
		
		System.out.println(dp[cost]);
	}

}
