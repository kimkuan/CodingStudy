import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());	
		int n;
		
		while(testcase-- > 0) {
			n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n]; 
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			
			for(int j = 2; j < n; j++) {	
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
			}

			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
	}
}
