package y2021.mon06.day21.boj_1로만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_1로만들기2 {
	
	static int N;
	static int[] dp; // 해당 숫자를 1로 만들 수 있는 최소 횟수
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		// N을 1로 만들기 위한 최소 횟수
		for(int i = 1; i <= N; i++) 
			dp[i] = getMinCount(i);
		sb.append(dp[N]).append("\n");
		
		// N을 1로 만들기 위한 로그
		trace(N); 
		for(Integer x : list) 
			sb.append(x).append(" ");
		
		System.out.print(sb.toString());
	}	
	
	private static int getMinCount(int num) {
		if(num <= 1)
			return 0;
		if(dp[num] > 0)
			return dp[num];
		
		int result = Integer.MAX_VALUE;
		if(num % 3 == 0) 
			result = Math.min(result, getMinCount(num/3)+1);
		
		if(num % 2 == 0) 
			result = Math.min(result, getMinCount(num/2)+1);
		
		result = Math.min(result, getMinCount(num-1)+1);
		
		return result;
	}
	
	private static void trace(int num) {
		while(num >= 1) {
			int nextNum = num;
			int minValue = Integer.MAX_VALUE;
			
			list.add(num);
			
			if(num % 3 == 0 && dp[num/3] < minValue) {
				nextNum = num/3;
				minValue = dp[num/3];
			}
			if(num % 2 == 0 && dp[num/2] < minValue) {
				nextNum = num/2;
				minValue = dp[num/2];
			}
			if(dp[num-1] < minValue) {
				nextNum = num-1;
				minValue = dp[num-1];
			}
			num = nextNum;
		}
	}
}
// dp[1] = 0;
// dp[2] = 1;
// dp[3] = 1;
// dp[4] = 2;
// dp[5] = 4;

// ...
// dp[15] = Math.max(dp[5], dp[14])
