package mon02.day08.boj_피보나치수4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_피보나치수4_이상현 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] dp = new BigInteger[10001];
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		System.out.print(dp[n]);
	}
}
