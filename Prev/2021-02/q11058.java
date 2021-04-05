import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11058 {
	
	static int N;
	static long[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 5) {
			System.out.print(N);
			return;
		}
		dp = new long[N+1];
		dp[1] = 1; // A출력
		dp[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + 1; // 이전 + A출력 
			
			for(int j = 1; j <= i-3; j++) { // Ctrl-A-C-V => 총 3번
				dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
			}
		}
		System.out.print(dp[N]);
	}
}