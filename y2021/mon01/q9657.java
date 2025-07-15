package y2021.mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9657 {

	static boolean dp[];  // (default : false)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new boolean[1001];
		
		dp[1] = true; // 승리
		dp[3] = true;
		dp[4] = true;
		
		for(int i = 5; i <= n; i++) {
			if(dp[i-1] && dp[i-3] && dp[i-4]) // 모든 경우가 상대방이 승리한다면
				dp[i] = false; // 나는 패배
			else
				dp[i] = true;
		}
		if(dp[n])
			System.out.println("SK");
		else
			System.out.println("CY");
	}
}

/*
 * 필승조건 => 상대방이 질 경우가 하나라도 있으면 그 경우를 선택하면 나는 이긴다!
 * 만약 내가 1개를 선택하면 : 상대방은 무조건 dp[i-1]
 *  	 3개를 선택하면 : dp[i-3]
 *  	 4개를 선택하면 : dp[i-4]
 *  
 *  상대방의 결과 중 상대방이 질 경우가 하나라도 존재하면 그 경우를 선택할 것이다. (승리를 위해)
 */
