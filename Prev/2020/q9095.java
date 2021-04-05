import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int dp[] = new int[n+3];
			/*
			if(n <= 3) {
				if(n == 3)
					System.out.println(4);
				else
					System.out.println(n);
				continue;
			}
			*/			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i = 4; i <= n; i++) {
				dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
			}
			System.out.println(dp[n]);
		}
	}
}
/*
 * 1 = 1 -> 1개
 * 2 = 1+1 = 2 -> 2개
 * 3 = 1+1+1 = 1+2 = 2+1 = 3 -> 4개
 * 4 = 1+1+1+1 = 1+1+2 = 1+2+1 = 2+1+1 = 2+2 = 3+1 = 1+3 -> 7개
 * 5 = 1+1+1+1+1 = (1,1,1,2) = (1,2,2) = (1,1,3) = (2,3) -> 13개
 */
