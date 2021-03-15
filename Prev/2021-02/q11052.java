import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [S1] 카드 구매하기  */

public class q11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n+1]; // 1~n까지
		int dp[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 0;
		}
		
		dp[1] = arr[1];
		
		for(int i = 2; i <= n ; i++) {	
			dp[i] = Math.max(arr[1]*i, dp[i]); // 1장으로 n개를 구매
			dp[i] = Math.max(arr[i], dp[i]); // n개를 팩으로 구매

			for(int j = 1; j <= i/2; j++ ) {
				dp[i] = Math.max(dp[i-j]+ dp[j], dp[i]); // 나눠서 구매
			}
		}
		System.out.println(dp[n]);
	}
}

/* 
 * dp[1] = 1번 카드만 쓰고 1장 만들 수 있는 최대 금액
 * dp[2] = 1~2번 카드만 쓰고 2장 만들 수 있는 최대 금액 // 1+1, 2 
 * dp[3] = 1~3번 카드를 써서 3장 만들 수 있는 최대 금액 // 1*3, 1+2, 3
 * dp[4] = 1~4번 카드를 써서 4장 만들 수 있는 최대 금액 // 1*4, 1+3, 2+2, 4
 * dp[n] = 1~n번 카드를 써서 5장 만들 수 있는 최대 금액
 * 
 * 점화식 : dp[i] = max (arr[i], dp[i], dp[i-j] + dp[j]);
 */
