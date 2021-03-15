import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [S1] RGB거리 - 1149번 */

public class q1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3]; 
		int[][] arr = new int[n][3]; 
		int ans = 1000000;

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0]; // R
		dp[0][1] = arr[0][1]; // G
		dp[0][2] = arr[0][2]; // B
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) { // 이전에 선택한 색 (R : 0, G : 1, B : 2)
				if(j == 0) 
					dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				
				else if(j == 1) 
					dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				
				else 
					dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
		}
		
		for(int j = 0; j < 3; j++) {
			if(dp[n-1][j] < ans) 
				ans = dp[n-1][j];
		}
		
		System.out.print(ans);
	}
}
